package com.yooeee.elastic.search.service;

import com.yooeee.elastic.search.SearchShop;
import com.yooeee.elastic.search.dto.ShopDto;
import com.yooeee.elastic.search.entry.Shop;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/7.
 */
public interface ShopService {

    /**
     * 单个索引
     * @param shopDto {@link ShopDto}
     * @return
     */
    public boolean index(ShopDto shopDto);


    public boolean index(Shop shop);

    /**
     * 初始化索引
     */
    public void indexAll();


    /**
     * 店铺查询
     * @param shop {@link SearchShop}
     * @return search result.
     */
    public List<Map<String,Object>> shopSearch(SearchShop shop);

    /**
     * 获取店铺总数
     * @param shop {@link SearchShop}
     * @return totalHits.
     */
    public long countShopSearch(SearchShop shop);


    /**
     * 删除店铺索引
     * @param shopDto
     * @return
     */
    public boolean deleteShopIndex(ShopDto shopDto);


    public boolean updateShopIndex(ShopDto shopDto);



}
