package com.location.entity.rentalobject;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Computer extends RentalObject {
    private String model;
    private int ram;
    private int rom;

    @Override
    public double calculateRentalPrice(int days) {
        return basePrice * days + (ram * 10000.0) + (rom * 500.0);
    }
}
