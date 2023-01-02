package org.kieszek.rentalcars;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Cars")
public class RentalCars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    private Integer price;

    public RentalCars() {
    }

    public RentalCars(String name, String model, Integer price) {
        this.name = name;
        this.model = model;
        this.price = price;
    }

    public RentalCarsDto toDto(){
        RentalCarsDto rentalCarsDto = new RentalCarsDto(id, name, model, price);
        return rentalCarsDto;
    }

}
