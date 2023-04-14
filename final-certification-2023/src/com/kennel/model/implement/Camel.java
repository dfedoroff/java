package com.kennel.model.implement;

import com.kennel.model.AbstractPackAnimal;
import com.kennel.model.AnimalGenius;

import java.time.LocalDate;

public class Camel extends AbstractPackAnimal {
    public Camel(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalGenius.CAMEL);
    }
}
