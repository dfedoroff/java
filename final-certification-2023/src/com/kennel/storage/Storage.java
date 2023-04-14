package com.kennel.storage;

import com.kennel.model.AbstractAnimal;

import java.util.List;

public interface Storage {
    List<AbstractAnimal> getAllAnimals();

    AbstractAnimal getAnimalById(int animalId);

    boolean addAnimal(AbstractAnimal animal);

    int removeAnimal(AbstractAnimal animal);
}
