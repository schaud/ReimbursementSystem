package dev.chaudhry.services;

import dev.chaudhry.daos.*;
import dev.chaudhry.entities.Employee;
import dev.chaudhry.entities.EmployeeReimburse;
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
            manager = managerdao.readManager(manager); // reads manager directly from the database to get the current approval amount
            managerdao.updateApproved(manager, reimbursement.getAmount());
            return reimbursementdao.updateReimbursement(reimbursement, "Approved", manager.getManagerID());

    }

    @Override
    public Reimbursement denyReimbursement(Reimbursement reimbursement, Manager manager) {
            return reimbursementdao.updateReimbursement(reimbursement, "Denied", manager.getManagerID());
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

    @Override
    public ArrayList<Reimbursement> viewMyPending(Employee employee) {
        ArrayList <Reimbursement> allReimburse = reimbursementdao.getReimbursementsByEmployeeID(employee.getEmployeeID());
        ArrayList<Reimbursement> pendingReimburse = new ArrayList<>();
        for(Reimbursement r: allReimburse){
            if (r.getStatus().equals("Pending")) {
                pendingReimburse.add(r);
            }
        }

        return pendingReimburse;
    }

    @Override
    public ArrayList<Reimbursement> viewMyApproved(Employee employee) {
        ArrayList <Reimbursement> allReimburse = reimbursementdao.getReimbursementsByEmployeeID(employee.getEmployeeID());
        ArrayList<Reimbursement> approvedReimburse = new ArrayList<>();
        for(Reimbursement r: allReimburse){
            if (r.getStatus().equals("Approved")) {
                approvedReimburse.add(r);
            }
        }

        return approvedReimburse;
    }

    @Override
    public ArrayList<Reimbursement> viewMyDenied(Employee employee) {
        ArrayList <Reimbursement> allReimburse = reimbursementdao.getReimbursementsByEmployeeID(employee.getEmployeeID());
        ArrayList<Reimbursement> deniedReimburse = new ArrayList<>();
        for(Reimbursement r: allReimburse){
            if (r.getStatus().equals("Denied")) {
                deniedReimburse.add(r);
            }
        }

        return deniedReimburse;
    }

    @Override
    public ArrayList<EmployeeReimburse> mostRequests(){
        return reimbursementdao.mostRequests();
    }

    @Override
    public int avgReimburse(){
        return reimbursementdao.avgReimburse();
    }

    @Override
    public int totalApproved(){
        return reimbursementdao.totalApproved();
    }

    @Override
    public int totalDenied(){
        return reimbursementdao.totalDenied();
    }

    @Override
    public int totalRequests(){
        return reimbursementdao.totalRequests();
    }
}


