package com.location.entity.renter;

import com.location.entity.Rent;
import com.location.entity.rentalobject.RentalObject;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Association extends Renter{

    private String registrationCode;

    @Override
    public Rent rent(RentalObject object, int days) {
        Rent rent = new Rent(this, object, days);
        rent.setTotalPrice(rent.getTotalPrice() * 0.80); // discount 20%
        return rent;
    }
}
