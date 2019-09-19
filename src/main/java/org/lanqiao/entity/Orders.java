package org.lanqiao.entity;

import java.util.Date;

public class Orders {
    private Integer orderId;

    private Address address;

    private Integer addrId;

    private Custom custom;

    private Integer cusId;

    private Date orderTime;

    private Double gooYmoney;

    private Double gooSmoney;

    private String orderStatus;

    private String orderNote;

    private String estimatedTime;

    private Integer shopId;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Double getGooYmoney() {
        return gooYmoney;
    }

    public void setGooYmoney(Double gooYmoney) {
        this.gooYmoney = gooYmoney;
    }

    public Double getGooSmoney() {
        return gooSmoney;
    }

    public void setGooSmoney(Double gooSmoney) {
        this.gooSmoney = gooSmoney;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote == null ? null : orderNote.trim();
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime == null ? null : estimatedTime.trim();
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", address=" + address +
                ", custom=" + custom +
                ", orderTime=" + orderTime +
                ", gooYmoney=" + gooYmoney +
                ", gooSmoney=" + gooSmoney +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderNote='" + orderNote + '\'' +
                ", estimatedTime='" + estimatedTime + '\'' +
                ", shopId=" + shopId +
                '}';
    }
}