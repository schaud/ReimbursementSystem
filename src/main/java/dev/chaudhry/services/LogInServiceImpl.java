package dev.chaudhry.services;

import dev.chaudhry.daos.EmployeeDAO;
import dev.chaudhry.daos.EmployeeDAOMaria;
import dev.chaudhry.entities.Employee;

public class LogInServiceImpl implements LogInService {

    private EmployeeDAO employeedao = new EmployeeDAOMaria();


    public Employee LogIn(Employee employee){

        return employeedao.readEmployee(employee);

    }
}
