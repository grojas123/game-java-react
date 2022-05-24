package com.codeoftheweb.salvo.domain;

import com.codeoftheweb.salvo.repositories.GamePlayerRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    private String password;

    private String role;

    public Player() { }

    public Player(String first, String last, String email,String password) {
        this.firstName = first;
        this.lastName = last;
        this.email=email;
        this.password=password;
    }

    @OneToMany(mappedBy = "player")
    private List<Score> scores;


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
    //@JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public List getGames(GamePlayerRepository repositoryGamePlayer) {

        return repositoryGamePlayer.findByPlayer_Id(id);};


    public String toString() {
        return id + " " +firstName + " " + lastName;
    }


}