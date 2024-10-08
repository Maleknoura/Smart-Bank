package com.wora.smartbank.controller;

import com.wora.smartbank.entities.Request;
import com.wora.smartbank.service.RequestService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/requests")
public class RequestServlet extends HttpServlet {

    @Inject
    private RequestService requestService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
        List<Request> requests = requestService.findall();

        req.setAttribute("requests", requests);
        System.out.println("requests" + requests);
        req.getRequestDispatcher("Req.jsp").forward(req, resp);
    }
}
