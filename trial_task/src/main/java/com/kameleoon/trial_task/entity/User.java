package com.kameleoon.trial_task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "date")
    private Timestamp date;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
             cascade = CascadeType.ALL,
            mappedBy = "user")
    private List<Quote> quotes;

    public User() {
    }

    public User(long id, String name, String email, String password, Timestamp date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.date = date;
    }

    public void addQuoteToUser(Quote quote) {
        if (quotes == null) quotes = new ArrayList<>();
        quotes.add(quote);
        quote.setUser(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}
