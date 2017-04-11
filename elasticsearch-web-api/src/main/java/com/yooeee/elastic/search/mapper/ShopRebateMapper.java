package com.yooeee.elastic.search.mapper;

import com.yooeee.elastic.search.entry.ShopRebate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopRebateMapper {


    ShopRebate selectByPrimaryKey(Integer rebid);


    ShopRebate  selectByMerId(@Param("merId") String merId);


}