package dev.chaudhry.daos;

import dev.chaudhry.entities.Reimbursement;
import dev.chaudhry.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class ReimburstmentDAOMaria implements ReimbursementDAO{

    @Override
    public Reimbursement createRequest(Reimbursement reimbursement) {

        try (Connection conn = ConnectionUtil.createConnection()) {
            //
            String sql = "INSERT INTO REIMBURSEMENTS VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setString(2, reimbursement.getRequesterID());
            ps.setInt(3, reimbursement.getAmount());
            ps.setString(4, reimbursement.getDescription());
            ps.setString(5, reimbursement.getStatus());
            ps.setString(6, reimbursement.getManagerID());
            ps.execute();


            return reimbursement;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Reimbursement> viewReimbursements() {

        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "SELECT * FROM REIMBURSEMENTS";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

            while (rs.next()) {

                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setReimbursementID(rs.getInt("ID"));
                reimbursement.setRequesterID(rs.getString("REQUESTER_ID"));
                reimbursement.setAmount(rs.getInt("AMOUNT"));
                reimbursement.setDescription(rs.getString("DESCRIPTION"));
                reimbursement.setStatus(rs.getString("STATUS"));
                reimbursement.setManagerID(rs.getString("MANAGER_ID"));
                reimbursements.add(reimbursement);
            }

            return reimbursements;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public Reimbursement updateReimbursement(Reimbursement reimbursement, String status, String managerID) {

        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "UPDATE REIMBURSEMENTS SET STATUS = ?, MANAGER_ID = ? WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setString(2, managerID);
            ps.setInt(3, reimbursement.getReimbursementID());
            ps.execute();

            reimbursement.setStatus(status);
            reimbursement.setManagerID(managerID);

            return reimbursement;

        } catch (
                SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Reimbursement getReimbursementByID(int id){

        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "SELECT * FROM REIMBURSEMENTS WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();

            int ID = rs.getInt("ID");
            String requesterID = rs.getString("REQUESTER_ID");
            int amount = rs.getInt("AMOUNT");
            String description = rs.getString("DESCRIPTION");
            String managerID = rs.getString("MANAGER_ID");

            Reimbursement reimbursement = new Reimbursement();
            reimbursement.setReimbursementID(ID);
            reimbursement.setRequesterID(requesterID);
            reimbursement.setAmount(amount);
            reimbursement.setDescription(description);
            reimbursement.setManagerID(managerID);

            return reimbursement;

        } catch (SQLException e) {
            //e.printStackTrace();
            return null;
        }

    }

    @Override
    public ArrayList<Reimbursement> getReimbursementsByEmployeeID(String Id) {

        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "SELECT * FROM REIMBURSEMENTS WHERE REQUESTER_ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Id);
            ResultSet rs = ps.executeQuery();

            ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

            while (rs.next()) {

                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setReimbursementID(rs.getInt("ID"));
                reimbursement.setRequesterID(rs.getString("REQUESTER_ID"));
                reimbursement.setAmount(rs.getInt("AMOUNT"));
                reimbursement.setDescription(rs.getString("DESCRIPTION"));
                reimbursement.setStatus(rs.getString("STATUS"));
                reimbursement.setManagerID(rs.getString("MANAGER_ID"));
                reimbursements.add(reimbursement);
            }

            return reimbursements;

        } catch (SQLException e) {
            //e.printStackTrace();
            return null;
        }


    }

    @Override
    public ArrayList<Reimbursement> viewPendingReimbursements() {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "SELECT * FROM REIMBURSEMENTS WHERE STATUS = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Pending");

            ResultSet rs = ps.executeQuery();

            ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

            while (rs.next()) {

                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setReimbursementID(rs.getInt("ID"));
                reimbursement.setRequesterID(rs.getString("REQUESTER_ID"));
                reimbursement.setAmount(rs.getInt("AMOUNT"));
                reimbursement.setDescription(rs.getString("DESCRIPTION"));
                reimbursement.setStatus(rs.getString("STATUS"));
                reimbursement.setManagerID(rs.getString("MANAGER_ID"));
                reimbursements.add(reimbursement);
            }

            return reimbursements;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public ArrayList<Reimbursement> viewApprovedReimbursements() {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "SELECT * FROM REIMBURSEMENTS WHERE STATUS = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Approved");

            ResultSet rs = ps.executeQuery();

            ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

            while (rs.next()) {

                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setReimbursementID(rs.getInt("ID"));
                reimbursement.setRequesterID(rs.getString("REQUESTER_ID"));
                reimbursement.setAmount(rs.getInt("AMOUNT"));
                reimbursement.setDescription(rs.getString("DESCRIPTION"));
                reimbursement.setStatus(rs.getString("STATUS"));
                reimbursement.setManagerID(rs.getString("MANAGER_ID"));
                reimbursements.add(reimbursement);
            }

            return reimbursements;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public ArrayList<Reimbursement> viewDeniedReimbursements() {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "SELECT * FROM REIMBURSEMENTS WHERE STATUS = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"Denied");

            ResultSet rs = ps.executeQuery();

            ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

            while (rs.next()) {

                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setReimbursementID(rs.getInt("ID"));
                reimbursement.setRequesterID(rs.getString("REQUESTER_ID"));
                reimbursement.setAmount(rs.getInt("AMOUNT"));
                reimbursement.setDescription(rs.getString("DESCRIPTION"));
                reimbursement.setStatus(rs.getString("STATUS"));
                reimbursement.setManagerID(rs.getString("MANAGER_ID"));
                reimbursements.add(reimbursement);
            }

            return reimbursements;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }
}
