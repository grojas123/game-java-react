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

            Date game_player_date01 = new Date();
            Date game_player_date02 = new Date();
            Date game_player_date03 = new Date();
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
                    // Create a Game01Player01game01_ships
                    // Create the list of Locations of the Ships
                    List<String> location_Ship01 = new ArrayList<>();
                    location_Ship01.add("B1");
                    location_Ship01.add("B2");

                    List<String> location_Ship02 = new ArrayList<>();
                    location_Ship02.add("B5");
                    location_Ship02.add("B6");
                    location_Ship02.add("B7");
                    location_Ship02.add("B8");

                    List<String> location_Ship03 = new ArrayList<>();
                    location_Ship03.add("F3");
                    location_Ship03.add("G3");
                    location_Ship03.add("H3");
                    location_Ship03.add("I3");
                    location_Ship03.add("J3");

                    List<String> location_Ship04 = new ArrayList<>();
                    location_Ship04.add("H7");
                    location_Ship04.add("I7");
                    location_Ship04.add("J7");

                    List<String> location_Ship05 = new ArrayList<>();
                    location_Ship05.add("E9");
                    location_Ship05.add("F9");
                    location_Ship05.add("G9");
                    // Create the Ships with the locations
                    Ship Ship01= new Ship("Container Ship",location_Ship01);
                    Ship Ship02= new Ship("Bulk Carrier",location_Ship02);
                    Ship Ship03= new Ship("Tanker Ship",location_Ship03);
                    Ship Ship04= new Ship("Passenger Ship",location_Ship04);
                    Ship Ship05= new Ship("Naval Ship",location_Ship05);

                    // Create the list of Ships for the game01
                    List<Ship> game01_list_of_ships = new ArrayList<>();
                    game01_list_of_ships.add(Ship01);
                    game01_list_of_ships.add(Ship02);
                    game01_list_of_ships.add(Ship03);
                    game01_list_of_ships.add(Ship04);
                    game01_list_of_ships.add(Ship05);
                    repositoryShips.save(Ship01);
                    repositoryShips.save(Ship02);
                    repositoryShips.save(Ship03);
                    repositoryShips.save(Ship04);
                    repositoryShips.save(Ship05);
                    // Create and save Game and Player pairs in GamePlayer repository

                    GamePlayer Game01Player01game01_list_of_ships = new GamePlayer(Game01,Player01,game_player_date01,game01_list_of_ships);

                    repositoryGamePlayer.save(Game01Player01game01_list_of_ships);

                    // Set the game player row with the ship
                    Ship01.setGamePlayer(Game01Player01game01_list_of_ships);
                    Ship02.setGamePlayer(Game01Player01game01_list_of_ships);
                    Ship03.setGamePlayer(Game01Player01game01_list_of_ships);
                    Ship04.setGamePlayer(Game01Player01game01_list_of_ships);
                    Ship05.setGamePlayer(Game01Player01game01_list_of_ships);
                    repositoryShips.save(Ship01);
                    repositoryShips.save(Ship02);
                    repositoryShips.save(Ship03);
                    repositoryShips.save(Ship04);
                    repositoryShips.save(Ship05);

                    // To Create the Game02Player02game02_ships

                    List<String> location_Ship06 = new ArrayList<>();
                    location_Ship06.add("A1");
                    location_Ship06.add("A2");
                    location_Ship06.add("A3");
                    location_Ship06.add("A4");

                    List<String> location_Ship07 = new ArrayList<>();
                    location_Ship07.add("E5");
                    location_Ship07.add("E6");
                    location_Ship07.add("E7");

                    List<String> location_Ship08 = new ArrayList<>();
                    location_Ship08.add("G1");
                    location_Ship08.add("H2");
                    location_Ship08.add("I1");

                    List<String> location_Ship09 = new ArrayList<>();
                    location_Ship09.add("D10");
                    location_Ship09.add("F10");
                    location_Ship09.add("G10");

                    List<String> location_Ship10 = new ArrayList<>();
                    location_Ship10.add("J5");
                    location_Ship10.add("J6");
                    location_Ship10.add("J7");
                    location_Ship10.add("J8");
                    location_Ship10.add("J9");

                    // Create the Ships with the locations
                    Ship Ship06= new Ship("Container Ship",location_Ship06);
                    Ship Ship07= new Ship("Bulk Carrier",location_Ship07);
                    Ship Ship08= new Ship("Tanker Ship",location_Ship08);
                    Ship Ship09= new Ship("Passenger Ship",location_Ship09);
                    Ship Ship10= new Ship("Naval Ship",location_Ship10);

                    repositoryShips.save(Ship06);
                    repositoryShips.save(Ship07);
                    repositoryShips.save(Ship08);
                    repositoryShips.save(Ship09);
                    repositoryShips.save(Ship10);

                    // Create the list of Ships for the game02
                    List<Ship> game02_list_of_ships = new ArrayList<>();
                    game02_list_of_ships.add(Ship06);
                    game02_list_of_ships.add(Ship07);
                    game02_list_of_ships.add(Ship08);
                    game02_list_of_ships.add(Ship09);
                    game02_list_of_ships.add(Ship10);
                    repositoryShips.save(Ship06);
                    repositoryShips.save(Ship07);
                    repositoryShips.save(Ship08);
                    repositoryShips.save(Ship09);
                    repositoryShips.save(Ship10);

                    GamePlayer Game02Player02game02_list_of_ships= new GamePlayer(Game02,Player02,game_player_date02,game02_list_of_ships);
                    repositoryGamePlayer.save(Game02Player02game02_list_of_ships);

                    // Set the game player row with the ship
                    Ship06.setGamePlayer(Game02Player02game02_list_of_ships);
                    Ship07.setGamePlayer(Game02Player02game02_list_of_ships);
                    Ship08.setGamePlayer(Game02Player02game02_list_of_ships);
                    Ship09.setGamePlayer(Game02Player02game02_list_of_ships);
                    Ship10.setGamePlayer(Game02Player02game02_list_of_ships);
                    repositoryShips.save(Ship06);
                    repositoryShips.save(Ship07);
                    repositoryShips.save(Ship08);
                    repositoryShips.save(Ship09);
                    repositoryShips.save(Ship10);
                    //GamePlayer Game01Player02Ship02 = new GamePlayer(Game01,Player02,game_player_date01,Ship02);

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





