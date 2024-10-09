package com.wora.smartbank.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;


@Entity
public class State implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "statetype",nullable = false, unique = true)
    private String stateType;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
    private List<RequestState> requestStates;

    public State() {}

    public State(String stateType) {
        this.stateType = stateType;
    }

    public int getId() {
        return id;
    }

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }

    public List<RequestState> getRequestStates() {
        return requestStates;
    }

    public void addRequestState(RequestState requestState) {
        requestStates.add(requestState);
        requestState.setState(this);
    }


}
