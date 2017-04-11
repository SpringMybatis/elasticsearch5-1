package com.yooeee.elastic.search.mapper;

import com.yooeee.elastic.search.entry.SysArea;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysAreaMapper {


    SysArea selectByPrimaryKey(String id);

}