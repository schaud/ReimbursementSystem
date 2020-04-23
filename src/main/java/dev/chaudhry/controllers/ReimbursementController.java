package dev.chaudhry.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import dev.chaudhry.entities.Employee;
import dev.chaudhry.entities.Manager;
import dev.chaudhry.entities.Reimbursement;
import dev.chaudhry.services.ReimbursementService;
import dev.chaudhry.services.ReimbursementServiceImpl;
import jdk.nashorn.internal.parser.JSONParser;

public class ReimbursementController {

    ReimbursementService rserv = new ReimbursementServiceImpl();

    public void getAllReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Gson gson = new Gson();
        List<Reimbursement> reimbursements = rserv.viewAllReimbursements();
        PrintWriter pw = response.getWriter();
        String json = gson.toJson(reimbursements);
        pw.append(json);

    }

    public void getPendingReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Gson gson = new Gson();
        List<Reimbursement> reimbursements = rserv.viewPendingReimbursements();
        PrintWriter pw = response.getWriter();
        String json = gson.toJson(reimbursements);
        pw.append(json);

    }

    public void getApprovedReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Gson gson = new Gson();
        List<Reimbursement> reimbursements = rserv.viewApprovedReimbursements();
        PrintWriter pw = response.getWriter();
        String json = gson.toJson(reimbursements);
        pw.append(json);

    }

    public void getDeniedReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Gson gson = new Gson();
        List<Reimbursement> reimbursements = rserv.viewDeniedReimbursements();
        PrintWriter pw = response.getWriter();
        String json = gson.toJson(reimbursements);
        pw.append(json);

    }


    public void submitReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String body = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
        Gson gson = new Gson();

        Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
        rserv.submitReimbursement(reimbursement);
        response.getWriter().append("Success!!!!");
    }

    public void getEmployeeReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        List<Reimbursement> reimbursements = rserv.viewEmployeeReimbursements(employee);
        PrintWriter pw = response.getWriter();
        String json = gson.toJson(reimbursements);
        pw.append(json);
    }

    public void denyReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        String json = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
        Reimbursement reimbursement = gson.fromJson(json, Reimbursement.class);
        String username = (String) request.getSession().getAttribute("manager");
        Manager manager = new Manager();
        manager.setManagerID(username);
        rserv.denyReimbursement(reimbursement, manager);
        System.out.println(reimbursement);
        response.getWriter().append("The reimbursement has been denied.");
    }

    public void approveReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        String json = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
        Reimbursement reimbursement = gson.fromJson(json, Reimbursement.class);
        Manager manager = (Manager) request.getSession().getAttribute("manager");
        rserv.approveReimbursement(reimbursement, manager);
        System.out.println(reimbursement);
        response.getWriter().append("The reimbursement has been approved.");

    }

}
