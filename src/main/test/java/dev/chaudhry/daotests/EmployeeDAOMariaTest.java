package dev.chaudhry.daotests;
import dev.chaudhry.daos.EmployeeDAO;
import dev.chaudhry.daos.EmployeeDAOMaria;
import dev.chaudhry.entities.Employee;
import org.junit.Test;

public class EmployeeDAOMariaTest {

    public static EmployeeDAO employeedao = new EmployeeDAOMaria();

    @Test
    public void readEmployee(){
        Employee employee = new Employee();
        employee.setEmployeeID("employee1");
        employee.setPassword("ABC1234");
        System.out.println(employeedao.readEmployee(employee));

    }



}
