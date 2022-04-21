package com.codeoftheweb.salvo.domain;

import com.codeoftheweb.salvo.repositories.GamePlayerRepository;
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
    private String email;

    public Player() { }

    public Player(String first, String last, String email) {
        this.firstName = first;
        this.lastName = last;
        this.email=email;
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
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public Long getId() {
        return id;
    }

    public List getGames(GamePlayerRepository repositoryGamePlayer) {

        return repositoryGamePlayer.findByPlayer_Id(id);};


    public String toString() {
        return id + " " +firstName + " " + lastName;
    }


}