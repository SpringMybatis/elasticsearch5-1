package com.yooeee.elastic.search.mapper;

import com.yooeee.elastic.search.entry.ShopCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopCategoryMapper {


    ShopCategory selectByPrimaryKey(Integer merchantId);


}