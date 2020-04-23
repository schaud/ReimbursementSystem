package dev.chaudhry.entities;

public class Reimbursement {

    private int reimbursementID;
    private int amount;
    private String description;
    private String requesterID;
    private String status;
    private String managerID;

    public Reimbursement() {
    }

    public Reimbursement(int reimbursementID, int amount, String description, String requesterID, String status, String managerID) {
        this.reimbursementID = reimbursementID;
        this.amount = amount;
        this.description = description;
        this.requesterID = requesterID;
        this.status = status;
        this.managerID = managerID;
    }

    public int getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(int reimbursementID) {
        this.reimbursementID = reimbursementID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequesterID() {
        return requesterID;
    }

    public void setRequesterID(String requesterID) {
        this.requesterID = requesterID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementID=" + reimbursementID +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", requesterID='" + requesterID + '\'' +
                ", status='" + status + '\'' +
                ", managerID='" + managerID + '\'' +
                '}';
    }
}