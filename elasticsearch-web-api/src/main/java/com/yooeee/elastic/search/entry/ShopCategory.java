package com.yooeee.elastic.search.entry;

import java.util.Date;

public class ShopCategory {
    private Integer merchantId;

    private String merchantName;

    private Integer typeId;

    private String typeName;

    private Integer merchantParentId;

    private Integer level;

    private String merchantUrl;

    private Integer merchantSort;

    private String merchantTitle;

    private Date merchantInserttime;

    private String merchantOperator;

    private String merchantParentIds;

    private Integer delFlag;

    private String classArea;

    private String classAreaName;

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getMerchantParentId() {
        return merchantParentId;
    }

    public void setMerchantParentId(Integer merchantParentId) {
        this.merchantParentId = merchantParentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getMerchantUrl() {
        return merchantUrl;
    }

    public void setMerchantUrl(String merchantUrl) {
        this.merchantUrl = merchantUrl == null ? null : merchantUrl.trim();
    }

    public Integer getMerchantSort() {
        return merchantSort;
    }

    public void setMerchantSort(Integer merchantSort) {
        this.merchantSort = merchantSort;
    }

    public String getMerchantTitle() {
        return merchantTitle;
    }

    public void setMerchantTitle(String merchantTitle) {
        this.merchantTitle = merchantTitle == null ? null : merchantTitle.trim();
    }

    public Date getMerchantInserttime() {
        return merchantInserttime;
    }

    public void setMerchantInserttime(Date merchantInserttime) {
        this.merchantInserttime = merchantInserttime;
    }

    public String getMerchantOperator() {
        return merchantOperator;
    }

    public void setMerchantOperator(String merchantOperator) {
        this.merchantOperator = merchantOperator == null ? null : merchantOperator.trim();
    }

    public String getMerchantParentIds() {
        return merchantParentIds;
    }

    public void setMerchantParentIds(String merchantParentIds) {
        this.merchantParentIds = merchantParentIds == null ? null : merchantParentIds.trim();
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getClassArea() {
        return classArea;
    }

    public void setClassArea(String classArea) {
        this.classArea = classArea == null ? null : classArea.trim();
    }

    public String getClassAreaName() {
        return classAreaName;
    }

    public void setClassAreaName(String classAreaName) {
        this.classAreaName = classAreaName == null ? null : classAreaName.trim();
    }
}