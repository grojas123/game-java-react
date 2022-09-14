package com.codeoftheweb.salvo.domain;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


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
    @Enumerated(EnumType.ORDINAL)
    public categoriesGamePlayerStatus GamePlayerStatus;
    public Boolean onPlayingTurn;

    public Integer countShipsDestroyed=0;

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

    public categoriesGamePlayerStatus getGamePlayerStatus() {
        return GamePlayerStatus;
    }

    public void setGamePlayerStatus(categoriesGamePlayerStatus GamePlayerStatus) {
        this.GamePlayerStatus = GamePlayerStatus;
    }

    public Boolean getOnPlayingTurn() {
        return onPlayingTurn;
    }

    public void setOnPlayingTurn(Boolean onPlayingTurn) {
        this.onPlayingTurn = onPlayingTurn;
    }

    public Integer getCountShipsDestroyed() {
        return countShipsDestroyed;
    }

    public void setCountShipsDestroyed(Integer countShipsDestroyed) {
        this.countShipsDestroyed = countShipsDestroyed;
    }

    public categoriesGamePlayerStatus computeBoardStatus() {
        String salvoHit="03";
        int totalCellShips=15;
        List<Ship> GamePlayerShips=getShips();
        List<Salvo> GamePlayerSalvos=getSalvoes();
        int totalCountShips=GamePlayerShips.size();
        List<Boolean> checkShipsStatusClean =GamePlayerShips.stream().map(ship->ship.getShipStatus().equals(categoriesStatusShips.CLEAN)).collect(Collectors.toList());
        List<Boolean> checkSalvosStatusHit=GamePlayerSalvos.stream().map(salvo -> salvo.getStatus().equals(salvoHit)).collect(Collectors.toList());
        List<Boolean> checkShipsStatusDestroyed =GamePlayerShips.stream().map(ship->ship.getShipStatus().equals(categoriesStatusShips.DESTROYED)).collect(Collectors.toList());
        int countShipsCleans= (int) checkShipsStatusClean.stream().filter(a->a.equals(true)).count();
        int countSalvoHits= (int) checkSalvosStatusHit.stream().filter(a->a.equals(true)).count();
        int countShipsDestroyed= (int) checkShipsStatusDestroyed.stream().filter(a->a.equals(true)).count();
        setCountShipsDestroyed(countShipsDestroyed);
        if(countSalvoHits==totalCellShips){
            GamePlayerStatus=categoriesGamePlayerStatus.WON;
        } else if(countShipsCleans==totalCountShips || countShipsDestroyed<totalCountShips){
            GamePlayerStatus=categoriesGamePlayerStatus.PLAYING;
        } else if(countShipsDestroyed==totalCountShips){
            GamePlayerStatus=categoriesGamePlayerStatus.LOST;
        }
        return GamePlayerStatus;
    }
}
