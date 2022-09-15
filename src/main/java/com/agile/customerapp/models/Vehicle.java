package com.agile.customerapp.models;

public class Vehicle {

    private String vehicleId;
    private String description;
    private Integer inStockCount;
    private Integer minCreditScore;
    private String price;

    public String getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInStockCount() {
        return inStockCount;
    }

    public void setInStockCount(Integer inStockCount) {
        this.inStockCount = inStockCount;
    }

    public Integer getMinCreditScore() {
        return minCreditScore;
    }

    public String getPrice() {
        return price;
    }
    
    public void setMinCreditScore(Integer minCreditScore) {
        this.minCreditScore = minCreditScore;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
}
