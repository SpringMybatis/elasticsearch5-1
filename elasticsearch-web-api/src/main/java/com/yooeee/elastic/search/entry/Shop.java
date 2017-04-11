package com.yooeee.elastic.search.entry;

import java.io.Serializable;
import java.util.Date;

public class Shop  implements Serializable{
    private static final long serialVersionUID = 7699626227162850792L;



    private Integer mid;

    private String merchantId;

    private String merchantCname;

    private String merchantEname;

    private Integer merchantClassId;

    private String districtName;

    private String cityName;

    private String provinceName;

    private String longitude;

    private String latitude;

    private Double serviceRate;

    private String address;

    private String contactPhone;

    private String hours;

    private String logoUrl;

    private String contactInfo;

    private String traffic;

    private Integer weight;

    private Integer focus;

    private String ispub;

    private String cooperationLevel;

    private String field1;

    private String field2;

    private String merchantOrgId;

    private String qrCodeUrl;

    private String activityImg;

    private String shopFace;

    private String useVoucher;

    private String sysOfficeId;

    private String subBank;

    private String openBank;

    private String bankNo;

    private String personName;

    private Date paymentSettleDate;

    private String backRatio;

    private Integer sttleType;

    private String sttleDate1;

    private String sttleDate2;

    private String sttleDate3;

    private String sttleDate4;

    private String haveShop;

    private String shopName;

    private String shopSmallPic;

    private String shopPic;

    private String shopTextPic;

    private String shopHaveGoods;

    private String areaTag;

    private String detailDocUrl;

    private Date createTime;

    private Date updateTime;

    private Double merchantDiscount;

    private Integer settleDay;

    private Integer deleteStatus;

    private String h5RqCode;

    private String contractNo;

    private String recMobile;

    private Double pjFirstPartyRate;

    private Double pjPayRate;

    private Double h5FirstPartyRate;

    private Double h5PayRate;

    private String description;

    private String scenePics;

    private String shopText;

    private String shopPri;

    private String shopPriList;

