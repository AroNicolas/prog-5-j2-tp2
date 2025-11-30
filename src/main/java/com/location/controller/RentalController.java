package com.location.controller;

import com.location.entity.rentalobject.RentalObject;
import com.location.entity.renter.Renter;
import com.location.service.RentalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
@Slf4j
public class RentalController {

    private final RentalService rentalService;

    @PostMapping("/rent")
    public ResponseEntity<Double> rentObject(
            @RequestParam Long renterId,
            @RequestParam Long objectId,
            @RequestParam int days
    ) {
        double price = rentalService.rent(renterId, objectId, days);
        return ResponseEntity.ok(price);
    }

    @GetMapping("/objects/{id}")
    public ResponseEntity<RentalObject> getRentalObject(@PathVariable Long id) {
        RentalObject obj = rentalService.getRentalObject(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/renters/{id}")
    public ResponseEntity<Renter> getRenter(@PathVariable Long id) {
        Renter renter = rentalService.getRenter(id);
        return ResponseEntity.ok(renter);
    }
}

