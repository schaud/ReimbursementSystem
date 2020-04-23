package dev.chaudhry.services;

import dev.chaudhry.entities.Employee;
import dev.chaudhry.entities.Manager;
import dev.chaudhry.entities.Reimbursement;

import java.util.ArrayList;

public interface ReimbursementService {

     Reimbursement submitReimbursement(Reimbursement reimbursement);

     Reimbursement approveReimbursement(Reimbursement reimbursement, Manager Manager);

     Reimbursement denyReimbursement(Reimbursement reimbursement, Manager manager);

     ArrayList<Reimbursement> viewAllReimbursements ();

     ArrayList<Reimbursement> viewPendingReimbursements ();

     ArrayList<Reimbursement> viewApprovedReimbursements ();

     ArrayList<Reimbursement> viewDeniedReimbursements ();

     ArrayList<Reimbursement> viewEmployeeReimbursements (Employee employee);


}
