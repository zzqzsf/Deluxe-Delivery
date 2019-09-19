package org.lanqiao.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@SolrDocument(solrCoreName = "articles")
public class Shop implements Serializable {
    @Id
    @Indexed
    private Integer shopId;
    @Indexed
    private String shopName;

    private String shopPwd;

    private String shopAddr;

    private String shopTel;

    private String shopState;

    private String shopImg;

    private BigDecimal shopCom;

    private Integer shopMonSale;

    private Double startPrice;

    private Double packagFee;
    private Double peiFee;

    public Double getPeiFee() {
        return peiFee;
    }

    public void setPeiFee(Double peiFee) {
        this.peiFee = peiFee;
    }


    private List<Foodtype> foodtypeList;

    private List<Food> foodList;

//
    public List<Foodtype> getFoodtypeList() {
        return foodtypeList;
    }

    public void setFoodtypeList(List<Foodtype> foodtypeList) {
        this.foodtypeList = foodtypeList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopPwd() {
        return shopPwd;
    }

    public void setShopPwd(String shopPwd) {
        this.shopPwd = shopPwd == null ? null : shopPwd.trim();
    }

    public String getShopAddr() {
        return shopAddr;
    }

    public void setShopAddr(String shopAddr) {
        this.shopAddr = shopAddr == null ? null : shopAddr.trim();
    }

    public String getShopTel() {
        return shopTel;
    }

    public void setShopTel(String shopTel) {
        this.shopTel = shopTel == null ? null : shopTel.trim();
    }

    public String getShopState() {
        return shopState;
    }

    public void setShopState(String shopState) {
        this.shopState = shopState == null ? null : shopState.trim();
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg == null ? null : shopImg.trim();
    }

    public BigDecimal getShopCom() {
        return shopCom;
    }

    public void setShopCom(BigDecimal shopCom) {
        this.shopCom = shopCom;
    }

    public Integer getShopMonSale() {
        return shopMonSale;
    }

    public void setShopMonSale(Integer shopMonSale) {
        this.shopMonSale = shopMonSale;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Double getPackagFee() {
        return packagFee;
    }

    public void setPackagFee(Double packagFee) {
        this.packagFee = packagFee;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", shopPwd='" + shopPwd + '\'' +
                ", shopAddr='" + shopAddr + '\'' +
                ", shopTel='" + shopTel + '\'' +
                ", shopState='" + shopState + '\'' +
                ", shopImg='" + shopImg + '\'' +
                ", shopCom=" + shopCom +
                ", shopMonSale=" + shopMonSale +
                ", startPrice=" + startPrice +
                ", packagFee=" + packagFee +
                ", peiFee=" + peiFee +
                ", foodtypeList=" + foodtypeList +
                ", foodList=" + foodList +
                '}';
    }
}