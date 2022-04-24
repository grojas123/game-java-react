package com.codeoftheweb.salvo.bootstrap;

import com.codeoftheweb.salvo.domain.GamePlayer;
import com.codeoftheweb.salvo.domain.Player;
import com.codeoftheweb.salvo.domain.Salvo;
import com.codeoftheweb.salvo.domain.Ship;
import com.codeoftheweb.salvo.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class UpdateShipsSalvos {
    public GamePlayer gamePlayer00;
    public GamePlayer gamePlayer01;
    public ShipRepository shipRepository;

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

    public UpdateShipsSalvos(GamePlayer gamePlayer00, GamePlayer gamePlayer01,ShipRepository shipRepository) {
        this.gamePlayer00 = gamePlayer00;
        this.gamePlayer01 = gamePlayer01;
        this.shipRepository=shipRepository;
    }

    public ShipRepository getShipRepository() {
        return shipRepository;
    }

    public void setShipRepository(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public void UpdateSalvosAdversary(){
        Player Player01 =gamePlayer00.getPlayer();
        List<Ship> Player01Ships = gamePlayer00.getShips();
        List<Salvo> Player01Salvoes=gamePlayer00.getSalvoes();

        Player Player02=gamePlayer01.getPlayer();
        List<Ship> Player02Ships=gamePlayer01.getShips();
        List<Salvo> Player02Salvoes=gamePlayer01.getSalvoes();


        // Check the Player01 Salvoes  with the Player02 Ships
        Player01Salvoes.forEach(salvoPlayer01 -> {
            String Player01SalvoOneCell=salvoPlayer01.getLocations().get(0);

            Player02Ships.forEach(
                            ship->
                    {
                        List<String> Player02ShipCellList =ship.getLocations();
                        Integer indexOneCellShip=0;
                        Player02ShipCellList.get(indexOneCellShip);
                        for (final String Player02ShipOneCell :Player02ShipCellList){

                            if (Player02ShipOneCell.substring(0,4).equals(Player01SalvoOneCell.substring(0,4)))
                            {
                                System.out.println("Hit a Cell");
                                String cellHitValueTemp=Player02ShipOneCell.substring(0,4)+"02";
                                //System.out.println(cellHitValueTemp);
                                Player02ShipCellList.set(indexOneCellShip,cellHitValueTemp);

                            }
                            indexOneCellShip=indexOneCellShip+1;
                        }
                            //System.out.println(Player02ShipCellList);
                            ship.setLocations(Player02ShipCellList);
                            shipRepository.save(ship);
                    }
                                );
        });

        //------------------------------------------------
        Player02Salvoes.forEach(salvoPlayer02 -> {
            String Player02SalvoOneCell=salvoPlayer02.getLocations().get(0);

            Player01Ships.forEach(
                    ship->
                    {
                        List<String> Player01ShipCellList =ship.getLocations();
                        Integer indexOneCellShip=0;
                        Player01ShipCellList.get(indexOneCellShip);
                        for (final String Player01ShipOneCell :Player01ShipCellList){

                            if (Player01ShipOneCell.substring(0,4).equals(Player02SalvoOneCell.substring(0,4)))
                            {
                                System.out.println("Hit a cell");
                                String cellHitValueTemp=Player01ShipOneCell.substring(0,4)+"02";
                                Player01ShipCellList.set(indexOneCellShip,cellHitValueTemp);

                            }
                            indexOneCellShip=indexOneCellShip+1;
                        }
                        //System.out.println(Player01ShipCellList);
                        ship.setLocations(Player01ShipCellList);
                        shipRepository.save(ship);
                    }
            );
        });



    }
}
