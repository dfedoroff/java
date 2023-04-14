package com.kennel.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAnimal {
    private static int counter;
    private final int id = ++counter;

    private AnimalGenius animalGenius;

    private String name;

    private LocalDate birthDate;

    private List<Skill> animalSkills;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public AnimalGenius getAnimalGenius() {
        return animalGenius;
    }

    public void setAnimalGenius(AnimalGenius animalGenius) {
        this.animalGenius = animalGenius;
    }

    public List<Skill> getAnimalSkills() {
        return animalSkills;
    }

    public AbstractAnimal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        animalSkills = new ArrayList<>();
    }

    public String getBurthDateAsString() {
        return String.format("%02d-%02d-%4d", birthDate.getDayOfMonth(), birthDate.getMonthValue(),
                birthDate.getYear());
    }

    public int getAge() {
        int years = Period.between(birthDate, LocalDate.now()).getYears();
        int months = Period.between(birthDate, LocalDate.now()).getMonths();
        return years * 12 + months;
    }

    public boolean learnSkill(Skill newSkill) {
        if (animalSkills.contains(newSkill)){
            return false;
        }
        animalSkills.add(newSkill);
        return true;
    }

    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}