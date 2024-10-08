package com.wora.smartbank.dao.impl;

import com.wora.smartbank.dao.RequestDao;
import com.wora.smartbank.entities.Request;
import com.wora.smartbank.util.JpaUtil;
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
    public void delete(long id) {
        Request request=entityManager.find(Request.class,id);
        entityManager.remove(request);

    }
}
