package com.yooeee.elastic.search;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/6.
 */
public interface SearchShopService {

    public List<Map<String,Object>> search(SearchShop shop);

    public void createIndex();




}
