package com.nathan.example.explorecali.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "states")
public class State {
    @Id
    @Column(name = "stateId")
    private String id;
    @Column(name = "stateName")
    private String name;

    public State() {}

    public State(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "State{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
