package com.example.api.students;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Student {

  @Id
  @javax.persistence.Id
  @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
  private Long id;

  private String name;

  @Column(unique = true)
  private String email;

  private LocalDate dayOfBirth;

  public Student() {}

  public Student(String name, String email, LocalDate dayOfBirth) {
    this.name = name;
    this.email = email;
    this.dayOfBirth = dayOfBirth;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public LocalDate getDayOfBirth() {
    return dayOfBirth;
  }

  public int getAge() {
    return Period.between(dayOfBirth, LocalDate.now()).getYears();
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDayOfBirth(LocalDate dayOfBirth) {
    this.dayOfBirth = dayOfBirth;
  }

  @Override
  public String toString() {
    return "Student{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", email='"
        + email
        + '\''
        + ", dayOfBirth="
        + dayOfBirth
        + '}';
  }
}
