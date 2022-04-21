package com.codeoftheweb.salvo;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import com.codeoftheweb.salvo.domain.Game;
import com.codeoftheweb.salvo.domain.GamePlayer;
import com.codeoftheweb.salvo.domain.Player;
import com.codeoftheweb.salvo.domain.Ship;
import com.codeoftheweb.salvo.repositories.GamePlayerRepository;
import com.codeoftheweb.salvo.repositories.GameRepository;
import com.codeoftheweb.salvo.repositories.PlayerRepository;
import com.codeoftheweb.salvo.repositories.ShipRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication

public class SalvoApplication {

   // private static final Logger log = LoggerFactory.getLogger(SalvoApplication.class);

    /*public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }*/
    public static void main(String[] args) {
        SpringApplication.run(SalvoApplication.class, args);
    }
   @Bean
    public CommandLineRunner
        initData(GameRepository repositoryGames, PlayerRepository repositoryPlayers, GamePlayerRepository repositoryGamePlayer, ShipRepository repositoryShips) {

          /*  Date game_creation_date01 = new Date();
            Date game_creation_date02= addHoursToJavaUtilDate(game_creation_date01,1);*/
            //Date game_creation_date03= addHoursToJavaUtilDate(game_creation_date01,2);
            //Date game_creation_date04= addHoursToJavaUtilDate(game_creation_date01,3);
            //Date game_creation_date05= addHoursToJavaUtilDate(game_creation_date01,4);


                return (args) -> {

                    //___________________________________ Comments in block to test
                    // Save Games
                    /*Game Game01 = new Game("Game 01", game_creation_date01);
                    Game Game02 = new Game("Game 02", game_creation_date02);
                    repositoryGames.save(Game01);
                    repositoryGames.save(Game02);

                    // Save Players
                    Player Player01 = new Player("Jack", "Bauer","jack@example.com");
                    Player Player02 = new Player("Kim", "Bassigner","kim@example.com");
                    Player Player03 = new Player("Tony", "Almeida","tony@example.com");
                    Player Player04 = new Player("Mia", "Rojas","mia@example.com");

                    repositoryPlayers.save(Player01);
                    repositoryPlayers.save(Player02);
                    repositoryPlayers.save(Player03);
                    repositoryPlayers.save(Player04);
                   // repositoryPlayers.save(Player05);
                    //__________________________________________________________________________________________________________________
                    // Create a Game01Player01gamePlayer01ListOfShips

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
                    List<Ship> gamePlayer01ListOfShips = new ArrayList<>();
                    gamePlayer01ListOfShips.add(Ship01Destroyer);
                    gamePlayer01ListOfShips.add(Ship02Battleship);
                    gamePlayer01ListOfShips.add(Ship03AircraftCarrier);
                    gamePlayer01ListOfShips.add(Ship04Submarine);
                    gamePlayer01ListOfShips.add(Ship05Cruiser);
                    repositoryShips.save(Ship01Destroyer);
                    repositoryShips.save(Ship02Battleship);
                    repositoryShips.save(Ship03AircraftCarrier);
                    repositoryShips.save(Ship04Submarine);
                    repositoryShips.save(Ship05Cruiser);
                    // Create and save Game01 and Player01 pairs in GamePlayer repository
                    Date gamePlayer01Date = new Date();
                    GamePlayer Game01Player01gamePlayer01ListOfShips = new GamePlayer(Game01,Player01,gamePlayer01Date,gamePlayer01ListOfShips);

                    repositoryGamePlayer.save(Game01Player01gamePlayer01ListOfShips);

                    // Set the game player row with the ship
                    Ship01Destroyer.setGamePlayer(Game01Player01gamePlayer01ListOfShips);
                    Ship02Battleship.setGamePlayer(Game01Player01gamePlayer01ListOfShips);
                    Ship03AircraftCarrier.setGamePlayer(Game01Player01gamePlayer01ListOfShips);
                    Ship04Submarine.setGamePlayer(Game01Player01gamePlayer01ListOfShips);
                    Ship05Cruiser.setGamePlayer(Game01Player01gamePlayer01ListOfShips);
                    repositoryShips.save(Ship01Destroyer);
                    repositoryShips.save(Ship02Battleship);
                    repositoryShips.save(Ship03AircraftCarrier);
                    repositoryShips.save(Ship04Submarine);
                    repositoryShips.save(Ship05Cruiser);

                    // To Create the Ships with gamePlayer02ListOfShips in Game01 for Player02

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

                    // Create the list of Ships for the Player02 in Game01
                    List<Ship> gamePlayer02ListOfShips = new ArrayList<>();
                    gamePlayer02ListOfShips.add(Ship06Battleship);
                    gamePlayer02ListOfShips.add(Ship07Submarine);
                    gamePlayer02ListOfShips.add(Ship08Cruiser);
                    gamePlayer02ListOfShips.add(Ship09Submarine);
                    gamePlayer02ListOfShips.add(Ship10AircraftCarrier);

                    Date gamePlayer02Date = new Date();
                    GamePlayer Game01Player02gamePlayer02ListOfShips= new GamePlayer(Game01,Player02,gamePlayer02Date,gamePlayer02ListOfShips);
                    repositoryGamePlayer.save(Game01Player02gamePlayer02ListOfShips);

                    // Set the game player row with the ship
                    Ship06Battleship.setGamePlayer(Game01Player02gamePlayer02ListOfShips);
                    Ship07Submarine.setGamePlayer(Game01Player02gamePlayer02ListOfShips);
                    Ship08Cruiser.setGamePlayer(Game01Player02gamePlayer02ListOfShips);
                    Ship09Submarine.setGamePlayer(Game01Player02gamePlayer02ListOfShips);
                    Ship10AircraftCarrier.setGamePlayer(Game01Player02gamePlayer02ListOfShips);
                    repositoryShips.save(Ship06Battleship);
                    repositoryShips.save(Ship07Submarine);
                    repositoryShips.save(Ship08Cruiser);
                    repositoryShips.save(Ship09Submarine);
                    repositoryShips.save(Ship10AircraftCarrier);
                    //______________________________________________________________________________________________________________
                    // To create Ships for Player04 in Game02 with gamePlayer03ListOfShips
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

                    // Create the list of Ships for the gamePlayer03
                    List<Ship> gamePlayer03ListOfShips = new ArrayList<>();
                    gamePlayer03ListOfShips.add(Ship11Submarine);
                    gamePlayer03ListOfShips.add(Ship12AircraftCarrier);
                    gamePlayer03ListOfShips.add(Ship13BattleShip);
                    gamePlayer03ListOfShips.add(Ship14Carrier);
                    gamePlayer03ListOfShips.add(Ship15Destroyer);

                    Date gamePlayer03Date = new Date();
                    GamePlayer Game02Player04gamePlayer03ListOfShips= new GamePlayer(Game02,Player03,gamePlayer03Date,gamePlayer03ListOfShips);
                    repositoryGamePlayer.save(Game02Player04gamePlayer03ListOfShips);

                    Ship11Submarine.setGamePlayer(Game02Player04gamePlayer03ListOfShips);
                    Ship12AircraftCarrier.setGamePlayer(Game02Player04gamePlayer03ListOfShips);
                    Ship13BattleShip.setGamePlayer(Game02Player04gamePlayer03ListOfShips);
                    Ship14Carrier.setGamePlayer(Game02Player04gamePlayer03ListOfShips);
                    Ship15Destroyer.setGamePlayer(Game02Player04gamePlayer03ListOfShips);
                    repositoryShips.save(Ship11Submarine);
                    repositoryShips.save(Ship12AircraftCarrier);
                    repositoryShips.save(Ship13BattleShip);
                    repositoryShips.save(Ship14Carrier);
                    repositoryShips.save(Ship15Destroyer);

                    // To create Game02Player04gamePlayer04ListOfShips
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

                    Date gamePlayer04Date = new Date();
                    GamePlayer Game02Player04gamePlayer04ListOfShips= new GamePlayer(Game02,Player04,gamePlayer04Date,gamePlayer03ListOfShips);
                    repositoryGamePlayer.save(Game02Player04gamePlayer04ListOfShips);

                    Ship16AircraftCarrier.setGamePlayer(Game02Player04gamePlayer04ListOfShips);
                    Ship17Submarine.setGamePlayer(Game02Player04gamePlayer04ListOfShips);
                    Ship18Cruiser.setGamePlayer(Game02Player04gamePlayer04ListOfShips);
                    Ship19Battleship.setGamePlayer(Game02Player04gamePlayer04ListOfShips);
                    Ship20Destroyer.setGamePlayer(Game02Player04gamePlayer04ListOfShips);

                    repositoryShips.save(Ship16AircraftCarrier);
                    repositoryShips.save(Ship17Submarine);
                    repositoryShips.save(Ship18Cruiser);
                    repositoryShips.save(Ship19Battleship);
                    repositoryShips.save(Ship20Destroyer);*/
                    // End of comment to test
                    //System.out.println(String.valueOf(repositoryGamePlayer.findAll()));

                   // GamePlayer Game01Player03Ship03 = new GamePlayer(Game01,Player03,game_player_date01,Ship03);
                   // repositoryGamePlayer.save(Game01Player03Ship03);

                   // GamePlayer Game02Player01Ship04 = new GamePlayer(Game02,Player01,game_player_date01,Ship04);
                   // repositoryGamePlayer.save(Game02Player01Ship04);

                    //GamePlayer Game02Player02Ship05 = new GamePlayer(Game02,Player02,game_player_date01,Ship05);
                    //repositoryGamePlayer.save(Game02Player02Ship05);

                    //GamePlayer Game02Player03Ship01 = new GamePlayer(Game02,Player03,game_player_date01,Ship01);
                    //repositoryGamePlayer.save(Game02Player03Ship01);

                    //GamePlayer Game03Player01Ship02 = new GamePlayer(Game03,Player01,game_player_date01,Ship02);
                    //repositoryGamePlayer.save(Game03Player01Ship02);

                    //GamePlayer Game03Player02Ship03 = new GamePlayer(Game03,Player02,game_player_date01,Ship03);
                    //repositoryGamePlayer.save(Game03Player02Ship03);

                    //GamePlayer Game03Player03Ship04 = new GamePlayer(Game03,Player03,game_player_date01,Ship04);
                    //repositoryGamePlayer.save(Game03Player03Ship04);

                    //GamePlayer Game03Player04Ship05 = new GamePlayer(Game03,Player04,game_player_date01,Ship05);
                    //repositoryGamePlayer.save(Game03Player04Ship05);
                    //System.out.println(String.valueOf(Ship01.getLocations()));
                    //System.out.println(String.valueOf(Ship02.getLocations()));
                    //GamePlayer Game04Player01Ship01 = new GamePlayer(Game04,Player01,game_player_date01,Ship01);
                   // repositoryGamePlayer.save(Game04Player01Ship01);
                    //log.info("Player05.getGames(repositoryGamePlayer)");
                    //log.info(String.valueOf(Player02.getGames(repositoryGamePlayer)));
                    //log.info("Game01.getPlayers(repositoryGamePlayer)");
                    //log.info(String.valueOf(Game01.getPlayers(repositoryGamePlayer)));
                   //log.info("repositoryGamePlayer.findAll()");
                    //log.info(String.valueOf(repositoryGamePlayer.findAll()));
                    //Long id04 = Game04.getId();
                    //log.info(String.valueOf(id04));
                    //log.info("GamePlayer found with findAll():");
                    //log.info("-------------------------------");
                    //for (GamePlayer gamePlayer : repositoryGamePlayer.findAll()) {
                    //   log.info(gamePlayer.toString());
                    // }
                    //List listPlayer01 = repositoryGamePlayer.findByPlayer_Id(Player02.getId());

                    //log.info(String.valueOf(listPlayer01));

                    // fetch all games
                    //log.info("Games found with findAll():");
                    //log.info("-------------------------------");
                    //for (Game game : repositoryGames.findAll()) {
                     //   log.info(game.toString());
                   // }
                    ///log.info("");
                    //Optional<Game> game = repositoryGames.findById(2L);
                    //log.info("Player found with findById(1L):");
                    //log.info("--------------------------------");
                    //log.info(game.toString());
                    //log.info("");

                    //log.info("Customer found with findByGameName(\"Game Sergi\"):");
                    //log.info("--------------------------------------------");
                    //repositoryGames.findByGameName("Game Sergi").forEach(sergi -> {
                    //    log.info(sergi.toString());
                    //});
                    //List<GamePlayer> gameplayer02=repositoryGamePlayer.findByid(2L);
                    //log.info("repositoryGamePlayer.findByid(1L):");
                    //log.info(gameplayer02.toString());
                };

}


    }





