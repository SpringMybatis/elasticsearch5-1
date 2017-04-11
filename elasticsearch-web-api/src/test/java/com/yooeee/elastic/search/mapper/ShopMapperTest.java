package com.yooeee.elastic.search.mapper;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.yooeee.elastic.search.entry.Shop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ShopMapperTest {

    @Autowired
    private ShopMapper shopMapper;

    @Test
    public void selectByPrimaryKey() throws Exception {

    }

    @Test
    public void findList() throws Exception {

        PageHelper.startPage(1,10);
       List<Shop> list =  shopMapper.findList();

        System.out.println(JSON.toJSON(list));
    }

}