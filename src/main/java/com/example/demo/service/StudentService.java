package com.example.demo.service;

import com.example.demo.model.StudentModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<StudentModel> getStudents() {
        return List.of(
                new StudentModel(
                        1L,
                        "Mary",
                        "mary.jammy@gmail.com",
                        LocalDate.of(1989, 01,12),
                        21
                )
        );
    }
}
