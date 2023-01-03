package org.kieszek.rentalcars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("{id}")
    public Optional<RentalCars> getById(@PathVariable Long id){
        return rentalCarsService.getById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        rentalCarsService.deleteId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<RentalCarsDto> updatePriceProduct(@PathVariable Long id, @RequestParam Integer price){
        RentalCarsDto newPriceProduct = rentalCarsService.updatePrice(id, price);
        return ResponseEntity.status(HttpStatus.OK).body(newPriceProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalCarsDto> updateCar(@PathVariable Long id, @RequestBody RentalCarsDto rentalCarsDtoDto){
        RentalCarsDto savedCar = rentalCarsService.updateCar(id, rentalCarsDtoDto);
        return ResponseEntity.ok(savedCar);
    }

}
