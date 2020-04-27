package dev.chaudhry.entities;

public class EmployeeReimburse {

    private String requesterID;
    private int reimbursementAttempts;

    public EmployeeReimburse() {
    }

    public EmployeeReimburse(String requesterID, int reimbursementAttempts) {
        this.requesterID = requesterID;
        this.reimbursementAttempts = reimbursementAttempts;
    }

    public String getRequesterID() {
        return requesterID;
    }

    public void setRequesterID(String requesterID) {
        this.requesterID = requesterID;
    }

    public int getReimbursementAttempts() {
        return reimbursementAttempts;
    }

    public void setReimbursementAttempts(int reimbursementAttempts) {
        this.reimbursementAttempts = reimbursementAttempts;
    }
}
