package org.lanqiao.entity;

import java.util.List;

public class OrderItem {
    private Integer detId;

    private Integer foodId;

    private Integer orderId;

    private Integer foodNumber;

    private Double detMoney;

    private String detNote;

    private Integer addressId;


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getDetId() {
        return detId;
    }

    public void setDetId(Integer detId) {
        this.detId = detId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getFoodNumber() {
        return foodNumber;
    }

    public void setFoodNumber(Integer foodNumber) {
        this.foodNumber = foodNumber;
    }

    public Double getDetMoney() {
        return detMoney;
    }

    public void setDetMoney(Double detMoney) {
        this.detMoney = detMoney;
    }

    public String getDetNote() {
        return detNote;
    }

    public void setDetNote(String detNote) {
        this.detNote = detNote == null ? null : detNote.trim();
    }
}