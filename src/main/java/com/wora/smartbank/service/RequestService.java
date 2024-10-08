package com.wora.smartbank.service;

import com.wora.smartbank.entities.Request;

import java.util.List;

public interface RequestService {
    public void save(Request request);
    public void update(Request request);
    List<Request> findall();
    public Request findById(long id);
    public void delete (long id);
}
