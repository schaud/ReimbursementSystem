package dev.chaudhry.servlets;

import dev.chaudhry.entities.Employee;
import dev.chaudhry.entities.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // read that session attribute and send it to the front end
        if (request.getSession().getAttribute("employee") != null){
            Employee username = (Employee) request.getSession().getAttribute("employee");
            response.getWriter().append(username.getEmployeeID());

        } else {
            Manager username = (Manager) request.getSession().getAttribute("manager");
            response.getWriter().append(username.getManagerID());
        }

    }
}
