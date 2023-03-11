package com.kameleoon.trial_task.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "score")
    private long score;

    @Lob
    @Column(name = "graph")
    private String graph;

    public Vote() {
    }

    public Vote(long id, long score, String graph) {
        this.id = id;
        this.score = score;
        this.graph = graph;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }
}
