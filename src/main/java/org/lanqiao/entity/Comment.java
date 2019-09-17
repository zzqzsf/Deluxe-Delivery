package org.lanqiao.entity;

import java.util.Date;
import java.util.Set;

public class Comment {
    private Integer comId;

    private Integer shopId;

    private Custom custom;

    private String comText;

    private Integer comLevel;

    private Date comTime;

    private String shopResponse;

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom customs) {
        this.custom = customs;
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