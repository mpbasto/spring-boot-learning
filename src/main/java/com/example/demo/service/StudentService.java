package com.example.demo.service;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentModel> getStudents() {
        return studentRepository.findAll();
    }
}


// To be added
//new StudentModel(
//        1L,
//        "Mary",
//        "mary.jammy@gmail.com",
//        LocalDate.of(1989, 01,12),
//        21
//        )
