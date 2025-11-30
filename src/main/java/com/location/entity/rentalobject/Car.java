package com.location.entity.rentalobject;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Car extends RentalObject {
    private String model;
    private double mileage;

    @Override
    public double calculateRentalPrice(int days) {
        return basePrice * days + (mileage * 2000.0);
    }
}
