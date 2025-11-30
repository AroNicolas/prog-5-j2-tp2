package com.location.repository;

import com.location.entity.rentalobject.RentalObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalObjectRepository extends JpaRepository<RentalObject, Long> {
}

