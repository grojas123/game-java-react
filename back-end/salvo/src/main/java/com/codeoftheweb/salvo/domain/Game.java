package com.codeoftheweb.salvo.domain;
import com.codeoftheweb.salvo.repositories.GamePlayerRepository;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Game {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String gameName;
    private Date creationGameDate;

    public Game() { }

    @OneToMany(mappedBy = "game")
    private List<GamePlayer> gamePlayers;


    public Game(String name, Date creationGameDate ) {
        this.gameName = name;
        this.creationGameDate= creationGameDate;

    }

    public String getGameName() {
        return gameName;
    }
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Date getGameDate() {
        return creationGameDate;
    }
    public void setGameDate(String lastName) {
        this.creationGameDate = creationGameDate;
    }

    public Long getId() {
        return id;
    }


    public List getPlayers(GamePlayerRepository repositoryGamePlayer) {return  repositoryGamePlayer.findByGame_Id(id);} ;
    public String toString() {
        return id + " " + gameName + " " + creationGameDate ;
    }

}
