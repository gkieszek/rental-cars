package org.kieszek.rentalcars;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Samochody")
public class RentalCars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    private Integer price;

    public RentalCarsDto toDto(){
        RentalCarsDto rentalCarsDto = new RentalCarsDto(id, name, model, price);
        return rentalCarsDto;
    }

}
