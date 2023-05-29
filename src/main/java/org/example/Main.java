package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        List<Package> packages = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("test-data.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");

                String targetLocation = fields[0].trim();
                int targetDistance = Integer.parseInt(fields[1].trim());
                double packageValue = Double.parseDouble(fields[2].trim());
                LocalDate deliveryDate = LocalDate.parse(fields[3].trim());

                Package p = new Package(targetLocation, targetDistance, packageValue, deliveryDate);
                packages.add(p);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<DeliveryGroup> deliveryGroups = createDeliveryGroups(packages);
        System.out.println(deliveryGroups);
    }

    private static List<DeliveryGroup> createDeliveryGroups(List<Package> packages) {
        Map<DeliveryKey, List<Package>> packageMap = new HashMap<>();

        for (Package pack : packages) {
            DeliveryKey key = new DeliveryKey(pack.getTargetLocation(), pack.getDeliveryDate());
            if (!packageMap.containsKey(key)) {
                packageMap.put(key, new ArrayList<>());
            }
            packageMap.get(key).add(pack);
        }

        List<DeliveryGroup> deliveryGroups = new ArrayList<>();
        for (Map.Entry<DeliveryKey, List<Package>> entry : packageMap.entrySet()) {
            DeliveryKey key = entry.getKey();
            List<Package> packagesForGroup = entry.getValue();
            DeliveryGroup group = new DeliveryGroup(key.getLocation(), key.getDeliveryDate(), packagesForGroup);
            deliveryGroups.add(group);
        }

        return deliveryGroups;
    }

    static class DeliveryKey {
        private String location;
        private LocalDate deliveryDate;

        public DeliveryKey(String location, LocalDate deliveryDate) {
            this.location = location;
            this.deliveryDate = deliveryDate;
        }

        public String getLocation() {
            return location;
        }

        public LocalDate getDeliveryDate() {
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
}