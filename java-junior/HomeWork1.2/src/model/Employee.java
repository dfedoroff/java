package model;

public class Employee {
    private final String name;
    private final int age;
    private double salary;
    private final String department;

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "\nИмя: " + name + ", Возраст: " + age + ", Зарплата: " + salary + ", Отдел: " + department;
    }
}
