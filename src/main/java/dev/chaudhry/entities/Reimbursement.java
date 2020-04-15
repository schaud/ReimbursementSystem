package dev.chaudhry.entities;

public class Reimbursement {

    private int reimbursementID;
    private int amount;
    private String description;
    private int requesterID;
    private String status;

    public Reimbursement() {
    }

    public Reimbursement(int reimbursementID, int amount, String description, int requesterID, String status) {
        this.reimbursementID = reimbursementID;
        this.amount = amount;
        this.description = description;
        this.requesterID = requesterID;
        this.status = status;
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

    public int getRequesterID() {
        return requesterID;
    }

    public void setRequesterID(int requesterID) {
        this.requesterID = requesterID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementID=" + reimbursementID +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", requesterID=" + requesterID +
                ", status='" + status + '\'' +
                '}';
    }
}
