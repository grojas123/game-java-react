package com.codeoftheweb.salvo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        initData(GameRepository repositoryGames,PlayerRepository repositoryPlayers,GamePlayerRepository repositoryGamePlayer) {

            Date game_creation_date01 = new Date();
            Date game_creation_date02= addHoursToJavaUtilDate(game_creation_date01,1);
            Date game_creation_date03= addHoursToJavaUtilDate(game_creation_date01,2);
            Date game_creation_date04= addHoursToJavaUtilDate(game_creation_date01,3);
            Date game_creation_date05= addHoursToJavaUtilDate(game_creation_date01,4);

            Date game_player_date01 = new Date();
                return (args) -> {
                    // Save Games
                    Game Game01 = new Game("Game 01", game_creation_date01);
                    Game Game02= new Game("Game 02", game_creation_date02);
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
                    // Create and save Game and Player pairs in GamePlayer repository
                    GamePlayer Game01Player01 = new GamePlayer(Game01,Player01,game_player_date01);
                    repositoryGamePlayer.save(Game01Player01);

                    GamePlayer Game01Player02 = new GamePlayer(Game01,Player02,game_player_date01);
                    repositoryGamePlayer.save(Game01Player02);

                    GamePlayer Game01Player03 = new GamePlayer(Game01,Player03,game_player_date01);
                    repositoryGamePlayer.save(Game01Player03);

                    GamePlayer Game02Player01 = new GamePlayer(Game02,Player01,game_player_date01);
                    repositoryGamePlayer.save(Game02Player01);

                    GamePlayer Game02Player02 = new GamePlayer(Game02,Player02,game_player_date01);
                    repositoryGamePlayer.save(Game02Player02);

                    GamePlayer Game02Player03 = new GamePlayer(Game02,Player03,game_player_date01);
                    repositoryGamePlayer.save(Game02Player03);

                    GamePlayer Game03Player01 = new GamePlayer(Game03,Player01,game_player_date01);
                    repositoryGamePlayer.save(Game03Player01);

                    GamePlayer Game03Player02 = new GamePlayer(Game03,Player02,game_player_date01);
                    repositoryGamePlayer.save(Game03Player02);

                    GamePlayer Game03Player03 = new GamePlayer(Game03,Player03,game_player_date01);
                    repositoryGamePlayer.save(Game03Player03);

                    GamePlayer Game03Player04 = new GamePlayer(Game03,Player04,game_player_date01);
                    repositoryGamePlayer.save(Game03Player04);
                    GamePlayer Game04Player01 = new GamePlayer(Game04,Player01,game_player_date01);
                    repositoryGamePlayer.save(Game04Player01);
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





