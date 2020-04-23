package dev.chaudhry.servlets;

import dev.chaudhry.entities.Manager;
import dev.chaudhry.services.LogInService;
import dev.chaudhry.services.LogInServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ManagerLoginServlet", urlPatterns = "/mlogin")
public class ManagerLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LogInService loginserv = new LogInServiceImpl();
        String destPage = "login.html";

        Manager manager = new Manager();
        manager.setManagerID(username);
        manager.setPassword(password);
        manager = loginserv.LogIn(manager);

        if (manager != null) {
            HttpSession session = request.getSession();
            session.setAttribute("manager", manager);
            destPage = "mhome.html";
            response.sendRedirect(destPage);

//            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
//            dispatcher.forward(request, response);
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Invalid credentials. Please try again.');");
            out.println("location='login.html';");
            out.println("</script>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
