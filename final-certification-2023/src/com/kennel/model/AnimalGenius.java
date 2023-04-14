package com.kennel.model;

public enum AnimalGenius {
    DOG ("Собака"),
    CAT ("Кошка"),
    HAMSTER ("Хомяк"),
    HORSE ("Лошадь"),
    CAMEL ("Верблюд"),
    DONKEY ("Осёл");

    private String title;
    AnimalGenius(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
