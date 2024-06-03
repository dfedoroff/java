package ru.gb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTests {

    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository();
    }

    @Test
    void testGetAll() {
        List<Student> students = studentRepository.getAll();
        assertEquals(5, students.size(), "Должно быть 5 студентов в репозитории");
    }

    @Test
    void testGetById() {
        Optional<Student> student = studentRepository.getById(1);
        assertTrue(student.isPresent(), "Студент с ID 1 должен существовать");
        assertEquals("Student1", student.get().getName(), "Имя студента с ID 1 должно быть 'Student1'");

        student = studentRepository.getById(99);
        assertFalse(student.isPresent(), "Студент с ID 99 не должен существовать");
    }

    @Test
    void testGetByNameContaining() {
        List<Student> students = studentRepository.getByNameContaining("Student");
        assertEquals(5, students.size(), "Должно быть 5 студентов с именем, содержащим 'Student'");

        students = studentRepository.getByNameContaining("NonExistent");
        assertTrue(students.isEmpty(), "Не должно быть студентов с именем, содержащим 'NonExistent'");
    }

    @Test
    void testSave() {
        Student newStudent = new Student("NewStudent", "Group3");
        Student savedStudent = studentRepository.save(newStudent);
        assertEquals(newStudent, savedStudent, "Сохраненный студент должен совпадать с новым студентом");

        List<Student> students = studentRepository.getAll();
        assertEquals(6, students.size(), "Должно быть 6 студентов в репозитории после добавления нового");
    }

    @Test
    void testDeleteById() {
        boolean result = studentRepository.deleteById(1);
        assertTrue(result, "Удаление студента с ID 1 должно быть успешным");
        assertFalse(studentRepository.getById(1).isPresent(), "Студент с ID 1 не должен существовать после удаления");

        result = studentRepository.deleteById(99);
        assertFalse(result, "Удаление несуществующего студента с ID 99 должно быть неуспешным");
    }
}
