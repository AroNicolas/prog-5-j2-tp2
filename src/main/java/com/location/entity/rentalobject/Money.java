package com.location.entity.rentalobject;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Money extends RentalObject {

    private double amount;

    private double interest;

    @Override
    public double calculateRentalPrice(int days) {
        return amount * (interest / 100) * days;
    }
}

