package org.lanqiao.entity;

public class Foodtype {
    private Integer ftyId;

    private String ftyName;

    private Integer shopId;

    public Integer getFtyId() {
        return ftyId;
    }

    public void setFtyId(Integer ftyId) {
        this.ftyId = ftyId;
    }

    public String getFtyName() {
        return ftyName;
    }

    public void setFtyName(String ftyName) {
        this.ftyName = ftyName == null ? null : ftyName.trim();
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
}