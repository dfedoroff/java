package employeelist;

import employee.Employee;
import java.util.ArrayList;
import java.util.Iterator;

public class EmployeeList implements Iterable<Employee> {
    private final ArrayList<Employee> employees;

    public EmployeeList() {
        this.employees = new ArrayList<>();
    }

    public void printAllEmployees() {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employees) {
            sb.append(employee.toString())
                    .append(". Среднемесячная зарплата: ")
                    .append(employee.calculateMonthlyAverageSalary())
                    .append(" руб.\n");
        }
        System.out.println(sb.toString());
    }

    public void add(Employee employee) {
        this.employees.add(employee);
    }

    @Override
    public Iterator<Employee> iterator() {
        return new EmployeeIterator();
    }

    private class EmployeeIterator implements Iterator<Employee> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < employees.size();
        }

        @Override
        public Employee next() {
            return employees.get(currentIndex++);
        }
    }
}
