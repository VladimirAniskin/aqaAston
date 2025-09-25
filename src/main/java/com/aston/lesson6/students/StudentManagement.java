package com.aston.lesson6.students;

import java.util.Set;

public class StudentManagement {

  public static void removeUnderperformingStudents(Set<Student> students) {
    students.removeIf(student -> student.getAverageGrade() < 3.0);
  }


  public static void promoteStudents(Set<Student> students) {
    for (Student student : students) {
      if (student.getAverageGrade() >= 3.0) {
        student.promoteToNextCourse();
      }
    }
  }


  public static void printStudents(Set<Student> students, int course) {
    System.out.println("\nСтуденты " + course + " курса:");
    boolean found = false;

    for (Student student : students) {
      if (student.getCourse() == course) {
        System.out.println("• " + student.getName() + " (Группа: " + student.getGroup() +
                               ", Средний балл: " + String.format("%.2f",
                                                                  student.getAverageGrade()) + ")");
        found = true;
      }
    }

    if (!found) {
      System.out.println("На " + course + " курсе нет студентов.");
    }
  }


  public static void printAllStudents(Set<Student> students, String title) {
    System.out.println("\n" + title + ":");
    if (students.isEmpty()) {
      System.out.println("Нет студентов.");
      return;
    }

    students.forEach(student -> System.out.println("• " + student));
  }
}
