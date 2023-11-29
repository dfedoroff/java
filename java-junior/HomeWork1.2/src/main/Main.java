package main;

import model.Employee;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;
import util.EmployeeGenerator;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> employees = EmployeeGenerator.generateEmployees();

        // Вывод уникальных отделов
        System.out.println("====== УНИКАЛЬНЫЕ ОТДЕЛЫ ======");
        employeeService.getUniqueDepartments(employees).forEach(department ->
                System.out.println("Отдел: " + department));
        System.out.println();

        // Повышение зарплаты и вывод сотрудников
        System.out.println("====== СОТРУДНИКИ ПОСЛЕ ПОВЫШЕНИЯ ЗАРПЛАТЫ (ДЛЯ ЗАРПЛАТ МЕНЬШЕ 10000) ======");
        employeeService.increaseSalary(employees, 10000, 20);
        employees.forEach(employee ->
                System.out.println(employee));
        System.out.println();

        // Группировка сотрудников по отделам
        System.out.println("====== СОТРУДНИКИ ПО ОТДЕЛАМ ======");
        Map<String, List<Employee>> groupedByDept = employeeService.groupEmployeesByDepartment(employees);
        groupedByDept.forEach((department, empList) -> {
            System.out.println("\nОтдел: " + department);
            empList.forEach(employee ->
                    System.out.printf("\t%-10s | Возраст: %-3d | Зарплата: %-8.2f | Отдел: %-10s%n",
                            employee.getName(), employee.getAge(), employee.getSalary(), employee.getDepartment()));
        });
        System.out.println();

        // Средняя зарплата по отделам
        System.out.println("====== СРЕДНЯЯ ЗАРПЛАТА ПО ОТДЕЛАМ ======");
        Map<String, Double> avgSalaryByDept = employeeService.averageSalaryByDepartment(employees);
        avgSalaryByDept.forEach((department, avgSalary) ->
                System.out.printf("Отдел: %-15s Средняя зарплата: %.2f%n", department, avgSalary));
    }
}
