package dev.chaudhry.daotests;
import dev.chaudhry.daos.ReimbursementDAO;
import dev.chaudhry.daos.ReimburstmentDAOMaria;
import dev.chaudhry.entities.Reimbursement;
import org.junit.Test;

import java.util.ArrayList;


public class ReimbursementDAOMariaTest {

    public static ReimbursementDAO reimbursementdao = new ReimburstmentDAOMaria();


    @Test
    public void createRequest(){
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setRequesterID("employee1");
        reimbursement.setAmount(400);
        reimbursement.setStatus("Pending");
        reimbursement.setDescription("flights");
        System.out.println(reimbursementdao.createRequest(reimbursement));
    }

    @Test
    public void viewReimbursements(){

        ArrayList<Reimbursement> reimbursements = reimbursementdao.viewReimbursements();
        System.out.println(reimbursements);

    }

    @Test
    public void getReimbursementsByEmployeeID(){
        System.out.println(reimbursementdao.getReimbursementsByEmployeeID("employee1"));


    }

    @Test
    public void mostRequests(){
        System.out.println(reimbursementdao.mostRequests().get(0).getRequesterID());
        System.out.println(reimbursementdao.mostRequests().get(0).getReimbursementAttempts());

    }

    @Test
    public void avgReimburse(){
        System.out.println(reimbursementdao.avgReimburse());
    }



}
