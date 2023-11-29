package util;

import model.Employee;
import java.util.Arrays;
import java.util.List;

public class EmployeeGenerator {
    public static List<Employee> generateEmployees() {
        return Arrays.asList(
                new Employee("Иван", 30, 70000, "IT"),
                new Employee("Елена", 28, 65000, "Бухгалтерия"),
                new Employee("Сергей", 35, 80000, "Маркетинг"),
                new Employee("Мария", 40, 9000, "Продажи"),
                new Employee("Алексей", 45, 90000, "Управление"),
                new Employee("Татьяна", 25, 55000, "HR"),
                new Employee("Дмитрий", 32, 72000, "IT"),
                new Employee("Ольга", 29, 62000, "Бухгалтерия"),
                new Employee("Николай", 50, 9000, "Продажи"),
                new Employee("Ирина", 38, 78000, "Маркетинг")
        );
    }
}
