package com.codeoftheweb.salvo.bootstrap;

import com.codeoftheweb.salvo.domain.*;
import com.codeoftheweb.salvo.repositories.GamePlayerRepository;
import com.codeoftheweb.salvo.repositories.GameRepository;
import com.codeoftheweb.salvo.repositories.PlayerRepository;
import com.codeoftheweb.salvo.repositories.ShipRepository;
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
        // Save Games
        Game Game01 = new Game("Game 01", game_creation_date01);
        Game Game02 = new Game("Game 02", game_creation_date02);
        repositoryGames.save(Game01);
        repositoryGames.save(Game02);

        // Save Players
        Player Player01 = new Player("Jack", "Bauer","jack@example.com");
        Player Player02 = new Player("Kim", "Bassigner","kim@example.com");
        Player Player03 = new Player("Tony", "Almeida","tony@example.com");
        Player Player04 = new Player("Mia", "Rich","mia@example.com");

        repositoryPlayers.save(Player01);
        repositoryPlayers.save(Player02);
        repositoryPlayers.save(Player03);
        repositoryPlayers.save(Player04);


        // Create the list of Locations of the Ships
        List<String> locationShip01Destroyer = new ArrayList<>();
        locationShip01Destroyer.add("0109");
        locationShip01Destroyer.add("0209");

        List<String> locationShip02Battleship = new ArrayList<>();
        locationShip02Battleship.add("0509");
        locationShip02Battleship.add("0609");
        locationShip02Battleship.add("0709");
        locationShip02Battleship.add("0809");

        List<String> locationShip03AircraftCarrier = new ArrayList<>();
        locationShip03AircraftCarrier.add("0301");
        locationShip03AircraftCarrier.add("0302");
        locationShip03AircraftCarrier.add("0303");
        locationShip03AircraftCarrier.add("0304");
        locationShip03AircraftCarrier.add("0305");

        List<String> locationShip04Submarine = new ArrayList<>();
        locationShip04Submarine.add("0701");
        locationShip04Submarine.add("0702");
        locationShip04Submarine.add("0703");

        List<String> locationShip05Cruiser = new ArrayList<>();
        locationShip05Cruiser.add("0904");
        locationShip05Cruiser.add("0905");
        locationShip05Cruiser.add("0906");
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
        repositoryShips.save(Ship01Destroyer);
        repositoryShips.save(Ship02Battleship);
        repositoryShips.save(Ship03AircraftCarrier);
        repositoryShips.save(Ship04Submarine);
        repositoryShips.save(Ship05Cruiser);
        // Create and save Game01 and Player01 pairs in GamePlayer repository
        Date gamePlayer01Date = new Date();
        // To creat some salvoes to test
        List<Salvo> Player01ListSalvoesOnGame01 = new ArrayList<>();

        List<String> locationSalvo01 = new ArrayList<>();
        locationSalvo01.add("0303");
        Salvo Salvo01= new Salvo("Normal",locationSalvo01);
        repositorySalvoes.save(Salvo01);
        Player01ListSalvoesOnGame01.add(Salvo01);

        List<String> locationSalvo02 = new ArrayList<>();
        locationSalvo02.add("0307");
        Salvo Salvo02= new Salvo("Normal",locationSalvo02);
        repositorySalvoes.save(Salvo02);
        Player01ListSalvoesOnGame01.add(Salvo02);

        List<String> locationSalvo03 = new ArrayList<>();
        locationSalvo03.add("0704");
        Salvo Salvo03= new Salvo("Normal",locationSalvo03);
        repositorySalvoes.save(Salvo03);
        Player01ListSalvoesOnGame01.add(Salvo03);

        List<String> locationSalvo04 = new ArrayList<>();
        locationSalvo04.add("0709");
        Salvo Salvo04= new Salvo("Normal",locationSalvo04);
        repositorySalvoes.save(Salvo04);
        Player01ListSalvoesOnGame01.add(Salvo04);

        List<String> locationSalvo05 = new ArrayList<>();
        locationSalvo05.add("0101");
        Salvo Salvo05= new Salvo("Normal",locationSalvo05);
        repositorySalvoes.save(Salvo05);
        Player01ListSalvoesOnGame01.add(Salvo05);

        GamePlayer Game01Player01Player01ListOfShipsPlayer01ListSalvoes = new GamePlayer(Game01,Player01,gamePlayer01Date,Player01ListShipsGame01,Player01ListSalvoesOnGame01);
        // To set the GamePlayer for the salvoes
        repositoryGamePlayer.save(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);

        Salvo01.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        repositorySalvoes.save(Salvo01);

        Salvo02.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        repositorySalvoes.save(Salvo02);

        Salvo03.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        repositorySalvoes.save(Salvo03);

        Salvo04.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        repositorySalvoes.save(Salvo04);

        Salvo05.setGamePlayer(Game01Player01Player01ListOfShipsPlayer01ListSalvoes);
        repositorySalvoes.save(Salvo05);

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
        locationShip06Battleship.add("0110");
        locationShip06Battleship.add("0210");
        locationShip06Battleship.add("0310");
        locationShip06Battleship.add("0410");

        List<String> locationShip07Submarine = new ArrayList<>();
        locationShip07Submarine.add("0506");
        locationShip07Submarine.add("0606");
        locationShip07Submarine.add("0706");

        List<String> locationShip08Cruiser = new ArrayList<>();
        locationShip08Cruiser.add("1005");
        locationShip08Cruiser.add("1006");
        locationShip08Cruiser.add("1007");

        List<String> locationShip09Submarine = new ArrayList<>();
        locationShip09Submarine.add("0102");
        locationShip09Submarine.add("0103");
        locationShip09Submarine.add("0104");

        List<String> locationShip10AircraftCarrier = new ArrayList<>();
        locationShip10AircraftCarrier.add("0501");
        locationShip10AircraftCarrier.add("0601");
        locationShip10AircraftCarrier.add("0701");
        locationShip10AircraftCarrier.add("0801");
        locationShip10AircraftCarrier.add("0901");

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
        List<Salvo> Player02ListSalvoesOnGame01 = new ArrayList<>();

        List<String> locationSalvo06 = new ArrayList<>();
        locationSalvo06.add("0309");
        Salvo Salvo06= new Salvo("Normal",locationSalvo06);
        repositorySalvoes.save(Salvo06);
        Player02ListSalvoesOnGame01.add(Salvo06);

        List<String> locationSalvo07 = new ArrayList<>();
        locationSalvo07.add("0304");
        Salvo Salvo07= new Salvo("Normal",locationSalvo07);
        repositorySalvoes.save(Salvo07);
        Player02ListSalvoesOnGame01.add(Salvo07);

        List<String> locationSalvo08 = new ArrayList<>();
        locationSalvo08.add("0506");
        Salvo Salvo08= new Salvo("Normal",locationSalvo08);
        repositorySalvoes.save(Salvo08);
        Player02ListSalvoesOnGame01.add(Salvo08);

        List<String> locationSalvo09 = new ArrayList<>();
        locationSalvo09.add("0803");
        Salvo Salvo09= new Salvo("Normal",locationSalvo09);
        repositorySalvoes.save(Salvo09);
        Player02ListSalvoesOnGame01.add(Salvo09);

        List<String> locationSalvo10 = new ArrayList<>();
        locationSalvo10.add("0809");
        Salvo Salvo10= new Salvo("Normal",locationSalvo10);
        repositorySalvoes.save(Salvo10);
        Player02ListSalvoesOnGame01.add(Salvo10);

        Date gamePlayer02Date = new Date();

        GamePlayer Game01Player02Player02ListOfShipsPlayer02ListSalvoes= new GamePlayer(Game01,Player02,gamePlayer02Date,Player02ListShipsGame01,Player02ListSalvoesOnGame01);
        repositoryGamePlayer.save(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);

        Salvo06.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        repositorySalvoes.save(Salvo06);

        Salvo07.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        repositorySalvoes.save(Salvo07);

        Salvo08.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        repositorySalvoes.save(Salvo08);

        Salvo09.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        repositorySalvoes.save(Salvo09);

        Salvo10.setGamePlayer(Game01Player02Player02ListOfShipsPlayer02ListSalvoes);
        repositorySalvoes.save(Salvo10);

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
        //______________________________________________________________________________________________________________
        // To create Ships for Player03 in Game02 with Player03ListOfShips
        // Create and Locate the Ships
        List<String> locationShip11Submarine = new ArrayList<>();
        locationShip11Submarine.add("0309");
        locationShip11Submarine.add("0409");
        locationShip11Submarine.add("0509");

        List<String> locationShip12AircraftCarrier = new ArrayList<>();
        locationShip12AircraftCarrier.add("0506");
        locationShip12AircraftCarrier.add("0606");
        locationShip12AircraftCarrier.add("0706");
        locationShip12AircraftCarrier.add("0806");
        locationShip12AircraftCarrier.add("0906");


        List<String> locationShip13BattleShip = new ArrayList<>();
        locationShip13BattleShip.add("0304");
        locationShip13BattleShip.add("0404");
        locationShip13BattleShip.add("0504");
        locationShip13BattleShip.add("0604");

        List<String> locationShip14Carrier = new ArrayList<>();
        locationShip14Carrier.add("0802");
        locationShip14Carrier.add("0902");
        locationShip14Carrier.add("1002");

        List<String> locationShip15Destroyer = new ArrayList<>();
        locationShip15Destroyer.add("0101");
        locationShip15Destroyer.add("0201");

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

        Date gamePlayer03Date = new Date();
        List<Salvo> Player03ListSalvoesOnGame02 = new ArrayList<>();

        List<String> locationSalvo11 = new ArrayList<>();
        locationSalvo11.add("0104");
        Salvo Salvo11= new Salvo("Normal",locationSalvo11);
        repositorySalvoes.save(Salvo11);
        Player03ListSalvoesOnGame02.add(Salvo11);

        List<String> locationSalvo12 = new ArrayList<>();
        locationSalvo12.add("0401");
        Salvo Salvo12= new Salvo("Normal",locationSalvo12);
        repositorySalvoes.save(Salvo12);
        Player03ListSalvoesOnGame02.add(Salvo12);

        List<String> locationSalvo13 = new ArrayList<>();
        locationSalvo13.add("0508");
        Salvo Salvo13= new Salvo("Normal",locationSalvo13);
        repositorySalvoes.save(Salvo13);
        Player03ListSalvoesOnGame02.add(Salvo13);

        List<String> locationSalvo14 = new ArrayList<>();
        locationSalvo14.add("0805");
        Salvo Salvo14= new Salvo("Normal",locationSalvo14);
        repositorySalvoes.save(Salvo14);
        Player03ListSalvoesOnGame02.add(Salvo14);

        List<String> locationSalvo15 = new ArrayList<>();
        locationSalvo15.add("1004");
        Salvo Salvo15= new Salvo("Normal",locationSalvo15);
        repositorySalvoes.save(Salvo15);
        Player03ListSalvoesOnGame02.add(Salvo15);


        GamePlayer Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes= new GamePlayer(Game02,Player03,gamePlayer03Date,Player03ListShipsGame02,Player03ListSalvoesOnGame02);
        repositoryGamePlayer.save(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);

        Salvo11.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        repositorySalvoes.save(Salvo11);

        Salvo12.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        repositorySalvoes.save(Salvo12);

        Salvo13.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        repositorySalvoes.save(Salvo13);

        Salvo14.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        repositorySalvoes.save(Salvo14);

        Salvo15.setGamePlayer(Game02Player03gamePlayer03ListOfShipsPlayer03ListSalvoes);
        repositorySalvoes.save(Salvo15);

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
        locationShip16AircraftCarrier.add("0106");
        locationShip16AircraftCarrier.add("0107");
        locationShip16AircraftCarrier.add("0108");
        locationShip16AircraftCarrier.add("0109");
        locationShip16AircraftCarrier.add("0110");

        List<String> locationShip17Submarine = new ArrayList<>();
        locationShip17Submarine.add("0707");
        locationShip17Submarine.add("0708");
        locationShip17Submarine.add("0709");

        List<String> locationShip18Cruiser = new ArrayList<>();
        locationShip18Cruiser.add("0702");
        locationShip18Cruiser.add("0703");
        locationShip18Cruiser.add("0704");

        List<String> locationShip19Battleship = new ArrayList<>();
        locationShip19Battleship.add("0402");
        locationShip19Battleship.add("0403");
        locationShip19Battleship.add("0404");
        locationShip19Battleship.add("0405");

        List<String> locationShip20Destroyer = new ArrayList<>();
        locationShip20Destroyer.add("1005");
        locationShip20Destroyer.add("1006");

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

        Date gamePlayer04Date = new Date();
        List<Salvo> Player04ListSalvoesOnGame02 = new ArrayList<>();

        List<String> locationSalvo16 = new ArrayList<>();
        locationSalvo16.add("0101");
        Salvo Salvo16= new Salvo("Normal",locationSalvo16);
        repositorySalvoes.save(Salvo16);
        Player04ListSalvoesOnGame02.add(Salvo15);

        List<String> locationSalvo17 = new ArrayList<>();
        locationSalvo17.add("0110");
        Salvo Salvo17= new Salvo("Normal",locationSalvo17);
        repositorySalvoes.save(Salvo17);
        Player04ListSalvoesOnGame02.add(Salvo17);

        List<String> locationSalvo18 = new ArrayList<>();
        locationSalvo18.add("0605");
        Salvo Salvo18= new Salvo("Normal",locationSalvo18);
        repositorySalvoes.save(Salvo18);
        Player04ListSalvoesOnGame02.add(Salvo18);

        List<String> locationSalvo19 = new ArrayList<>();
        locationSalvo19.add("1001");
        Salvo Salvo19= new Salvo("Normal",locationSalvo19);
        repositorySalvoes.save(Salvo19);
        Player04ListSalvoesOnGame02.add(Salvo19);

        List<String> locationSalvo20 = new ArrayList<>();
        locationSalvo20.add("1010");
        Salvo Salvo20= new Salvo("Normal",locationSalvo20);
        repositorySalvoes.save(Salvo20);
        Player04ListSalvoesOnGame02.add(Salvo20);

        GamePlayer Game02Player04Player04ListOfShipsPlayer04ListSalvoes= new GamePlayer(Game02,Player04,gamePlayer04Date,Player04ListOfShipsIOnGame02 ,Player04ListSalvoesOnGame02);
        repositoryGamePlayer.save(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);

        Salvo16.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        repositorySalvoes.save(Salvo16);

        Salvo17.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        repositorySalvoes.save(Salvo17);

        Salvo18.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        repositorySalvoes.save(Salvo18);

        Salvo19.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        repositorySalvoes.save(Salvo19);

        Salvo20.setGamePlayer(Game02Player04Player04ListOfShipsPlayer04ListSalvoes);
        repositorySalvoes.save(Salvo20);

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
    }
}
