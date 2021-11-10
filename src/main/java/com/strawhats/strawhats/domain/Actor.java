package com.strawhats.strawhats.domain;

import javax.persistence.*;

@Entity //<- I want this to be a table in DB
public class Actor {

    @Id //primary key in table
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String heroes;
    private String actorName;

    public Actor() {

    }

    public Actor(long id, String heroes, String actorName) {
        this.id = id;
        this.heroes = heroes;
        this.actorName = actorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeroes() {
        return heroes;
    }

    public void setHeroes(String heroes) {
        this.heroes = heroes;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
}
