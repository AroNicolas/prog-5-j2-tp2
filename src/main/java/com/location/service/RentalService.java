package com.location.service;

import com.location.entity.rentalobject.RentalObject;
import com.location.entity.renter.Renter;

public interface RentalService {

    double rent(Long renterId, Long objectId, int days);

    RentalObject getRentalObject(Long id);

    Renter getRenter(Long id);
}

