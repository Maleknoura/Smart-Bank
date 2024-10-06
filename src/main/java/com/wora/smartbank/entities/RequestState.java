package com.wora.smartbank.entities;


import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "request_state")
public class RequestState implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State state;

    @Column(name = "historique")
    private String historique;

    public RequestState() {}

    public RequestState(Request request, State state, String historique) {
        this.request = request;
        this.state = state;
        this.historique = historique;
    }

    public long getId() {
        return id;
    }

    public Request getRequest() {
        return request;
    }

    public State getState() {
        return state;
    }

    public String getHistorique() {
        return historique;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setHistorique(String historique) {
        this.historique = historique;
    }
}

