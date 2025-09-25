package com.aston.lesson6;

import static com.aston.lesson6.students.StudentManagement.printAllStudents;
import static com.aston.lesson6.students.StudentManagement.printStudents;
import static com.aston.lesson6.students.StudentManagement.promoteStudents;
import static com.aston.lesson6.students.StudentManagement.removeUnderperformingStudents;

import com.aston.lesson6.phoneDirectory.PhoneDirectory;
import com.aston.lesson6.students.Student;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    PhoneDirectory directory = new PhoneDirectory();

    System.out.println("=== СТУДЕНТЫ ===");
    // Создаем коллекцию студентов
    Set<Student> students = new HashSet<>();

    // Добавление студентов с разными оценками
    students.add(new Student("Иван Иванов", "Группа 101", 1,
                             Arrays.asList(5, 4, 3, 5, 4))); // Средний: 4.2
    students.add(new Student("Петр Петров", "Группа 102", 1,
                             Arrays.asList(3, 3, 2, 3, 2))); // Средний: 2.6
    students.add(new Student("Мария Сидорова", "Группа 201", 2,
                             Arrays.asList(4, 5, 5, 4, 5))); // Средний: 4.6
    students.add(new Student("Анна Козлова", "Группа 202", 2,
                             Arrays.asList(2, 2, 3, 2, 2))); // Средний: 2.2
    students.add(new Student("Сергей Смирнов", "Группа 301", 3,
                             Arrays.asList(5, 5, 5, 5, 5))); // Средний: 5.0
    students.add(new Student("Ольга Новикова", "Группа 302", 3,
                             Arrays.asList(3, 3, 3, 3, 3))); // Средний: 3.0

    // Вывод исходный список
    printAllStudents(students, "ИСХОДНЫЙ СПИСОК СТУДЕНТОВ");

    // Вывод студентов по курсам
    printStudents(students, 1);
    printStudents(students, 2);
    printStudents(students, 3);

    // Удаляем студентов со средним баллом < 3
    removeUnderperformingStudents(students);
    printAllStudents(students, "ПОСЛЕ УДАЛЕНИЯ СТУДЕНТОВ СО СРЕДНИМ БАЛЛОМ < 3");

    // Переводим студентов на следующий курс
    promoteStudents(students);
    printAllStudents(students, "ПОСЛЕ ПЕРЕВОДА НА СЛЕДУЮЩИЙ КУРС");

    // Вывод студентов по новым курсам
    printStudents(students, 1);
    printStudents(students, 2);
    printStudents(students, 3);
    printStudents(students, 4);

    System.out.println("\n=== ДОПОЛНИТЕЛЬНЫЕ ТЕСТЫ ===");

    students.add(new Student("Дмитрий Волков", "Группа 401", 4,
                             Arrays.asList(4, 4, 4, 4, 4)));
    students.add(new Student("Елена Зайцева", "Группа 402", 4,
                             Arrays.asList(2, 2, 2, 2, 2))); // Будет удален

    printAllStudents(students, "ПОСЛЕ ДОБАВЛЕНИЯ НОВЫХ СТУДЕНТОВ");

    removeUnderperformingStudents(students);
    promoteStudents(students);

    printAllStudents(students, "ФИНАЛЬНЫЙ СПИСОК ПОСЛЕ ВСЕХ ОПЕРАЦИЙ");

    // Выводим студентов 5 курса (максимальный)
    printStudents(students, 5);

    System.out.println("=== ТЕЛЕФОННЫЙ СПРАВОЧНИК ===\n");

    System.out.println("=== ДОБАВЛЕНИЕ ЗАПИСЕЙ ===");

    // Добавляем записи
    directory.add("Иванов", "+7-911-123-45-67");
    directory.add("Петров", "+7-912-345-67-89");
    directory.add("Сидорова", "+7-913-456-78-90");
    directory.add("Иванов", "+7-914-567-89-01");
    directory.add("Петров", "+7-915-678-90-12");
    directory.add("Иванов", "+7-916-789-01-23");

    // Выводим весь справочник
    directory.printAll();

    System.out.println("\n=== ПОИСК ПО ФАМИЛИИ ===");

    // Поиск существующих фамилий
    System.out.println("Телефоны Иванова: " + directory.get("Иванов"));
    System.out.println("Телефоны Петрова: " + directory.get("Petrov"));
    System.out.println("Телефоны Сидоровой: " + directory.get("Сидорова"));

    // Поиск несуществующей фамилии
    System.out.println("Телефоны Кузнецова: " + directory.get("Кузнецов"));

    System.out.println("\n=== ДОПОЛНИТЕЛЬНЫЕ ОПЕРАЦИИ ===");

    // Проверка наличия фамилий
    System.out.println("Есть ли Иванов в справочнике: " + directory.containsLastName("Иванов"));
    System.out.println("Есть ли Кузнецов в справочнике: " + directory.containsLastName("Кузнецов"));

    // Получение всех фамилий
    System.out.println("Все фамилии в справочнике: " + directory.getAllLastNames());

    // Удаление телефона
    System.out.println("\nУдаляем телефон у Иванова: +7-914-567-89-01");
    directory.removePhone("Иванов", "+7-914-567-89-01");
    System.out.println("Телефоны Иванова после удаления: " + directory.get("Иванов"));

    // Добавляем еще записи
    System.out.println("\n=== ДОБАВЛЯЕМ ЕЩЕ ЗАПИСИ ===");
    directory.add("Смирнов", "+7-917-890-12-34");
    directory.add("Козлова", "+7-918-901-23-45");
    directory.add("Иванов", "+7-919-012-34-56"); // Новый телефон для существующей фамилии

    directory.printAll();

    System.out.println("\n=== ПРОВЕРКА РАЗЛИЧНЫХ СЦЕНАРИЕВ ===");

    // Создаем новый справочник для тестов
    PhoneDirectory testDirectory = new PhoneDirectory();

    // Тест с пустым справочником
    System.out.println("Поиск в пустом справочнике: " + testDirectory.get("Иванов"));

    // Тест с одной фамилией и одним телефоном
    testDirectory.add("Тестов", "+7-000-000-00-00");
    System.out.println("Телефоны Тестова: " + testDirectory.get("Тестов"));

    // Тест удаления фамилии
    testDirectory.removeLastName("Тестов");
    System.out.println("Телефоны Тестова после удаления: " + testDirectory.get("Тестов"));

    // Тест очистки справочника
    testDirectory.add("Временный", "+7-999-999-99-99");
    System.out.println("Размер до очистки: " + testDirectory.size());
    testDirectory.clear();
    System.out.println("Размер после очистки: " + testDirectory.size());


  }

}
