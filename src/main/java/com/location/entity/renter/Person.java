package com.location.entity.renter;

import com.location.entity.Rent;
import com.location.entity.rentalobject.RentalObject;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Person extends Renter {

    private String cin;

    @Override
    public Rent rent(RentalObject object, int days) {
        return new Rent(this, object, days); //  normal price
    }
}
