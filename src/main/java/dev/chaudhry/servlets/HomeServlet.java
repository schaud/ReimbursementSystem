package dev.chaudhry.servlets;

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
        String username;
        if ((String) request.getSession().getAttribute("employee") != null){
            username = (String) request.getSession().getAttribute("employee");
        } else {
            username = (String) request.getSession().getAttribute("manager");

        }
        response.getWriter().append(username);

    }
}
