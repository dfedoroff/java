package com.kennel.model.implement;

import com.kennel.model.AbstractPackAnimal;
import com.kennel.model.AnimalGenius;

import java.time.LocalDate;

public class Horse extends AbstractPackAnimal {
    public Horse(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalGenius.HORSE);
    }
}
