package org.kieszek.rentalcars;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalCarsRepository extends JpaRepository<RentalCars, Long> {

    List<RentalCars> findRentalCarsByModel (String model);
}
