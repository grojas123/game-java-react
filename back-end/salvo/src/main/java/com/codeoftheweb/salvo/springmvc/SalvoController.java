package com.codeoftheweb.salvo.springmvc;
//import com.fasterxml.jackson.annotation.JsonRootName;
import com.codeoftheweb.salvo.domain.Game;
import com.codeoftheweb.salvo.domain.GamePlayer;
import com.codeoftheweb.salvo.repositories.GamePlayerRepository;
import com.codeoftheweb.salvo.repositories.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalvoController {
    private String extractGameId(String stringToSearch) {
        String regex = "(?<=game_id=)(.*\\n?)(?=,\\splayer=)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringToSearch);
        matcher.find();
        //System.out.println(matcher.group());
        return  matcher.group();
    };
    private static final Logger log = LoggerFactory.getLogger(SalvoController.class);
    @Autowired
    private GameRepository gamesRepository;
    private Object listTemp05;

    @RequestMapping("/games_ids")
    public List<Long> getAllGamesIds() {
        List<Long> listTemp = new ArrayList<>();
            for (Game game : gamesRepository.findAll()) {
                listTemp.add(game.getId());
                }
    //log.info(String.valueOf(listTemp));
    return listTemp;
}

    private Map<String, Object> makePlayersPerGameDTO(GamePlayer gamePlayer) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("game_id", gamePlayer.getGameId());
        dto.put("player", gamePlayer.getPlayer());
        dto.put("creation_date",gamePlayer.getGamePlayerCreationDate());
        dto.put("score",gamePlayer.getScore());

        return dto;
    }
    @RequestMapping("/games01")
   public List<Game> getAllGames(){
       return gamesRepository.findAll();
   }
    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @RequestMapping("/games")
    public Object getAllGamePlayersPerGame(){
        List listTemp= gamePlayerRepository.findAll()
                .stream()
                .map(gamePlayer_temp -> makePlayersPerGameDTO(gamePlayer_temp))
                .collect(Collectors.toList());
        Object listTemp03= listTemp.stream()
                .collect(Collectors
                        .groupingBy(listTemp_05-> extractGameId(listTemp_05.toString())));
        //log.info(String.valueOf(listTemp03));
        //List<GamePlayer> listTemp02= gamePlayerRepository.findAll();
        //System.out.println(listTemp02.size());
        return listTemp03;
    }
    //@Autowired
    //private ShipRepository shipRepository;
   // @RequestMapping("/ships")
    //public List<Ship> getAllShips(){
     //   return shipRepository.findAll();
    //};

   @RequestMapping("/gameview/{gameid}")
    public List<GamePlayer> getGamePlayer(@PathVariable Long gameid) {
       //System.out.println(gamePlayerRepository.findByGame_Id(gameid));
        return gamePlayerRepository.findByGame_Id(gameid);
    };

}
