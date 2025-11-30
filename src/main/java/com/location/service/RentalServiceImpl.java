package com.location.service;

import com.location.entity.rentalobject.RentalObject;
import com.location.entity.renter.Renter;
import com.location.exception.ObjectUnavailableException;
import com.location.exception.RenterNotFoundException;
import com.location.manager.RentalManager;
import com.location.repository.RentalObjectRepository;
import com.location.repository.RenterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RentalServiceImpl implements RentalService {

    private final RentalManager rentalManager;
    private final RentalObjectRepository rentalObjectRepository;
    private final RenterRepository renterRepository;

    @Override
    @Transactional
    public double rent(Long renterId, Long objectId, int days) {

        Renter renter = renterRepository.findById(renterId)
                .orElseThrow(() -> new RenterNotFoundException("Renter not found with id: " + renterId));

        RentalObject object = rentalObjectRepository.findById(objectId)
                .orElseThrow(() -> new ObjectUnavailableException("Object not found id: " + objectId));

        double price = rentalManager.rentObject(renter, object, days);

        rentalObjectRepository.save(object);

        log.info("RentalService: {} rented {} for {} day(s), total price: {}",
                renter.getName(), object.getId(), days, price);

        return price;
    }

    @Override
    public RentalObject getRentalObject(Long id) {
        return rentalObjectRepository.findById(id)
                .orElseThrow(() -> new ObjectUnavailableException("Object not found id: " + id));
    }

    @Override
    public Renter getRenter(Long id) {
        return renterRepository.findById(id)
                .orElseThrow(() -> new RenterNotFoundException("Renter not found with id: " + id));
    }
}
