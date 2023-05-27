package org.example;

import java.util.List;

public class DeliveryGroup {
    private String targetLocation;
    private String deliveryDate;
    private List<Package> packageList;


    public DeliveryGroup(String targetLocation, String deliveryDate, List<Package> packageList) {
        this.targetLocation = targetLocation;
        this.deliveryDate = deliveryDate;
        this.packageList = packageList;

    }


    public String getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(String targetLocation) {
        this.targetLocation = targetLocation;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Package> getPackageList() {
        return packageList;
    }

    public void setPackageList(List<Package> packageList) {
        this.packageList = packageList;
    }
    public double calculateGroupValue() {
        double groupValue = 0.0;
        for (Package p : packageList) {
            groupValue += p.getPackageValue();
        }
        return groupValue;
    }

    public double calculateGroupRevenue() {
        double groupRevenue = 0.0;
        for (Package p : packageList) {
            groupRevenue += p.getTargetDistance() * 1.0;
        }
        return groupRevenue;
    }
}