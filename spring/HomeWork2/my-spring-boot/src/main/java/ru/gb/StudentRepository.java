package ru.gb;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Component
public class StudentRepository {
    private final List<Student> students;
    private final AtomicLong idCounter = new AtomicLong(1);

    public StudentRepository() {
        this.students = new ArrayList<>();
        // Добавление начальных студентов
        students.add(new Student(idCounter.getAndIncrement(), "Student1", "Group1"));
        students.add(new Student(idCounter.getAndIncrement(), "Student2", "Group1"));
        students.add(new Student(idCounter.getAndIncrement(), "Student3", "Group2"));
        students.add(new Student(idCounter.getAndIncrement(), "Student4", "Group2"));
        students.add(new Student(idCounter.getAndIncrement(), "Student5", "Group3"));
    }

    // Получение всех студентов
    public List<Student> getAll() {
        return List.copyOf(students);
    }

    // Получение студента по ID
    public Optional<Student> getById(long id) {
        return students.stream()
                .filter(it -> it.getId() == id)
                .findFirst();
    }

    // Получение студентов по имени
    public List<Student> getByNameContaining(String name) {
        return students.stream()
                .filter(it -> it.getName().contains(name))
                .collect(Collectors.toList());
    }

    // Получение студентов по имени группы
    public List<Student> getByGroupName(String groupName) {
        return students.stream()
                .filter(it -> it.getGroupName().equals(groupName))
                .collect(Collectors.toList());
    }

    // Сохранение нового студента
    public Student save(Student student) {
        student.setId(idCounter.getAndIncrement());
        students.add(student);
        return student;
    }

    // Удаление студента по ID
    public boolean deleteById(long id) {
        return students.removeIf(it -> it.getId() == id);
    }
}
