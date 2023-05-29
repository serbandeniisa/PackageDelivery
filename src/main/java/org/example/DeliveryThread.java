package org.example;

import java.util.List;

public class DeliveryThread extends Thread {
    private final DeliveryGroup deliveryGroup;

    public class DeliveryThread extends Thread {
        private final DeliveryGroup deliveryGroup;

        public DeliveryThread(DeliveryGroup deliveryGroup) {
            this.deliveryGroup = deliveryGroup;
        }

        @Override
        public void run() {
            List<Package> packageList = deliveryGroup.getPackageList();
            double totalDistance = 0.0;
            for (Package p : packageList) {
                totalDistance += p.getTargetDistance();
            }

            double deliveryTime = totalDistance

            try {
                Thread.sleep((long) (deliveryTime * 3600 * 1000));
            } catch (InterruptedException e) {
                System.out.println("Delivery interrupted for group: " + deliveryGroup);
                return;
            }

            System.out.println("Delivery completed for group: " + deliveryGroup);
        }
    }