package org.example;

import java.util.Objects;

public class DeliveryKey {
    private String location;
    private String deliveryDate;

    public DeliveryKey(String location, String deliveryDate) {
        this.location = location;
        this.deliveryDate = deliveryDate;
    }

    public String getLocation() {
        return location;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryKey that = (DeliveryKey) o;
        return Objects.equals(location, that.location) &&
                Objects.equals(deliveryDate, that.deliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, deliveryDate);
    }
}
