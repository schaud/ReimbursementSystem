package dev.chaudhry.daos;
import dev.chaudhry.entities.Employee;
import dev.chaudhry.utils.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAOMaria implements EmployeeDAO {


    @Override
    public Employee readEmployee(Employee employee) {

        try (Connection conn = ConnectionUtil.createConnection()) {
            //
            String sql = "SELECT * FROM EMPLOYEE WHERE ID = ? AND PASSWORD = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employee.getEmployeeID());
            ps.setString(2, employee.getPassword());
            ps.execute();


            return employee;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
