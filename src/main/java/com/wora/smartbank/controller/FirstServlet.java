package com.wora.smartbank.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/FirstStep")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("im in do post");

        String type = req.getParameter("type");
        String position = req.getParameter("position");

        String durationsInMonths = req.getParameter("durationsInMonths");
        String monthlyPayment = req.getParameter("monthlyPayment");
        Double amount = Double.parseDouble(req.getParameter("amount"));

        session.setAttribute("type", type);
        session.setAttribute("position", position);
        session.setAttribute("durationsInMonths", durationsInMonths);
        session.setAttribute("monthlyPayment", monthlyPayment);
        session.setAttribute("amount", amount);

        System.out.println("Type: " + type);
        System.out.println("Position: " + position);
        System.out.println("Durations in Months: " + durationsInMonths);
        System.out.println("monthlyPayment: " + monthlyPayment);
        System.out.println("Amount: " + amount);
        System.out.println("done&");
        resp.sendRedirect("CoordoneesSecond.jsp");
    }
}
