package com.wora.smartbank.dao.impl;

import com.wora.smartbank.dao.RequestStateDao;
import com.wora.smartbank.entities.RequestState;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@RequestScoped
public class RequestStateDaoImpl implements RequestStateDao {
    @Inject
    EntityManager entityManager;
    @Override
    public void save(RequestState requestState) {
        EntityTransaction transaction= entityManager.getTransaction();
        transaction.begin();
        try{
            entityManager.persist(requestState);
            transaction.commit();
        }
        catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
