package employee;

public abstract class Employee implements Comparable<Employee> {

    public abstract int calculateMonthlyAverageSalary();

    @Override
    public int compareTo(Employee other) {
        return this.calculateMonthlyAverageSalary() - other.calculateMonthlyAverageSalary();
    }
}
