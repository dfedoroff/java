package ru.gb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
@ContextConfiguration(classes = StudentControllerTests.TestConfig.class)
class StudentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentRepository studentRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Student student1;
    private Student student2;

    @Configuration
    @ComponentScan(basePackages = "ru.gb")
    static class TestConfig {
    }

    @BeforeEach
    void setup() {
        student1 = new Student(1, "Student1", "Group1");
        student2 = new Student(2, "Student2", "Group1");

        when(studentRepository.getAll()).thenReturn(Arrays.asList(student1, student2));
        when(studentRepository.getById(1L)).thenReturn(Optional.of(student1));
        when(studentRepository.getById(2L)).thenReturn(Optional.of(student2));
        when(studentRepository.getById(3L)).thenReturn(Optional.empty());
        when(studentRepository.getByNameContaining("Student")).thenReturn(Arrays.asList(student1, student2));
        when(studentRepository.getByGroupName("Group1")).thenReturn(Arrays.asList(student1, student2));
        when(studentRepository.save(any(Student.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(studentRepository.deleteById(1L)).thenReturn(true);
        when(studentRepository.deleteById(2L)).thenReturn(true);
        when(studentRepository.deleteById(3L)).thenReturn(false);
    }

    @Test
    void shouldReturnAllStudents() throws Exception {
        mockMvc.perform(get("/student"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Student1"))
                .andExpect(jsonPath("$[1].name").value("Student2"));
    }

    @Test
    void shouldReturnStudentById() throws Exception {
        mockMvc.perform(get("/student/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Student1"));

        mockMvc.perform(get("/student/3"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreateStudent() throws Exception {
        Student newStudent = new Student("Student3", "Group2");
        mockMvc.perform(post("/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newStudent)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Student3"))
                .andExpect(jsonPath("$.groupName").value("Group2"));
    }

    @Test
    void shouldDeleteStudent() throws Exception {
        mockMvc.perform(delete("/student/1"))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/student/3"))
                .andExpect(status().isNotFound());
    }
}
