package com.codeoftheweb.salvo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication

public class SalvoApplication {

    private static final Logger log = LoggerFactory.getLogger(SalvoApplication.class);

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }
    public static void main(String[] args) {
        SpringApplication.run(SalvoApplication.class, args);
    }
   @Bean
    public CommandLineRunner
        initData(GameRepository repositoryGames,PlayerRepository repositoryPlayers,GamePlayerRepository repositoryGamePlayer,ShipRepository repositoryShips) {

            Date game_creation_date01 = new Date();
            Date game_creation_date02= addHoursToJavaUtilDate(game_creation_date01,1);
            Date game_creation_date03= addHoursToJavaUtilDate(game_creation_date01,2);
            Date game_creation_date04= addHoursToJavaUtilDate(game_creation_date01,3);
            Date game_creation_date05= addHoursToJavaUtilDate(game_creation_date01,4);


                return (args) -> {
                    // Save Games
                    Game Game01 = new Game("Game 01", game_creation_date01);
                    Game Game02 = new Game("Game 02", game_creation_date02);
                    Game Game03 = new Game("Game 03", game_creation_date03);
                    Game Game04 = new Game("Game 04", game_creation_date04);
                    Game Game05 = new Game("Game 05", game_creation_date05);
                    repositoryGames.save(Game01);
                    repositoryGames.save(Game02);
                    repositoryGames.save(Game03);
                    repositoryGames.save(Game04);
                    repositoryGames.save(Game05);
                    // Save Players
                    Player Player01 = new Player("Jack", "Bauer","jack@example.com");
                    Player Player02 = new Player("Kim", "Bassigner","kim@example.com");
                    Player Player03 = new Player("Tony", "Almeida","tony@example.com");
                    Player Player04 = new Player("Mia", "Rojas","mia@example.com");
                    Player Player05 = new Player("Michelle", "Dessler","michelle@example.com");
                    repositoryPlayers.save(Player01);
                    repositoryPlayers.save(Player02);
                    repositoryPlayers.save(Player03);
                    repositoryPlayers.save(Player04);
                    repositoryPlayers.save(Player05);

                    // Create a Game01Player01gamePlayer01ListOfShips
                    // Create the list of Locations of the Ships
                    List<String> locationShip01 = new ArrayList<>();
                    locationShip01.add("B1");
                    locationShip01.add("B2");

                    List<String> locationShip02 = new ArrayList<>();
                    locationShip02.add("B5");
                    locationShip02.add("B6");
                    locationShip02.add("B7");
                    locationShip02.add("B8");

                    List<String> locationShip03 = new ArrayList<>();
                    locationShip03.add("F3");
                    locationShip03.add("G3");
                    locationShip03.add("H3");
                    locationShip03.add("I3");
                    locationShip03.add("J3");

                    List<String> locationShip04 = new ArrayList<>();
                    locationShip04.add("H7");
                    locationShip04.add("I7");
                    locationShip04.add("J7");

                    List<String> locationShip05 = new ArrayList<>();
                    locationShip05.add("E9");
                    locationShip05.add("F9");
                    locationShip05.add("G9");
                    // Create the Ships with the locations
                    Ship Ship01= new Ship("Container Ship",locationShip01);
                    Ship Ship02= new Ship("Bulk Carrier",locationShip02);
                    Ship Ship03= new Ship("Tanker Ship",locationShip03);
                    Ship Ship04= new Ship("Passenger Ship",locationShip04);
                    Ship Ship05= new Ship("Naval Ship",locationShip05);

                    // Create the list of Ships for the game01
                    List<Ship> gamePlayer01ListOfShips = new ArrayList<>();
                    gamePlayer01ListOfShips.add(Ship01);
                    gamePlayer01ListOfShips.add(Ship02);
                    gamePlayer01ListOfShips.add(Ship03);
                    gamePlayer01ListOfShips.add(Ship04);
                    gamePlayer01ListOfShips.add(Ship05);
                    repositoryShips.save(Ship01);
                    repositoryShips.save(Ship02);
                    repositoryShips.save(Ship03);
                    repositoryShips.save(Ship04);
                    repositoryShips.save(Ship05);
                    // Create and save Game and Player pairs in GamePlayer repository
                    Date gamePlayer01Date = new Date();
                    GamePlayer Game01Player01gamePlayer01ListOfShips = new GamePlayer(Game01,Player01,gamePlayer01Date,gamePlayer01ListOfShips);

                    repositoryGamePlayer.save(Game01Player01gamePlayer01ListOfShips);

                    // Set the game player row with the ship
                    Ship01.setGamePlayer(Game01Player01gamePlayer01ListOfShips);
                    Ship02.setGamePlayer(Game01Player01gamePlayer01ListOfShips);
                    Ship03.setGamePlayer(Game01Player01gamePlayer01ListOfShips);
                    Ship04.setGamePlayer(Game01Player01gamePlayer01ListOfShips);
                    Ship05.setGamePlayer(Game01Player01gamePlayer01ListOfShips);
                    repositoryShips.save(Ship01);
                    repositoryShips.save(Ship02);
                    repositoryShips.save(Ship03);
                    repositoryShips.save(Ship04);
                    repositoryShips.save(Ship05);

                    // To Create the Game01Player02gamePlayer02ListOfShips

                    List<String> locationShip06 = new ArrayList<>();
                    locationShip06.add("A1");
                    locationShip06.add("A2");
                    locationShip06.add("A3");
                    locationShip06.add("A4");

                    List<String> locationShip07 = new ArrayList<>();
                    locationShip07.add("E5");
                    locationShip07.add("E6");
                    locationShip07.add("E7");

                    List<String> locationShip08 = new ArrayList<>();
                    locationShip08.add("G1");
                    locationShip08.add("H1");
                    locationShip08.add("I1");

                    List<String> locationShip09 = new ArrayList<>();
                    locationShip09.add("D10");
                    locationShip09.add("E10");
                    locationShip09.add("F10");

                    List<String> locationShip10 = new ArrayList<>();
                    locationShip10.add("J5");
                    locationShip10.add("J6");
                    locationShip10.add("J7");
                    locationShip10.add("J8");
                    locationShip10.add("J9");

                    // Create the Ships with the locations
                    Ship Ship06= new Ship("Container Ship",locationShip06);
                    Ship Ship07= new Ship("Bulk Carrier",locationShip07);
                    Ship Ship08= new Ship("Tanker Ship",locationShip08);
                    Ship Ship09= new Ship("Passenger Ship",locationShip09);
                    Ship Ship10= new Ship("Naval Ship",locationShip10);

                    repositoryShips.save(Ship06);
                    repositoryShips.save(Ship07);
                    repositoryShips.save(Ship08);
                    repositoryShips.save(Ship09);
                    repositoryShips.save(Ship10);

                    // Create the list of Ships for the gamePlayer02
                    List<Ship> gamePlayer02ListOfShips = new ArrayList<>();
                    gamePlayer02ListOfShips.add(Ship06);
                    gamePlayer02ListOfShips.add(Ship07);
                    gamePlayer02ListOfShips.add(Ship08);
                    gamePlayer02ListOfShips.add(Ship09);
                    gamePlayer02ListOfShips.add(Ship10);

                    Date gamePlayer02Date = new Date();
                    GamePlayer Game01Player02gamePlayer02ListOfShips= new GamePlayer(Game01,Player02,gamePlayer02Date,gamePlayer02ListOfShips);
                    repositoryGamePlayer.save(Game01Player02gamePlayer02ListOfShips);

                    // Set the game player row with the ship
                    Ship06.setGamePlayer(Game01Player02gamePlayer02ListOfShips);
                    Ship07.setGamePlayer(Game01Player02gamePlayer02ListOfShips);
                    Ship08.setGamePlayer(Game01Player02gamePlayer02ListOfShips);
                    Ship09.setGamePlayer(Game01Player02gamePlayer02ListOfShips);
                    Ship10.setGamePlayer(Game01Player02gamePlayer02ListOfShips);
                    repositoryShips.save(Ship06);
                    repositoryShips.save(Ship07);
                    repositoryShips.save(Ship08);
                    repositoryShips.save(Ship09);
                    repositoryShips.save(Ship10);

                    // To create Game02Player04gamePlayer03ListOfShips
                    // Create and Locate the Ships
                    List<String> locationShip11 = new ArrayList<>();
                    locationShip11.add("B3");
                    locationShip11.add("B4");
                    locationShip11.add("B5");

                    List<String> locationShip12 = new ArrayList<>();
                    locationShip12.add("E5");
                    locationShip12.add("E6");
                    locationShip12.add("E7");
                    locationShip12.add("E8");
                    locationShip12.add("E9");

                    List<String> locationShip13 = new ArrayList<>();
                    locationShip13.add("G3");
                    locationShip13.add("G4");
                    locationShip13.add("G5");
                    locationShip13.add("G6");

                    List<String> locationShip14 = new ArrayList<>();
                    locationShip14.add("I8");
                    locationShip14.add("I9");
                    locationShip14.add("I10");

                    List<String> locationShip15 = new ArrayList<>();
                    locationShip15.add("J1");
                    locationShip15.add("J2");

                    Ship Ship11= new Ship("Container Ship",locationShip11);
                    Ship Ship12= new Ship("Bulk Carrier",locationShip12);
                    Ship Ship13= new Ship("Tanker Ship",locationShip13);
                    Ship Ship14= new Ship("Passenger Ship",locationShip14);
                    Ship Ship15= new Ship("Naval Ship",locationShip15);

                    repositoryShips.save(Ship11);
                    repositoryShips.save(Ship12);
                    repositoryShips.save(Ship13);
                    repositoryShips.save(Ship14);
                    repositoryShips.save(Ship15);

                    // Create the list of Ships for the gamePlayer03
                    List<Ship> gamePlayer03ListOfShips = new ArrayList<>();
                    gamePlayer03ListOfShips.add(Ship11);
                    gamePlayer03ListOfShips.add(Ship12);
                    gamePlayer03ListOfShips.add(Ship13);
                    gamePlayer03ListOfShips.add(Ship14);
                    gamePlayer03ListOfShips.add(Ship15);

                    Date gamePlayer03Date = new Date();
                    GamePlayer Game02Player04gamePlayer03ListOfShips= new GamePlayer(Game02,Player04,gamePlayer03Date,gamePlayer03ListOfShips);
                    repositoryGamePlayer.save(Game02Player04gamePlayer03ListOfShips);

                    Ship11.setGamePlayer(Game02Player04gamePlayer03ListOfShips);
                    Ship12.setGamePlayer(Game02Player04gamePlayer03ListOfShips);
                    Ship13.setGamePlayer(Game02Player04gamePlayer03ListOfShips);
                    Ship14.setGamePlayer(Game02Player04gamePlayer03ListOfShips);
                    Ship15.setGamePlayer(Game02Player04gamePlayer03ListOfShips);
                    repositoryShips.save(Ship11);
                    repositoryShips.save(Ship12);
                    repositoryShips.save(Ship13);
                    repositoryShips.save(Ship14);
                    repositoryShips.save(Ship15);

                    // To create Game02Player04gamePlayer04ListOfShips
                    // Create and Locate the Ships
                    List<String> locationShip16 = new ArrayList<>();
                    locationShip16.add("A1");
                    locationShip16.add("B1");
                    locationShip16.add("C1");
                    locationShip16.add("D1");
                    locationShip16.add("E1");

                    List<String> locationShip17 = new ArrayList<>();
                    locationShip17.add("B7");
                    locationShip17.add("C7");
                    locationShip17.add("D7");

                    List<String> locationShip18 = new ArrayList<>();
                    locationShip18.add("G7");
                    locationShip18.add("H7");
                    locationShip18.add("I7");

                    List<String> locationShip19 = new ArrayList<>();
                    locationShip19.add("F4");
                    locationShip19.add("G4");
                    locationShip19.add("H4");
                    locationShip19.add("I4");

                    List<String> locationShip20 = new ArrayList<>();
                    locationShip20.add("E10");
                    locationShip20.add("F10");

                    Ship Ship16= new Ship("Container Ship",locationShip16);
                    Ship Ship17= new Ship("Bulk Carrier",locationShip17);
                    Ship Ship18= new Ship("Tanker Ship",locationShip18);
                    Ship Ship19= new Ship("Passenger Ship",locationShip19);
                    Ship Ship20= new Ship("Naval Ship",locationShip20);
                    repositoryShips.save(Ship16);
                    repositoryShips.save(Ship17);
                    repositoryShips.save(Ship18);
                    repositoryShips.save(Ship19);
                    repositoryShips.save(Ship20);

                    Date gamePlayer04Date = new Date();
                    GamePlayer Game02Player04gamePlayer04ListOfShips= new GamePlayer(Game02,Player04,gamePlayer04Date,gamePlayer03ListOfShips);
                    repositoryGamePlayer.save(Game02Player04gamePlayer04ListOfShips);

                    Ship16.setGamePlayer(Game02Player04gamePlayer04ListOfShips);
                    Ship17.setGamePlayer(Game02Player04gamePlayer04ListOfShips);
                    Ship18.setGamePlayer(Game02Player04gamePlayer04ListOfShips);
                    Ship19.setGamePlayer(Game02Player04gamePlayer04ListOfShips);
                    Ship10.setGamePlayer(Game02Player04gamePlayer04ListOfShips);

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





