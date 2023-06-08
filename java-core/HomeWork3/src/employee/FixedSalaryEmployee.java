package employee;

public class FixedSalaryEmployee extends Employee {
    private final int monthlySalary;

    public FixedSalaryEmployee(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public int calculateMonthlyAverageSalary() {
        return this.monthlySalary;
    }

    @Override
    public String toString() {
        return "Сотрудник с фиксированной зарплатой. Месячная зарплата: " + monthlySalary;
    }
}
