package com.nathan.example.explorecali.data.entity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "explorers")
public class Explorer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "explorerId")
    private Integer id;

    @Embedded
    @AttributeOverrides(value = {
        @AttributeOverride(name = "firstName", column = @Column(name = "firstName")),
            @AttributeOverride(name = "lastName", column = @Column(name = "lastName")),
            @AttributeOverride(name = "datOfBirth", column = @Column(name = "dob")),
            @AttributeOverride(name = "email", column = @Column(name = "email")),
            @AttributeOverride(name = "address.address", column = @Column(name = "address")),
            @AttributeOverride(name = "address.city", column = @Column(name = "city")),
            @AttributeOverride(name = "address.zipcode", column = @Column(name = "zipcode")),
    })
    private Person person;
    @ManyToOne
    @JoinColumn(name = "state")
    private State state;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "tours")
    private String tours;
    @Column(name = "bio")
    private String bio;

    @OneToMany(mappedBy = "explorer")
    private Set<TourRating> ratings = new HashSet<TourRating>();

    public Explorer() {}

    public Explorer(Person person, State state, String userName, String password, String tours, String bio) {
        this.person = person;
        this.state = state;
        this.userName = userName;
        this.password = password;
        this.tours = tours;
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTours() {
        return tours;
    }

    public void setTours(String tours) {
        this.tours = tours;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Explorer{" +
                "id=" + id +
                ", person=" + person +
                ", stateId='" + state.getName() + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", tours='" + tours + '\'' +
                ", bio='" + bio + '\'' +
                ", ratings='" + ratings + '\'' +
                '}';
    }
}
