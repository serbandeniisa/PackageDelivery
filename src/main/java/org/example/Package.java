package org.example;

import java.time.LocalDate;


public class Package {
    private final String targetLocation;
    private final int targetDistance;
    private final double packageValue;
    private final String deliveryDate;

    public Package(String targetLocation, int targetDistance, double packageValue, String deliveryDate) {
        this.targetLocation = targetLocation;
        this.targetDistance = targetDistance;
        this.packageValue = packageValue;
        this.deliveryDate = deliveryDate;
    }

    public String getTargetLocation() {
        return targetLocation;
    }

    public int getTargetDistance() {
        return targetDistance;
    }

    public double getPackageValue() {
        return packageValue;
    }

    public LocalDate getDeliveryDate() {
        return LocalDate.parse(deliveryDate);
    }
}






