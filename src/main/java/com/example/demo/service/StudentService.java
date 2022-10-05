package com.example.demo.service;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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

    public void addNewStudent(StudentModel studentModel) {
        Optional<StudentModel> studentModelOptional = studentRepository.findStudentModelByEmail(studentModel.getEmail());
        if (studentModelOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(studentModel);
    }

    public void deleteStudent(Long studentId) {
       boolean exists = studentRepository.existsById(studentId);
       if(!exists) {
           throw new IllegalStateException("student with id " + studentId + " does not exist");
       }
       studentRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        StudentModel studentModel = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "student with id " + studentId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(studentModel.getName(), name)) {
            studentModel.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(studentModel.getEmail(), email)) {
            Optional<StudentModel> studentModelOptional = studentRepository.findStudentModelByEmail(email);
            if (studentModelOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            studentModel.setEmail(email);
        }
    }
}
