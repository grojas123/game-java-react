package com.codeoftheweb.salvo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    public Score() {

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long score;
    public Date finishDate;
    @ManyToOne
    @JoinColumn(name="GAME_ID")
    private Game game;

    @ManyToOne
    @JoinColumn(name="PLAYER_ID")
    private Player player;


    public Score(Long score, Date finishDate, Game game, Player player) {
        this.score = score;
        this.finishDate = finishDate;
        this.game = game;
        this.player = player;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}