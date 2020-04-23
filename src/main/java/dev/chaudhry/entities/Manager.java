package dev.chaudhry.entities;

public class Manager {
    private String managerID;
    private String password;
    private int amountApproved;


    public Manager() {
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAmountApproved() {
        return amountApproved;
    }

    public void setAmountApproved(int amountApproved) {
        this.amountApproved = amountApproved;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerID='" + managerID + '\'' +
                ", password='" + password + '\'' +
                ", amountApproved='" + amountApproved + '\'' +
                '}';
    }
}
