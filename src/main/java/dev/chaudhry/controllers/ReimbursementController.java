package dev.chaudhry.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import dev.chaudhry.entities.Employee;
import dev.chaudhry.entities.EmployeeReimburse;
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

    public void getMyPendingReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        List<Reimbursement> reimbursements = rserv.viewMyPending(employee);
        PrintWriter pw = response.getWriter();
        String json = gson.toJson(reimbursements);
        pw.append(json);
    }

    public void getMyApprovedReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        List<Reimbursement> reimbursements = rserv.viewMyApproved(employee);
        PrintWriter pw = response.getWriter();
        String json = gson.toJson(reimbursements);
        pw.append(json);
    }

    public void getMyDeniedReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        List<Reimbursement> reimbursements = rserv.viewMyDenied(employee);
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

    public void showMostRequests(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Gson gson = new Gson();
        List<EmployeeReimburse> reimbursements = rserv.mostRequests();
        PrintWriter pw = response.getWriter();
        String json = gson.toJson(reimbursements);
        pw.append(json);
    }

    public void showAvgReimburse(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Gson gson = new Gson();
        int reimbursements = rserv.avgReimburse();
        PrintWriter pw = response.getWriter();
        String json = gson.toJson(reimbursements);
        pw.append(json);
    }

    public void showTotalApproved(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Gson gson = new Gson();
        int reimbursements = rserv.totalApproved();
        PrintWriter pw = response.getWriter();
        String json = gson.toJson(reimbursements);
        pw.append(json);
    }
    public void showTotalDenied(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Gson gson = new Gson();
        int reimbursements = rserv.totalDenied();
        PrintWriter pw = response.getWriter();
        String json = gson.toJson(reimbursements);
        pw.append(json);
    }
    public void showTotalRequests(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Gson gson = new Gson();
        int reimbursements = rserv.totalRequests();
        PrintWriter pw = response.getWriter();
        String json = gson.toJson(reimbursements);
        pw.append(json);
    }

}
