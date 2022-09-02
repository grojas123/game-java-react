package com.codeoftheweb.salvo.bootstrap;

import com.codeoftheweb.salvo.domain.*;
import com.codeoftheweb.salvo.repositories.GamePlayerRepository;
import com.codeoftheweb.salvo.repositories.SalvoRepository;
import com.codeoftheweb.salvo.repositories.ShipRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateBoard {

    Player player;
    Game game;

    Date gamePlayerDate;
    List<List<String>> listLocationsShips;
    List<List<String>> listLocationSalvoes;
    ShipRepository shipRepository;
    SalvoRepository salvoRepository;
    GamePlayerRepository gamePlayerRepository;

    public CreateBoard(Player player, Game game, Date gamePlayerDate, List<List<String>> listLocationsShips, List<List<String>> listLocationSalvoes, ShipRepository shipRepository, SalvoRepository salvoRepository, GamePlayerRepository gamePlayerRepository) {
        this.player = player;
        this.game = game;
        this.gamePlayerDate = gamePlayerDate;
        this.listLocationsShips = listLocationsShips;
        this.listLocationSalvoes = listLocationSalvoes;
        this.shipRepository = shipRepository;
        this.salvoRepository = salvoRepository;
        this.gamePlayerRepository = gamePlayerRepository;
    }

    public List<List<String>> getListLocationsShips() {
        return listLocationsShips;
    }

    public void setListLocationsShips(List<List<String>> listLocationsShips) {
        this.listLocationsShips = listLocationsShips;
    }

    public ShipRepository getShipRepository() {
        return shipRepository;
    }

    public void setShipRepository(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public List<List<String>> getListLocationSalvoes() {
        return listLocationSalvoes;
    }

    public void setListLocationSalvoes(List<List<String>> listLocationSalvoes) {
        this.listLocationSalvoes = listLocationSalvoes;
    }

    public GamePlayer getBoard() {
        List<Ship> shipList = new ArrayList<>();
        List<Salvo> salvoesList = new ArrayList<>();
        for(final List<String> locationShip : listLocationsShips) {
            String typeShip;

            switch (locationShip.size()){
                case 1:
                    typeShip="Ship 00";
                    break;
                case 2:
                    typeShip="Ship 01";
                    break;
                case 3:
                    typeShip="Ship 02";
                    break;
                case 4:
                    typeShip="Ship 03";
                    break;
                case 5:
                    typeShip="Ship 04";
                    break;
                default:
                    typeShip="Unknown Type";
            }
            Ship ship= new Ship(typeShip,locationShip);
            shipRepository.save(ship);
            shipList.add(ship);

            ;};

        for (final List<String> locationSalvo:listLocationSalvoes) {
            String SalvoId;
            SalvoId=locationSalvo.get(0).substring(0,4);
            Salvo salvo = new Salvo(SalvoId,locationSalvo);
            salvoRepository.save(salvo);
            salvoesList.add(salvo);
        }

        GamePlayer gamePlayer = new GamePlayer(game,player,gamePlayerDate,shipList,salvoesList);
        gamePlayerRepository.save(gamePlayer);

        for (final Ship ship :shipList) {
            ship.setGamePlayer(gamePlayer);
            shipRepository.save(ship);
        }
        for (final Salvo salvo:salvoesList){
            salvo.setGamePlayer(gamePlayer);
            salvoRepository.save(salvo);
        }
        return gamePlayer;
    };
    }


