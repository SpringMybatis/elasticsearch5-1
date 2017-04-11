package com.yooeee.elastic.search.dto;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/7.
 */
public class ShopDto implements Serializable {
    private static final long serialVersionUID = -3132105767422317184L;

    private String id;
    private String cname;
    private String desc;
    private String areaTag;
    private String provinceName;
    private String cityName;
    private String districtName;
    private Double longitude;
    private Double latitude;
    private String field1;
    private String field2;
    private String category;
    private int isRebate;
    private double returnRatio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAreaTag() {
        return areaTag;
    }

    public void setAreaTag(String areaTag) {
        this.areaTag = areaTag;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getIsRebate() {
        return isRebate;
    }

    public void setIsRebate(int isRebate) {
        this.isRebate = isRebate;
    }

    public double getReturnRatio() {
        return returnRatio;
    }

    public void setReturnRatio(double returnRatio) {
        this.returnRatio = returnRatio;
    }
}
