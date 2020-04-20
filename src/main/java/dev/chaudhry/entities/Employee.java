package dev.chaudhry.entities;

public class Employee {

    private String EmployeeID;
    private String password;

    public Employee() {
    }

    public Employee(String employeeID, String name, String username, String password) {
        EmployeeID = employeeID;
        this.password = password;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeID='" + EmployeeID + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


