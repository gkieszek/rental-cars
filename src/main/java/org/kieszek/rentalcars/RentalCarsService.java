package org.kieszek.rentalcars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentalCarsService {
    @Autowired
    RentalCarsRepository rentalCarsRepository;

    public RentalCarsDto add(RentalCarsDto rentalCarsDto){
        RentalCars rentalCars = new RentalCars();
        rentalCars.setName(rentalCarsDto.getName());
        rentalCars.setModel(rentalCarsDto.getModel());
        rentalCars.setPrice(rentalCarsDto.getPrice());
        RentalCars saved = rentalCarsRepository.save(rentalCars);
        return new RentalCarsDto(saved.getId(), saved.getName(), saved.getModel(), saved.getPrice());
    }

    public List<RentalCarsDto> findAll() {
        return rentalCarsRepository.findAll()
                .stream()
                .map(rc -> new RentalCarsDto(rc.getId(), rc.getName(), rc.getModel(), rc.getPrice()))
                .collect(Collectors.toList());
    }

    public Optional<RentalCars> getById(Long id){
        return rentalCarsRepository.findById(id);
    }

    public void deleteId(Long id) {
        rentalCarsRepository.deleteById(id);

    }
}
