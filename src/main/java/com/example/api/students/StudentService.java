package com.example.api.students;

import com.example.api.response.RestApiException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> list() {
    return studentRepository.findAll();
  }

  public void add(Student student) {
    if (studentRepository.findStudentByEmail(student.getEmail()).isPresent()) {
      throw new RestApiException("Email is busy");
    }
    studentRepository.save(student);
  }

  public void delete(Long studentId) {
    studentRepository.deleteById(studentId);
  }

  public void update(Student student) {
    Optional<Student> rowInDb = studentRepository.findById(student.getId());
    if (rowInDb.isPresent()) {
      Student item = rowInDb.get();
      if (!student.getName().isEmpty()) {
        item.setName(student.getName());
      }
      if (student.getDayOfBirth() != null) {
        item.setDayOfBirth(student.getDayOfBirth());
      }
      studentRepository.save(item);
    }
  }
}
