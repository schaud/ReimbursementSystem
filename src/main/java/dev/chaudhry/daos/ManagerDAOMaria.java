package dev.chaudhry.daos;

import dev.chaudhry.entities.Employee;
import dev.chaudhry.entities.Manager;
import dev.chaudhry.utils.ConnectionUtil;

import java.sql.*;

public class ManagerDAOMaria implements ManagerDAO {


    @Override
    public Manager readManager(Manager manager) {

        try (Connection conn = ConnectionUtil.createConnection()) {
            //
            String sql = "SELECT * FROM MANAGER WHERE ID = ? AND PASSWORD = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, manager.getManagerID());
            ps.setString(2, manager.getPassword());
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            rs.next();
            String ID = rs.getString("ID");
            String password = rs.getString("PASSWORD");
            manager.setManagerID(ID);
            manager.setPassword(password);
            return manager;



        } catch (SQLException e) {
            //e.printStackTrace();
            return null;
        }
    }

    @Override
    public Manager updateApproved(Manager manager, int amount) {

        try (
                Connection conn = ConnectionUtil.createConnection()) {
            String sql = "UPDATE MANAGER SET APPROVED = ? WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, manager.getAmountApproved() + amount);
            ps.setString(2, manager.getManagerID());
            boolean success = ps.execute();

            return manager;

        } catch (
                SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
