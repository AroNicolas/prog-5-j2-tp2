package com.location.entity.rentalobject;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class RentalObject {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private boolean available = true;

    @Column(nullable = true)
    protected Double basePrice;

    public abstract double calculateRentalPrice(int days);
}


