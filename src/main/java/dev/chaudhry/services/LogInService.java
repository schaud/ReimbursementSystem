package dev.chaudhry.services;

import dev.chaudhry.entities.Employee;
import dev.chaudhry.entities.Manager;

public interface LogInService {

    Employee LogIn(Employee employee);

    Manager LogIn(Manager manager);


}
