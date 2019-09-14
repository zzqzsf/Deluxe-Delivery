package org.lanqiao.entity;


import java.util.Date;


public class Orders {
    private Integer orderId;

    private Integer addrId;

    private Integer cusId;

    private Date orderTime;

    private Double gooYmoney;

    private Double gooSmoney;

    private String orderState;

    private String orderNote;

    private String estimatedTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
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

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
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
}