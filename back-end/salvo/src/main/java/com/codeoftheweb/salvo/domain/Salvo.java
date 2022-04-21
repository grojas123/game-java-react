package com.codeoftheweb.salvo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Salvo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String salvoType;


    public Salvo() {

    }
    @ElementCollection
    @Column(name="locations")
    private List<String> locations = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "game_player")
    private GamePlayer gamePlayer;

    public Salvo(String salvoType, List<String> locations){
        this.salvoType=salvoType;
        this.locations=locations;

    }

    public String getSalvoType() {
        return salvoType;
    }

    public void setSalvoType(String salvoType) {
        this.salvoType = salvoType;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }
}
