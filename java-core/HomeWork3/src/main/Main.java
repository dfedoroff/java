package main;

import employee.*;
import employeelist.EmployeeList;

public class Main {
    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();
        employeeList.add(new HourlyPaidEmployee(20));
        employeeList.add(new FixedSalaryEmployee(2000));
        employeeList.printAllEmployees();
    }
}
