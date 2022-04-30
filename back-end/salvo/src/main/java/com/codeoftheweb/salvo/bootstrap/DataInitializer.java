package com.codeoftheweb.salvo.bootstrap;

import com.codeoftheweb.salvo.domain.*;
import com.codeoftheweb.salvo.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }
    private final GameRepository repositoryGames;
    private final PlayerRepository repositoryPlayers;
    private final GamePlayerRepository repositoryGamePlayer;
    private final ShipRepository repositoryShips;
    private final SalvoRepository repositorySalvoes;
    public DataInitializer(GameRepository repositoryGames,PlayerRepository repositoryPlayers,GamePlayerRepository repositoryGamePlayer,ShipRepository repositoryShips,SalvoRepository repositorySalvoes) {
       this.repositoryGames=repositoryGames;
       this.repositoryPlayers=repositoryPlayers;
       this.repositoryGamePlayer=repositoryGamePlayer;
       this.repositoryShips=repositoryShips;
       this.repositorySalvoes=repositorySalvoes;
    }

    @Override
    public void run(String... args) throws Exception {
        Date game_creation_date01 = new Date();
        Date game_creation_date02= addHoursToJavaUtilDate(game_creation_date01,1);
        Date game_creation_date03= addHoursToJavaUtilDate(game_creation_date01,2);
        // Save Games
        Game Game01 = new Game("Game 01", game_creation_date01);
        Game Game02 = new Game("Game 02", game_creation_date02);
        Game Game03 = new Game("Game 03", game_creation_date03);
        repositoryGames.save(Game01);
        repositoryGames.save(Game02);
        repositoryGames.save(Game03);
        // Save Players
        Player Player01 = new Player("Jack", "Bauer","jack@example.com");
        Player Player02 = new Player("Kim", "Bassigner","kim@example.com");
        Player Player03 = new Player("Tony", "Almeida","tony@example.com");
        Player Player04 = new Player("Mia", "Rich","mia@example.com");
        Player Player05 = new Player("Arthur", "Rubinstein","arthur@example.com");
        Player Player06 = new Player("Daniel", "Barenboim","daniel@example.com");

        repositoryPlayers.save(Player01);
        repositoryPlayers.save(Player02);
        repositoryPlayers.save(Player03);
        repositoryPlayers.save(Player04);
        repositoryPlayers.save(Player05);
        repositoryPlayers.save(Player06);
    //_______________________________________________________________________________________________________
    // Creation of Game01
    //_______________________________________________________________________________________________________

        // Board Player01

        List<String> locationShip01Destroyer = new ArrayList<>();
        locationShip01Destroyer.add("010201");
        locationShip01Destroyer.add("020201");

        List<String> locationShip02Battleship = new ArrayList<>();
        locationShip02Battleship.add("050201");
        locationShip02Battleship.add("060201");
        locationShip02Battleship.add("070201");
        locationShip02Battleship.add("080201");

        List<String> locationShip03AircraftCarrier = new ArrayList<>();
        locationShip03AircraftCarrier.add("030601");
        locationShip03AircraftCarrier.add("030701");
        locationShip03AircraftCarrier.add("030801");
        locationShip03AircraftCarrier.add("030901");
        locationShip03AircraftCarrier.add("031001");

        List<String> locationShip04Submarine = new ArrayList<>();
        locationShip04Submarine.add("070801");
        locationShip04Submarine.add("070901");
        locationShip04Submarine.add("071001");

        List<String> locationShip05Cruiser = new ArrayList<>();
        locationShip05Cruiser.add("090501");
        locationShip05Cruiser.add("090601");
        locationShip05Cruiser.add("090701");

        List<List<String>> listLocationsShipsPlayer01Game01 = new ArrayList<>();;
        listLocationsShipsPlayer01Game01.add(locationShip01Destroyer);
        listLocationsShipsPlayer01Game01.add(locationShip02Battleship);
        listLocationsShipsPlayer01Game01.add(locationShip03AircraftCarrier);
        listLocationsShipsPlayer01Game01.add(locationShip04Submarine);
        listLocationsShipsPlayer01Game01.add(locationShip05Cruiser);

        List<String> locationSalvo01 = new ArrayList<>();
        locationSalvo01.add("010102");

        List<String> locationSalvo02 = new ArrayList<>();
        locationSalvo02.add("010702");

        List<String> locationSalvo03 = new ArrayList<>();
        locationSalvo03.add("010802");

        List<String> locationSalvo04 = new ArrayList<>();
        locationSalvo04.add("010902");

        List<String> locationSalvo05 = new ArrayList<>();
        locationSalvo05.add("011002");

        List<String> locationSalvo06_01 = new ArrayList<>();
        locationSalvo06_01.add("020102");

        List<String> locationSalvo06_02 = new ArrayList<>();
        locationSalvo06_02.add("030102");

        List<String> locationSalvo06_03 = new ArrayList<>();
        locationSalvo06_03.add("030802");

        List<String> locationSalvo06_04 = new ArrayList<>();
        locationSalvo06_04.add("040102");


        List<String> locationSalvo06_05 = new ArrayList<>();
        locationSalvo06_05.add("040402");

        List<String> locationSalvo06_06 = new ArrayList<>();
        locationSalvo06_06.add("050602");

        List<String> locationSalvo06_07 = new ArrayList<>();
        locationSalvo06_07.add("051002");

        List<String> locationSalvo06_08 = new ArrayList<>();
        locationSalvo06_08.add("060602");

        List<String> locationSalvo06_09 = new ArrayList<>();
        locationSalvo06_09.add("070202");

        List<String> locationSalvo06_10 = new ArrayList<>();
        locationSalvo06_10.add("070602");

        List<String> locationSalvo06_11 = new ArrayList<>();
        locationSalvo06_11.add("070702");

        List<String> locationSalvo06_12 = new ArrayList<>();
        locationSalvo06_12.add("071002");

        List<String> locationSalvo06_13 = new ArrayList<>();
        locationSalvo06_13.add("081002");

        List<String> locationSalvo06_14 = new ArrayList<>();
        locationSalvo06_14.add("091002");

        List<String> locationSalvo06_15 = new ArrayList<>();
        locationSalvo06_15.add("100302");

        List<String> locationSalvo06_16 = new ArrayList<>();
        locationSalvo06_16.add("100402");

        List<String> locationSalvo06_17 = new ArrayList<>();
        locationSalvo06_17.add("100502");

        List<String> locationSalvo06_18 = new ArrayList<>();
        locationSalvo06_18.add("100602");

        List<String> locationSalvo06_19 = new ArrayList<>();
        locationSalvo06_19.add("101002");

        List<String> locationSalvo06_20 = new ArrayList<>();
        locationSalvo06_20.add("061002");


        List<List<String>> listLocationsSalvoesPlayer01Game01 = new ArrayList<>();;
        listLocationsSalvoesPlayer01Game01.add(locationSalvo01);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo02);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo03);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo04);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo05);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_01);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_02);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_03);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_04);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_05);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_06);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_07);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_08);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_09);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_10);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_11);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_12);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_13);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_14);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_15);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_16);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_17);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_18);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_19);
        listLocationsSalvoesPlayer01Game01.add(locationSalvo06_20);
        Date gamePlayer01Date = new Date();

        CreateBoard boardPlayer01Game01 = new CreateBoard(Player01,Game01,gamePlayer01Date,listLocationsShipsPlayer01Game01,listLocationsSalvoesPlayer01Game01,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer01Game01=boardPlayer01Game01.getBoard();


        // To Create the Board of Player02 in Game01

        List<String> locationShip06Battleship = new ArrayList<>();
        locationShip06Battleship.add("010101");
        locationShip06Battleship.add("020101");
        locationShip06Battleship.add("020101");
        locationShip06Battleship.add("040101");

        List<String> locationShip07Submarine = new ArrayList<>();
        locationShip07Submarine.add("010701");
        locationShip07Submarine.add("010801");
        locationShip07Submarine.add("010901");
        locationShip07Submarine.add("011001");

        List<String> locationShip08Cruiser = new ArrayList<>();
        locationShip08Cruiser.add("050601");
        locationShip08Cruiser.add("060601");
        locationShip08Cruiser.add("070601");


        List<String> locationShip09Submarine = new ArrayList<>();
        locationShip09Submarine.add("100401");
        locationShip09Submarine.add("100501");
        locationShip09Submarine.add("100601");

        List<String> locationShip10AircraftCarrier = new ArrayList<>();
        locationShip10AircraftCarrier.add("051001");
        locationShip10AircraftCarrier.add("061001");
        locationShip10AircraftCarrier.add("071001");
        locationShip10AircraftCarrier.add("081001");
        locationShip10AircraftCarrier.add("091001");

        List<List<String>> listLocationsShipsPlayer02Game01 = new ArrayList<>();
        listLocationsShipsPlayer02Game01.add(locationShip06Battleship);
        listLocationsShipsPlayer02Game01.add(locationShip07Submarine);
        listLocationsShipsPlayer02Game01.add(locationShip08Cruiser);
        listLocationsShipsPlayer02Game01.add(locationShip09Submarine);
        listLocationsShipsPlayer02Game01.add(locationShip10AircraftCarrier);


        List<String> locationSalvo06 = new ArrayList<>();
        locationSalvo06.add("010702");

        List<String> locationSalvo07 = new ArrayList<>();
        locationSalvo07.add("030202");

        List<String> locationSalvo08 = new ArrayList<>();
        locationSalvo08.add("030602");

        List<String> locationSalvo09 = new ArrayList<>();
        locationSalvo09.add("030702");

        List<String> locationSalvo10 = new ArrayList<>();
        locationSalvo10.add("030802");

        List<String> locationSalvo10_01 = new ArrayList<>();
        locationSalvo10_01.add("030902");

        List<String> locationSalvo10_02 = new ArrayList<>();
        locationSalvo10_02.add("031002");

        List<String> locationSalvo10_03 = new ArrayList<>();
        locationSalvo10_03.add("050202");

        List<String> locationSalvo10_04 = new ArrayList<>();
        locationSalvo10_04.add("050502");

        List<String> locationSalvo10_05 = new ArrayList<>();
        locationSalvo10_05.add("051002");

        List<String> locationSalvo10_06 = new ArrayList<>();
        locationSalvo10_06.add("060502");

        List<String> locationSalvo10_07 = new ArrayList<>();
        locationSalvo10_07.add("061002");

        List<String> locationSalvo10_08 = new ArrayList<>();
        locationSalvo10_08.add("070202");

        List<String> locationSalvo10_09 = new ArrayList<>();
        locationSalvo10_09.add("070902");

        List<String> locationSalvo10_10 = new ArrayList<>();
        locationSalvo10_10.add("080202");

        List<String> locationSalvo10_11 = new ArrayList<>();
        locationSalvo10_11.add("080802");

        List<String> locationSalvo10_12 = new ArrayList<>();
        locationSalvo10_12.add("090602");

        List<String> locationSalvo10_13 = new ArrayList<>();
        locationSalvo10_13.add("100402");

        List<String> locationSalvo10_14 = new ArrayList<>();
        locationSalvo10_14.add("100802");


        List<List<String>> listLocationsSalvoesPlayer02Game01 = new ArrayList<>();
        listLocationsSalvoesPlayer02Game01.add(locationSalvo06);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo07);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo08);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo09);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10_01);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10_02);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10_03);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10_04);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10_05);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10_06);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10_07);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10_08);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10_09);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10_10);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10_11);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10_12);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10_13);
        listLocationsSalvoesPlayer02Game01.add(locationSalvo10_14);

        Date gamePlayer02Date = new Date();

        CreateBoard boardPlayer02Game01 = new CreateBoard(Player02,Game01,gamePlayer02Date,listLocationsShipsPlayer02Game01,listLocationsSalvoesPlayer02Game01,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer02Game01=boardPlayer02Game01.getBoard();
        // Update the data between the two Boards created
        UpdateShipsSalvos updateGame01SalvosAgainstShipsPlayer01Player02TwoWays= new UpdateShipsSalvos(gamePlayerPlayer01Game01,gamePlayerPlayer02Game01,repositoryShips);
        updateGame01SalvosAgainstShipsPlayer01Player02TwoWays.UpdateSalvosAdversary();
        //_______________________________________________________________________________________________________
        // End of Game01
        //_______________________________________________________________________________________________________

        //_______________________________________________________________________________________________________
        // Creation Game02
        //_______________________________________________________________________________________________________

        // Creation of Board Player03

        List<String> locationShip11Submarine = new ArrayList<>();
        locationShip11Submarine.add("030201");
        locationShip11Submarine.add("040201");
        locationShip11Submarine.add("050201");

        List<String> locationShip12AircraftCarrier = new ArrayList<>();
        locationShip12AircraftCarrier.add("050501");
        locationShip12AircraftCarrier.add("060501");
        locationShip12AircraftCarrier.add("070501");
        locationShip12AircraftCarrier.add("080501");
        locationShip12AircraftCarrier.add("090501");

        List<String> locationShip13BattleShip = new ArrayList<>();
        locationShip13BattleShip.add("030701");
        locationShip13BattleShip.add("040701");
        locationShip13BattleShip.add("050701");
        locationShip13BattleShip.add("060701");

        List<String> locationShip14Carrier = new ArrayList<>();
        locationShip14Carrier.add("080901");
        locationShip14Carrier.add("090901");
        locationShip14Carrier.add("100901");

        List<String> locationShip15Destroyer = new ArrayList<>();
        locationShip15Destroyer.add("011001");
        locationShip15Destroyer.add("021001");
        locationShip15Destroyer.add("031001");

        List<List<String>> listLocationsShipsPlayer03Game02 = new ArrayList<>();
        listLocationsShipsPlayer03Game02.add(locationShip11Submarine);
        listLocationsShipsPlayer03Game02.add(locationShip12AircraftCarrier);
        listLocationsShipsPlayer03Game02.add(locationShip13BattleShip);
        listLocationsShipsPlayer03Game02.add(locationShip14Carrier);
        listLocationsShipsPlayer03Game02.add(locationShip15Destroyer);

        List<String> locationSalvo11 = new ArrayList<>();
        locationSalvo11.add("010102");

        List<String> locationSalvo12 = new ArrayList<>();
        locationSalvo12.add("010702");

        List<String> locationSalvo13 = new ArrayList<>();
        locationSalvo13.add("020902");

        List<String> locationSalvo14 = new ArrayList<>();
        locationSalvo14.add("030402");

        List<String> locationSalvo15 = new ArrayList<>();
        locationSalvo15.add("041002");

        List<String> locationSalvo15_01 = new ArrayList<>();
        locationSalvo15_01.add("050302");

        List<String> locationSalvo15_02 = new ArrayList<>();
        locationSalvo15_02.add("050402");

        List<String> locationSalvo15_03 = new ArrayList<>();
        locationSalvo15_03.add("050602");

        List<String> locationSalvo15_04 = new ArrayList<>();
        locationSalvo15_04.add("070202");

        List<String> locationSalvo15_05 = new ArrayList<>();
        locationSalvo15_05.add("070302");

        List<String> locationSalvo15_06 = new ArrayList<>();
        locationSalvo15_06.add("070402");

    /*  Skipped to continue the consistency of the counting   List<String> locationSalvo15_07 = new ArrayList<>(); */

        List<String> locationSalvo15_08 = new ArrayList<>();
        locationSalvo15_08.add("070802");

        List<String> locationSalvo15_09 = new ArrayList<>();
        locationSalvo15_09.add("080602");

        List<String> locationSalvo15_10 = new ArrayList<>();
        locationSalvo15_10.add("100702");

        List<String> locationSalvo15_11 = new ArrayList<>();
        locationSalvo15_11.add("101002");

        List<String> locationSalvo15_12 = new ArrayList<>();
        locationSalvo15_12.add("100102");

        List<List<String>> listLocationsSalvoesPlayer03Game02 = new ArrayList<>();
        listLocationsSalvoesPlayer03Game02.add(locationSalvo11);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo12);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo13);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo14);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo15);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo15_01);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo15_02);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo15_03);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo15_04);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo15_05);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo15_06);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo15_08);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo15_09);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo15_10);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo15_11);
        listLocationsSalvoesPlayer03Game02.add(locationSalvo15_12);


        Date gamePlayer03Date = new Date();

        CreateBoard boardPlayer03Game02 = new CreateBoard(Player03,Game02,gamePlayer03Date,listLocationsShipsPlayer03Game02,listLocationsSalvoesPlayer03Game02,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer03Game02=boardPlayer03Game02.getBoard();

        // Creation of Board Player04 in Game02

        List<String> locationShip16AircraftCarrier = new ArrayList<>();
        locationShip16AircraftCarrier.add("010101");
        locationShip16AircraftCarrier.add("010201");
        locationShip16AircraftCarrier.add("010301");
        locationShip16AircraftCarrier.add("010401");
        locationShip16AircraftCarrier.add("010501");

        List<String> locationShip17Submarine = new ArrayList<>();
        locationShip17Submarine.add("070201");
        locationShip17Submarine.add("070301");
        locationShip17Submarine.add("070401");

        List<String> locationShip18Cruiser = new ArrayList<>();
        locationShip18Cruiser.add("070701");
        locationShip18Cruiser.add("070801");
        locationShip18Cruiser.add("070901");

        List<String> locationShip19Battleship = new ArrayList<>();
        locationShip19Battleship.add("040601");
        locationShip19Battleship.add("040701");
        locationShip19Battleship.add("040801");
        locationShip19Battleship.add("040901");

        List<String> locationShip20Destroyer = new ArrayList<>();
        locationShip20Destroyer.add("100501");
        locationShip20Destroyer.add("100601");

        List<List<String>> listLocationsShipsPlayer04Game02 = new ArrayList<>();
        listLocationsShipsPlayer04Game02.add(locationShip16AircraftCarrier);
        listLocationsShipsPlayer04Game02.add(locationShip17Submarine);
        listLocationsShipsPlayer04Game02.add(locationShip18Cruiser);
        listLocationsShipsPlayer04Game02.add(locationShip19Battleship);
        listLocationsShipsPlayer04Game02.add(locationShip20Destroyer);


       // Create the Salvoes

        List<String> locationSalvo16 = new ArrayList<>();
        locationSalvo16.add("010102");

        List<String> locationSalvo17 = new ArrayList<>();
        locationSalvo17.add("011002");

        List<String> locationSalvo18 = new ArrayList<>();
        locationSalvo18.add("021002");

        List<String> locationSalvo19 = new ArrayList<>();
        locationSalvo19.add("030202");

        List<String> locationSalvo20 = new ArrayList<>();
        locationSalvo20.add("030702");

        List<String> locationSalvo20_01 = new ArrayList<>();
        locationSalvo20_01.add("040202");

        List<String> locationSalvo20_02 = new ArrayList<>();
        locationSalvo20_02.add("040702");

        List<String> locationSalvo20_03 = new ArrayList<>();
        locationSalvo20_03.add("050202");

        List<String> locationSalvo20_04 = new ArrayList<>();
        locationSalvo20_04.add("050502");

        List<String> locationSalvo20_05 = new ArrayList<>();
        locationSalvo20_05.add("050702");

        List<String> locationSalvo20_06 = new ArrayList<>();
        locationSalvo20_06.add("060502");

        List<String> locationSalvo20_07 = new ArrayList<>();
        locationSalvo20_07.add("060602");

        List<String> locationSalvo20_08 = new ArrayList<>();
        locationSalvo20_08.add("060702");

        List<String> locationSalvo20_09 = new ArrayList<>();
        locationSalvo20_09.add("070502");

        List<String> locationSalvo20_10 = new ArrayList<>();
        locationSalvo20_10.add("080502");

        List<String> locationSalvo20_11 = new ArrayList<>();
        locationSalvo20_11.add("080902");

        List<String> locationSalvo20_12 = new ArrayList<>();
        locationSalvo20_12.add("090502");

        List<String> locationSalvo20_13 = new ArrayList<>();
        locationSalvo20_13.add("090902");

        List<String> locationSalvo20_14 = new ArrayList<>();
        locationSalvo20_14.add("031002");

        List<String> locationSalvo20_15 = new ArrayList<>();
        locationSalvo20_15.add("100902");

        List<String> locationSalvo20_16 = new ArrayList<>();
        locationSalvo20_16.add("101002");

        List<List<String>> listLocationsSalvoesPlayer04Game02 = new ArrayList<>();
        listLocationsSalvoesPlayer04Game02.add(locationSalvo16);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo17);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo18);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo19);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_01);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_02);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_03);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_04);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_05);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_06);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_07);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_08);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_09);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_10);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_11);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_12);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_13);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_14);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_15);
        listLocationsSalvoesPlayer04Game02.add(locationSalvo20_16);

        Date gamePlayer04Date = new Date();

        CreateBoard boardPlayer04Game02 = new CreateBoard(Player04,Game02,gamePlayer04Date,listLocationsShipsPlayer04Game02,listLocationsSalvoesPlayer04Game02,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer04Game02=boardPlayer04Game02.getBoard();

        //------------Update the two Boards
        UpdateShipsSalvos updateGame02SalvosAgainstShipsPlayer03Player04TwoWays= new UpdateShipsSalvos(gamePlayerPlayer03Game02,gamePlayerPlayer04Game02,repositoryShips);
        updateGame02SalvosAgainstShipsPlayer03Player04TwoWays.UpdateSalvosAdversary();

        //_______________________________________________________________________________________________________
        // End of Game02
        //_______________________________________________________________________________________________________


        //_______________________________________________________________________________________________________
        // Creation of Game03
        //_______________________________________________________________________________________________________

        // Board Player05 in Game03

        List<String> locationShip21Submarine = new ArrayList<>();
        locationShip21Submarine.add("030201");
        locationShip21Submarine.add("040201");
        locationShip21Submarine.add("050201");

        List<String> locationShip22AircraftCarrier = new ArrayList<>();
        locationShip22AircraftCarrier.add("040701");
        locationShip22AircraftCarrier.add("050701");
        locationShip22AircraftCarrier.add("060701");
        locationShip22AircraftCarrier.add("070701");
        locationShip22AircraftCarrier.add("080701");

        List<String> locationShip23Destroyer = new ArrayList<>();
        locationShip23Destroyer.add("070501");
        locationShip23Destroyer.add("080501");

        List<String> locationShip24Cruiser = new ArrayList<>();
        locationShip24Cruiser.add("030801");
        locationShip24Cruiser.add("030901");
        locationShip24Cruiser.add("031001");

        List<String> locationShip25BattleShip = new ArrayList<>();
        locationShip25BattleShip.add("100201");
        locationShip25BattleShip.add("100301");
        locationShip25BattleShip.add("100401");
        locationShip25BattleShip.add("100501");

        List<List<String>> listLocationsShipsPlayer05Game03 = new ArrayList<>();
        listLocationsShipsPlayer05Game03.add(locationShip21Submarine);
        listLocationsShipsPlayer05Game03.add(locationShip22AircraftCarrier);
        listLocationsShipsPlayer05Game03.add(locationShip23Destroyer);
        listLocationsShipsPlayer05Game03.add(locationShip24Cruiser);
        listLocationsShipsPlayer05Game03.add(locationShip25BattleShip);

        // Creation of Salvoes for Player05

        List<String> locationSalvo21 = new ArrayList<>();
        locationSalvo21.add("010102");

        List<String> locationSalvo22 = new ArrayList<>();
        locationSalvo22.add("020602");

        List<String> locationSalvo23 = new ArrayList<>();
        locationSalvo23.add("020702");

        List<String> locationSalvo24 = new ArrayList<>();
        locationSalvo24.add("020802");

        List<String> locationSalvo25 = new ArrayList<>();
        locationSalvo25.add("030102");

        List<String> locationSalvo26 = new ArrayList<>();
        locationSalvo26.add("030402");

        List<String> locationSalvo27 = new ArrayList<>();
        locationSalvo27.add("040102");

        List<String> locationSalvo28 = new ArrayList<>();
        locationSalvo28.add("040402");

        List<String> locationSalvo29 = new ArrayList<>();
        locationSalvo29.add("050102");

        List<String> locationSalvo30 = new ArrayList<>();
        locationSalvo30.add("050402");

        List<String> locationSalvo31 = new ArrayList<>();
        locationSalvo31.add("060102");

        List<String> locationSalvo32 = new ArrayList<>();
        locationSalvo32.add("060402");

        List<String> locationSalvo33 = new ArrayList<>();
        locationSalvo33.add("070102");

        List<String> locationSalvo34 = new ArrayList<>();
        locationSalvo34.add("070802");

        List<String> locationSalvo35 = new ArrayList<>();
        locationSalvo35.add("070902");

        List<String> locationSalvo36 = new ArrayList<>();
        locationSalvo36.add("071002");

        List<String> locationSalvo37 = new ArrayList<>();
        locationSalvo37.add("080602");

        List<String> locationSalvo37_01 = new ArrayList<>();
        locationSalvo37_01.add("090602");

        List<List<String>> listLocationsSalvoesPlayer05Game03 = new ArrayList<>();
        listLocationsSalvoesPlayer05Game03.add(locationSalvo21);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo22);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo23);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo24);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo25);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo26);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo27);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo28);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo29);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo30);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo31);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo32);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo33);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo34);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo35);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo36);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo37);
        listLocationsSalvoesPlayer05Game03.add(locationSalvo37_01);

        Date gamePlayer05Date = new Date();

        CreateBoard boardPlayer05Game03 = new CreateBoard(Player05,Game03,gamePlayer05Date,listLocationsShipsPlayer05Game03,listLocationsSalvoesPlayer05Game03,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer05Game03=boardPlayer05Game03.getBoard();

        // Creation Board Player06 in Game03

        List<String> locationShip26Cruiser = new ArrayList<>();
        locationShip26Cruiser.add("020601");
        locationShip26Cruiser.add("020701");
        locationShip26Cruiser.add("020801");

        List<String> locationShip27BattleShip = new ArrayList<>();
        locationShip27BattleShip.add("030401");
        locationShip27BattleShip.add("040401");
        locationShip27BattleShip.add("050401");
        locationShip27BattleShip.add("060401");

        List<String> locationShip28AircraftCarrier = new ArrayList<>();
        locationShip28AircraftCarrier.add("030101");
        locationShip28AircraftCarrier.add("040101");
        locationShip28AircraftCarrier.add("050101");
        locationShip28AircraftCarrier.add("060101");
        locationShip28AircraftCarrier.add("070101");

        List<String> locationShip29Submarine = new ArrayList<>();
        locationShip29Submarine.add("070801");
        locationShip29Submarine.add("070901");
        locationShip29Submarine.add("071001");

        List<String> locationShip30Destroyer = new ArrayList<>();
        locationShip30Destroyer.add("080601");
        locationShip30Destroyer.add("090601");

        List<List<String>> listLocationsShipsPlayer06Game03 = new ArrayList<>();
        listLocationsShipsPlayer06Game03.add(locationShip26Cruiser);
        listLocationsShipsPlayer06Game03.add(locationShip27BattleShip);
        listLocationsShipsPlayer06Game03.add(locationShip28AircraftCarrier);
        listLocationsShipsPlayer06Game03.add(locationShip29Submarine);
        listLocationsShipsPlayer06Game03.add(locationShip30Destroyer);


        // The creation of Player06 Salvoes

        List<String> locationSalvo38 = new ArrayList<>();
        locationSalvo38.add("020802");

        List<String> locationSalvo39 = new ArrayList<>();
        locationSalvo39.add("020902");

        List<String> locationSalvo40 = new ArrayList<>();
        locationSalvo40.add("021002");

        List<String> locationSalvo41 = new ArrayList<>();
        locationSalvo41.add("030202");

        List<String> locationSalvo42 = new ArrayList<>();
        locationSalvo42.add("030702");

        List<String> locationSalvo43 = new ArrayList<>();
        locationSalvo43.add("040202");

        List<String> locationSalvo44 = new ArrayList<>();
        locationSalvo44.add("040702");

        List<String> locationSalvo45 = new ArrayList<>();
        locationSalvo45.add("050202");

        List<String> locationSalvo46 = new ArrayList<>();
        locationSalvo46.add("050702");

        List<String> locationSalvo47 = new ArrayList<>();
        locationSalvo47.add("060502");

        List<String> locationSalvo48 = new ArrayList<>();
        locationSalvo48.add("060702");

        List<String> locationSalvo49 = new ArrayList<>();
        locationSalvo49.add("070502");

        List<String> locationSalvo50 = new ArrayList<>();
        locationSalvo50.add("070702");

        List<String> locationSalvo51 = new ArrayList<>();
        locationSalvo51.add("100202");

        List<String> locationSalvo52 = new ArrayList<>();
        locationSalvo52.add("100302");

        List<String> locationSalvo53 = new ArrayList<>();
        locationSalvo53.add("100402");

        List<String> locationSalvo54 = new ArrayList<>();
        locationSalvo54.add("100502");

        List<String> locationSalvo55 = new ArrayList<>();
        locationSalvo55.add("030802");

        List<String> locationSalvo56 = new ArrayList<>();
        locationSalvo56.add("030902");

        List<String> locationSalvo57 = new ArrayList<>();
        locationSalvo57.add("031002");

        List<String> locationSalvo58 = new ArrayList<>();
        locationSalvo58.add("080502");

        List<String> locationSalvo59 = new ArrayList<>();
        locationSalvo59.add("080702");

        List<List<String>> listLocationsSalvoesPlayer06Game03 = new ArrayList<>();
        listLocationsSalvoesPlayer06Game03.add(locationSalvo38);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo39);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo40);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo41);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo42);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo43);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo44);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo45);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo46);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo47);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo48);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo49);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo50);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo51);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo52);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo53);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo54);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo55);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo56);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo57);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo58);
        listLocationsSalvoesPlayer06Game03.add(locationSalvo59);

        Date gamePlayer06Date = new Date();
        CreateBoard boardPlayer06Game03 = new CreateBoard(Player06,Game03,gamePlayer06Date,listLocationsShipsPlayer06Game03,listLocationsSalvoesPlayer06Game03,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer06Game03=boardPlayer06Game03.getBoard();

        //Update the Board Player05 vs Board Player06 in Game03
        UpdateShipsSalvos updateGame03SalvosAgainstShipsPlayer05Player06TwoWays= new UpdateShipsSalvos(gamePlayerPlayer05Game03,gamePlayerPlayer06Game03,repositoryShips);
        updateGame03SalvosAgainstShipsPlayer05Player06TwoWays.UpdateSalvosAdversary();

        //_______________________________________________________________________________________________________
        // End of Game03
        //_______________________________________________________________________________________________________

    }
}
