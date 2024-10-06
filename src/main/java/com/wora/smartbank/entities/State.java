package com.wora.smartbank.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class State implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private StateType type;

    public State() {}

    public State(long id, StateType type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public StateType getType() {
        return type;
    }

    public void setType(StateType type) {
        this.type = type;
    }
}

