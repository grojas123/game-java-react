package com.codeoftheweb.salvo.bootstrap;

import com.codeoftheweb.salvo.domain.GamePlayer;
import com.codeoftheweb.salvo.domain.Player;
import com.codeoftheweb.salvo.domain.Salvo;
import com.codeoftheweb.salvo.domain.Ship;
import com.codeoftheweb.salvo.repositories.SalvoRepository;
import com.codeoftheweb.salvo.repositories.ShipRepository;

import java.util.List;

public class UpdateShipsSalvos {
    public GamePlayer gamePlayer01;
    public GamePlayer gamePlayer02;
    public ShipRepository shipRepository;
    public SalvoRepository salvoRepository;

    public GamePlayer getGamePlayer01() {
        return gamePlayer01;
    }

    public void setGamePlayer01(GamePlayer gamePlayer01) {
        this.gamePlayer01 = gamePlayer01;
    }

    public GamePlayer getGamePlayer02() {
        return gamePlayer02;
    }

    public void setGamePlayer02(GamePlayer gamePlayer02) {
        this.gamePlayer02 = gamePlayer02;
    }


    public UpdateShipsSalvos(GamePlayer gamePlayer01, GamePlayer gamePlayer02,ShipRepository shipRepository,SalvoRepository salvoRepository) {

        this.gamePlayer01 = gamePlayer01;
        this.gamePlayer02 = gamePlayer02;
        this.shipRepository=shipRepository;
        this.salvoRepository=salvoRepository;
    }

    public ShipRepository getShipRepository() {
        return shipRepository;
    }

    public void setShipRepository(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public SalvoRepository getSalvoRepository() {
        return salvoRepository;
    }

    public void setSalvoRepository(SalvoRepository salvoRepository) {
        this.salvoRepository = salvoRepository;
    }

    public void UpdateSalvosAdversary(){
        String salvoStatusHit="03";
        String salvoStatusFired="02";
        String shipCellHit="02";
        Player Player01 =gamePlayer01.getPlayer();
        List<Ship> Player01Ships = gamePlayer01.getShips();
        List<Salvo> Player01Salvoes=gamePlayer01.getSalvoes();

        Player Player02=gamePlayer02.getPlayer();
        List<Ship> Player02Ships=gamePlayer02.getShips();
        List<Salvo> Player02Salvoes=gamePlayer02.getSalvoes();

        // Check the Player01 Salvoes  with the Player02 Ships
        Player01Salvoes.forEach(salvoPlayer01 -> {
            // For each salvo I check for all the ships and then ship cell locations .
            String Player01SalvoOneCellLocation=salvoPlayer01.getLocations().get(0);
            String Player01StatusSalvoOneCellLocation=Player01SalvoOneCellLocation.substring(4,6);
            List<String> Player01LocationsOneSalvo=salvoPlayer01.getLocations();

            Player02Ships.forEach(
                            ship->
                    {
                        List<String> Player02ShipCellList =ship.getLocations();
                        Integer indexOneCellShip=0;
                        Player02ShipCellList.get(indexOneCellShip);
                        //This for is for check all the cells of a ship and check against of one salvo at the time
                        // if the match happens the status of the cell of the ship change the status of the cell to shipCellHit

                        for (final String Player02ShipOneCell :Player02ShipCellList){
                            Boolean statusSlavoHit=Player01StatusSalvoOneCellLocation.equals(salvoStatusFired);
                            Boolean matchCellLocation=Player02ShipOneCell.substring(0,4).equals(Player01SalvoOneCellLocation.substring(0,4));
                            if (matchCellLocation && statusSlavoHit)
                            {


                                String cellHitValueTemp=Player02ShipOneCell.substring(0,4)+shipCellHit;
                                Player02ShipCellList.set(indexOneCellShip,cellHitValueTemp);

                                Player01LocationsOneSalvo.set(0,Player01SalvoOneCellLocation.substring(0,4)+salvoStatusHit);
                                salvoPlayer01.setLocations(Player01LocationsOneSalvo);
                                salvoRepository.save(salvoPlayer01);


                            }
                            indexOneCellShip=indexOneCellShip+1;
                        }
                            ship.setLocations(Player02ShipCellList);
                            ship.calculateStatus();
                            shipRepository.save(ship);

                    }

                    );

             });

        // Check the Player02 Salvoes  with the Player01 Ships
        Player02Salvoes.forEach(salvoPlayer02 -> {
            // For each salvo I check for all the ships and then ship cell locations .
            String Player02SalvoOneCellLocation=salvoPlayer02.getLocations().get(0);
            List<String> Player02LocationsOneSalvo=salvoPlayer02.getLocations();
            String Player02StatusSalvoOneCellLocation=Player02SalvoOneCellLocation.substring(4,6);

            Player01Ships.forEach(
                    ship->
                    {
                        List<String> Player01ShipCellList =ship.getLocations();
                        Integer indexOneCellShip=0;
                        Player01ShipCellList.get(indexOneCellShip);
                        //This for is for check all the cells of a ship and check against of one salvo at the time
                        // if the match happens the status of the cell of the ship change the status of the cell to shipCellHit
                        for (final String Player01ShipOneCell :Player01ShipCellList){
                            Boolean statusSlavoHit=Player02StatusSalvoOneCellLocation.equals(salvoStatusFired);
                            Boolean matchCellLocation=Player01ShipOneCell.substring(0,4).equals(Player02SalvoOneCellLocation.substring(0,4));
                            if (matchCellLocation && statusSlavoHit)
                            {

                                String cellHitValueTemp=Player01ShipOneCell.substring(0,4)+shipCellHit;

                                Player01ShipCellList.set(indexOneCellShip,cellHitValueTemp);
                                Player02LocationsOneSalvo.set(0,Player02SalvoOneCellLocation.substring(0,4)+salvoStatusHit);
                                salvoPlayer02.setLocations(Player02LocationsOneSalvo);
                                salvoRepository.save(salvoPlayer02);
                            }
                            indexOneCellShip=indexOneCellShip+1;
                        }
                        ship.setLocations(Player01ShipCellList);
                        ship.calculateStatus();
                        shipRepository.save(ship);
                    }
            );
        });



    }
}
