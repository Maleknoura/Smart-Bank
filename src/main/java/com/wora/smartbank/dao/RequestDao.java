package com.wora.smartbank.dao;

import com.wora.smartbank.entities.Request;

import java.util.List;

public interface RequestDao {
    public void save(Request request);
    public List <Request> findAll();
    public Request findById(int id);
    public void delete(int id);
}
