package com.yooeee.elastic.search;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/6.
 */
public class SearchShop implements Serializable {
    private static final long serialVersionUID = 5694515747271816972L;

    private String name; //检索关键字
    private double latitude; //纬度
    private double longitude; //经度

    private int distance; //距离
    private String unit;//单位 m,km

    private int from;
    private int size= 30;

    private int currentPage;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage =  currentPage <=0 ?1 :currentPage;
    }

    public int getFrom() {

        return (this.currentPage-1)*size;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "SearchShop{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", distance=" + distance +
                ", unit='" + unit + '\'' +
                '}';
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
