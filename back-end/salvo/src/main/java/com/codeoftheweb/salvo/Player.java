package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import java.util.List;

import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String firstName;
    private String lastName;

    public Player() { }

    public Player(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }
    public List getGames(GamePlayerRepository repositoryGamePlayer) {return repositoryGamePlayer.findByPlayer_Id(id);};

    public String toString() {
        return id + " " +firstName + " " + lastName;
    }
}