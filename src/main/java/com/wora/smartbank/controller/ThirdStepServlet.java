package com.wora.smartbank.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.wora.smartbank.dao.RequestDao;
import com.wora.smartbank.entities.Request;
import com.wora.smartbank.service.RequestService;
import com.wora.smartbank.service.impl.RequestServiceImpl;
import com.wora.smartbank.dao.impl.RequestDaoImpl;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/ThirdStep")
public class ThirdStepServlet extends HttpServlet {
    @Inject
    public RequestService requestService;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();


        String type = (String) session.getAttribute("type");
        String position = (String) session.getAttribute("position");
        String durationsInMonths = (String) session.getAttribute("durationsInMonths");
        String monthlyPayment = (String) session.getAttribute("monthlyPayment");
        String amount = (String) session.getAttribute("amount");
        String email = (String) session.getAttribute("email");
        String numberPhone = (String) session.getAttribute("numberPhone");


        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String cin = request.getParameter("cin");
        String birthdate = request.getParameter("birthdate");
        String startEmployementDate = request.getParameter("startEmployementDate");
        String monthlyIncome = request.getParameter("monthlyIncome");
        String title = request.getParameter("title");

        System.out.println("Type: " + type);
        System.out.println("Position: " + position);
        System.out.println("Durations in Months: " + durationsInMonths);
        System.out.println("Monthly Income: " + monthlyIncome);
        System.out.println("Amount: " + amount);
        System.out.println("Email: " + email);
        System.out.println("Number Phone: " + numberPhone);
        System.out.println("First Name: " + firstname);
        System.out.println("Last Name: " + lastname);
        System.out.println("CIN: " + cin);
        System.out.println("Birth Date: " + birthdate);
        System.out.println("Start Employment Date: " + startEmployementDate);
        System.out.println("monthlyIncome: " + monthlyIncome);
        System.out.println("title"+ title);

        LocalDate birthDateObj = LocalDate.parse(birthdate, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate startEmployementDateObj = LocalDate.parse(startEmployementDate, DateTimeFormatter.ISO_LOCAL_DATE);
        BigDecimal monthlyPaymentObj = new BigDecimal(monthlyPayment);
        BigDecimal monthlyPaymentDecimal = new BigDecimal(monthlyPayment);

        int durationsInMonthsInt = Integer.parseInt(durationsInMonths);
        boolean hasActivateCredits = false;
        Request requestObj = new Request();


        requestObj.setFirstName(firstname);
        requestObj.setLastName(lastname);
        requestObj.setCIN(cin);
        requestObj.setBirthDate(birthDateObj);
        requestObj.setStartEmployementDate(startEmployementDateObj);
        requestObj.setMonthlyIncome(Double.parseDouble(monthlyIncome));

        requestObj.setHasActivateCredits(hasActivateCredits);
        requestObj.setEmail(email);
        requestObj.setPhoneNumber(numberPhone);
        requestObj.setType(type);
        requestObj.setPosition(position);
        requestObj.setTitle(title);
        requestObj.setAmount(amount);
        requestObj.setDurationsInMonths(durationsInMonthsInt);
        requestObj.setMonthlyPayment(monthlyPaymentObj);

        requestService.save(requestObj);

        response.sendRedirect("Confirmation.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        String type = (String) session.getAttribute("type");
        String position = (String) session.getAttribute("position");
        String durationsInMonths = (String) session.getAttribute("durationsInMonths");
        String monthlyIncome = (String) session.getAttribute("monthlyIncome");
        String amount = (String) session.getAttribute("amount");
              String email = (String) session.getAttribute("email");
            String numberPhone = (String) session.getAttribute("numberPhone");

        request.setAttribute("type", type);
        request.setAttribute("position", position);
        request.setAttribute("durationsInMonths", durationsInMonths);
        request.setAttribute("monthlyIncome", monthlyIncome);
        request.setAttribute("amount", amount);
         request.setAttribute("email", email);
        request.setAttribute("numberPhone", numberPhone);


        RequestDispatcher dispatcher = request.getRequestDispatcher("ThirdSection.jsp");
        dispatcher.forward(request, response);
    }

}
