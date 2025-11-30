package com.location.entity;

import com.location.entity.rentalobject.RentalObject;
import com.location.entity.renter.Renter;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @ManyToOne(optional = false)
    private Renter renter;

    @ManyToOne(optional = false)
    private RentalObject rentalObject;

    private int days;

    private double totalPrice;

    public Rent() {}

    public Rent(Renter renter, RentalObject rentalObject, int days) {
        this.renter = renter;
        this.rentalObject = rentalObject;
        this.days = days;

        this.totalPrice = rentalObject.calculateRentalPrice(days);
        rentalObject.setAvailable(false);
    }
}

