package dev.chaudhry.services;

import dev.chaudhry.daos.*;
import dev.chaudhry.entities.Employee;
import dev.chaudhry.entities.Manager;
import dev.chaudhry.entities.Reimbursement;

import java.util.ArrayList;

public class ReimbursementServiceImpl implements ReimbursementService {

    private ReimbursementDAO reimbursementdao = new ReimburstmentDAOMaria();
    private ManagerDAO managerdao = new ManagerDAOMaria();

    @Override
    public Reimbursement submitReimbursement(Reimbursement reimbursement) {
        return reimbursementdao.createRequest(reimbursement);
    }

    @Override
    public Reimbursement approveReimbursement(Reimbursement reimbursement, Manager manager) {
        System.out.println(reimbursement);
            managerdao.updateApproved(manager, reimbursement.getAmount());
            return reimbursementdao.updateReimbursement(reimbursement, "Approved", manager.getManagerID());

    }

    @Override
    public Reimbursement denyReimbursement(Reimbursement reimbursement, Manager manager) {
        if (reimbursement.getStatus().equals("Pending")) {
            return reimbursementdao.updateReimbursement(reimbursement, "Denied", manager.getManagerID());
        }
        else return null;
    }

    @Override
    public ArrayList<Reimbursement> viewAllReimbursements() {
        return reimbursementdao.viewReimbursements();
    }

    @Override
    public ArrayList<Reimbursement> viewEmployeeReimbursements(Employee employee) {
        return reimbursementdao.getReimbursementsByEmployeeID(employee.getEmployeeID());
    }

    @Override
    public ArrayList<Reimbursement> viewPendingReimbursements() {
        return reimbursementdao.viewPendingReimbursements();

    }

    @Override
    public ArrayList<Reimbursement> viewApprovedReimbursements() {
        return reimbursementdao.viewApprovedReimbursements();
    }

    @Override
    public ArrayList<Reimbursement> viewDeniedReimbursements() {
        return reimbursementdao.viewDeniedReimbursements();
    }
}
