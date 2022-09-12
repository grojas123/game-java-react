package com.codeoftheweb.salvo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String shipName;
    private String statusCellClean="01";
    private String statusCellHit="02";


    @Enumerated(EnumType.ORDINAL)
    public categoriesStatusShips StatusShips;
    public Ship() {

    }
    @ElementCollection
    @Column(name="locations")
    private List<String> locations = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "game_player")
    private GamePlayer gamePlayer;

    public Ship(String shipName, List<String> locations){
        this.shipName = shipName;
        this.locations=locations;
     }

    public Integer getShipSize(){
        return getLocations().size();
    }
    public String getShipName() {
        return shipName;
    }


    public void setShipName(String shipType) {
        shipType = shipType;
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

    public categoriesStatusShips getShipStatus() {
        return StatusShips;
    }

    private void setShipStatus(categoriesStatusShips StatusShips) {
        this.StatusShips = StatusShips;
    }

    public void calculateStatus(){
            List<Boolean> checkCleans= getLocations().stream().map(locations->locations.substring(4,6).equals(statusCellClean)).collect(Collectors.toList());
            List<Boolean> checkHits= getLocations().stream().map(locations->locations.substring(4,6).equals(statusCellHit)).collect(Collectors.toList());
            int countCleans= (int) checkCleans.stream().filter(a->a.equals(true)).count();
            int countHits= (int) checkHits.stream().filter(a->a.equals(true)).count();
            if(countCleans==getShipSize()){
                    setShipStatus(categoriesStatusShips.CLEAN);
            } else if (countHits<getShipSize()){
                setShipStatus(categoriesStatusShips.HIT);
            } else if(countHits==getShipSize()){
                setShipStatus(categoriesStatusShips.DESTROYED);
            }

    }
}

