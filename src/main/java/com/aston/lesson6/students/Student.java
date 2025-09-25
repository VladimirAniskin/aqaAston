package com.aston.lesson6.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {

  private String name;

  private String group;

  private int course;

  private List<Integer> grades;

  public Student(String name, String group, int course, List<Integer> grades) {
    this.name = name;
    this.group = group;
    this.course = course;
    this.grades = new ArrayList<>(grades);
  }


  public double getAverageGrade() {
    if (grades.isEmpty()) {
      return 0.0;
    }
    int sum = 0;
    for (int grade : grades) {
      sum += grade;
    }
    return (double) sum / grades.size();
  }


  public void promoteToNextCourse() {
    if (course < 5) {
      course++;
    }
  }

  public String getName() {
    return name;
  }

  public String getGroup() {
    return group;
  }

  public int getCourse() {
    return course;
  }

  public List<Integer> getGrades() {
    return new ArrayList<>(grades);
  }

  @Override
  public String toString() {
    return String.format("Студент: %s, Группа: %s, Курс: %d, Средний балл: %.2f, Оценки: %s",
                         name, group, course, getAverageGrade(), grades);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return course == student.course &&
        Objects.equals(name, student.name) &&
        Objects.equals(group, student.group);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, group, course);
  }

}
