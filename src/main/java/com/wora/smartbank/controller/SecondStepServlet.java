package com.wora.smartbank.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/SecondStep")
public class SecondStepServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String type = (String) session.getAttribute("type");
        String position = (String) session.getAttribute("position");
        String durationsInMonths = (String) session.getAttribute("durationsInMonths");
        String monthlyPayment = (String) session.getAttribute("monthlyPayment");

        Double amount = (Double) session.getAttribute("amount");

        String email = request.getParameter("email");
        String numberPhone = request.getParameter("numberPhone");

        session.setAttribute("email", email);
        session.setAttribute("numberPhone", numberPhone);

        System.out.println("Type: " + type);
        System.out.println("Position: " + position);
        System.out.println("Durations in Months: " + durationsInMonths);
        System.out.println("Monthly Income: " + monthlyPayment);
        System.out.println("Amount: " + amount);
        System.out.println("Email: " + email);
        System.out.println("Number Phone: " + numberPhone);

        response.sendRedirect("ThirdSection.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String type = (String) session.getAttribute("type");
        String position = (String) session.getAttribute("position");
        String durationsInMonths = (String) session.getAttribute("durationsInMonths");
        String monthlyPayment = (String) session.getAttribute("monthlyPayment");

        Double amount = (Double) session.getAttribute("amount");

        request.setAttribute("type", type);
        request.setAttribute("position", position);
        request.setAttribute("durationsInMonths", durationsInMonths);
        request.setAttribute("monthlyPayment", monthlyPayment);
        request.setAttribute("amount", amount);

        RequestDispatcher dispatcher = request.getRequestDispatcher("CoordoneesSecond.jsp");
        dispatcher.forward(request, response);
    }
}
