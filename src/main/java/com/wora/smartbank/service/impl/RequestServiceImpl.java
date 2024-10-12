package com.wora.smartbank.service.impl;

import com.wora.smartbank.dao.RequestDao;
import com.wora.smartbank.dao.RequestStateDao;
import com.wora.smartbank.dto.RequestDetails;
import com.wora.smartbank.entities.Request;
import com.wora.smartbank.entities.RequestState;
import com.wora.smartbank.entities.State;
import com.wora.smartbank.service.RequestService;
import com.wora.smartbank.util.PaymentValidator;
import com.wora.smartbank.util.ValidationUtil;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RequestScoped
public class RequestServiceImpl implements RequestService {

    @Inject
    private RequestDao requestDao;
@Inject
private RequestStateDao requestStateDao;
    @Inject
    private ValidationUtil validationUtil;
    @Inject
    private PaymentValidator paymentValidator;


    @Override
    public void save(Request request) {
        System.out.println("here");

        RequestDetails requestDetails = new RequestDetails(
                request.getType(),
                request.getAmount(),
                request.getDurationsInMonths(),
                request.getMonthlyIncome()
        );

        Set<ConstraintViolation<Request>> violations = validationUtil.validateRequest(request);

        if (!violations.isEmpty()) {
            System.out.println("Des erreurs de validation ont été détectées :");
            for (ConstraintViolation<Request> violation : violations) {
                System.out.println("Erreur de validation : " + violation.getMessage());
            }
        } else {
            RequestDetails calculatedDetails = paymentValidator.calculate(requestDetails);

            if (!requestDetails.monthlyIncome().equals(calculatedDetails.monthlyIncome())) {
                requestDetails = new RequestDetails(
                        requestDetails.type(),
                        requestDetails.amount(),
                        calculatedDetails.durationInmonths(),
                        requestDetails.monthlyIncome()
                );
            }

            requestDao.save(request);

            RequestState requestState = new RequestState();
            requestState.setRequest(request);
            State pendingState = new State();
            pendingState.setId(1);
            requestState.setState(pendingState);
            requestState.setHistorique(LocalDate.now());
            requestState.setDescription(null);

            requestStateDao.save(requestState);

            System.out.println("Requête enregistrée avec succès avec l'état 'pending'.");
        }
    }


    @Override
    public void update(Request request) {
        Set<ConstraintViolation<Request>> violations = validationUtil.validateRequest(request);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Request> violation : violations) {
                System.out.println("Validation error: " + violation.getPropertyPath() + " " + violation.getMessage());
            }
        } else {
            requestDao.update(request);
        }
    }

    @Override
    public List<Request> findall() {
        return requestDao.findAll();
    }

    @Override
    public Request findById(long id) {
        return requestDao.findById(id);
    }

    @Override
    public void delete(long id) {
        requestDao.delete(id);
    }

    @Override
    public void updateStatus(int requestId, int stateId, String description) {
        requestDao.updateStatus(requestId, stateId, description);
    }
}
