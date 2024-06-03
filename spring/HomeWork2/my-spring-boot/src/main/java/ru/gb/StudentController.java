package ru.gb;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository repository;

    // Получение всех студентов
    @GetMapping
    public List<Student> getStudents() {
        return repository.getAll();
    }

    // Получение студента по ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        Optional<Student> student = repository.getById(id);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Получение списка студентов по имени
    @GetMapping("/search")
    public List<Student> getStudentByName(@RequestParam String name) {
        return repository.getByNameContaining(name);
    }

    // Получение всех студентов группы
    @GetMapping("/group/{groupName}/student")
    public List<Student> getStudentsByGroup(@PathVariable String groupName) {
        return repository.getByGroupName(groupName);
    }

    // Создание нового студента
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = repository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    // Удаление студента по ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        if (repository.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
