package com.yooeee.elastic.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.yooeee.elastic.search.ElasticTransportClient;
import com.yooeee.elastic.search.SearchShop;
import com.yooeee.elastic.search.constant.SearchConstants;
import com.yooeee.elastic.search.dto.ShopDto;
import com.yooeee.elastic.search.entry.Shop;
import com.yooeee.elastic.search.entry.ShopCategory;
import com.yooeee.elastic.search.entry.ShopRebate;
import com.yooeee.elastic.search.entry.SysArea;
import com.yooeee.elastic.search.mapper.ShopCategoryMapper;
import com.yooeee.elastic.search.mapper.ShopMapper;
import com.yooeee.elastic.search.mapper.ShopRebateMapper;
import com.yooeee.elastic.search.mapper.SysAreaMapper;
import com.yooeee.elastic.search.service.ShopService;
import com.yooeee.elastic.search.util.ShopSearchUtil;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortMode;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author admin.
 * @version 1.0
 */

@Service
public class ShopServiceImpl implements ShopService {

    private static final Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);


    private ElasticTransportClient elasticTransportClient;

    private ShopMapper shopMapper;

    private SysAreaMapper sysAreaMapper;

    private ShopCategoryMapper shopCategoryMapper;

    private ShopRebateMapper shopRebateMapper;

    @Inject
    @Required
    public void setElasticTransportClient(ElasticTransportClient elasticTransportClient) {
        this.elasticTransportClient = elasticTransportClient;
    }

    @Inject
    @Required
    public void setShopMapper(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    @Inject
    @Required
    public void setSysAreaMapper(SysAreaMapper sysAreaMapper) {
        this.sysAreaMapper = sysAreaMapper;
    }

    @Inject
    @Required
    public void setShopCategoryMapper(ShopCategoryMapper shopCategoryMapper) {
        this.shopCategoryMapper = shopCategoryMapper;
    }

    @Inject
    @Required
    public void setShopRebateMapper(ShopRebateMapper shopRebateMapper) {
        this.shopRebateMapper = shopRebateMapper;
    }

    /**
     * @param shopDto {@link ShopDto}
     * @return true success.
     */

    @Override
    public boolean index(ShopDto shopDto) {


        TransportClient transportClient = elasticTransportClient.getClient();

        IndexResponse response = transportClient.prepareIndex(SearchConstants.SHOP_INDEX, SearchConstants.SHOP_TYPE, shopDto.getId())
                .setSource(ShopSearchUtil.generateShopIndexMap(shopDto))
                .get();

        RestStatus status = response.status();


        System.out.println(JSON.toJSON(response));

        return status.getStatus() == RestStatus.OK.getStatus();


    }

    @Override
    public boolean index(Shop shop) {


        return false;
    }

    @Override
    public void indexAll() {

        List<Shop> shopList = shopMapper.findList();
        System.out.println(shopList.size());
        for (Shop shop : shopList) {
            logger.info("shopId:{}", shop.getMid());
            ShopDto shopDto = new ShopDto();

            String provinceId = shop.getProvinceName();
            String cityId = shop.getProvinceName();
            String districtId = shop.getProvinceName();
            Integer merchantClassId = shop.getMerchantClassId();
            if (provinceId != null && !"".equals(provinceId)) {
                SysArea province = sysAreaMapper.selectByPrimaryKey(provinceId);
                shopDto.setProvinceName(province.getName());
            } else {
                shopDto.setProvinceName("");
            }

            if (cityId != null && !"".equals(cityId)) {
                SysArea city = sysAreaMapper.selectByPrimaryKey(cityId);
                shopDto.setCityName(city.getName());
            } else {
                shopDto.setCityName("");
            }
            if (districtId != null && !"".equals(districtId)) {
                SysArea district = sysAreaMapper.selectByPrimaryKey(districtId);
                shopDto.setDistrictName(district.getName());
            } else {
                shopDto.setDistrictName("");
            }

            if (merchantClassId != null ) {
                ShopCategory shopCategory = shopCategoryMapper.selectByPrimaryKey(merchantClassId);
                shopDto.setCategory(shopCategory.getMerchantName());
            } else {
                shopDto.setCategory("");
                shopDto.setAreaTag("");
            }


            shopDto.setAreaTag(shop.getAddress());
            shopDto.setField1(shop.getField1());
            shopDto.setField2(shop.getField2());
            shopDto.setCname(shop.getMerchantCname());
            shopDto.setDesc(shop.getDescription());
            shopDto.setId(shop.getMid() + "");
            if (shop.getLongitude() != null && !"".equals(shop.getLongitude())) {

                shopDto.setLongitude(Double.valueOf(shop.getLongitude()));
            }

            if (shop.getLatitude() != null && !"".equals(shop.getLatitude())) {
                shopDto.setLatitude(Double.valueOf(shop.getLatitude()));
            }


            ShopRebate shopRebate = shopRebateMapper.selectByMerId(shop.getMerchantId());

            if (shopRebate != null) {
                shopDto.setIsRebate(Integer.valueOf(shopRebate.getIsRebates()));
                shopDto.setReturnRatio(shopRebate.getReturnRatio());
            }

            boolean result = index(shopDto);
            logger.info("shopId:{},index result:{}", shopDto.getId(), result);

        }


    }


    @Override
    public List<Map<String, Object>> shopSearch(SearchShop shop) {

        TransportClient client = elasticTransportClient.getClient();

        String keyword = shop.getName();
        List<Map<String, Object>> result = new ArrayList<>();

        BoolQueryBuilder queryBuilder = getShopBoolQueryBuilder(shop, keyword);


        SearchResponse searchResponse = client
                .prepareSearch("shops")
                .addSort(getShopSortLocation(shop))
                .setQuery(queryBuilder)
                .setFrom(shop.getFrom())
                .setSize(shop.getSize())
                .execute()
                .actionGet();


        SearchHits searchHits = searchResponse.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit searchHit : hits) {
            Object[] sortValues = searchHit.sortValues();
            Map<String, Object> sourceAsMap = searchHit.sourceAsMap();
            sourceAsMap.put("distance", sortValues[0] + shop.getUnit());
            result.add(sourceAsMap);
        }


        return result;
    }

    private GeoDistanceSortBuilder getShopSortLocation(SearchShop shop) {
        return SortBuilders.geoDistanceSort("location", new GeoPoint(shop.getLatitude(), shop.getLongitude())).sortMode(SortMode.MIN).unit(DistanceUnit.KILOMETERS).order(SortOrder.DESC);
    }

    private BoolQueryBuilder getShopBoolQueryBuilder(SearchShop shop, String keyword) {
        BoolQueryBuilder queryBuilder = QueryBuilders
                .boolQuery();
        if (keyword != null && !"".equals(keyword)) {
            queryBuilder.should(QueryBuilders.matchQuery("cname", keyword))
                    .should(QueryBuilders.matchQuery("areaTag", keyword))
                    .should(QueryBuilders.matchQuery("field1", keyword))
                    .should(QueryBuilders.matchQuery("field2", keyword))
                    .should(QueryBuilders.matchQuery("privinceName", keyword))
                    .should(QueryBuilders.matchQuery("cityName", keyword))
                    .should(QueryBuilders.matchQuery("districtName", keyword));

        }


        queryBuilder.filter(QueryBuilders.geoDistanceQuery("location").distance(shop.getDistance() + shop.getUnit()).point(shop.getLatitude(), shop.getLongitude()));
        return queryBuilder;
    }

    @Override
    public long countShopSearch(SearchShop shop) {

        TransportClient client = elasticTransportClient.getClient();

        String keyword = shop.getName();

        BoolQueryBuilder queryBuilder = getShopBoolQueryBuilder(shop, keyword);


        SearchResponse searchResponse = client
                .prepareSearch("shops")
                .addSort(getShopSortLocation(shop))
                .setQuery(queryBuilder)
                .setSize(0)
                .execute()
                .actionGet();


        if (RestStatus.OK.equals(searchResponse.status())) {
            return searchResponse.getHits().totalHits();
        }

        return 0L;
    }

    @Override
    public boolean deleteShopIndex(ShopDto shopDto) {
        TransportClient client = elasticTransportClient.getClient();

        DeleteResponse response = client.prepareDelete(SearchConstants.SHOP_INDEX, SearchConstants.SHOP_TYPE, shopDto.getId()).get();

        return RestStatus.OK.equals(response.status());
    }

    @Override
    public boolean updateShopIndex(ShopDto shopDto) {
        TransportClient client = elasticTransportClient.getClient();
        UpdateRequest updateRequest = new UpdateRequest(SearchConstants.SHOP_INDEX, SearchConstants.SHOP_TYPE, shopDto.getId())
                .doc(ShopSearchUtil.generateShopIndexMap(shopDto));
        try {
            UpdateResponse updateResponse = client.update(updateRequest).get();

            return RestStatus.OK.equals(updateResponse.status());
        } catch (InterruptedException e) {
            logger.error("thread interrupted by other ", e);
        } catch (ExecutionException e) {
            logger.error("update index execution error ", e);
        }


        return false;
    }
}
