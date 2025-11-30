package com.location.entity.rentalobject;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Bike extends RentalObject {

    private boolean electric;

    @Override
    public double calculateRentalPrice(int days) {
        double extra = electric ? 30000.0 : 0.0;
        return basePrice * days + extra;
    }
}

