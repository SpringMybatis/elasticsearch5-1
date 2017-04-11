package com.yooeee.elastic.search;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.ScriptSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortMode;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/4/6.
 */
@Service
public class SearchShopServiceImpl implements SearchShopService {


    @Autowired
    private ElasticTransportClient elasticTransportClient;


    @Override
    public List<Map<String, Object>> search(SearchShop shop) {
        List<Map<String, Object>> result = new ArrayList<>();
        TransportClient client = elasticTransportClient.getClient();

        Map<String, Object> scriptMap = new HashMap<>();
        scriptMap.put("time", new Date().getTime());

        QueryBuilder queryBuilder = QueryBuilders
                .boolQuery()
                .must(QueryBuilders.matchQuery("name", shop.getName()))
                .filter(QueryBuilders.geoDistanceQuery("location").distance(shop.getDistance() + shop.getUnit()).point(shop.getLatitude(), shop.getLongitude()));
        SearchResponse searchResponse = client
                .prepareSearch("merchants")
                .addSort(SortBuilders.geoDistanceSort("location", new GeoPoint(shop.getLatitude(), shop.getLongitude())).sortMode(SortMode.MIN).unit(DistanceUnit.KILOMETERS).order(SortOrder.DESC))
                .addSort(SortBuilders.scriptSort(new Script(ScriptType.INLINE, "painless", "(params.time>doc['startTime'].value && params.time < doc['endTime'].value)?doc['fx'].value:doc['tsfx'].value", scriptMap), ScriptSortBuilder.ScriptSortType.NUMBER))
                .setQuery(queryBuilder)
                .execute()
                .actionGet();
        SearchHits searchHits = searchResponse.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit searchHit : hits) {
            Object[] sortValues = searchHit.sortValues();
            Map<String, Object> sourceAsMap = searchHit.sourceAsMap();
            sourceAsMap.put("distance", sortValues[0]);
            sourceAsMap.put("currentV", sortValues[1]);
            result.add(sourceAsMap);
        }

        return result;
    }

    @Override
    public void createIndex() {
        TransportClient client = elasticTransportClient.getClient();
// TODO: 2017/4/10


    }


}
