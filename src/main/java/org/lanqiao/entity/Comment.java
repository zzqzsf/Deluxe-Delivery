package org.lanqiao.entity;

import java.util.Date;

public class Comment {
    private Integer comId;

    private Integer shopId;

    private Integer cusId;

    private String comText;

    private Integer comLevel;

    private Date comTime;

    private String shopResponse;

    private Shop shop;

    private Custom custom;

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getComText() {
        return comText;
    }

    public void setComText(String comText) {
        this.comText = comText == null ? null : comText.trim();
    }

    public Integer getComLevel() {
        return comLevel;
    }

    public void setComLevel(Integer comLevel) {
        this.comLevel = comLevel;
    }

    public Date getComTime() {
        return comTime;
    }

    public void setComTime(Date comTime) {
        this.comTime = comTime;
    }

    public String getShopResponse() {
        return shopResponse;
    }

    public void setShopResponse(String shopResponse) {
        this.shopResponse = shopResponse == null ? null : shopResponse.trim();
    }
}