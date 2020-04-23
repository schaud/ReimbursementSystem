package dev.chaudhry.servicestests;

import dev.chaudhry.daos.ReimbursementDAO;
import dev.chaudhry.daos.ReimburstmentDAOMaria;
import dev.chaudhry.entities.Employee;
import dev.chaudhry.entities.Manager;
import dev.chaudhry.entities.Reimbursement;
import dev.chaudhry.services.ReimbursementService;
import dev.chaudhry.services.ReimbursementServiceImpl;
import org.junit.Test;

public class ReimbursementServiceImplTest {

    public static ReimbursementService reimbursementserv = new ReimbursementServiceImpl();
    public static ReimbursementDAO reimbursementdao = new ReimburstmentDAOMaria();

    Reimbursement reimbursement = new Reimbursement();
    Employee employee = new Employee();
    Manager manager = new Manager();



    @Test
    public void submitReimbursement() {

        reimbursement.setRequesterID("employee2");
        reimbursement.setAmount(50);
        reimbursement.setStatus("Pending");
        reimbursement.setDescription("transportation");
        System.out.println(reimbursementserv.submitReimbursement(reimbursement));
    }

    @Test
    public void approveReimbursement() {
        manager.setManagerID("manager1");
        reimbursement = reimbursementdao.getReimbursementByID(2);
        System.out.println(reimbursementserv.approveReimbursement(reimbursement, manager));
    }

    @Test
    public void denyReimbursement() {
        manager.setManagerID("manager2");
        reimbursement = reimbursementdao.getReimbursementByID(3);
        System.out.println(reimbursementserv.denyReimbursement(reimbursement, manager));

    }

    @Test
    public void viewAllReimbursements(){
        System.out.println(reimbursementserv.viewAllReimbursements());

    }

    @Test
    public void viewEmployeeReimbursements(){
        employee.setEmployeeID("employee1");
        System.out.println(reimbursementserv.viewEmployeeReimbursements(employee));

    }
}
