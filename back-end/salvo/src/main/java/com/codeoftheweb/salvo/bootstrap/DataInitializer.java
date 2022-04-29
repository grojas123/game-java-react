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

        // Create the list of Locations of the Ships

        List<String> locationShip01Destroyer = new ArrayList<>();
        locationShip01Destroyer.add("010901");
        locationShip01Destroyer.add("020901");

        List<String> locationShip02Battleship = new ArrayList<>();
        locationShip02Battleship.add("050901");
        locationShip02Battleship.add("060901");
        locationShip02Battleship.add("070901");
        locationShip02Battleship.add("080901");

        List<String> locationShip03AircraftCarrier = new ArrayList<>();
        locationShip03AircraftCarrier.add("030101");
        locationShip03AircraftCarrier.add("030201");
        locationShip03AircraftCarrier.add("030301");
        locationShip03AircraftCarrier.add("030401");
        locationShip03AircraftCarrier.add("030501");

        List<String> locationShip04Submarine = new ArrayList<>();
        locationShip04Submarine.add("070101");
        locationShip04Submarine.add("070201");
        locationShip04Submarine.add("070301");

        List<String> locationShip05Cruiser = new ArrayList<>();
        locationShip05Cruiser.add("090401");
        locationShip05Cruiser.add("090501");
        locationShip05Cruiser.add("090601");
        // Create the Ships with the locations for Player01
        Ship Ship01Destroyer= new Ship("Destroyer",locationShip01Destroyer);
        Ship Ship02Battleship= new Ship("Battleship",locationShip02Battleship);
        Ship Ship03AircraftCarrier= new Ship("Aircraft Carrier",locationShip03AircraftCarrier);
        Ship Ship04Submarine= new Ship("Submarine",locationShip04Submarine);
        Ship Ship05Cruiser= new Ship("Cruiser",locationShip05Cruiser);

        // Create the list of Ships for the Player01 in Game01
        List<Ship> Player01ListShipsGame01 = new ArrayList<>();
        Player01ListShipsGame01.add(Ship01Destroyer);
        Player01ListShipsGame01.add(Ship02Battleship);
        Player01ListShipsGame01.add(Ship03AircraftCarrier);
        Player01ListShipsGame01.add(Ship04Submarine);
        Player01ListShipsGame01.add(Ship05Cruiser);
        // Save Ships
        repositoryShips.save(Ship01Destroyer);
        repositoryShips.save(Ship02Battleship);
        repositoryShips.save(Ship03AircraftCarrier);
        repositoryShips.save(Ship04Submarine);
        repositoryShips.save(Ship05Cruiser);
        // Create and save Game01 and Player01 pairs in GamePlayer repository


        // To creat some salvoes to test
        List<String> locationSalvo01 = new ArrayList<>();
        locationSalvo01.add("030301");
        Salvo Salvo01= new Salvo("Normal",locationSalvo01);

        List<String> locationSalvo02 = new ArrayList<>();
        locationSalvo02.add("030701");
        Salvo Salvo02= new Salvo("Normal",locationSalvo02);

        List<String> locationSalvo03 = new ArrayList<>();
        locationSalvo03.add("070401");
        Salvo Salvo03= new Salvo("Normal",locationSalvo03);

        List<String> locationSalvo04 = new ArrayList<>();
        locationSalvo04.add("070901");
        Salvo Salvo04= new Salvo("Normal",locationSalvo04);

        List<String> locationSalvo05 = new ArrayList<>();
        locationSalvo05.add("010101");
        Salvo Salvo05= new Salvo("Normal",locationSalvo05);

        List<String> locationSalvo06_01 = new ArrayList<>();
        locationSalvo06_01.add("011001");
        Salvo Salvo06_01= new Salvo("Normal",locationSalvo06_01);

        List<String> locationSalvo06_02 = new ArrayList<>();
        locationSalvo06_02.add("021001");
        Salvo Salvo06_02= new Salvo("Normal",locationSalvo06_02);

        List<String> locationSalvo06_03 = new ArrayList<>();
        locationSalvo06_03.add("031001");
        Salvo Salvo06_03= new Salvo("Normal",locationSalvo06_03);

        List<String> locationSalvo06_04 = new ArrayList<>();
        locationSalvo06_04.add("041001");
        Salvo Salvo06_04= new Salvo("Normal",locationSalvo06_04);

        List<String> locationSalvo06_05 = new ArrayList<>();
        locationSalvo06_05.add("010201");
        Salvo Salvo06_05= new Salvo("Normal",locationSalvo06_05);

        List<String> locationSalvo06_06 = new ArrayList<>();
        locationSalvo06_06.add("010301");
        Salvo Salvo06_06= new Salvo("Normal",locationSalvo06_06);

        List<String> locationSalvo06_07 = new ArrayList<>();
        locationSalvo06_07.add("010401");
        Salvo Salvo06_07= new Salvo("Normal",locationSalvo06_07);

        List<String> locationSalvo06_08 = new ArrayList<>();
        locationSalvo06_08.add("050601");
        Salvo Salvo06_08= new Salvo("Normal",locationSalvo06_08);

        List<String> locationSalvo06_09 = new ArrayList<>();
        locationSalvo06_09.add("060601");
        Salvo Salvo06_09= new Salvo("Normal",locationSalvo06_09);

        List<String> locationSalvo06_10 = new ArrayList<>();
        locationSalvo06_10.add("070601");
        Salvo Salvo06_10= new Salvo("Normal",locationSalvo06_10);

        List<String> locationSalvo06_11 = new ArrayList<>();
        locationSalvo06_11.add("050101");
        Salvo Salvo06_11= new Salvo("Normal",locationSalvo06_11);

        List<String> locationSalvo06_12 = new ArrayList<>();
        locationSalvo06_12.add("060101");
        Salvo Salvo06_12= new Salvo("Normal",locationSalvo06_12);

        List<String> locationSalvo06_13 = new ArrayList<>();
        locationSalvo06_13.add("070101");
        Salvo Salvo06_13= new Salvo("Normal",locationSalvo06_13);

        List<String> locationSalvo06_14 = new ArrayList<>();
        locationSalvo06_14.add("080101");
        Salvo Salvo06_14= new Salvo("Normal",locationSalvo06_14);

        List<String> locationSalvo06_15 = new ArrayList<>();
        locationSalvo06_15.add("090101");
        Salvo Salvo06_15= new Salvo("Normal",locationSalvo06_15);

        List<String> locationSalvo06_16 = new ArrayList<>();
        locationSalvo06_16.add("100501");
        Salvo Salvo06_16= new Salvo("Normal",locationSalvo06_16);

        List<String> locationSalvo06_17 = new ArrayList<>();
        locationSalvo06_17.add("100601");
        Salvo Salvo06_17= new Salvo("Normal",locationSalvo06_17);

        List<String> locationSalvo06_18 = new ArrayList<>();
        locationSalvo06_18.add("100701");
        Salvo Salvo06_18= new Salvo("Normal",locationSalvo06_18);

        List<String> locationSalvo06_19 = new ArrayList<>();
        locationSalvo06_19.add("101001");
        Salvo Salvo06_19= new Salvo("Normal",locationSalvo06_19);

        //To save the Salvoes

        repositorySalvoes.save(Salvo01);
        repositorySalvoes.save(Salvo02);
        repositorySalvoes.save(Salvo03);
        repositorySalvoes.save(Salvo04);
        repositorySalvoes.save(Salvo05);
        repositorySalvoes.save(Salvo06_01);
        repositorySalvoes.save(Salvo06_02);
        repositorySalvoes.save(Salvo06_03);
        repositorySalvoes.save(Salvo06_04);
        repositorySalvoes.save(Salvo06_05);
        repositorySalvoes.save(Salvo06_06);
        repositorySalvoes.save(Salvo06_07);
        repositorySalvoes.save(Salvo06_08);
        repositorySalvoes.save(Salvo06_09);
        repositorySalvoes.save(Salvo06_10);
        repositorySalvoes.save(Salvo06_11);
        repositorySalvoes.save(Salvo06_12);
        repositorySalvoes.save(Salvo06_13);
        repositorySalvoes.save(Salvo06_14);
        repositorySalvoes.save(Salvo06_15);
        repositorySalvoes.save(Salvo06_16);
        repositorySalvoes.save(Salvo06_17);
        repositorySalvoes.save(Salvo06_18);
        repositorySalvoes.save(Salvo06_19);


        Date gamePlayer01Date = new Date();
        // Create the list of Salvoes
        List<Salvo> Player01ListSalvoesOnGame01 = new ArrayList<>();

        Player01ListSalvoesOnGame01.add(Salvo01);
        Player01ListSalvoesOnGame01.add(Salvo02);
        Player01ListSalvoesOnGame01.add(Salvo03);
        Player01ListSalvoesOnGame01.add(Salvo04);
        Player01ListSalvoesOnGame01.add(Salvo05);
        Player01ListSalvoesOnGame01.add(Salvo06_01);
        Player01ListSalvoesOnGame01.add(Salvo06_02);
        Player01ListSalvoesOnGame01.add(Salvo06_03);
        Player01ListSalvoesOnGame01.add(Salvo06_04);
        Player01ListSalvoesOnGame01.add(Salvo06_05);
        Player01ListSalvoesOnGame01.add(Salvo06_06);
        Player01ListSalvoesOnGame01.add(Salvo06_07);
        Player01ListSalvoesOnGame01.add(Salvo06_08);
        Player01ListSalvoesOnGame01.add(Salvo06_09);
        Player01ListSalvoesOnGame01.add(Salvo06_10);
        Player01ListSalvoesOnGame01.add(Salvo06_11);
        Player01ListSalvoesOnGame01.add(Salvo06_12);
        Player01ListSalvoesOnGame01.add(Salvo06_13);
        Player01ListSalvoesOnGame01.add(Salvo06_14);
        Player01ListSalvoesOnGame01.add(Salvo06_15);
        Player01ListSalvoesOnGame01.add(Salvo06_16);
        Player01ListSalvoesOnGame01.add(Salvo06_17);
        Player01ListSalvoesOnGame01.add(Salvo06_18);
        Player01ListSalvoesOnGame01.add(Salvo06_19);


        GamePlayer Game01Player01Player01ListOfShipsPlayer01ListSalvoes = new GamePlayer(Game01,Player01,gamePlayer01Date,Player01ListShipsGame01,Player01ListSalvoesOnGame01);
        // To set the GamePlayer for the salvoes
        repositoryGamePlayer.save(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);

        Salvo01.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo02.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo03.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo04.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo05.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_01.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_02.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_03.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_04.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_05.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_06.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_07.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_08.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_09.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_10.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_11.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_12.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_13.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_14.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_15.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_16.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_17.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_18.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Salvo06_19.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);

        // To save the Salvoes

        repositorySalvoes.save(Salvo01);
        repositorySalvoes.save(Salvo02);
        repositorySalvoes.save(Salvo03);
        repositorySalvoes.save(Salvo04);
        repositorySalvoes.save(Salvo05);
        repositorySalvoes.save(Salvo06_01);
        repositorySalvoes.save(Salvo06_02);
        repositorySalvoes.save(Salvo06_03);
        repositorySalvoes.save(Salvo06_04);
        repositorySalvoes.save(Salvo06_05);
        repositorySalvoes.save(Salvo06_06);
        repositorySalvoes.save(Salvo06_07);
        repositorySalvoes.save(Salvo06_08);
        repositorySalvoes.save(Salvo06_09);
        repositorySalvoes.save(Salvo06_10);
        repositorySalvoes.save(Salvo06_11);
        repositorySalvoes.save(Salvo06_12);
        repositorySalvoes.save(Salvo06_13);
        repositorySalvoes.save(Salvo06_14);
        repositorySalvoes.save(Salvo06_15);
        repositorySalvoes.save(Salvo06_16);
        repositorySalvoes.save(Salvo06_17);
        repositorySalvoes.save(Salvo06_18);
        repositorySalvoes.save(Salvo06_19);


        // Set the game player row with the ship
        Ship01Destroyer.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Ship02Battleship.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Ship03AircraftCarrier.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Ship04Submarine.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        Ship05Cruiser.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);

        repositoryShips.save(Ship01Destroyer);
        repositoryShips.save(Ship02Battleship);
        repositoryShips.save(Ship03AircraftCarrier);
        repositoryShips.save(Ship04Submarine);
        repositoryShips.save(Ship05Cruiser);


        // To Create the Ships with Player02ListShipsGame01

        List<String> locationShip06Battleship = new ArrayList<>();
        locationShip06Battleship.add("011001");
        locationShip06Battleship.add("021001");
        locationShip06Battleship.add("031001");
        locationShip06Battleship.add("041001");

        List<String> locationShip07Submarine = new ArrayList<>();
        locationShip07Submarine.add("050601");
        locationShip07Submarine.add("060601");
        locationShip07Submarine.add("070601");

        List<String> locationShip08Cruiser = new ArrayList<>();
        locationShip08Cruiser.add("100501");
        locationShip08Cruiser.add("100601");
        locationShip08Cruiser.add("100701");

        List<String> locationShip09Submarine = new ArrayList<>();
        locationShip09Submarine.add("010201");
        locationShip09Submarine.add("010301");
        locationShip09Submarine.add("010401");

        List<String> locationShip10AircraftCarrier = new ArrayList<>();
        locationShip10AircraftCarrier.add("050101");
        locationShip10AircraftCarrier.add("060101");
        locationShip10AircraftCarrier.add("070101");
        locationShip10AircraftCarrier.add("080101");
        locationShip10AircraftCarrier.add("090101");

        // Create the Ships with the locations
        Ship Ship06Battleship= new Ship("Battleship",locationShip06Battleship);
        Ship Ship07Submarine= new Ship("Submarine",locationShip07Submarine);
        Ship Ship08Cruiser= new Ship("Cruiser",locationShip08Cruiser);
        Ship Ship09Submarine= new Ship("Submarine",locationShip09Submarine);
        Ship Ship10AircraftCarrier= new Ship("Aircraft Carrier",locationShip10AircraftCarrier);

        repositoryShips.save(Ship06Battleship);
        repositoryShips.save(Ship07Submarine);
        repositoryShips.save(Ship08Cruiser);
        repositoryShips.save(Ship09Submarine);
        repositoryShips.save(Ship10AircraftCarrier);

        // Create the list of Player02ListShipsGame01

        List<Ship> Player02ListShipsGame01 = new ArrayList<>();
        Player02ListShipsGame01.add(Ship06Battleship);
        Player02ListShipsGame01.add(Ship07Submarine);
        Player02ListShipsGame01.add(Ship08Cruiser);
        Player02ListShipsGame01.add(Ship09Submarine);
        Player02ListShipsGame01.add(Ship10AircraftCarrier);

        // To Creat some Salvoes


        List<String> locationSalvo06 = new ArrayList<>();
        locationSalvo06.add("030901");
        Salvo Salvo06= new Salvo("Normal",locationSalvo06);

        List<String> locationSalvo07 = new ArrayList<>();
        locationSalvo07.add("030401");
        Salvo Salvo07= new Salvo("Normal",locationSalvo07);

        List<String> locationSalvo08 = new ArrayList<>();
        locationSalvo08.add("050601");
        Salvo Salvo08= new Salvo("Normal",locationSalvo08);

        List<String> locationSalvo09 = new ArrayList<>();
        locationSalvo09.add("070201");
        Salvo Salvo09= new Salvo("Normal",locationSalvo09);

        List<String> locationSalvo10 = new ArrayList<>();
        locationSalvo10.add("080901");
        Salvo Salvo10= new Salvo("Normal",locationSalvo10);

        List<String> locationSalvo10_01 = new ArrayList<>();
        locationSalvo10_01.add("080301");
        Salvo Salvo10_01= new Salvo("Normal",locationSalvo10_01);

        List<String> locationSalvo10_02 = new ArrayList<>();
        locationSalvo10_02.add("030101");
        Salvo Salvo10_02= new Salvo("Normal",locationSalvo10_02);

        List<String> locationSalvo10_03 = new ArrayList<>();
        locationSalvo10_03.add("030201");
        Salvo Salvo10_03= new Salvo("Normal",locationSalvo10_03);

        List<String> locationSalvo10_04 = new ArrayList<>();
        locationSalvo10_04.add("030301");
        Salvo Salvo10_04= new Salvo("Normal",locationSalvo10_04);

        List<String> locationSalvo10_05 = new ArrayList<>();
        locationSalvo10_05.add("030501");
        Salvo Salvo10_05= new Salvo("Normal",locationSalvo10_05);

        List<String> locationSalvo10_06 = new ArrayList<>();
        locationSalvo10_06.add("010401");
        Salvo Salvo10_06= new Salvo("Normal",locationSalvo10_06);

        List<String> locationSalvo10_07 = new ArrayList<>();
        locationSalvo10_07.add("050101");
        Salvo Salvo10_07= new Salvo("Normal",locationSalvo10_07);

        List<String> locationSalvo10_08 = new ArrayList<>();
        locationSalvo10_08.add("060101");
        Salvo Salvo10_08= new Salvo("Normal",locationSalvo10_08);

        List<String> locationSalvo10_09 = new ArrayList<>();
        locationSalvo10_09.add("060801");
        Salvo Salvo10_09= new Salvo("Normal",locationSalvo10_09);

        List<String> locationSalvo10_10 = new ArrayList<>();
        locationSalvo10_10.add("070901");
        Salvo Salvo10_10= new Salvo("Normal",locationSalvo10_10);

        List<String> locationSalvo10_11 = new ArrayList<>();
        locationSalvo10_11.add("090501");
        Salvo Salvo10_11= new Salvo("Normal",locationSalvo10_11);

        List<String> locationSalvo10_12 = new ArrayList<>();
        locationSalvo10_12.add("100101");
        Salvo Salvo10_12= new Salvo("Normal",locationSalvo10_12);

        List<String> locationSalvo10_13 = new ArrayList<>();
        locationSalvo10_13.add("100301");
        Salvo Salvo10_13= new Salvo("Normal",locationSalvo10_13);

        List<String> locationSalvo10_14 = new ArrayList<>();
        locationSalvo10_14.add("100701");
        Salvo Salvo10_14= new Salvo("Normal",locationSalvo10_14);

        // Save Salvoes
        repositorySalvoes.save(Salvo06);
        repositorySalvoes.save(Salvo07);
        repositorySalvoes.save(Salvo08);
        repositorySalvoes.save(Salvo09);
        repositorySalvoes.save(Salvo10);
        repositorySalvoes.save(Salvo10_01);
        repositorySalvoes.save(Salvo10_02);
        repositorySalvoes.save(Salvo10_03);
        repositorySalvoes.save(Salvo10_04);
        repositorySalvoes.save(Salvo10_05);
        repositorySalvoes.save(Salvo10_06);
        repositorySalvoes.save(Salvo10_07);
        repositorySalvoes.save(Salvo10_08);
        repositorySalvoes.save(Salvo10_09);
        repositorySalvoes.save(Salvo10_10);
        repositorySalvoes.save(Salvo10_11);
        repositorySalvoes.save(Salvo10_12);
        repositorySalvoes.save(Salvo10_13);
        repositorySalvoes.save(Salvo10_14);
        // Array of Salvoes
        List<Salvo> Player02ListSalvoesOnGame01 = new ArrayList<>();
        Player02ListSalvoesOnGame01.add(Salvo06);
        Player02ListSalvoesOnGame01.add(Salvo07);
        Player02ListSalvoesOnGame01.add(Salvo08);
        Player02ListSalvoesOnGame01.add(Salvo09);
        Player02ListSalvoesOnGame01.add(Salvo10);
        Player02ListSalvoesOnGame01.add(Salvo10_01);
        Player02ListSalvoesOnGame01.add(Salvo10_02);
        Player02ListSalvoesOnGame01.add(Salvo10_03);
        Player02ListSalvoesOnGame01.add(Salvo10_04);
        Player02ListSalvoesOnGame01.add(Salvo10_05);
        Player02ListSalvoesOnGame01.add(Salvo10_06);
        Player02ListSalvoesOnGame01.add(Salvo10_07);
        Player02ListSalvoesOnGame01.add(Salvo10_08);
        Player02ListSalvoesOnGame01.add(Salvo10_09);
        Player02ListSalvoesOnGame01.add(Salvo10_10);
        Player02ListSalvoesOnGame01.add(Salvo10_11);
        Player02ListSalvoesOnGame01.add(Salvo10_12);
        Player02ListSalvoesOnGame01.add(Salvo10_13);
        Player02ListSalvoesOnGame01.add(Salvo10_14);


        Date gamePlayer02Date = new Date();

        GamePlayer Game01Player02Player02ListOfShipsPlayer02ListSalvoes= new GamePlayer(Game01,Player02,gamePlayer02Date,Player02ListShipsGame01,Player02ListSalvoesOnGame01);
        repositoryGamePlayer.save(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);

        Salvo06.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo07.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo08.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo09.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10_01.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10_02.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10_03.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10_04.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10_05.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10_06.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10_07.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10_08.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10_09.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10_10.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10_11.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10_12.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10_13.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Salvo10_14.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);

        // Save the Salvoes
        repositorySalvoes.save(Salvo06);
        repositorySalvoes.save(Salvo07);
        repositorySalvoes.save(Salvo08);
        repositorySalvoes.save(Salvo09);
        repositorySalvoes.save(Salvo10);
        repositorySalvoes.save(Salvo10_01);
        repositorySalvoes.save(Salvo10_02);
        repositorySalvoes.save(Salvo10_03);
        repositorySalvoes.save(Salvo10_04);
        repositorySalvoes.save(Salvo10_05);
        repositorySalvoes.save(Salvo10_06);
        repositorySalvoes.save(Salvo10_07);
        repositorySalvoes.save(Salvo10_08);
        repositorySalvoes.save(Salvo10_09);
        repositorySalvoes.save(Salvo10_10);
        repositorySalvoes.save(Salvo10_11);
        repositorySalvoes.save(Salvo10_12);
        repositorySalvoes.save(Salvo10_13);
        repositorySalvoes.save(Salvo10_14);

        // Set the game player row with the ship
        Ship06Battleship.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Ship07Submarine.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Ship08Cruiser.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Ship09Submarine.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        Ship10AircraftCarrier.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        repositoryShips.save(Ship06Battleship);
        repositoryShips.save(Ship07Submarine);
        repositoryShips.save(Ship08Cruiser);
        repositoryShips.save(Ship09Submarine);
        repositoryShips.save(Ship10AircraftCarrier);

        UpdateShipsSalvos updateGame01SalvosAgainstShipsPlayer01Player02TwoWays= new UpdateShipsSalvos(Game01Player01Player01ListOfShipsPlayer01ListSalvoes,Game01Player02Player02ListOfShipsPlayer02ListSalvoes,repositoryShips);
        updateGame01SalvosAgainstShipsPlayer01Player02TwoWays.UpdateSalvosAdversary();

        //______________________________________________________________________________________________________________
        // To create Ships for Player03 in Game02 with Player03ListOfShips
        // Create and Locate the Ships
        List<String> locationShip11Submarine = new ArrayList<>();
        locationShip11Submarine.add("030901");
        locationShip11Submarine.add("040901");
        locationShip11Submarine.add("050901");

        List<String> locationShip12AircraftCarrier = new ArrayList<>();
        locationShip12AircraftCarrier.add("050601");
        locationShip12AircraftCarrier.add("060601");
        locationShip12AircraftCarrier.add("070601");
        locationShip12AircraftCarrier.add("080601");
        locationShip12AircraftCarrier.add("090601");


        List<String> locationShip13BattleShip = new ArrayList<>();
        locationShip13BattleShip.add("030401");
        locationShip13BattleShip.add("040401");
        locationShip13BattleShip.add("050401");
        locationShip13BattleShip.add("060401");

        List<String> locationShip14Carrier = new ArrayList<>();
        locationShip14Carrier.add("080201");
        locationShip14Carrier.add("090201");
        locationShip14Carrier.add("100201");

        List<String> locationShip15Destroyer = new ArrayList<>();
        locationShip15Destroyer.add("010101");
        locationShip15Destroyer.add("020101");

        Ship Ship11Submarine= new Ship("Submarine",locationShip11Submarine);
        Ship Ship12AircraftCarrier= new Ship("Aircraft Carrier",locationShip12AircraftCarrier);
        Ship Ship13BattleShip= new Ship("BattleShip",locationShip13BattleShip);
        Ship Ship14Carrier= new Ship("Carrier",locationShip14Carrier);
        Ship Ship15Destroyer= new Ship("Destroyer",locationShip15Destroyer);

        repositoryShips.save(Ship11Submarine);
        repositoryShips.save(Ship12AircraftCarrier);
        repositoryShips.save(Ship13BattleShip);
        repositoryShips.save(Ship14Carrier);
        repositoryShips.save(Ship15Destroyer);

        // Create the list of Player03ListShipsGame02

        List<Ship> Player03ListShipsGame02 = new ArrayList<>();
        Player03ListShipsGame02.add(Ship11Submarine);
        Player03ListShipsGame02.add(Ship12AircraftCarrier);
        Player03ListShipsGame02.add(Ship13BattleShip);
        Player03ListShipsGame02.add(Ship14Carrier);
        Player03ListShipsGame02.add(Ship15Destroyer);

        List<String> locationSalvo11 = new ArrayList<>();
        locationSalvo11.add("010401");
        Salvo Salvo11= new Salvo("Normal",locationSalvo11);

        List<String> locationSalvo12 = new ArrayList<>();
        locationSalvo12.add("040101");
        Salvo Salvo12= new Salvo("Normal",locationSalvo12);

        List<String> locationSalvo13 = new ArrayList<>();
        locationSalvo13.add("050801");
        Salvo Salvo13= new Salvo("Normal",locationSalvo13);

        List<String> locationSalvo14 = new ArrayList<>();
        locationSalvo14.add("080501");
        Salvo Salvo14= new Salvo("Normal",locationSalvo14);

        List<String> locationSalvo15 = new ArrayList<>();
        locationSalvo15.add("100401");
        Salvo Salvo15= new Salvo("Normal",locationSalvo15);

        List<String> locationSalvo15_01 = new ArrayList<>();
        locationSalvo15_01.add("070701");
        Salvo Salvo15_01= new Salvo("Normal",locationSalvo15_01);

        List<String> locationSalvo15_02 = new ArrayList<>();
        locationSalvo15_02.add("070801");
        Salvo Salvo15_02= new Salvo("Normal",locationSalvo15_02);

        List<String> locationSalvo15_03 = new ArrayList<>();
        locationSalvo15_03.add("070901");
        Salvo Salvo15_03= new Salvo("Normal",locationSalvo15_03);

        List<String> locationSalvo15_04 = new ArrayList<>();
        locationSalvo15_04.add("011001");
        Salvo Salvo15_04= new Salvo("Normal",locationSalvo15_04);

        List<String> locationSalvo15_05 = new ArrayList<>();
        locationSalvo15_05.add("020201");
        Salvo Salvo15_05= new Salvo("Normal",locationSalvo15_05);

        List<String> locationSalvo15_06 = new ArrayList<>();
        locationSalvo15_06.add("030701");
        Salvo Salvo15_06= new Salvo("Normal",locationSalvo15_06);

    /*  Skipped to continue the consistency of the counting   List<String> locationSalvo15_07 = new ArrayList<>(); */

        List<String> locationSalvo15_08 = new ArrayList<>();
        locationSalvo15_08.add("050501");
        Salvo Salvo15_08= new Salvo("Normal",locationSalvo15_08);

        List<String> locationSalvo15_09 = new ArrayList<>();
        locationSalvo15_09.add("050701");
        Salvo Salvo15_09= new Salvo("Normal",locationSalvo15_09);

        List<String> locationSalvo15_10 = new ArrayList<>();
        locationSalvo15_10.add("070301");
        Salvo Salvo15_10= new Salvo("Normal",locationSalvo15_10);

        List<String> locationSalvo15_11 = new ArrayList<>();
        locationSalvo15_11.add("100101");
        Salvo Salvo15_11= new Salvo("Normal",locationSalvo15_11);

        List<String> locationSalvo15_12 = new ArrayList<>();
        locationSalvo15_12.add("101001");
        Salvo Salvo15_12= new Salvo("Normal",locationSalvo15_12);

        // To save Salvoes
        repositorySalvoes.save(Salvo11);
        repositorySalvoes.save(Salvo12);
        repositorySalvoes.save(Salvo13);
        repositorySalvoes.save(Salvo14);
        repositorySalvoes.save(Salvo15);
        repositorySalvoes.save(Salvo15_01);
        repositorySalvoes.save(Salvo15_02);
        repositorySalvoes.save(Salvo15_03);
        repositorySalvoes.save(Salvo15_04);
        repositorySalvoes.save(Salvo15_05);
        repositorySalvoes.save(Salvo15_06);
        repositorySalvoes.save(Salvo15_08);
        repositorySalvoes.save(Salvo15_09);
        repositorySalvoes.save(Salvo15_10);
        repositorySalvoes.save(Salvo15_11);
        repositorySalvoes.save(Salvo15_12);

        Date gamePlayer03Date = new Date();
        // To create the list of Salvoes
        List<Salvo> Player03ListSalvoesOnGame02 = new ArrayList<>();
        Player03ListSalvoesOnGame02.add(Salvo11);
        Player03ListSalvoesOnGame02.add(Salvo12);
        Player03ListSalvoesOnGame02.add(Salvo13);
        Player03ListSalvoesOnGame02.add(Salvo14);
        Player03ListSalvoesOnGame02.add(Salvo15);
        Player03ListSalvoesOnGame02.add(Salvo15_01);
        Player03ListSalvoesOnGame02.add(Salvo15_02);
        Player03ListSalvoesOnGame02.add(Salvo15_03);
        Player03ListSalvoesOnGame02.add(Salvo15_04);
        Player03ListSalvoesOnGame02.add(Salvo15_05);
        Player03ListSalvoesOnGame02.add(Salvo15_06);
        Player03ListSalvoesOnGame02.add(Salvo15_08);
        Player03ListSalvoesOnGame02.add(Salvo15_09);
        Player03ListSalvoesOnGame02.add(Salvo15_10);
        Player03ListSalvoesOnGame02.add(Salvo15_11);
        Player03ListSalvoesOnGame02.add(Salvo15_12);

        // To create the second page of the game
        GamePlayer Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes= new GamePlayer(Game02,Player03,gamePlayer03Date,Player03ListShipsGame02,Player03ListSalvoesOnGame02);
        repositoryGamePlayer.save(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);

        Salvo11.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Salvo12.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Salvo13.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Salvo14.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Salvo15.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Salvo15_01.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Salvo15_02.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Salvo15_03.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Salvo15_04.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Salvo15_05.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        /*Skipped to continue the consistency of the counting    Salvo15_07.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes); repositorySalvoes.save(Salvo15_07);*/
        Salvo15_08.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Salvo15_09.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Salvo15_10.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Salvo15_11.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Salvo15_12.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);


        // To Save the Salvoes
        repositorySalvoes.save(Salvo11);
        repositorySalvoes.save(Salvo12);
        repositorySalvoes.save(Salvo13);
        repositorySalvoes.save(Salvo14);
        repositorySalvoes.save(Salvo15);
        repositorySalvoes.save(Salvo15_01);
        repositorySalvoes.save(Salvo15_02);
        repositorySalvoes.save(Salvo15_03);
        repositorySalvoes.save(Salvo15_04);
        repositorySalvoes.save(Salvo15_05);
        repositorySalvoes.save(Salvo15_08);
        repositorySalvoes.save(Salvo15_09);
        repositorySalvoes.save(Salvo15_10);
        repositorySalvoes.save(Salvo15_11);
        repositorySalvoes.save(Salvo15_12);



        //_________________________________________________________________________________________________
        Ship11Submarine.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Ship12AircraftCarrier.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Ship13BattleShip.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Ship14Carrier.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        Ship15Destroyer.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        repositoryShips.save(Ship11Submarine);
        repositoryShips.save(Ship12AircraftCarrier);
        repositoryShips.save(Ship13BattleShip);
        repositoryShips.save(Ship14Carrier);
        repositoryShips.save(Ship15Destroyer);

        // To create Player04ListOfShipsIOnGame02
        // Create and Locate the Ships
        List<String> locationShip16AircraftCarrier = new ArrayList<>();
        locationShip16AircraftCarrier.add("010601");
        locationShip16AircraftCarrier.add("010701");
        locationShip16AircraftCarrier.add("010801");
        locationShip16AircraftCarrier.add("010901");
        locationShip16AircraftCarrier.add("011001");

        List<String> locationShip17Submarine = new ArrayList<>();
        locationShip17Submarine.add("070701");
        locationShip17Submarine.add("070801");
        locationShip17Submarine.add("070901");

        List<String> locationShip18Cruiser = new ArrayList<>();
        locationShip18Cruiser.add("070201");
        locationShip18Cruiser.add("070301");
        locationShip18Cruiser.add("070401");

        List<String> locationShip19Battleship = new ArrayList<>();
        locationShip19Battleship.add("040201");
        locationShip19Battleship.add("040301");
        locationShip19Battleship.add("040401");
        locationShip19Battleship.add("040501");

        List<String> locationShip20Destroyer = new ArrayList<>();
        locationShip20Destroyer.add("100501");
        locationShip20Destroyer.add("100601");

        Ship Ship16AircraftCarrier= new Ship("Aircraft Carrier",locationShip16AircraftCarrier);
        Ship Ship17Submarine= new Ship("Submarine",locationShip17Submarine);
        Ship Ship18Cruiser= new Ship("Cruiser",locationShip18Cruiser);
        Ship Ship19Battleship= new Ship("Battleship",locationShip19Battleship);
        Ship Ship20Destroyer= new Ship("Destroyer",locationShip20Destroyer);
        repositoryShips.save(Ship16AircraftCarrier);
        repositoryShips.save(Ship17Submarine);
        repositoryShips.save(Ship18Cruiser);
        repositoryShips.save(Ship19Battleship);
        repositoryShips.save(Ship20Destroyer);
        // Create the list of Player03ListShipsGame02
        List<Ship> Player04ListOfShipsIOnGame02 = new ArrayList<>();
        Player04ListOfShipsIOnGame02.add(Ship16AircraftCarrier);
        Player04ListOfShipsIOnGame02.add(Ship17Submarine);
        Player04ListOfShipsIOnGame02.add(Ship18Cruiser);
        Player04ListOfShipsIOnGame02.add(Ship19Battleship);
        Player04ListOfShipsIOnGame02.add(Ship20Destroyer);

       // Create the Salvoes

        List<String> locationSalvo16 = new ArrayList<>();
        locationSalvo16.add("010101");
        Salvo Salvo16= new Salvo("Normal",locationSalvo16);

        List<String> locationSalvo17 = new ArrayList<>();
        locationSalvo17.add("011001");
        Salvo Salvo17= new Salvo("Normal",locationSalvo17);

        List<String> locationSalvo18 = new ArrayList<>();
        locationSalvo18.add("040901");
        Salvo Salvo18= new Salvo("Normal",locationSalvo18);

        List<String> locationSalvo19 = new ArrayList<>();
        locationSalvo19.add("100101");
        Salvo Salvo19= new Salvo("Normal",locationSalvo19);

        List<String> locationSalvo20 = new ArrayList<>();
        locationSalvo20.add("101001");
        Salvo Salvo20= new Salvo("Normal",locationSalvo20);

        List<String> locationSalvo20_01 = new ArrayList<>();
        locationSalvo20_01.add("050601");
        Salvo Salvo20_01= new Salvo("Normal",locationSalvo20_01);

        List<String> locationSalvo20_02 = new ArrayList<>();
        locationSalvo20_02.add("060601");
        Salvo Salvo20_02= new Salvo("Normal",locationSalvo20_02);

        List<String> locationSalvo20_03 = new ArrayList<>();
        locationSalvo20_03.add("070601");
        Salvo Salvo20_03= new Salvo("Normal",locationSalvo20_03);

        List<String> locationSalvo20_04 = new ArrayList<>();
        locationSalvo20_04.add("080601");
        Salvo Salvo20_04= new Salvo("Normal",locationSalvo20_04);

        List<String> locationSalvo20_05 = new ArrayList<>();
        locationSalvo20_05.add("090601");
        Salvo Salvo20_05= new Salvo("Normal",locationSalvo20_05);

        List<String> locationSalvo20_06 = new ArrayList<>();
        locationSalvo20_06.add("060501");
        Salvo Salvo20_06= new Salvo("Normal",locationSalvo20_06);

        List<String> locationSalvo20_07 = new ArrayList<>();
        locationSalvo20_07.add("030401");
        Salvo Salvo20_07= new Salvo("Normal",locationSalvo20_07);

        List<String> locationSalvo20_08 = new ArrayList<>();
        locationSalvo20_08.add("030901");
        Salvo Salvo20_08= new Salvo("Normal",locationSalvo20_08);

        List<String> locationSalvo20_09 = new ArrayList<>();
        locationSalvo20_09.add("040401");
        Salvo Salvo20_09= new Salvo("Normal",locationSalvo20_09);

        List<String> locationSalvo20_10 = new ArrayList<>();
        locationSalvo20_10.add("050401");
        Salvo Salvo20_10= new Salvo("Normal",locationSalvo20_10);

        List<String> locationSalvo20_11 = new ArrayList<>();
        locationSalvo20_11.add("060401");
        Salvo Salvo20_11= new Salvo("Normal",locationSalvo20_11);

        List<String> locationSalvo20_12 = new ArrayList<>();
        locationSalvo20_12.add("080201");
        Salvo Salvo20_12= new Salvo("Normal",locationSalvo20_12);

        List<String> locationSalvo20_13 = new ArrayList<>();
        locationSalvo20_13.add("090201");
        Salvo Salvo20_13= new Salvo("Normal",locationSalvo20_13);

        List<String> locationSalvo20_14 = new ArrayList<>();
        locationSalvo20_14.add("100201");
        Salvo Salvo20_14= new Salvo("Normal",locationSalvo20_14);

        // To save the Salvoes
        repositorySalvoes.save(Salvo16);
        repositorySalvoes.save(Salvo17);
        repositorySalvoes.save(Salvo18);
        repositorySalvoes.save(Salvo19);
        repositorySalvoes.save(Salvo20);
        repositorySalvoes.save(Salvo20_01);
        repositorySalvoes.save(Salvo20_02);
        repositorySalvoes.save(Salvo20_03);
        repositorySalvoes.save(Salvo20_04);
        repositorySalvoes.save(Salvo20_05);
        repositorySalvoes.save(Salvo20_06);
        repositorySalvoes.save(Salvo20_07);
        repositorySalvoes.save(Salvo20_08);
        repositorySalvoes.save(Salvo20_09);
        repositorySalvoes.save(Salvo20_10);
        repositorySalvoes.save(Salvo20_11);
        repositorySalvoes.save(Salvo20_12);
        repositorySalvoes.save(Salvo20_13);
        repositorySalvoes.save(Salvo20_14);

        Date gamePlayer04Date = new Date();
        //To Create the list of Salvoes
        List<Salvo> Player04ListSalvoesOnGame02 = new ArrayList<>();
        Player04ListSalvoesOnGame02.add(Salvo15);
        Player04ListSalvoesOnGame02.add(Salvo17);
        Player04ListSalvoesOnGame02.add(Salvo18);
        Player04ListSalvoesOnGame02.add(Salvo19);
        Player04ListSalvoesOnGame02.add(Salvo20);
        Player04ListSalvoesOnGame02.add(Salvo20_01);
        Player04ListSalvoesOnGame02.add(Salvo20_02);
        Player04ListSalvoesOnGame02.add(Salvo20_03);
        Player04ListSalvoesOnGame02.add(Salvo20_04);
        Player04ListSalvoesOnGame02.add(Salvo20_05);
        Player04ListSalvoesOnGame02.add(Salvo20_06);
        Player04ListSalvoesOnGame02.add(Salvo20_07);
        Player04ListSalvoesOnGame02.add(Salvo20_08);
        Player04ListSalvoesOnGame02.add(Salvo20_09);
        Player04ListSalvoesOnGame02.add(Salvo20_10);
        Player04ListSalvoesOnGame02.add(Salvo20_11);
        Player04ListSalvoesOnGame02.add(Salvo20_12);
        Player04ListSalvoesOnGame02.add(Salvo20_13);
        Player04ListSalvoesOnGame02.add(Salvo20_14);



        GamePlayer Game02Player04Player04ListOfShipsPlayer04ListSalvoes= new GamePlayer(Game02,Player04,gamePlayer04Date,Player04ListOfShipsIOnGame02 ,Player04ListSalvoesOnGame02);
        repositoryGamePlayer.save(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);

        Salvo16.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo17.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo18.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo19.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20_01.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20_02.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20_03.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20_04.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20_05.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20_06.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20_07.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20_08.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20_09.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20_10.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20_11.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20_12.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20_13.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Salvo20_14.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);

        // To save Salvoes
        repositorySalvoes.save(Salvo16);
        repositorySalvoes.save(Salvo17);
        repositorySalvoes.save(Salvo18);
        repositorySalvoes.save(Salvo19);
        repositorySalvoes.save(Salvo20);
        repositorySalvoes.save(Salvo20_01);
        repositorySalvoes.save(Salvo20_02);
        repositorySalvoes.save(Salvo20_03);
        repositorySalvoes.save(Salvo20_04);
        repositorySalvoes.save(Salvo20_05);
        repositorySalvoes.save(Salvo20_06);
        repositorySalvoes.save(Salvo20_07);
        repositorySalvoes.save(Salvo20_08);
        repositorySalvoes.save(Salvo20_09);
        repositorySalvoes.save(Salvo20_10);
        repositorySalvoes.save(Salvo20_11);
        repositorySalvoes.save(Salvo20_12);
        repositorySalvoes.save(Salvo20_13);
        repositorySalvoes.save(Salvo20_14);



        Ship16AircraftCarrier.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Ship17Submarine.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Ship18Cruiser.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Ship19Battleship.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        Ship20Destroyer.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);

        repositoryShips.save(Ship16AircraftCarrier);
        repositoryShips.save(Ship17Submarine);
        repositoryShips.save(Ship18Cruiser);
        repositoryShips.save(Ship19Battleship);
        repositoryShips.save(Ship20Destroyer);

        //Updates from the two Boards
        UpdateShipsSalvos updateGame02SalvosAgainstShipsPlayer03Player04TwoWays= new UpdateShipsSalvos(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes,Game02Player04Player04ListOfShipsPlayer04ListSalvoes,repositoryShips);
        updateGame02SalvosAgainstShipsPlayer03Player04TwoWays.UpdateSalvosAdversary();

       // Creation Game3

        // Board Player05
        List<String> locationShip21Cruiser = new ArrayList<>();
        locationShip21Cruiser.add("020101");
        locationShip21Cruiser.add("020201");
        locationShip21Cruiser.add("020201");

        List<String> locationShip22AircraftCarrier = new ArrayList<>();
        locationShip22AircraftCarrier.add("030401");
        locationShip22AircraftCarrier.add("040401");
        locationShip22AircraftCarrier.add("050401");
        locationShip22AircraftCarrier.add("060401");
        locationShip22AircraftCarrier.add("070401");

        List<String> locationShip23Destroyer = new ArrayList<>();
        locationShip23Destroyer.add("060601");
        locationShip23Destroyer.add("070601");

        List<String> locationShip24Submarine = new ArrayList<>();
        locationShip24Submarine.add("030901");
        locationShip24Submarine.add("040901");
        locationShip24Submarine.add("050901");

        List<String> locationShip25BattleShip = new ArrayList<>();
        locationShip25BattleShip.add("100601");
        locationShip25BattleShip.add("100701");
        locationShip25BattleShip.add("100801");
        locationShip25BattleShip.add("100901");

        Ship Ship21Cruiser= new Ship("Cruiser",locationShip21Cruiser);
        Ship Ship22AircraftCarrier= new Ship("Aircraft Carrier",locationShip22AircraftCarrier);
        Ship Ship23Destroyer= new Ship("Destroyer",locationShip23Destroyer);
        Ship Ship24Submarine= new Ship("Submarine",locationShip24Submarine);
        Ship Ship25BattleShip= new Ship("Battle Ship",locationShip25BattleShip);
        repositoryShips.save(Ship21Cruiser);
        repositoryShips.save(Ship22AircraftCarrier);
        repositoryShips.save(Ship23Destroyer);
        repositoryShips.save(Ship24Submarine);
        repositoryShips.save(Ship25BattleShip);
        // Create the list of Player03ListShipsGame02

        List<Ship> Player05ListOfShipsIOnGame03 = new ArrayList<>();
        Player04ListOfShipsIOnGame02.add(Ship21Cruiser);
        Player04ListOfShipsIOnGame02.add(Ship22AircraftCarrier);
        Player04ListOfShipsIOnGame02.add(Ship23Destroyer);
        Player04ListOfShipsIOnGame02.add(Ship24Submarine);
        Player04ListOfShipsIOnGame02.add(Ship25BattleShip);



        // Creation of Salvoes for Player05

        List<String> locationSalvo21 = new ArrayList<>();
        locationSalvo21.add("020301");
        Salvo Salvo21= new Salvo("Normal",locationSalvo21);

        List<String> locationSalvo22 = new ArrayList<>();
        locationSalvo22.add("020401");
        Salvo Salvo22= new Salvo("Normal",locationSalvo22);

        List<String> locationSalvo23 = new ArrayList<>();
        locationSalvo23.add("020501");
        Salvo Salvo23= new Salvo("Normal",locationSalvo23);

        List<String> locationSalvo24 = new ArrayList<>();
        locationSalvo24.add("030701");
        Salvo Salvo24= new Salvo("Normal",locationSalvo24);

        List<String> locationSalvo25 = new ArrayList<>();
        locationSalvo25.add("040701");
        Salvo Salvo25= new Salvo("Normal",locationSalvo25);

        List<String> locationSalvo26 = new ArrayList<>();
        locationSalvo26.add("050701");
        Salvo Salvo26= new Salvo("Normal",locationSalvo26);

        List<String> locationSalvo27 = new ArrayList<>();
        locationSalvo27.add("060701");
        Salvo Salvo27= new Salvo("Normal",locationSalvo27);

        List<String> locationSalvo28 = new ArrayList<>();
        locationSalvo28.add("031001");
        Salvo Salvo28= new Salvo("Normal",locationSalvo28);

        List<String> locationSalvo29 = new ArrayList<>();
        locationSalvo29.add("041001");
        Salvo Salvo29= new Salvo("Normal",locationSalvo29);

        List<String> locationSalvo30 = new ArrayList<>();
        locationSalvo30.add("051001");
        Salvo Salvo30= new Salvo("Normal",locationSalvo30);

        List<String> locationSalvo31 = new ArrayList<>();
        locationSalvo31.add("061001");
        Salvo Salvo31= new Salvo("Normal",locationSalvo31);

        List<String> locationSalvo32 = new ArrayList<>();
        locationSalvo32.add("071001");
        Salvo Salvo32= new Salvo("Normal",locationSalvo32);

        List<String> locationSalvo33 = new ArrayList<>();
        locationSalvo33.add("070101");
        Salvo Salvo33= new Salvo("Normal",locationSalvo33);

        List<String> locationSalvo34 = new ArrayList<>();
        locationSalvo34.add("070201");
        Salvo Salvo34= new Salvo("Normal",locationSalvo34);

        List<String> locationSalvo35 = new ArrayList<>();
        locationSalvo35.add("070301");
        Salvo Salvo35= new Salvo("Normal",locationSalvo35);

        List<String> locationSalvo36 = new ArrayList<>();
        locationSalvo36.add("080501");
        Salvo Salvo36= new Salvo("Normal",locationSalvo36);

        List<String> locationSalvo37 = new ArrayList<>();
        locationSalvo37.add("090501");
        Salvo Salvo37= new Salvo("Normal",locationSalvo37);

        //To Save Salvoes
        repositorySalvoes.save(Salvo21);
        repositorySalvoes.save(Salvo22);
        repositorySalvoes.save(Salvo23);
        repositorySalvoes.save(Salvo24);
        repositorySalvoes.save(Salvo25);
        repositorySalvoes.save(Salvo26);
        repositorySalvoes.save(Salvo27);
        repositorySalvoes.save(Salvo28);
        repositorySalvoes.save(Salvo29);
        repositorySalvoes.save(Salvo30);
        repositorySalvoes.save(Salvo31);
        repositorySalvoes.save(Salvo32);
        repositorySalvoes.save(Salvo33);
        repositorySalvoes.save(Salvo34);
        repositorySalvoes.save(Salvo35);
        repositorySalvoes.save(Salvo36);
        repositorySalvoes.save(Salvo37);


        Date gamePlayer05Date = new Date();
        // To Create the list of Salvoes
        List<Salvo> Player05ListSalvoesOnGame03 = new ArrayList<>();

        Player05ListSalvoesOnGame03.add(Salvo21);
        Player05ListSalvoesOnGame03.add(Salvo22);
        Player05ListSalvoesOnGame03.add(Salvo23);
        Player05ListSalvoesOnGame03.add(Salvo24);
        Player05ListSalvoesOnGame03.add(Salvo25);
        Player05ListSalvoesOnGame03.add(Salvo26);
        Player05ListSalvoesOnGame03.add(Salvo27);
        Player05ListSalvoesOnGame03.add(Salvo28);
        Player05ListSalvoesOnGame03.add(Salvo29);
        Player05ListSalvoesOnGame03.add(Salvo30);
        Player05ListSalvoesOnGame03.add(Salvo31);
        Player05ListSalvoesOnGame03.add(Salvo32);
        Player05ListSalvoesOnGame03.add(Salvo33);
        Player05ListSalvoesOnGame03.add(Salvo34);
        Player05ListSalvoesOnGame03.add(Salvo35);
        Player05ListSalvoesOnGame03.add(Salvo36);
        Player05ListSalvoesOnGame03.add(Salvo37);


        GamePlayer Game03Player05Player05ListOfShipsPlayer05ListSalvoes= new GamePlayer(Game03,Player03,gamePlayer05Date,Player05ListOfShipsIOnGame03 ,Player05ListSalvoesOnGame03);
        repositoryGamePlayer.save(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);

        Salvo21.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo22.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo23.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo24.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo25.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo26.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo27.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo28.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo29.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo30.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo31.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo32.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo33.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo34.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo35.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo36.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Salvo37.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);

        // To save Salvoes
        repositorySalvoes.save(Salvo21);
        repositorySalvoes.save(Salvo22);
        repositorySalvoes.save(Salvo23);
        repositorySalvoes.save(Salvo24);
        repositorySalvoes.save(Salvo25);
        repositorySalvoes.save(Salvo26);
        repositorySalvoes.save(Salvo27);
        repositorySalvoes.save(Salvo28);
        repositorySalvoes.save(Salvo29);
        repositorySalvoes.save(Salvo30);
        repositorySalvoes.save(Salvo31);
        repositorySalvoes.save(Salvo32);
        repositorySalvoes.save(Salvo33);
        repositorySalvoes.save(Salvo34);
        repositorySalvoes.save(Salvo35);
        repositorySalvoes.save(Salvo36);
        repositorySalvoes.save(Salvo37);

        Ship21Cruiser.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Ship22AircraftCarrier.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Ship23Destroyer.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Ship24Submarine.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        Ship25BattleShip.setGamePlayer(Game03Player05Player05ListOfShipsPlayer05ListSalvoes);
        repositoryShips.save(Ship21Cruiser);
        repositoryShips.save(Ship22AircraftCarrier);
        repositoryShips.save(Ship23Destroyer);
        repositoryShips.save(Ship24Submarine);
        repositoryShips.save(Ship25BattleShip);

        // Creation Board Player06
        List<String> locationShip26Cruiser = new ArrayList<>();
        locationShip26Cruiser.add("020301");
        locationShip26Cruiser.add("020401");
        locationShip26Cruiser.add("020501");

        List<String> locationShip27BattleShip = new ArrayList<>();
        locationShip27BattleShip.add("030701");
        locationShip27BattleShip.add("040701");
        locationShip27BattleShip.add("070701");
        locationShip27BattleShip.add("060701");

        List<String> locationShip28AircraftCarrier = new ArrayList<>();
        locationShip28AircraftCarrier.add("031001");
        locationShip28AircraftCarrier.add("041001");
        locationShip28AircraftCarrier.add("051001");
        locationShip28AircraftCarrier.add("061001");
        locationShip28AircraftCarrier.add("071001");

        List<String> locationShip29Submarine = new ArrayList<>();
        locationShip29Submarine.add("070101");
        locationShip29Submarine.add("070201");
        locationShip29Submarine.add("070301");

        List<String> locationShip30Destroyer = new ArrayList<>();
        locationShip30Destroyer.add("080501");
        locationShip30Destroyer.add("090501");

        Ship Ship26Cruiser= new Ship("Cruiser",locationShip26Cruiser);
        Ship Ship27BattleShip = new Ship("Battle Ship",locationShip27BattleShip);
        Ship Ship28AircraftCarrier= new Ship("Aircraft Carrier",locationShip28AircraftCarrier);
        Ship Ship29Submarine= new Ship("Submarine",locationShip29Submarine);
        Ship Ship30Destroyer= new Ship("Destroyer",locationShip30Destroyer);
        repositoryShips.save(Ship26Cruiser);
        repositoryShips.save(Ship27BattleShip);
        repositoryShips.save(Ship28AircraftCarrier);
        repositoryShips.save(Ship29Submarine);
        repositoryShips.save(Ship30Destroyer);

        // Create the list of Ships Player06
        List<Ship> Player06ListOfShipsIOnGame03 = new ArrayList<>();
        Player06ListOfShipsIOnGame03.add(Ship26Cruiser);
        Player06ListOfShipsIOnGame03.add(Ship27BattleShip);
        Player06ListOfShipsIOnGame03.add(Ship28AircraftCarrier);
        Player06ListOfShipsIOnGame03.add(Ship29Submarine);
        Player06ListOfShipsIOnGame03.add(Ship30Destroyer);

        // The creation of Player06 Salvoes

        List<String> locationSalvo38 = new ArrayList<>();
        locationSalvo38.add("020101");
        Salvo Salvo38= new Salvo("Normal",locationSalvo38);

        List<String> locationSalvo39 = new ArrayList<>();
        locationSalvo39.add("020201");
        Salvo Salvo39= new Salvo("Normal",locationSalvo39);

        List<String> locationSalvo40 = new ArrayList<>();
        locationSalvo40.add("020301");
        Salvo Salvo40= new Salvo("Normal",locationSalvo40);

        List<String> locationSalvo41 = new ArrayList<>();
        locationSalvo41.add("030401");
        Salvo Salvo41= new Salvo("Normal",locationSalvo41);

        List<String> locationSalvo42 = new ArrayList<>();
        locationSalvo42.add("040401");
        Salvo Salvo42= new Salvo("Normal",locationSalvo42);

        List<String> locationSalvo43 = new ArrayList<>();
        locationSalvo43.add("050401");
        Salvo Salvo43= new Salvo("Normal",locationSalvo43);

        List<String> locationSalvo44 = new ArrayList<>();
        locationSalvo44.add("060401");
        Salvo Salvo44= new Salvo("Normal",locationSalvo44);

        List<String> locationSalvo45 = new ArrayList<>();
        locationSalvo45.add("070401");
        Salvo Salvo45= new Salvo("Normal",locationSalvo45);

        List<String> locationSalvo46 = new ArrayList<>();
        locationSalvo46.add("040901");
        Salvo Salvo46= new Salvo("Normal",locationSalvo46);

        List<String> locationSalvo47 = new ArrayList<>();
        locationSalvo47.add("050901");
        Salvo Salvo47= new Salvo("Normal",locationSalvo47);

        List<String> locationSalvo48 = new ArrayList<>();
        locationSalvo48.add("060901");
        Salvo Salvo48= new Salvo("Normal",locationSalvo48);

        List<String> locationSalvo49 = new ArrayList<>();
        locationSalvo49.add("060601");
        Salvo Salvo49= new Salvo("Normal",locationSalvo49);

        List<String> locationSalvo50 = new ArrayList<>();
        locationSalvo50.add("070601");
        Salvo Salvo50= new Salvo("Normal",locationSalvo50);

        List<String> locationSalvo51 = new ArrayList<>();
        locationSalvo51.add("100601");
        Salvo Salvo51= new Salvo("Normal",locationSalvo51);

        List<String> locationSalvo52 = new ArrayList<>();
        locationSalvo52.add("100701");
        Salvo Salvo52= new Salvo("Normal",locationSalvo52);

        List<String> locationSalvo53 = new ArrayList<>();
        locationSalvo53.add("100801");
        Salvo Salvo53= new Salvo("Normal",locationSalvo53);

        List<String> locationSalvo54 = new ArrayList<>();
        locationSalvo54.add("100901");
        Salvo Salvo54= new Salvo("Normal",locationSalvo54);

        // To save salvoes
        repositorySalvoes.save(Salvo38);
        repositorySalvoes.save(Salvo39);
        repositorySalvoes.save(Salvo40);
        repositorySalvoes.save(Salvo41);
        repositorySalvoes.save(Salvo42);
        repositorySalvoes.save(Salvo43);
        repositorySalvoes.save(Salvo44);
        repositorySalvoes.save(Salvo45);
        repositorySalvoes.save(Salvo46);
        repositorySalvoes.save(Salvo47);
        repositorySalvoes.save(Salvo48);
        repositorySalvoes.save(Salvo49);
        repositorySalvoes.save(Salvo50);
        repositorySalvoes.save(Salvo51);
        repositorySalvoes.save(Salvo52);
        repositorySalvoes.save(Salvo53);
        repositorySalvoes.save(Salvo54);

        Date gamePlayer06Date = new Date();
        //List of Salvoes
        List<Salvo> Player06ListSalvoesOnGame03 = new ArrayList<>();
        Player06ListSalvoesOnGame03.add(Salvo38);
        Player06ListSalvoesOnGame03.add(Salvo39);
        Player06ListSalvoesOnGame03.add(Salvo40);
        Player06ListSalvoesOnGame03.add(Salvo41);
        Player06ListSalvoesOnGame03.add(Salvo42);
        Player06ListSalvoesOnGame03.add(Salvo43);
        Player06ListSalvoesOnGame03.add(Salvo44);
        Player06ListSalvoesOnGame03.add(Salvo45);
        Player06ListSalvoesOnGame03.add(Salvo46);
        Player06ListSalvoesOnGame03.add(Salvo47);
        Player06ListSalvoesOnGame03.add(Salvo48);
        Player06ListSalvoesOnGame03.add(Salvo49);
        Player06ListSalvoesOnGame03.add(Salvo50);
        Player06ListSalvoesOnGame03.add(Salvo51);
        Player06ListSalvoesOnGame03.add(Salvo52);
        Player06ListSalvoesOnGame03.add(Salvo53);
        Player06ListSalvoesOnGame03.add(Salvo54);



        GamePlayer Game03Player06Player06ListOfShipsPlayer06ListSalvoes= new GamePlayer(Game03,Player06,gamePlayer06Date,Player06ListOfShipsIOnGame03 ,Player06ListSalvoesOnGame03);
        repositoryGamePlayer.save(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);

        Salvo38.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo39.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo40.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo41.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo42.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo43.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo44.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo45.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo46.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo47.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo48.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo49.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo50.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo51.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo52.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo53.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Salvo54.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);

