package com.codeoftheweb.salvo.web;

import com.codeoftheweb.salvo.bootstrap.CreateBoard;
import com.codeoftheweb.salvo.domain.Game;
import com.codeoftheweb.salvo.domain.GamePlayer;
import com.codeoftheweb.salvo.domain.Player;
import com.codeoftheweb.salvo.repositories.*;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.lang.instrument.Instrumentation;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private ShipRepository repositoryShips;
    @Autowired
    private SalvoRepository repositorySalvoes;

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
    private GamePlayerRepository repositoryGamePlayer;


    @GetMapping("/games")
    public Object getAllGamePlayersPerGame(){
        List listTemp= repositoryGamePlayer.findAll()
                .stream()
                .map(gamePlayer_temp -> makePlayersPerGameDTO(gamePlayer_temp))
                .collect(Collectors.toList());
        Object listTemp03= listTemp.stream()
                .collect(Collectors
                        .groupingBy(listTemp_05-> extractGameId(listTemp_05.toString())));

        return listTemp03;
    }

    @PostMapping(value="/games",consumes = "application/json")
    public Object createGame(){
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPlayerEmail = authentication.getName();
        Player currentPlayer= playerRepository.findByEmail(currentPlayerEmail);
        String firstName=currentPlayer.getFirstName();
        String lastName=currentPlayer.getLastName();
        String nameOfGame="Game of"+" "+firstName+" "+ lastName;
        Date dateCreationGame=new Date();
        Game newGame= new Game(nameOfGame,dateCreationGame);
        gamesRepository.save(newGame);
        List<List<String>> listLocationsShipsCurrentPlayer = new ArrayList<>();
        List<String> locationShip00 = new ArrayList<>();
        locationShip00.add("000001");
        List<String> locationShip01 = new ArrayList<>();
        locationShip01.add("030201");
        locationShip01.add("030301");
        List<String> locationShip02 = new ArrayList<>();
        locationShip02.add("070001");
        locationShip02.add("080001");
        locationShip02.add("090001");
        List<String> locationShip03 = new ArrayList<>();
        locationShip03.add("050501");
        locationShip03.add("050601");
        locationShip03.add("050701");
        locationShip03.add("050801");
        List<String> locationShip04 = new ArrayList<>();
        locationShip04.add("070401");
        locationShip04.add("070501");
        locationShip04.add("070601");
        locationShip04.add("070701");
        locationShip04.add("070801");
        listLocationsShipsCurrentPlayer.add(locationShip00);
        listLocationsShipsCurrentPlayer.add(locationShip01);
        listLocationsShipsCurrentPlayer.add(locationShip02);
        listLocationsShipsCurrentPlayer.add(locationShip03);
        listLocationsShipsCurrentPlayer.add(locationShip04);
        List<List<String>> listLocationsSalvoesCurrentPlayer = new ArrayList<>();
        CreateBoard boardPlayerGame = new CreateBoard(currentPlayer,newGame,dateCreationGame,listLocationsShipsCurrentPlayer,listLocationsSalvoesCurrentPlayer,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        //List<GamePlayer> BoardList =newGame.getGamePlayers();
        return boardPlayerGame.getBoard();
    };
    public List<List<String>> ConvertFromBackEndShipsCoordinates(JSONObject FrontEndData){
        List<List<String>> listCoordinatesBackEnd = new ArrayList<>();


        List<List<String>> listTemp = new ArrayList<>();
        return listTemp;
    }
@PostMapping(value="/games/players/{gameplayerid}/ships" ,consumes = "application/json")
public Object SaveShips(@PathVariable Long gameplayerid ,@RequestBody JSONObject postPayload){
    System.out.println(gameplayerid);
    System.out.println(postPayload);
    ConvertFromBackEndShipsCoordinates(postPayload);
    return '1';
}
    @PostMapping(value="/games/join/{gameid}")
    public Object joinGame(@PathVariable Long gameid){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPlayerEmail = authentication.getName();
        Player currentPlayer= playerRepository.findByEmail(currentPlayerEmail);
        Game gameToJoin = gamesRepository.findById(gameid).orElse(null);
        Long countGamePlayers =repositoryGamePlayer.findByGame_Id(gameid).stream().count();
        if (countGamePlayers==1) {
            Date dateCreationGame=new Date();
            List<List<String>> listLocationsShipsCurrentPlayer = new ArrayList<>();
            List<String> locationShip00 = new ArrayList<>();
            locationShip00.add("000001");
            List<String> locationShip01 = new ArrayList<>();
            locationShip01.add("030201");
            locationShip01.add("030301");
            List<String> locationShip02 = new ArrayList<>();
            locationShip02.add("070001");
            locationShip02.add("080001");
            locationShip02.add("090001");
            List<String> locationShip03 = new ArrayList<>();
            locationShip03.add("050501");
            locationShip03.add("050601");
            locationShip03.add("050701");
            locationShip03.add("050801");
            List<String> locationShip04 = new ArrayList<>();
            locationShip04.add("070401");
            locationShip04.add("070501");
            locationShip04.add("070601");
            locationShip04.add("070701");
            locationShip04.add("070801");
            listLocationsShipsCurrentPlayer.add(locationShip00);
            listLocationsShipsCurrentPlayer.add(locationShip01);
            listLocationsShipsCurrentPlayer.add(locationShip02);
            listLocationsShipsCurrentPlayer.add(locationShip03);
            listLocationsShipsCurrentPlayer.add(locationShip04);
            List<List<String>> listLocationsSalvoesCurrentPlayer = new ArrayList<>();
            CreateBoard boardPlayerGame = new CreateBoard(currentPlayer,gameToJoin,dateCreationGame,listLocationsShipsCurrentPlayer,listLocationsSalvoesCurrentPlayer,repositoryShips,repositorySalvoes,repositoryGamePlayer);
            return boardPlayerGame.getBoard();}
        else return new ResponseEntity<>("The game have a pair", HttpStatus.FORBIDDEN);
    };

    @RequestMapping("/gameview/{gameid}")
    public List<GamePlayer> getGamePlayer(@PathVariable Long gameid) {
         return repositoryGamePlayer.findByGame_Id(gameid);
    };
private JSONObject getNamesPlayerOnGamePlayer(List<GamePlayer> listGamePlayer) {
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
private JSONObject getEmptyPlayer(){
    String email ="";
    String firstName="";
    String lastName="";
    JSONObject jsonPlayerData = new JSONObject();
    jsonPlayerData.put("email",email);
    jsonPlayerData.put("firstName",firstName);
    jsonPlayerData.put("lastName",lastName);
    JSONObject jsonPlayer = new JSONObject();
    jsonPlayer.put("player",jsonPlayerData);
    return jsonPlayer;
}
    @RequestMapping("/v2/gameview/{gameid}")
    public Object getGamePlayerV2(@PathVariable Long gameid) {

        //To get the actual Player in the session
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPlayerEmail = authentication.getName();
        Player activePlayer=playerRepository.findByEmail(currentPlayerEmail);
        Long activePlayerid=activePlayer.getId();
        //To get the pair of GamePlayers of the gameid
        List<GamePlayer> gamePlayerListByGameId=repositoryGamePlayer.findByGame_Id(gameid);
       // To get the GamePlayer of the actual Player
        Predicate<GamePlayer> byActivePlayerId = gamePlayer -> gamePlayer.getPlayer().getId().equals(activePlayerid);
        List<GamePlayer> gamePlayerActual= (List<GamePlayer>) gamePlayerListByGameId.stream().filter(byActivePlayerId).collect(Collectors.toList());
        Integer sizegamePlayerActual=gamePlayerActual.size();
        boolean isActivePlayerOnTheGame=!sizegamePlayerActual.equals(0);
        if (isActivePlayerOnTheGame) {
            // To get the GamePlayer of the opponent Player
            Predicate<GamePlayer> byOpponentPlayer = gamePlayer -> !gamePlayer.getPlayer().getId().equals(activePlayerid);
            List<GamePlayer> gamePlayerOpponentUser= (List<GamePlayer>) gamePlayerListByGameId.stream().filter(byOpponentPlayer).collect(Collectors.toList());
            List<Object> boardActualPlayer = new ArrayList<Object>();
            if (gamePlayerOpponentUser.size()!=0) {
                JSONObject PlayerOpponentNames=getNamesPlayerOnGamePlayer(gamePlayerOpponentUser);
                //To create the board of the actual Player to return
                boardActualPlayer.add(gamePlayerActual.get(0));
                boardActualPlayer.add(PlayerOpponentNames);}
            else {// If Opponent Player is not present the data of the Opponent will be empty
                boardActualPlayer.add(gamePlayerActual.get(0));
                boardActualPlayer.add(getEmptyPlayer());}


            return boardActualPlayer;}

        else{// If the actual Player no belong to the game the array data will be empty
            return new ArrayList<Object>();
        }
    };

}
