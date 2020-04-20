package dev.chaudhry.daos;
import dev.chaudhry.entities.Employee;
import dev.chaudhry.utils.ConnectionUtil;

import java.sql.*;

public class EmployeeDAOMaria implements EmployeeDAO {


    @Override
    public Employee readEmployee(Employee employee) {

        try (Connection conn = ConnectionUtil.createConnection()) {
            //
            String sql = "SELECT * FROM EMPLOYEE WHERE ID = ? AND PASSWORD = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employee.getEmployeeID());
            ps.setString(2, employee.getPassword());
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

                rs.next();
                String ID = rs.getString("ID");
                String password = rs.getString("PASSWORD");
                employee.setEmployeeID(ID);
                employee.setPassword(password);
                return employee;



        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
