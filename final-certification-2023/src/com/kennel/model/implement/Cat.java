package com.kennel.model.implement;

import com.kennel.model.AbstractPet;
import com.kennel.model.AnimalGenius;

import java.time.LocalDate;

public class Cat extends AbstractPet {
    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalGenius.CAT);
    }
}
