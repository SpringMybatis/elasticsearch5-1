package com.yooeee.elastic.search.mapper;

import com.yooeee.elastic.search.entry.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {


    Shop selectByPrimaryKey(Integer mid);


    List<Shop> findList();


}