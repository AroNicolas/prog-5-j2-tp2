package com.location.entity.renter;

import com.location.entity.Rent;
import com.location.entity.rentalobject.RentalObject;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Company extends Renter {

    private String nif;

    @Override
    public Rent rent(RentalObject object, int days) {
        Rent rent = new Rent(this, object, days);
        rent.setTotalPrice(rent.getTotalPrice() * 0.90); // discount 10%
        return rent;
    }
}

