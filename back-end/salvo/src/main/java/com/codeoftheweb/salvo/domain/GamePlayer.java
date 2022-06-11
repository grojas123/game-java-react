package com.codeoftheweb.salvo.domain;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

@Entity
public class GamePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @ManyToOne
    @JoinColumn(name="PLAYER_ID")
    private Player player;

    @ManyToOne
    @JoinColumn(name="GAME_ID")
    private Game game;

    @ManyToOne
    @JoinColumn(name="SCORE_ID")
    private Score score;


    @OneToMany(mappedBy = "gamePlayer")
    private List<Ship> ships;

    @OneToMany(mappedBy = "gamePlayer")
    private List<Salvo> salvoes;


    private Date gamePlayerCreationDate;

    public GamePlayer() { }
    public GamePlayer(Game game, Player player,Date gamePlayerCreationDate, List<Ship> ships,List<Salvo> salvoes) {
        this.game = game;
        this.player = player;
        this.gamePlayerCreationDate=gamePlayerCreationDate;
        this.ships=ships;
        this.salvoes=salvoes;

    }

       public Date getGamePlayerCreationDate() {
        return gamePlayerCreationDate;
    }

    public void setGamePlayerCreationDate(Date gamePlayerCreationDate) {
        this.gamePlayerCreationDate =  gamePlayerCreationDate;
    };
    public void setGame(Game game) {this.game=game;};
    public Game getGame() {
        return game;
    }
    public Long getGameId() {return game.getId();}

    public void setPlayer(Player player) {this.player=player;};
    public Player getPlayer() {
        return player;
    }
    public Long getPlayerId() {return player.getId();};
    //public Long getId() { return id;  }
    public Game removeGame() {return game=null;};

    public String toString() {
        return game + " " + player+" "+ gamePlayerCreationDate;
    }

    public Long getId() {
        return id;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public List<Salvo> getSalvoes() {
        return salvoes;
    }

    public void setSalvoes(List<Salvo> salvoes) {
        this.salvoes = salvoes;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
