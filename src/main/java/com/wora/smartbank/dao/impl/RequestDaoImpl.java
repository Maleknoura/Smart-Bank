package com.wora.smartbank.dao.impl;

import com.wora.smartbank.dao.RequestDao;
import com.wora.smartbank.entities.Request;
import com.wora.smartbank.entities.RequestState;
import com.wora.smartbank.entities.State;
import java.time.LocalDate;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;

import java.util.List;


@RequestScoped
public class RequestDaoImpl implements RequestDao {

    @Inject
    private EntityManager entityManager;

    @Override
    public void save(Request request) {
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        try{
            entityManager.persist(request);
            transaction.commit();
        }
        catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

    }


    @Override
        public List<Request> findAll() {
            EntityTransaction transaction = entityManager.getTransaction();
            List<Request> requests = null;
            transaction.begin();
            try {
                TypedQuery<Request> query = entityManager.createQuery(
                        "SELECT r FROM Request r LEFT JOIN FETCH r.requestStates", Request.class);
                requests = query.getResultList();
                System.out.println("Number of requests found: " + requests.size());
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                System.err.println("Error during findAll: " + e.getMessage());
                e.printStackTrace();
            }
            return requests;
        }


    @Override
    public Request findById(long id) {
       Request request=entityManager.find(Request.class,id);
       return request;
    }
    @Override
    public void update(Request request){
        entityManager.merge(request);
    }

    @Override
    public void updateStatus(int requestId, int stateId,String description) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Request request = entityManager.find(Request.class, requestId);
            State state = entityManager.find(State.class, stateId);

            RequestState requestStatus = new RequestState();
            requestStatus.setRequest(request);
            requestStatus.setState(state);
            requestStatus.setHistorique(LocalDate.now());
            requestStatus.setDescription(description);

            entityManager.persist(requestStatus);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public void delete(long id) {
        Request request=entityManager.find(Request.class,id);
        entityManager.remove(request);

    }
}
