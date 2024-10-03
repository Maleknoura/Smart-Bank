package com.wora.smartbank;

import com.wora.smartbank.dao.implementation.RequestDaoImpl;
import com.wora.smartbank.entities.Request;
import com.wora.smartbank.service.impl.RequestServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RequestServiceImpl requestService = new RequestServiceImpl(new RequestDaoImpl());

        Request validRequest = new Request(1, "John", "Doe", "A123456", LocalDate.of(1990, 1, 1),
                LocalDate.of(2015, 1, 1), 5000.0, false, "john.doe@example.com",
                "0612345678", "type1", "position1", "10000", 12, new BigDecimal("500"));

        requestService.save(validRequest);

        List<Request> allRequests = requestService.findall(validRequest);

        if (allRequests.isEmpty()) {
            System.out.println("Aucune requête n'a été trouvée dans la base de données.");
        } else {
            System.out.println("Requêtes enregistrées dans la base de données :");
            for (Request req : allRequests) {
                System.out.println(req.getId() + " - " + req.getFirstName() + " " + req.getLastName());
            }
        }

        Request retrievedRequest = requestService.findById(1);
        if (retrievedRequest != null) {
            System.out.println("Requête récupérée : " + retrievedRequest.getFirstName() + " " + retrievedRequest.getLastName());
        } else {
            System.out.println("Aucune requête avec l'ID 1 trouvée.");
        }
    }
}
