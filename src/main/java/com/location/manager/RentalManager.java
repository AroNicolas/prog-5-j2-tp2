package com.location.manager;

import com.location.entity.rentalobject.RentalObject;
import com.location.entity.renter.Renter;
import com.location.exception.ObjectUnavailableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RentalManager {

    public void checkAvailability(RentalObject object) {
        if (!object.isAvailable()) {
            log.warn("Rental attempt failed: Object {} is not available", object.getId());
            throw new ObjectUnavailableException("The object is already rented");
        }
    }

    public double rentObject(Renter renter, RentalObject object, int days) {
        checkAvailability(object);

        double price = object.calculateRentalPrice(days);

        object.setAvailable(false);

        log.info("Renter '{}' rented object '{}' for {} day(s). Total price: {}",
                renter.getName(), object.getId(), days, price);

        return price;
    }
}

