package dev.chaudhry.services;

import dev.chaudhry.daos.EmployeeDAO;
import dev.chaudhry.daos.EmployeeDAOMaria;
import dev.chaudhry.daos.ManagerDAO;
import dev.chaudhry.daos.ManagerDAOMaria;
import dev.chaudhry.entities.Employee;
import dev.chaudhry.entities.Manager;

public class LogInServiceImpl implements LogInService {

    private EmployeeDAO employeedao = new EmployeeDAOMaria();
    private ManagerDAO managerdao = new ManagerDAOMaria();


    public Employee LogIn(Employee employee){

        return employeedao.readEmployee(employee);

    }

    public Manager LogIn(Manager manager){
        return managerdao.readManager(manager);
    }
}
