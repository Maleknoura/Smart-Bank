    package com.wora.smartbank.service.impl;

import com.wora.smartbank.dao.RequestDao;
import com.wora.smartbank.entities.Request;
import com.wora.smartbank.service.RequestService;
import com.wora.smartbank.util.ValidationUtil;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;

import java.util.List;
import java.util.Set;

    @RequestScoped
    public class RequestServiceImpl implements RequestService {

        @Inject
        private RequestDao requestDao;


    @Override
    public void save(Request request) {
      System.out.println("hello");
       Set<ConstraintViolation<Request>> violations = ValidationUtil.validateRequest(request);

        if (!violations.isEmpty()) {
            System.out.println("hereeee");
            for (ConstraintViolation<Request> violation : violations) {
                System.out.println("Validation error: " + violation.getPropertyPath() + " " + violation.getMessage());
            }
        } else {
            System.out.println("hello beforre");
            requestDao.save(request);
            System.out.println("hello after");
        }

    }

    @Override
    public void update(Request request) {
        Set<ConstraintViolation<Request>> violations = ValidationUtil.validateRequest(request);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Request> violation : violations) {
                System.out.println("Validation error: " + violation.getPropertyPath() + " " + violation.getMessage());
            }
        } else {
            requestDao.update(request);
        }
    }

    @Override
    public List<Request> findall(Request request) {
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
}