// To save salvoes
        repositorySalvoes.save(Salvo38);
        repositorySalvoes.save(Salvo39);
        repositorySalvoes.save(Salvo40);
        repositorySalvoes.save(Salvo41);
        repositorySalvoes.save(Salvo42);
        repositorySalvoes.save(Salvo43);
        repositorySalvoes.save(Salvo44);
        repositorySalvoes.save(Salvo45);
        repositorySalvoes.save(Salvo46);
        repositorySalvoes.save(Salvo47);
        repositorySalvoes.save(Salvo48);
        repositorySalvoes.save(Salvo49);
        repositorySalvoes.save(Salvo50);
        repositorySalvoes.save(Salvo51);
        repositorySalvoes.save(Salvo52);
        repositorySalvoes.save(Salvo53);
        repositorySalvoes.save(Salvo54);


        Ship26Cruiser.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Ship27BattleShip.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Ship28AircraftCarrier.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Ship29Submarine.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);
        Ship30Destroyer.setGamePlayer(Game03Player06Player06ListOfShipsPlayer06ListSalvoes);

        repositoryShips.save(Ship26Cruiser);
        repositoryShips.save(Ship27BattleShip);
        repositoryShips.save(Ship28AircraftCarrier);
        repositoryShips.save(Ship29Submarine);
        repositoryShips.save(Ship30Destroyer);

        //Updates from the two Boards
        UpdateShipsSalvos updateGame03SalvosAgainstShipsPlayer05Player06TwoWays= new UpdateShipsSalvos(Game03Player05Player05ListOfShipsPlayer05ListSalvoes,Game03Player06Player06ListOfShipsPlayer06ListSalvoes,repositoryShips);
        updateGame03SalvosAgainstShipsPlayer05Player06TwoWays.UpdateSalvosAdversary();

    }
}
