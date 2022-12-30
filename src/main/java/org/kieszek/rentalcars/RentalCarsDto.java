package org.kieszek.rentalcars;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalCarsDto {
    private Long id;
    private String name;
    private String model;
    private Integer price;

    public RentalCarsDto(Long id, String name, String model, Integer price) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
    }
}
