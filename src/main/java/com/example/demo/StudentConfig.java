package com.example.demo;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            StudentModel mary = new StudentModel(
                    "Mary",
                    "mary.jammy@gmail.com",
                    LocalDate.of(2000, 1,12),
                    21
            );
            StudentModel ralph = new StudentModel(
                    "Ralph",
                    "ralph.lauren@gmail.com",
                    LocalDate.of(2004, 8,23),
                    21
            );

            repository.saveAll(
                    List.of(mary, ralph)
            );
        };
    }
}