    @Override
    public String toString() {
        return "Shop{" +
                "mid=" + mid +
                ", merchantId='" + merchantId + '\'' +
                ", merchantCname='" + merchantCname + '\'' +
                ", merchantEname='" + merchantEname + '\'' +
                ", merchantClassId=" + merchantClassId +
                ", districtName='" + districtName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", serviceRate=" + serviceRate +
                ", address='" + address + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", hours='" + hours + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", traffic='" + traffic + '\'' +
                ", weight=" + weight +
                ", focus=" + focus +
                ", ispub='" + ispub + '\'' +
                ", cooperationLevel='" + cooperationLevel + '\'' +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", merchantOrgId='" + merchantOrgId + '\'' +
                ", qrCodeUrl='" + qrCodeUrl + '\'' +
                ", activityImg='" + activityImg + '\'' +
                ", shopFace='" + shopFace + '\'' +
                ", useVoucher='" + useVoucher + '\'' +
                ", sysOfficeId='" + sysOfficeId + '\'' +
                ", subBank='" + subBank + '\'' +
                ", openBank='" + openBank + '\'' +
                ", bankNo='" + bankNo + '\'' +
                ", personName='" + personName + '\'' +
                ", paymentSettleDate=" + paymentSettleDate +
                ", backRatio='" + backRatio + '\'' +
                ", sttleType=" + sttleType +
                ", sttleDate1='" + sttleDate1 + '\'' +
                ", sttleDate2='" + sttleDate2 + '\'' +
                ", sttleDate3='" + sttleDate3 + '\'' +
                ", sttleDate4='" + sttleDate4 + '\'' +
                ", haveShop='" + haveShop + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopSmallPic='" + shopSmallPic + '\'' +
                ", shopPic='" + shopPic + '\'' +
                ", shopTextPic='" + shopTextPic + '\'' +
                ", shopHaveGoods='" + shopHaveGoods + '\'' +
                ", areaTag='" + areaTag + '\'' +
                ", detailDocUrl='" + detailDocUrl + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", merchantDiscount=" + merchantDiscount +
                ", settleDay=" + settleDay +
                ", deleteStatus=" + deleteStatus +
                ", h5RqCode='" + h5RqCode + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", recMobile='" + recMobile + '\'' +
                ", pjFirstPartyRate=" + pjFirstPartyRate +
                ", pjPayRate=" + pjPayRate +
                ", h5FirstPartyRate=" + h5FirstPartyRate +
                ", h5PayRate=" + h5PayRate +
                ", description='" + description + '\'' +
                ", scenePics='" + scenePics + '\'' +
                ", shopText='" + shopText + '\'' +
                ", shopPri='" + shopPri + '\'' +
                ", shopPriList='" + shopPriList + '\'' +
                '}';
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getMerchantCname() {
        return merchantCname;
    }

    public void setMerchantCname(String merchantCname) {
        this.merchantCname = merchantCname == null ? null : merchantCname.trim();
    }

    public String getMerchantEname() {
        return merchantEname;
    }

    public void setMerchantEname(String merchantEname) {
        this.merchantEname = merchantEname == null ? null : merchantEname.trim();
    }

    public Integer getMerchantClassId() {
        return merchantClassId;
    }

    public void setMerchantClassId(Integer merchantClassId) {
        this.merchantClassId = merchantClassId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Double getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(Double serviceRate) {
        this.serviceRate = serviceRate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours == null ? null : hours.trim();
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo == null ? null : contactInfo.trim();
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic == null ? null : traffic.trim();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getFocus() {
        return focus;
    }

    public void setFocus(Integer focus) {
        this.focus = focus;
    }

    public String getIspub() {
        return ispub;
    }

    public void setIspub(String ispub) {
        this.ispub = ispub == null ? null : ispub.trim();
    }

    public String getCooperationLevel() {
        return cooperationLevel;
    }

    public void setCooperationLevel(String cooperationLevel) {
        this.cooperationLevel = cooperationLevel == null ? null : cooperationLevel.trim();
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    public String getMerchantOrgId() {
        return merchantOrgId;
    }

    public void setMerchantOrgId(String merchantOrgId) {
        this.merchantOrgId = merchantOrgId == null ? null : merchantOrgId.trim();
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl == null ? null : qrCodeUrl.trim();
    }

    public String getActivityImg() {
        return activityImg;
    }

    public void setActivityImg(String activityImg) {
        this.activityImg = activityImg == null ? null : activityImg.trim();
    }

    public String getShopFace() {
        return shopFace;
    }

    public void setShopFace(String shopFace) {
        this.shopFace = shopFace == null ? null : shopFace.trim();
    }

    public String getUseVoucher() {
        return useVoucher;
    }

    public void setUseVoucher(String useVoucher) {
        this.useVoucher = useVoucher == null ? null : useVoucher.trim();
    }

    public String getSysOfficeId() {
        return sysOfficeId;
    }

    public void setSysOfficeId(String sysOfficeId) {
        this.sysOfficeId = sysOfficeId == null ? null : sysOfficeId.trim();
    }

    public String getSubBank() {
        return subBank;
    }

    public void setSubBank(String subBank) {
        this.subBank = subBank == null ? null : subBank.trim();
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank == null ? null : openBank.trim();
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public Date getPaymentSettleDate() {
        return paymentSettleDate;
    }

    public void setPaymentSettleDate(Date paymentSettleDate) {
        this.paymentSettleDate = paymentSettleDate;
    }

    public String getBackRatio() {
        return backRatio;
    }

    public void setBackRatio(String backRatio) {
        this.backRatio = backRatio == null ? null : backRatio.trim();
    }

    public Integer getSttleType() {
        return sttleType;
    }

    public void setSttleType(Integer sttleType) {
        this.sttleType = sttleType;
    }

    public String getSttleDate1() {
        return sttleDate1;
    }

    public void setSttleDate1(String sttleDate1) {
        this.sttleDate1 = sttleDate1 == null ? null : sttleDate1.trim();
    }

    public String getSttleDate2() {
        return sttleDate2;
    }

    public void setSttleDate2(String sttleDate2) {
        this.sttleDate2 = sttleDate2 == null ? null : sttleDate2.trim();
    }

    public String getSttleDate3() {
        return sttleDate3;
    }

    public void setSttleDate3(String sttleDate3) {
        this.sttleDate3 = sttleDate3 == null ? null : sttleDate3.trim();
    }

    public String getSttleDate4() {
        return sttleDate4;
    }

    public void setSttleDate4(String sttleDate4) {
        this.sttleDate4 = sttleDate4 == null ? null : sttleDate4.trim();
    }

    public String getHaveShop() {
        return haveShop;
    }

    public void setHaveShop(String haveShop) {
        this.haveShop = haveShop == null ? null : haveShop.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopSmallPic() {
        return shopSmallPic;
    }

    public void setShopSmallPic(String shopSmallPic) {
        this.shopSmallPic = shopSmallPic == null ? null : shopSmallPic.trim();
    }

    public String getShopPic() {
        return shopPic;
    }

    public void setShopPic(String shopPic) {
        this.shopPic = shopPic == null ? null : shopPic.trim();
    }

    public String getShopTextPic() {
        return shopTextPic;
    }

    public void setShopTextPic(String shopTextPic) {
        this.shopTextPic = shopTextPic == null ? null : shopTextPic.trim();
    }

    public String getShopHaveGoods() {
        return shopHaveGoods;
    }

    public void setShopHaveGoods(String shopHaveGoods) {
        this.shopHaveGoods = shopHaveGoods == null ? null : shopHaveGoods.trim();
    }

    public String getAreaTag() {
        return areaTag;
    }

    public void setAreaTag(String areaTag) {
        this.areaTag = areaTag == null ? null : areaTag.trim();
    }

    public String getDetailDocUrl() {
        return detailDocUrl;
    }

    public void setDetailDocUrl(String detailDocUrl) {
        this.detailDocUrl = detailDocUrl == null ? null : detailDocUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Double getMerchantDiscount() {
        return merchantDiscount;
    }

    public void setMerchantDiscount(Double merchantDiscount) {
        this.merchantDiscount = merchantDiscount;
    }

    public Integer getSettleDay() {
        return settleDay;
    }

    public void setSettleDay(Integer settleDay) {
        this.settleDay = settleDay;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getH5RqCode() {
        return h5RqCode;
    }

    public void setH5RqCode(String h5RqCode) {
        this.h5RqCode = h5RqCode == null ? null : h5RqCode.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getRecMobile() {
        return recMobile;
    }

    public void setRecMobile(String recMobile) {
        this.recMobile = recMobile == null ? null : recMobile.trim();
    }

    public Double getPjFirstPartyRate() {
        return pjFirstPartyRate;
    }

    public void setPjFirstPartyRate(Double pjFirstPartyRate) {
        this.pjFirstPartyRate = pjFirstPartyRate;
    }

    public Double getPjPayRate() {
        return pjPayRate;
    }

    public void setPjPayRate(Double pjPayRate) {
        this.pjPayRate = pjPayRate;
    }

    public Double getH5FirstPartyRate() {
        return h5FirstPartyRate;
    }

    public void setH5FirstPartyRate(Double h5FirstPartyRate) {
        this.h5FirstPartyRate = h5FirstPartyRate;
    }

    public Double getH5PayRate() {
        return h5PayRate;
    }

    public void setH5PayRate(Double h5PayRate) {
        this.h5PayRate = h5PayRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getScenePics() {
        return scenePics;
    }

    public void setScenePics(String scenePics) {
        this.scenePics = scenePics == null ? null : scenePics.trim();
    }

    public String getShopText() {
        return shopText;
    }

    public void setShopText(String shopText) {
        this.shopText = shopText == null ? null : shopText.trim();
    }

    public String getShopPri() {
        return shopPri;
    }

    public void setShopPri(String shopPri) {
        this.shopPri = shopPri == null ? null : shopPri.trim();
    }

    public String getShopPriList() {
        return shopPriList;
    }

    public void setShopPriList(String shopPriList) {
        this.shopPriList = shopPriList == null ? null : shopPriList.trim();
    }
}