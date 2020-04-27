package dev.chaudhry.daos;

import dev.chaudhry.entities.EmployeeReimburse;
import dev.chaudhry.entities.Reimbursement;
import java.util.ArrayList;

public interface ReimbursementDAO {

    Reimbursement createRequest(Reimbursement reimbursement);

    ArrayList<Reimbursement> viewReimbursements ();

    ArrayList<Reimbursement> viewPendingReimbursements ();

    ArrayList<Reimbursement> viewApprovedReimbursements ();

    ArrayList<Reimbursement> viewDeniedReimbursements ();

    Reimbursement updateReimbursement(Reimbursement reimbursement, String status, String managerID);

    Reimbursement getReimbursementByID(int id);

    ArrayList<Reimbursement> getReimbursementsByEmployeeID(String Id);

    ArrayList<EmployeeReimburse> mostRequests();

    int avgReimburse();

    int totalApproved();

    int totalDenied();

    int totalRequests();





}
