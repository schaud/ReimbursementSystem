package dev.chaudhry.servlets;

import dev.chaudhry.controllers.ReimbursementController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DispatcherServlet", urlPatterns = "/api/*")
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1;

    public DispatcherServlet() {
        super();
    }

    ReimbursementController rcontroller = new ReimbursementController();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        System.out.println(uri);
        switch(uri){
            case "/api/reimbursements" : rcontroller.getAllReimbursements(request, response); break;
            case "/api/employeereimbursements" : rcontroller.getEmployeeReimbursements(request, response); break;
            case "/api/approvereimbursement" : rcontroller.approveReimbursement(request, response); break;
            case "/api/denyreimburesement" : rcontroller.denyReimbursement(request, response); break;
            case "/api/pending" : rcontroller.getPendingReimbursements(request, response); break;
            case "/api/approved" : rcontroller.getApprovedReimbursements(request, response); break;
            case "/api/denied" : rcontroller.getDeniedReimbursements(request, response); break;
            case "/api/submitreimbursement" : rcontroller.submitReimbursement(request, response); break;
            case "/api/epending" : rcontroller.getMyPendingReimbursements(request, response); break;
            case "/api/eapproved" : rcontroller.getMyApprovedReimbursements(request, response); break;
            case "/api/edenied" : rcontroller.getMyDeniedReimbursements(request, response); break;
            // BELOW ARE ALL MANAGER STATISTICS API URIS
            case "/api/mostrequests" : rcontroller.showMostRequests(request, response); break;
            case "/api/avgreimburse" : rcontroller.showAvgReimburse(request, response); break;
            case "/api/totalapproved" : rcontroller.showTotalApproved(request, response); break;
            case "/api/totaldenied" : rcontroller.showTotalDenied(request, response); break;
            case "/api/totalrequests" : rcontroller.showTotalRequests(request, response); break;




            default: response.getWriter().append("your request uri did not match anything"); break;
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}

