package com.yooeee.elastic.search.service.impl;

import com.yooeee.elastic.search.SearchShop;
import com.yooeee.elastic.search.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ShopServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(ShopServiceImplTest.class);


    @Autowired
    private ShopService shopService;

    @Test
    public void countShopSearch() throws Exception {
        SearchShop shop = new SearchShop();


        shop.setDistance(20000);
        shop.setName("川");
        shop.setUnit("km");
        shop.setLatitude(34.323612d);
        shop.setLongitude(116.570805d);
        logger.info("totalHits:{}", shopService.countShopSearch(shop));
    }


    @Test
    public void indexAll() throws Exception {
        shopService.indexAll();
    }

}