package org.lanqiao.entity;

public class OrderItem {
    private Integer detId;

    private Integer foodId;

    private Integer orderId;

    private Integer foodNumber;

    private Double detMoney;

    private String detNote;

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