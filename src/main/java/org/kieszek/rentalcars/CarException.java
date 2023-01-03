package org.kieszek.rentalcars;

public class CarException extends RuntimeException{

    public CarException(Long id){
        super(id+" not exist");
    }
}
