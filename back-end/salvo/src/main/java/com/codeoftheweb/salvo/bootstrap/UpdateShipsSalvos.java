package com.codeoftheweb.salvo.bootstrap;

import com.codeoftheweb.salvo.domain.GamePlayer;
import com.codeoftheweb.salvo.domain.Player;
import com.codeoftheweb.salvo.domain.Salvo;
import com.codeoftheweb.salvo.domain.Ship;
import com.codeoftheweb.salvo.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UpdateShipsSalvos {
    public GamePlayer gamePlayer00;
    public GamePlayer gamePlayer01;

    @Autowired
    ShipRepository shipRepository;
    public GamePlayer getGamePlayer00() {
        return gamePlayer00;
    }

    public void setGamePlayer00(GamePlayer gamePlayer00) {
        this.gamePlayer00 = gamePlayer00;
    }

    public GamePlayer getGamePlayer01() {
        return gamePlayer01;
    }

    public void setGamePlayer01(GamePlayer gamePlayer01) {
        this.gamePlayer01 = gamePlayer01;
    }

    public UpdateShipsSalvos(GamePlayer gamePlayer00, GamePlayer gamePlayer01) {
        this.gamePlayer00 = gamePlayer00;
        this.gamePlayer01 = gamePlayer01;
    }

    public void UpdateSalvosAdversary(){
        Player Player01 =gamePlayer00.getPlayer();
        List<Ship> Player01Ships = gamePlayer00.getShips();
        List<Salvo> Player01Salvoes=gamePlayer00.getSalvoes();

        Player Player02=gamePlayer01.getPlayer();
        List<Ship> Player02Ships=gamePlayer01.getShips();
        List<Salvo> Player02Salvoes=gamePlayer01.getSalvoes();

        System.out.println("Player01Salvoes Hits");
        System.out.println(Player01.getEmail());
        Player01Salvoes.forEach(salvoPlayer01 -> {
            String Player01SalvoLocation=salvoPlayer01.getLocations().get(0);

            Player02Ships.forEach(ship->{List<String> Player02ShipsLocations =ship.getLocations();
                Player02ShipsLocations.forEach(Player02ShipLocation->
                {
                    if (Player02ShipLocation.substring(0,4).equals(Player01SalvoLocation.substring(0,4))) {
                        System.out.println(Player02ShipLocation.substring(0,4));
                        System.out.println(Player01SalvoLocation);
                        System.out.println("Hit");
                    }
                });});
        });
        System.out.println("Player02Salvoes Hits");
        System.out.println(Player02.getEmail());
        Player02Salvoes.forEach(salvoPlayer02 -> {
            String Player02SalvoLocation=salvoPlayer02.getLocations().get(0);
            Player01Ships.forEach(ship->{List<String> Player01ShipsLocations =ship.getLocations();
                Player01ShipsLocations.forEach(Player01ShipLocation->
                {
                    if (Player01ShipLocation.substring(0,4).equals(Player02SalvoLocation.substring(0,4))) {
                        System.out.println(Player01ShipLocation.substring(0,4));
                        System.out.println(Player02SalvoLocation);
                        System.out.println("Hit");
                    }
                });});
        });

    }
}
