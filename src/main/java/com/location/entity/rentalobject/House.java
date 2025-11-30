package com.location.entity.rentalobject;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class House extends RentalObject {
    private double surface;

    @Override
    public double calculateRentalPrice(int days) {
        return basePrice * days + (surface * 3000.0);
    }
}
