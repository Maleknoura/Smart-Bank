package com.wora.smartbank.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "request_state")
public class RequestState implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    private LocalDate historique;

    @Column(length = 255)
    private String description;

    public RequestState() {}

    public RequestState(Request request, State state, LocalDate historique, String description) {
        this.request = request;
        this.state = state;
        this.historique = historique;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LocalDate getHistorique() {
        return historique;
    }

    public void setHistorique(LocalDate historique) {
        this.historique = historique;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
