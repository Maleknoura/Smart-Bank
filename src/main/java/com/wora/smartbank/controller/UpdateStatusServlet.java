package com.wora.smartbank.controller;

import com.wora.smartbank.service.RequestService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/updateStatus")
public class UpdateStatusServlet extends HttpServlet {
    @Inject
    public RequestService requestService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("i am in");
    int requestId = Integer.parseInt(req.getParameter("requestId"));
        int stateId = Integer.parseInt(req.getParameter("stateId"));
        String description = req.getParameter("description");

        requestService.updateStatus(requestId, stateId,description);
        System.out.println("stateId" + stateId);
        System.out.println("requestId" + stateId);
        System.out.println("description" + description);
        resp.sendRedirect("Confirmation.jsp");
    }
}
