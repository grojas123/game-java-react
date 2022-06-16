package com.codeoftheweb.salvo.web;

import com.codeoftheweb.salvo.domain.Game;
import com.codeoftheweb.salvo.domain.GamePlayer;
import com.codeoftheweb.salvo.domain.Player;
import com.codeoftheweb.salvo.repositories.GamePlayerRepository;
import com.codeoftheweb.salvo.repositories.GameRepository;
import com.codeoftheweb.salvo.repositories.PlayerRepository;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.lang.instrument.Instrumentation;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalvoController {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
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

    @RequestMapping("/players")
    public List<Player> playerList(){
        return playerRepository.findAll();
    }
    @RequestMapping("/actualuser")
    public Object actualUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //System.out.println(auth.getDetails());
        return auth.getPrincipal();
    }

    @RequestMapping(value="/regplayer", method = RequestMethod.POST, consumes = "application/json")
    public Player RegisterUser(@RequestBody JSONObject postPayload){
        String firstName=(String) postPayload.get("firstName");
        String lastName= (String) postPayload.get("lastName");
        String email=(String) postPayload.get("email");
        String password=(String) postPayload.get("password");
        String role=(String) postPayload.get("role");
        String passwordEncoded =passwordEncoder.encode(password);
        Player newPlayer = new Player(firstName,lastName,email,passwordEncoded);
        newPlayer.setRole(role);
        playerRepository.save(newPlayer);
        return playerRepository.getById(newPlayer.getId());
    }
    @RequestMapping("/games_ids")
    public List<Long> getAllGamesIds() {
        List<Long> listTemp = new ArrayList<>();
            for (Game game : gamesRepository.findAll()) {
                listTemp.add(game.getId());
                }
    //log.info(String.valueOf(listTemp));
    return listTemp;
}
    @Autowired
    private PlayerRepository playerRepository;

    @RequestMapping("/checkuser/{username}")
    public boolean checkUser(@PathVariable String username){
        //System.out.println(playerRepository.findByEmail(username));
        //System.out.println(playerRepository.findByEmail(username)!=null);
        return playerRepository.findByEmail(username)!=null ;
    };

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
         return gamePlayerRepository.findByGame_Id(gameid);
    };
private JSONObject getNamesPlayerOnGamePlayer(List<GamePlayer> listGamePlayer) {
    //System.out.println(listGamePlayer);
    Player playerTemp=listGamePlayer.get(0).getPlayer();
    String email = playerTemp.getEmail();
    String firstName=playerTemp.getFirstName();
    String lastName=playerTemp.getLastName();
    JSONObject jsonPlayerData = new JSONObject();
    jsonPlayerData.put("email",email);
    jsonPlayerData.put("firstName",firstName);
    jsonPlayerData.put("lastName",lastName);
    JSONObject jsonPlayer = new JSONObject();
    jsonPlayer.put("player",jsonPlayerData);
    return jsonPlayer;
};
    @RequestMapping("/v2/gameview/{gameid}")
    public Object getGamePlayer01(@PathVariable Long gameid) {


        //To get the actual Player in the session
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPlayerEmail = authentication.getName();
        Player activePlayer=playerRepository.findByEmail(currentPlayerEmail);
        Long activePlayerid=activePlayer.getId();
        //To get the pair of GamePlayers of the gameid
        List<GamePlayer> gamePlayerListByGameId=gamePlayerRepository.findByGame_Id(gameid);
       // To get the GamePlayer of the actual Player
        Predicate<GamePlayer> byActivePlayerId = gamePlayer -> gamePlayer.getPlayer().getId().equals(activePlayerid);
        List<GamePlayer> gamePlayerActual= (List<GamePlayer>) gamePlayerListByGameId.stream().filter(byActivePlayerId).collect(Collectors.toList());
        Integer sizegamePlayerActual=gamePlayerActual.size();
        boolean isActivePlayerOnTheGame=!sizegamePlayerActual.equals(0);
        if (isActivePlayerOnTheGame) {
            // To get the GamePlayer of the opponent Player
            Predicate<GamePlayer> byOpponentPlayer = gamePlayer -> !gamePlayer.getPlayer().getId().equals(activePlayerid);
            List<GamePlayer> gamePlayerOpponentUser= (List<GamePlayer>) gamePlayerListByGameId.stream().filter(byOpponentPlayer).collect(Collectors.toList());
            JSONObject PlayerOpponentNames=getNamesPlayerOnGamePlayer(gamePlayerOpponentUser);
            //To create the board of the actual Player to return
            List<Object> boardActualPlayer = new ArrayList<Object>();
            boardActualPlayer.add(gamePlayerActual.get(0));
            boardActualPlayer.add(PlayerOpponentNames);

            return boardActualPlayer;
                                        }
        else{
            return new ArrayList<Object>();
        }
    };

}
