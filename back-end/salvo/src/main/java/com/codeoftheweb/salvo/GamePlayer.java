package com.codeoftheweb.salvo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

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

    private Date gamePlayerCreationDate;

    public GamePlayer() { }
    public GamePlayer(Game game, Player player,Date gamePlayerCreationDate) {
        this.game = game;
        this.player = player;
        this.gamePlayerCreationDate=gamePlayerCreationDate;
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
}
