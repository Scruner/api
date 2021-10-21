package com.example.api.students;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {
  @Bean
  public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
    return args -> {
      studentRepository.saveAll(
          List.of(
              new Student("Alex", "alex@gmail.com", LocalDate.of(2000, Month.JANUARY, 3)),
              new Student("Dan", "dan@gmail.com", LocalDate.of(2001, Month.FEBRUARY, 5)),
              new Student("Bob", "boby@gmail.com", LocalDate.of(2002, Month.MARCH, 8))));
    };
  }
}
