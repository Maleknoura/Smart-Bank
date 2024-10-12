package com.wora.smartbank.dao;

import com.wora.smartbank.entities.Request;

import java.util.List;

public interface RequestDao {
    public void save(Request request);
    public List <Request> findAll();
    public Request findById(long id);
    public void delete(long id);
    public void update(Request request);
    public void updateStatus(int requestId,int stateId,String description);
}
