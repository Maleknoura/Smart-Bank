package com.wora.smartbank.dao.implementation;

import com.wora.smartbank.dao.RequestDao;
import com.wora.smartbank.entities.Request;
import com.wora.smartbank.util.JpaUtil;
import jakarta.persistence.*;
import jakarta.transaction.Transaction;

import java.util.List;

public class RequestDaoImpl implements RequestDao {
    private EntityManager entityManager;
    public RequestDaoImpl(){
        this.entityManager = JpaUtil.getEntityManager();
    }
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
        Query query=entityManager.createQuery("select r from Request r");
        return query.getResultList();
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
