package service.impl;

import model.Employee;
import service.EmployeeService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<String> getUniqueDepartments(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public void increaseSalary(List<Employee> employees, double threshold, double percent) {
        employees.stream()
                .filter(e -> e.getSalary() < threshold)
                .forEach(e -> e.setSalary(e.getSalary() * (1 + percent / 100)));
    }

    @Override
    public Map<String, List<Employee>> groupEmployeesByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }
}
