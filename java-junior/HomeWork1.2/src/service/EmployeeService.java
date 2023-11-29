package service;

import model.Employee;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<String> getUniqueDepartments(List<Employee> employees);
    void increaseSalary(List<Employee> employees, double threshold, double percent);
    Map<String, List<Employee>> groupEmployeesByDepartment(List<Employee> employees);
    Map<String, Double> averageSalaryByDepartment(List<Employee> employees);
}

