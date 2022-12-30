package org.kieszek.rentalcars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentalcars")
public class RentalCarsController {

    @Autowired
    RentalCarsService rentalCarsService;

    @PostMapping
    public ResponseEntity<RentalCarsDto> add(@RequestBody RentalCarsDto rentalCarsDto){
        RentalCarsDto carDto = rentalCarsService.add(rentalCarsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(carDto);
    }

    @GetMapping
    public List<RentalCarsDto> getAllCars(){
        return rentalCarsService.findAll();
    }
}
