package com.kennel.storage;

import com.kennel.model.AbstractAnimal;
import com.kennel.model.AbstractPackAnimal;
import com.kennel.model.AbstractPet;
import com.kennel.model.Skill;
import com.kennel.model.implement.*;
import com.kennel.model.implement.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KennelStorage implements Storage{
    Map<Integer, AbstractAnimal> dbAnimals = new HashMap<>();

    public KennelStorage() {
        init();
    }

    private void init(){
        AbstractPet cat = new Cat("Луна", LocalDate.of(2020, 5, 10));

        cat.learnSkill(new Skill("Назад"));
        dbAnimals.put(cat.getId(), cat);

        AbstractPet dog = new Dog("Макс", LocalDate.of(2022, 8, 15));
        dog.learnSkill(new Skill("Ко мне"));
        dog.learnSkill(new Skill("Стой"));
        dbAnimals.put(dog.getId(), dog);

        AbstractPet hamster = new Hamster("Карамелька", LocalDate.of(2021, 1, 18));
        hamster.learnSkill(new Skill("Ко мне"));
        dbAnimals.put(hamster.getId(), hamster);

        AbstractPackAnimal horse = new Horse("Троя", LocalDate.of(2022, 3, 15));
        horse.setLoadCapacity(300);
        horse.learnSkill(new Skill("Стой"));
        dbAnimals.put(horse.getId(), horse);

        AbstractPackAnimal horse2 = new Horse("Файтон", LocalDate.of(2020, 7, 15));
        horse2.setLoadCapacity(400);
        horse2.learnSkill(new Skill("Повернуть налево"));
        horse2.learnSkill(new Skill("Повернуть направо"));
        dbAnimals.put(horse2.getId(), horse2);

        AbstractPackAnimal donkey = new Donkey("Перси", LocalDate.of(2022, 7, 13));
        donkey.setLoadCapacity(500);
        donkey.learnSkill(new Skill("Ко мне"));
        dbAnimals.put(donkey.getId(), donkey);

        AbstractPackAnimal camel = new Camel("Зигмунд", LocalDate.of(2021, 4, 26));
        camel.setLoadCapacity(1000);
        camel.learnSkill(new Skill("Стой"));
        dbAnimals.put(camel.getId(), camel);
    }
    @Override
    public List<AbstractAnimal> getAllAnimals() {
        List<AbstractAnimal> result = new ArrayList<>();
        for (AbstractAnimal animal: dbAnimals.values()) {
            result.add(animal);
        }
        return result;
    }

    @Override
    public AbstractAnimal getAnimalById(int animalId) {
        return dbAnimals.getOrDefault(animalId, null);
    }

    @Override
    public boolean addAnimal(AbstractAnimal animal) {
        if (dbAnimals.containsKey(animal.getId())) {return false;}
        dbAnimals.put(animal.getId(), animal);
        return true;
    }

    @Override
    public int removeAnimal(AbstractAnimal animal) {
        if (!dbAnimals.containsKey(animal.getId())) {
            return -1;
        }
        AbstractAnimal removed = dbAnimals.remove(animal.getId());
        return removed.getId();
    }
}
