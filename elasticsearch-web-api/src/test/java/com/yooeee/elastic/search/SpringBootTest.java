package com.yooeee.elastic.search;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@org.springframework.boot.test.context.SpringBootTest
public class SpringBootTest {

@Autowired
private SearchShopService searchShopService;

@Autowired
private ElasticTransportClient elasticTransportClient;




    @Test
    public void test(){
        Assert.assertNotNull(searchShopService);
        Assert.assertNotNull(elasticTransportClient);
    }

}
