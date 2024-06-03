package ru.gb;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private static final AtomicLong idCounter = new AtomicLong(1);
    private long id;
    private String name;
    private String groupName;

    // Конструктор для создания нового студента с автоматическим присвоением ID
    public Student(String name, String groupName) {
        this.id = idCounter.getAndIncrement();
        this.name = name;
        this.groupName = groupName;
    }
}
