package com.yooeee.elastic.search.util;

import com.alibaba.fastjson.JSON;
import com.yooeee.elastic.search.dto.ShopDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin.
 * @version 1.0
 */
public final class ShopSearchUtil {
    private static final Logger logger = LoggerFactory.getLogger(ShopSearchUtil.class);


    public static Map<String, Object> generateShopIndexMap(ShopDto shopDto) {
        Map<String, Object> json = new HashMap<>();

        json.put("id", shopDto.getId());
        json.put("cname", shopDto.getCname());
        json.put("privinceName", shopDto.getProvinceName());
        json.put("cityName", shopDto.getCityName());
        json.put("districtName", shopDto.getDistrictName());
        json.put("field1", shopDto.getField1());
        json.put("field2", shopDto.getField2());
        json.put("areaTag", shopDto.getAreaTag());
        Map<String, Object> location = new HashMap<>();

        if (shopDto.getLongitude() != null && shopDto.getLatitude() != null
                && shopDto.getLatitude() <= 90 && shopDto.getLatitude() > -90d
                && shopDto.getLongitude() <= 180d && shopDto.getLongitude() >= -180d) {
            location.put("lat", shopDto.getLatitude());
            location.put("lon", shopDto.getLongitude());

        }
        json.put("location", location);
        json.put("isRebate", shopDto.getIsRebate());
        json.put("returnRatio", shopDto.getReturnRatio());
        logger.info("json:{}", JSON.toJSON(json));

        return json;
    }


}
