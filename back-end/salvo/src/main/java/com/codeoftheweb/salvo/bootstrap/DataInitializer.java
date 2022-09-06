package com.codeoftheweb.salvo.bootstrap;

import com.codeoftheweb.salvo.domain.*;
import com.codeoftheweb.salvo.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class DataInitializer implements CommandLineRunner {
    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }
    String password = "password";
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(password);
    private final GameRepository repositoryGames;
    private final PlayerRepository repositoryPlayers;
    private final GamePlayerRepository repositoryGamePlayer;
    private final ShipRepository repositoryShips;
    private final SalvoRepository repositorySalvoes;

    private final ScoreRepository repositoryScores;
    public DataInitializer(GameRepository repositoryGames,PlayerRepository repositoryPlayers,GamePlayerRepository repositoryGamePlayer,ShipRepository repositoryShips,SalvoRepository repositorySalvoes,ScoreRepository repositoryScores) {
       this.repositoryGames=repositoryGames;
       this.repositoryPlayers=repositoryPlayers;
       this.repositoryGamePlayer=repositoryGamePlayer;
       this.repositoryShips=repositoryShips;
       this.repositorySalvoes=repositorySalvoes;
       this.repositoryScores=repositoryScores;
    }
    private List<List<String>> createSalvoesList(){
        List<List<String>> SalvoesList = new ArrayList<>();
        String statusSalvoes="01";
        for(Integer x=0;x<=9;x++){
            for(Integer y=0;y<=9;y++){
                String xStringValue="0"+x;
                String yStringValue="0"+y;
                String locationStatusSalvoes=xStringValue+yStringValue+statusSalvoes;
                List<String> locationSalvo = new ArrayList<>();
                locationSalvo.add(locationStatusSalvoes);
                SalvoesList.add(locationSalvo);
            }
        }
        return SalvoesList;
    }
    private Salvo updateSalvo(List<Salvo> Salvoes,String locationToUpdate,String status){
        Predicate<Salvo> byLocation=salvo -> salvo.getLocations().get(0).substring(0,4).equals(locationToUpdate);
        List<Salvo> listSalvoToUpdate=Salvoes.stream().filter(byLocation).collect(Collectors.toList());
        List<String> locationToUpdateSalvo = new ArrayList<>();
        String locationNewStatusSalvoes=listSalvoToUpdate.get(0).getLocations().get(0).substring(0,4)+status;
        locationToUpdateSalvo.add(locationNewStatusSalvoes);
        listSalvoToUpdate.get(0).setLocations(locationToUpdateSalvo);
        return repositorySalvoes.save(listSalvoToUpdate.get(0));
    };

    @Override
    public void run(String... args) throws Exception {
    // TO create the user for H2 aka the user in console
        Player sa = new Player("sa", "h2","sa@example.com",encodedPassword);
        sa.setRole("ADMIN");
        repositoryPlayers.save(sa);

    //Data to creation of Games
    //_______________________________________________________________________________________________________
    // Creation of Game01
    //_______________________________________________________________________________________________________
        String statusSalvoFired="02";
        //String statusSalvoNoHit="03";

        Date game_creation_date01 = new Date();
        Game Game01 = new Game("Game 01", game_creation_date01);
        repositoryGames.save(Game01);

        Player Player01 = new Player("Player", "01","player01@example.com",encodedPassword);
        Player01.setRole("ADMIN");
        Player Player02 = new Player("Player", "02","player02@example.com",encodedPassword);
        Player02.setRole("ADMIN");
        repositoryPlayers.save(Player01);
        repositoryPlayers.save(Player02);
        // To Create the Board of Player01 in Game01

        List<String> locationShip01Destroyer = new ArrayList<>();
        locationShip01Destroyer.add("010201");
        List<String> locationShip02Battleship = new ArrayList<>();
        locationShip02Battleship.add("040101");
        locationShip02Battleship.add("050101");
        locationShip02Battleship.add("060101");
        locationShip02Battleship.add("070101");
        List<String> locationShip03AircraftCarrier = new ArrayList<>();
        locationShip03AircraftCarrier.add("020501");
        locationShip03AircraftCarrier.add("020601");
        locationShip03AircraftCarrier.add("020701");
        locationShip03AircraftCarrier.add("020801");
        locationShip03AircraftCarrier.add("020901");
        List<String> locationShip04Submarine = new ArrayList<>();
        locationShip04Submarine.add("060701");
        locationShip04Submarine.add("060801");
        locationShip04Submarine.add("060901");
        List<String> locationShip05Cruiser = new ArrayList<>();
        locationShip05Cruiser.add("080401");
        locationShip05Cruiser.add("080501");
        List<List<String>> listLocationsShipsPlayer01Game01 = new ArrayList<>();
        listLocationsShipsPlayer01Game01.add(locationShip01Destroyer);
        listLocationsShipsPlayer01Game01.add(locationShip02Battleship);
        listLocationsShipsPlayer01Game01.add(locationShip03AircraftCarrier);
        listLocationsShipsPlayer01Game01.add(locationShip04Submarine);
        listLocationsShipsPlayer01Game01.add(locationShip05Cruiser);

        List<List<String>> listLocationsSalvoesPlayer01Game01 = createSalvoesList();
        //System.out.println(createSalvoesList());
        Date gamePlayer01Date = new Date();
        CreateBoard boardPlayer01Game01 = new CreateBoard(Player01,Game01,gamePlayer01Date,listLocationsShipsPlayer01Game01,listLocationsSalvoesPlayer01Game01,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer01Game01=boardPlayer01Game01.getBoard();
        List<Salvo> salvoesPlayer01Game01=gamePlayerPlayer01Game01.getSalvoes();
        updateSalvo(salvoesPlayer01Game01,"0000",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0100",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0200",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0300",statusSalvoFired);

        updateSalvo(salvoesPlayer01Game01,"0006",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0007",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0008",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0009",statusSalvoFired);

        updateSalvo(salvoesPlayer01Game01,"0207",statusSalvoFired);

        updateSalvo(salvoesPlayer01Game01,"0303",statusSalvoFired);

        updateSalvo(salvoesPlayer01Game01,"0405",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0505",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0605",statusSalvoFired);

        updateSalvo(salvoesPlayer01Game01,"0601",statusSalvoFired);

        updateSalvo(salvoesPlayer01Game01,"0606",statusSalvoFired);

        updateSalvo(salvoesPlayer01Game01,"0409",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0509",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0609",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0709",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0809",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0909",statusSalvoFired);

        updateSalvo(salvoesPlayer01Game01,"0902",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0903",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0904",statusSalvoFired);
        updateSalvo(salvoesPlayer01Game01,"0905",statusSalvoFired);

        // To Create the Board of Player02 in Game01

        List<String> locationShip06Battleship = new ArrayList<>();
        locationShip06Battleship.add("010101");
        List<String> locationShip07Submarine = new ArrayList<>();
        locationShip07Submarine.add("000601");
        locationShip07Submarine.add("000701");
        locationShip07Submarine.add("000801");
        locationShip07Submarine.add("000901");
        List<String> locationShip08Cruiser = new ArrayList<>();
        locationShip08Cruiser.add("040501");
        locationShip08Cruiser.add("050501");
        List<String> locationShip09Submarine = new ArrayList<>();
        locationShip09Submarine.add("090301");
        locationShip09Submarine.add("090401");
        locationShip09Submarine.add("090501");
        List<String> locationShip10AircraftCarrier = new ArrayList<>();
        locationShip10AircraftCarrier.add("040901");
        locationShip10AircraftCarrier.add("050901");
        locationShip10AircraftCarrier.add("060901");
        locationShip10AircraftCarrier.add("070901");
        locationShip10AircraftCarrier.add("080901");
        List<List<String>> listLocationsShipsPlayer02Game01 = new ArrayList<>();
        listLocationsShipsPlayer02Game01.add(locationShip06Battleship);
        listLocationsShipsPlayer02Game01.add(locationShip07Submarine);
        listLocationsShipsPlayer02Game01.add(locationShip08Cruiser);
        listLocationsShipsPlayer02Game01.add(locationShip09Submarine);
        listLocationsShipsPlayer02Game01.add(locationShip10AircraftCarrier);

        List<List<String>> listLocationsSalvoesPlayer02Game01 = createSalvoesList();

        Date gamePlayer02Date = new Date();
        CreateBoard boardPlayer02Game01 = new CreateBoard(Player02,Game01,gamePlayer02Date,listLocationsShipsPlayer02Game01,listLocationsSalvoesPlayer02Game01,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer02Game01=boardPlayer02Game01.getBoard();
        List<Salvo> salvoesPlayer02Game01=gamePlayerPlayer02Game01.getSalvoes();

        updateSalvo(salvoesPlayer02Game01,"0006",statusSalvoFired);

        updateSalvo(salvoesPlayer02Game01,"0201",statusSalvoFired);

        updateSalvo(salvoesPlayer02Game01,"0205",statusSalvoFired);
        updateSalvo(salvoesPlayer02Game01,"0206",statusSalvoFired);
        updateSalvo(salvoesPlayer02Game01,"0207",statusSalvoFired);
        updateSalvo(salvoesPlayer02Game01,"0208",statusSalvoFired);
        updateSalvo(salvoesPlayer02Game01,"0209",statusSalvoFired);

        updateSalvo(salvoesPlayer02Game01,"0401",statusSalvoFired);

        updateSalvo(salvoesPlayer02Game01,"0404",statusSalvoFired);
        updateSalvo(salvoesPlayer02Game01,"0504",statusSalvoFired);

        updateSalvo(salvoesPlayer02Game01,"0409",statusSalvoFired);
        updateSalvo(salvoesPlayer02Game01,"0509",statusSalvoFired);

        updateSalvo(salvoesPlayer02Game01,"0601",statusSalvoFired);
        updateSalvo(salvoesPlayer02Game01,"0701",statusSalvoFired);

        updateSalvo(salvoesPlayer02Game01,"0608",statusSalvoFired);

        updateSalvo(salvoesPlayer02Game01,"0707",statusSalvoFired);

        updateSalvo(salvoesPlayer02Game01,"0805",statusSalvoFired);

        updateSalvo(salvoesPlayer02Game01,"0903",statusSalvoFired);

        updateSalvo(salvoesPlayer02Game01,"0907",statusSalvoFired);
        // Update the data between the two Boards created
        UpdateShipsSalvos updateGame01SalvosAgainstShipsPlayer01Player02TwoWays= new UpdateShipsSalvos(gamePlayerPlayer01Game01,gamePlayerPlayer02Game01,repositoryShips,repositorySalvoes);
        updateGame01SalvosAgainstShipsPlayer01Player02TwoWays.UpdateSalvosAdversary();
        //_______________________________________________________________________________________________________
        // End of Game01
        //_______________________________________________________________________________________________________

        //_______________________________________________________________________________________________________
        // Creation Game02
        //_______________________________________________________________________________________________________
        Date game_creation_date02= addHoursToJavaUtilDate(game_creation_date01,1);
        Game Game02 = new Game("Game 02", game_creation_date02);
        repositoryGames.save(Game02);

        Player Player03 = new Player("Player", "03","player03@example.com",encodedPassword);
        Player03.setRole("ADMIN");
        Player Player04 = new Player("Player", "04","player04@example.com",encodedPassword);
        Player04.setRole("ADMIN");
        repositoryPlayers.save(Player03);
        repositoryPlayers.save(Player04);
        // To Create the Board of Player03 in Game02

        List<String> locationShip11Submarine = new ArrayList<>();
        locationShip11Submarine.add("020101");
        List<String> locationShip12AircraftCarrier = new ArrayList<>();
        locationShip12AircraftCarrier.add("040401");
        locationShip12AircraftCarrier.add("050401");
        locationShip12AircraftCarrier.add("060401");
        locationShip12AircraftCarrier.add("070401");
        locationShip12AircraftCarrier.add("080401");
        List<String> locationShip13BattleShip = new ArrayList<>();
        locationShip13BattleShip.add("020601");
        locationShip13BattleShip.add("030601");
        locationShip13BattleShip.add("040601");
        locationShip13BattleShip.add("050601");
        List<String> locationShip14Carrier = new ArrayList<>();
        locationShip14Carrier.add("000901");
        locationShip14Carrier.add("010901");
        List<String> locationShip15Destroyer = new ArrayList<>();
        locationShip15Destroyer.add("070801");
        locationShip15Destroyer.add("080801");
        locationShip15Destroyer.add("090801");

        List<List<String>> listLocationsShipsPlayer03Game02 = new ArrayList<>();
        listLocationsShipsPlayer03Game02.add(locationShip11Submarine);
        listLocationsShipsPlayer03Game02.add(locationShip12AircraftCarrier);
        listLocationsShipsPlayer03Game02.add(locationShip13BattleShip);
        listLocationsShipsPlayer03Game02.add(locationShip14Carrier);
        listLocationsShipsPlayer03Game02.add(locationShip15Destroyer);

        List<List<String>> listLocationsSalvoesPlayer03Game02 = createSalvoesList();

        Date gamePlayer03Date = new Date();
        CreateBoard boardPlayer03Game02 = new CreateBoard(Player03,Game02,gamePlayer03Date,listLocationsShipsPlayer03Game02,listLocationsSalvoesPlayer03Game02,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer03Game02=boardPlayer03Game02.getBoard();
        List<Salvo> salvoesPlayer03Game02=gamePlayerPlayer03Game02.getSalvoes();
        updateSalvo(salvoesPlayer03Game02,"0000",statusSalvoFired);

        updateSalvo(salvoesPlayer03Game02,"0006",statusSalvoFired);

        updateSalvo(salvoesPlayer03Game02,"0108",statusSalvoFired);

        updateSalvo(salvoesPlayer03Game02,"0203",statusSalvoFired);

        updateSalvo(salvoesPlayer03Game02,"0309",statusSalvoFired);

        updateSalvo(salvoesPlayer03Game02,"0402",statusSalvoFired);
        updateSalvo(salvoesPlayer03Game02,"0403",statusSalvoFired);

        updateSalvo(salvoesPlayer03Game02,"0405",statusSalvoFired);

        updateSalvo(salvoesPlayer03Game02,"0601",statusSalvoFired);
        updateSalvo(salvoesPlayer03Game02,"0602",statusSalvoFired);
        updateSalvo(salvoesPlayer03Game02,"0603",statusSalvoFired);

        updateSalvo(salvoesPlayer03Game02,"0607",statusSalvoFired);

        updateSalvo(salvoesPlayer03Game02,"0705",statusSalvoFired);

        updateSalvo(salvoesPlayer03Game02,"0900",statusSalvoFired);

        updateSalvo(salvoesPlayer03Game02,"0906",statusSalvoFired);

        updateSalvo(salvoesPlayer03Game02,"0909",statusSalvoFired);
        // To Create the Board of Player04 in Game02

        List<String> locationShip16AircraftCarrier = new ArrayList<>();
        locationShip16AircraftCarrier.add("000001");
        locationShip16AircraftCarrier.add("000101");
        locationShip16AircraftCarrier.add("000201");
        locationShip16AircraftCarrier.add("000301");
        locationShip16AircraftCarrier.add("000401");
        List<String> locationShip17Submarine = new ArrayList<>();
        locationShip17Submarine.add("090401");
        List<String> locationShip18Cruiser = new ArrayList<>();
        locationShip18Cruiser.add("060601");
        locationShip18Cruiser.add("060701");
        locationShip18Cruiser.add("060801");
        List<String> locationShip19Battleship = new ArrayList<>();
        locationShip19Battleship.add("030501");
        locationShip19Battleship.add("030601");
        locationShip19Battleship.add("030701");
        locationShip19Battleship.add("030801");
        List<String> locationShip20Destroyer = new ArrayList<>();
        locationShip20Destroyer.add("060101");
        locationShip20Destroyer.add("060201");

        List<List<String>> listLocationsShipsPlayer04Game02 = new ArrayList<>();
        listLocationsShipsPlayer04Game02.add(locationShip16AircraftCarrier);
        listLocationsShipsPlayer04Game02.add(locationShip17Submarine);
        listLocationsShipsPlayer04Game02.add(locationShip18Cruiser);
        listLocationsShipsPlayer04Game02.add(locationShip19Battleship);
        listLocationsShipsPlayer04Game02.add(locationShip20Destroyer);


       // Create the Salvoes


        List<List<String>> listLocationsSalvoesPlayer04Game02 = createSalvoesList();

        Date gamePlayer04Date = new Date();

        CreateBoard boardPlayer04Game02 = new CreateBoard(Player04,Game02,gamePlayer04Date,listLocationsShipsPlayer04Game02,listLocationsSalvoesPlayer04Game02,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer04Game02=boardPlayer04Game02.getBoard();
        List<Salvo> salvoesPlayer04Game02=gamePlayerPlayer04Game02.getSalvoes();

        updateSalvo(salvoesPlayer04Game02,"0000",statusSalvoFired);

        updateSalvo(salvoesPlayer04Game02,"0009",statusSalvoFired);
        updateSalvo(salvoesPlayer04Game02,"0109",statusSalvoFired);
        updateSalvo(salvoesPlayer04Game02,"0209",statusSalvoFired);

        updateSalvo(salvoesPlayer04Game02,"0201",statusSalvoFired);
        updateSalvo(salvoesPlayer04Game02,"0301",statusSalvoFired);
        updateSalvo(salvoesPlayer04Game02,"0401",statusSalvoFired);

        updateSalvo(salvoesPlayer04Game02,"0206",statusSalvoFired);
        updateSalvo(salvoesPlayer04Game02,"0306",statusSalvoFired);
        updateSalvo(salvoesPlayer04Game02,"0406",statusSalvoFired);
        updateSalvo(salvoesPlayer04Game02,"0506",statusSalvoFired);

        updateSalvo(salvoesPlayer04Game02,"0505",statusSalvoFired);

        updateSalvo(salvoesPlayer04Game02,"0404",statusSalvoFired);
        updateSalvo(salvoesPlayer04Game02,"0504",statusSalvoFired);
        updateSalvo(salvoesPlayer04Game02,"0604",statusSalvoFired);
        updateSalvo(salvoesPlayer04Game02,"0704",statusSalvoFired);
        updateSalvo(salvoesPlayer04Game02,"0804",statusSalvoFired);

        updateSalvo(salvoesPlayer04Game02,"0708",statusSalvoFired);
        updateSalvo(salvoesPlayer04Game02,"0808",statusSalvoFired);
        updateSalvo(salvoesPlayer04Game02,"0908",statusSalvoFired);

        updateSalvo(salvoesPlayer04Game02,"0909",statusSalvoFired);

        //------------Update the two Boards
        UpdateShipsSalvos updateGame02SalvosAgainstShipsPlayer03Player04TwoWays= new UpdateShipsSalvos(gamePlayerPlayer03Game02,gamePlayerPlayer04Game02,repositoryShips,repositorySalvoes);
        updateGame02SalvosAgainstShipsPlayer03Player04TwoWays.UpdateSalvosAdversary();

        //_______________________________________________________________________________________________________
        // End of Game02
        //_______________________________________________________________________________________________________


        //_______________________________________________________________________________________________________
        // Creation of Game03
        //_______________________________________________________________________________________________________
        Date game_creation_date03= addHoursToJavaUtilDate(game_creation_date01,2);
        Game Game03 = new Game("Game 03", game_creation_date03);
        repositoryGames.save(Game03);

        Player Player05 = new Player("Player", "05","player05@example.com",encodedPassword);
        Player Player06 = new Player("Player", "06","player06@example.com",encodedPassword);
        Player05.setRole("ADMIN");
        Player06.setRole("ADMIN");
        repositoryPlayers.save(Player05);
        repositoryPlayers.save(Player06);

        // To Create the Board of Player05 in Game03

        List<String> locationShip21Submarine = new ArrayList<>();
        locationShip21Submarine.add("030201");
        List<String> locationShip22AircraftCarrier = new ArrayList<>();
        locationShip22AircraftCarrier.add("040701");
        locationShip22AircraftCarrier.add("050701");
        locationShip22AircraftCarrier.add("060701");
        locationShip22AircraftCarrier.add("070701");
        locationShip22AircraftCarrier.add("080701");
        List<String> locationShip23Destroyer = new ArrayList<>();
        locationShip23Destroyer.add("060401");
        locationShip23Destroyer.add("070401");
        List<String> locationShip24Cruiser = new ArrayList<>();
        locationShip24Cruiser.add("020701");
        locationShip24Cruiser.add("020801");
        locationShip24Cruiser.add("020901");
        List<String> locationShip25BattleShip = new ArrayList<>();
        locationShip25BattleShip.add("090101");
        locationShip25BattleShip.add("090201");
        locationShip25BattleShip.add("090301");
        locationShip25BattleShip.add("090401");

        List<List<String>> listLocationsShipsPlayer05Game03 = new ArrayList<>();
        listLocationsShipsPlayer05Game03.add(locationShip21Submarine);
        listLocationsShipsPlayer05Game03.add(locationShip22AircraftCarrier);
        listLocationsShipsPlayer05Game03.add(locationShip23Destroyer);
        listLocationsShipsPlayer05Game03.add(locationShip24Cruiser);
        listLocationsShipsPlayer05Game03.add(locationShip25BattleShip);

        // Creation of Salvoes for Player05

        List<List<String>> listLocationsSalvoesPlayer05Game03 = createSalvoesList();

        Date gamePlayer05Date = new Date();

        CreateBoard boardPlayer05Game03 = new CreateBoard(Player05,Game03,gamePlayer05Date,listLocationsShipsPlayer05Game03,listLocationsSalvoesPlayer05Game03,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer05Game03=boardPlayer05Game03.getBoard();
        List<Salvo> salvoesPlayer05Game03=gamePlayerPlayer05Game03.getSalvoes();
        updateSalvo(salvoesPlayer05Game03,"0000",statusSalvoFired);

        updateSalvo(salvoesPlayer05Game03,"0105",statusSalvoFired);
        updateSalvo(salvoesPlayer05Game03,"0106",statusSalvoFired);
        updateSalvo(salvoesPlayer05Game03,"0107",statusSalvoFired);

        updateSalvo(salvoesPlayer05Game03,"0200",statusSalvoFired);
        updateSalvo(salvoesPlayer05Game03,"0300",statusSalvoFired);
        updateSalvo(salvoesPlayer05Game03,"0400",statusSalvoFired);
        updateSalvo(salvoesPlayer05Game03,"0500",statusSalvoFired);
        updateSalvo(salvoesPlayer05Game03,"0600",statusSalvoFired);

        updateSalvo(salvoesPlayer05Game03,"0203",statusSalvoFired);
        updateSalvo(salvoesPlayer05Game03,"0303",statusSalvoFired);
        updateSalvo(salvoesPlayer05Game03,"0403",statusSalvoFired);
        updateSalvo(salvoesPlayer05Game03,"0503",statusSalvoFired);

        updateSalvo(salvoesPlayer05Game03,"0607",statusSalvoFired);
        updateSalvo(salvoesPlayer05Game03,"0608",statusSalvoFired);
        updateSalvo(salvoesPlayer05Game03,"0609",statusSalvoFired);

        updateSalvo(salvoesPlayer05Game03,"0705",statusSalvoFired);
        updateSalvo(salvoesPlayer05Game03,"0805",statusSalvoFired);

        // To Create the Board of Player06 in Game03

        List<String> locationShip26Cruiser = new ArrayList<>();
        locationShip26Cruiser.add("010601");
        List<String> locationShip27BattleShip = new ArrayList<>();
        locationShip27BattleShip.add("020301");
        locationShip27BattleShip.add("030301");
        locationShip27BattleShip.add("040301");
        locationShip27BattleShip.add("050301");
        List<String> locationShip28AircraftCarrier = new ArrayList<>();
        locationShip28AircraftCarrier.add("020001");
        locationShip28AircraftCarrier.add("030001");
        locationShip28AircraftCarrier.add("040001");
        locationShip28AircraftCarrier.add("050001");
        locationShip28AircraftCarrier.add("060001");
        List<String> locationShip29Submarine = new ArrayList<>();
        locationShip29Submarine.add("060701");
        locationShip29Submarine.add("060801");
        locationShip29Submarine.add("060901");
        List<String> locationShip30Destroyer = new ArrayList<>();
        locationShip30Destroyer.add("070501");
        locationShip30Destroyer.add("080501");

        List<List<String>> listLocationsShipsPlayer06Game03 = new ArrayList<>();
        listLocationsShipsPlayer06Game03.add(locationShip26Cruiser);
        listLocationsShipsPlayer06Game03.add(locationShip27BattleShip);
        listLocationsShipsPlayer06Game03.add(locationShip28AircraftCarrier);
        listLocationsShipsPlayer06Game03.add(locationShip29Submarine);
        listLocationsShipsPlayer06Game03.add(locationShip30Destroyer);


        // The creation of Player06 Salvoes


        List<List<String>> listLocationsSalvoesPlayer06Game03 = createSalvoesList();

        Date gamePlayer06Date = new Date();
        CreateBoard boardPlayer06Game03 = new CreateBoard(Player06,Game03,gamePlayer06Date,listLocationsShipsPlayer06Game03,listLocationsSalvoesPlayer06Game03,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer06Game03=boardPlayer06Game03.getBoard();
        List<Salvo> salvoesPlayer06Game03=gamePlayerPlayer06Game03.getSalvoes();

        updateSalvo(salvoesPlayer06Game03,"0201",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0301",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0401",statusSalvoFired);

        updateSalvo(salvoesPlayer06Game03,"0206",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0306",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0406",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0506",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0606",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0706",statusSalvoFired);

        updateSalvo(salvoesPlayer06Game03,"0107",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0108",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0109",statusSalvoFired);

        updateSalvo(salvoesPlayer06Game03,"0206",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0207",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0208",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0209",statusSalvoFired);

        updateSalvo(salvoesPlayer06Game03,"0504",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0604",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0704",statusSalvoFired);

        updateSalvo(salvoesPlayer06Game03,"0901",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0902",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0903",statusSalvoFired);
        updateSalvo(salvoesPlayer06Game03,"0904",statusSalvoFired);

        //Update the Board Player05 vs Board Player06 in Game03
        UpdateShipsSalvos updateGame03SalvosAgainstShipsPlayer05Player06TwoWays= new UpdateShipsSalvos(gamePlayerPlayer05Game03,gamePlayerPlayer06Game03,repositoryShips,repositorySalvoes);
        updateGame03SalvosAgainstShipsPlayer05Player06TwoWays.UpdateSalvosAdversary();

        //_______________________________________________________________________________________________________
        // End of Game03
        //_______________________________________________________________________________________________________

        //_______________________________________________________________________________________________________
        // Creation of Game04
        //_______________________________________________________________________________________________________
        Date game_creation_date04= addHoursToJavaUtilDate(game_creation_date01,4);
        Game Game04 = new Game("Game 04", game_creation_date04);
        repositoryGames.save(Game04);
        // To Create the Board of Player07 in Game04


        List<String> locationShip31 = new ArrayList<>();
        locationShip31.add("000001");
        //locationShip31.add("010201");
        //locationShip31.add("010301");
        List<String> locationShip32 = new ArrayList<>();
        locationShip32.add("020301");
        locationShip32.add("030301");
        locationShip32.add("040301");
        List<String> locationShip33 = new ArrayList<>();
        locationShip33.add("030601");
        locationShip33.add("040601");
        locationShip33.add("050601");
        locationShip33.add("060601");
        locationShip33.add("070601");
        List<String> locationShip34 = new ArrayList<>();
        locationShip34.add("060401");
        locationShip34.add("070401");
        List<String> locationShip35 = new ArrayList<>();
        locationShip35.add("090101");
        locationShip35.add("090201");
        locationShip35.add("090301");
        locationShip35.add("090401");

        List<List<String>> listLocationsShipsPlayer07Game04 = new ArrayList<>();
        listLocationsShipsPlayer07Game04.add(locationShip31);
        listLocationsShipsPlayer07Game04.add(locationShip32);
        listLocationsShipsPlayer07Game04.add(locationShip33);
        listLocationsShipsPlayer07Game04.add(locationShip34);
        listLocationsShipsPlayer07Game04.add(locationShip35);

        List<List<String>> listLocationsSalvoesPlayer07Game04 = createSalvoesList();

        Player Player07 = new Player("Player", "07","player07@example.com",encodedPassword);
        Player07.setRole("ADMIN");
        repositoryPlayers.save(Player07);

        Date gamePlayer07Date = new Date();
        CreateBoard boardPlayer07Game04 = new CreateBoard(Player07,Game04,gamePlayer07Date,listLocationsShipsPlayer07Game04,listLocationsSalvoesPlayer07Game04,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer07Game04=boardPlayer07Game04.getBoard();

        List<Salvo> salvoesPlayer07Game04=gamePlayerPlayer07Game04.getSalvoes();

        updateSalvo(salvoesPlayer07Game04,"0000",statusSalvoFired);

        updateSalvo(salvoesPlayer07Game04,"0203",statusSalvoFired);
        updateSalvo(salvoesPlayer07Game04,"0303",statusSalvoFired);
        updateSalvo(salvoesPlayer07Game04,"0403",statusSalvoFired);
        updateSalvo(salvoesPlayer07Game04,"0503",statusSalvoFired);

        updateSalvo(salvoesPlayer07Game04,"0607",statusSalvoFired);
        updateSalvo(salvoesPlayer07Game04,"0608",statusSalvoFired);
        updateSalvo(salvoesPlayer07Game04,"0609",statusSalvoFired);

        updateSalvo(salvoesPlayer07Game04,"0705",statusSalvoFired);
        updateSalvo(salvoesPlayer07Game04,"0805",statusSalvoFired);

        // To Create the Board of Player08 in Game04

        // Ship creation
        List<String> locationShip36 = new ArrayList<>();
        locationShip36.add("000001");

        List<String> locationShip37 = new ArrayList<>();
        locationShip37.add("010701");
        locationShip37.add("010801");
        locationShip37.add("010901");
        List<String> locationShip38 = new ArrayList<>();
        locationShip38.add("040001");
        locationShip38.add("050001");
        locationShip38.add("060001");
        locationShip38.add("070001");
        locationShip38.add("080001");
        List<String> locationShip39 = new ArrayList<>();
        locationShip39.add("020301");
        locationShip39.add("030301");
        locationShip39.add("040301");
        locationShip39.add("050301");
        List<String> locationShip40 = new ArrayList<>();
        locationShip40.add("070501");
        locationShip40.add("080501");

        List<List<String>> listLocationsShipsPlayer08Game04 = new ArrayList<>();
        listLocationsShipsPlayer08Game04.add(locationShip36);
        listLocationsShipsPlayer08Game04.add(locationShip37);
        listLocationsShipsPlayer08Game04.add(locationShip38);
        listLocationsShipsPlayer08Game04.add(locationShip39);
        listLocationsShipsPlayer08Game04.add(locationShip40);

        //Salvo creation

        List<List<String>> listLocationsSalvoesPlayer08Game04 = createSalvoesList();


        Player Player08 = new Player("Player", "08","player08@example.com",encodedPassword);
        Player08.setRole("ADMIN");
        repositoryPlayers.save(Player08);

        Date gamePlayer08Date = new Date();
        CreateBoard boardPlayer08Game04 = new CreateBoard(Player08,Game04,gamePlayer08Date,listLocationsShipsPlayer08Game04,listLocationsSalvoesPlayer08Game04,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer08Game04=boardPlayer08Game04.getBoard();
        List<Salvo> salvoesPlayer08Game04=gamePlayerPlayer08Game04.getSalvoes();

        updateSalvo(salvoesPlayer08Game04,"0201",statusSalvoFired);
        updateSalvo(salvoesPlayer08Game04,"0301",statusSalvoFired);
        updateSalvo(salvoesPlayer08Game04,"0401",statusSalvoFired);

        updateSalvo(salvoesPlayer08Game04,"0107",statusSalvoFired);
        updateSalvo(salvoesPlayer08Game04,"0108",statusSalvoFired);
        updateSalvo(salvoesPlayer08Game04,"0109",statusSalvoFired);

        updateSalvo(salvoesPlayer08Game04,"0207",statusSalvoFired);
        updateSalvo(salvoesPlayer08Game04,"0208",statusSalvoFired);
        updateSalvo(salvoesPlayer08Game04,"0209",statusSalvoFired);

        updateSalvo(salvoesPlayer08Game04,"0504",statusSalvoFired);

        updateSalvo(salvoesPlayer08Game04,"0704",statusSalvoFired);

        updateSalvo(salvoesPlayer08Game04,"0903",statusSalvoFired);
        updateSalvo(salvoesPlayer08Game04,"0904",statusSalvoFired);
        updateSalvo(salvoesPlayer08Game04,"0905",statusSalvoFired);

        //Update the Board Player07 vs Board Player08 in Game04
        UpdateShipsSalvos updateGame04SalvosAgainstShipsPlayer07Player08TwoWays= new UpdateShipsSalvos(gamePlayerPlayer07Game04,gamePlayerPlayer08Game04,repositoryShips,repositorySalvoes);
        updateGame04SalvosAgainstShipsPlayer07Player08TwoWays.UpdateSalvosAdversary();
        //_______________________________________________________________________________________________________
        // End of Game04
        //_______________________________________________________________________________________________________

        //_______________________________________________________________________________________________________
        // Creation of Game05
        //_______________________________________________________________________________________________________
        Date game_creation_date05= addHoursToJavaUtilDate(game_creation_date01,4);
        Game Game05 = new Game("Game 05", game_creation_date05);
        repositoryGames.save(Game05);
        // To Create the Board of Player09 in Game05

        // Creation of Ships
        List<String> locationShip41 = new ArrayList<>();
        locationShip41.add("010201");
        List<String> locationShip42 = new ArrayList<>();
        locationShip42.add("040001");
        locationShip42.add("040101");
        List<String> locationShip43 = new ArrayList<>();
        locationShip43.add("000401");
        locationShip43.add("010401");
        locationShip43.add("020401");
        locationShip43.add("030401");
        List<String> locationShip44 = new ArrayList<>();
        locationShip44.add("030801");
        locationShip44.add("040801");
        locationShip44.add("050801");
        locationShip44.add("060801");
        locationShip44.add("070801");
        List<String> locationShip45 = new ArrayList<>();
        locationShip45.add("090701");
        locationShip45.add("090801");
        locationShip45.add("090901");

        List<List<String>> listLocationsShipsPlayer09Game05 = new ArrayList<>();
        listLocationsShipsPlayer09Game05.add(locationShip41);
        listLocationsShipsPlayer09Game05.add(locationShip42);
        listLocationsShipsPlayer09Game05.add(locationShip43);
        listLocationsShipsPlayer09Game05.add(locationShip44);
        listLocationsShipsPlayer09Game05.add(locationShip45);

        // Creation of Salvoes

        List<List<String>> listLocationsSalvoesPlayer09Game05 = createSalvoesList();

        Player Player09 = new Player("Player", "09","player09@example.com",encodedPassword);
        Player09.setRole("ADMIN");
        repositoryPlayers.save(Player09);

        Date gamePlayer09Date = new Date();
        CreateBoard boardPlayer09Game05 = new CreateBoard(Player09,Game05,gamePlayer09Date,listLocationsShipsPlayer09Game05,listLocationsSalvoesPlayer09Game05,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer09Game05=boardPlayer09Game05.getBoard();
        List<Salvo> salvoesPlayer09Game05=gamePlayerPlayer09Game05.getSalvoes();

        updateSalvo(salvoesPlayer09Game05,"0000",statusSalvoFired);
        updateSalvo(salvoesPlayer09Game05,"0001",statusSalvoFired);
        updateSalvo(salvoesPlayer09Game05,"0002",statusSalvoFired);

        updateSalvo(salvoesPlayer09Game05,"0004",statusSalvoFired);

        updateSalvo(salvoesPlayer09Game05,"0007",statusSalvoFired);

        updateSalvo(salvoesPlayer09Game05,"0603",statusSalvoFired);
        updateSalvo(salvoesPlayer09Game05,"0703",statusSalvoFired);
        updateSalvo(salvoesPlayer09Game05,"0803",statusSalvoFired);
        updateSalvo(salvoesPlayer09Game05,"0903",statusSalvoFired);

        updateSalvo(salvoesPlayer09Game05,"0606",statusSalvoFired);
        updateSalvo(salvoesPlayer09Game05,"0706",statusSalvoFired);

        // To Create the Board of Player10 in Game05

        // Creation of Ships
        List<String> locationShip46 = new ArrayList<>();
        locationShip46.add("000001");
        List<String> locationShip47 = new ArrayList<>();
        locationShip47.add("000701");
        locationShip47.add("000801");
        locationShip47.add("000901");
        List<String> locationShip48 = new ArrayList<>();
        locationShip48.add("040001");
        locationShip48.add("050001");
        locationShip48.add("060001");
        locationShip48.add("070001");
        List<String> locationShip49 = new ArrayList<>();
        locationShip49.add("040301");
        locationShip49.add("050301");
        locationShip49.add("060301");
        locationShip49.add("070301");
        locationShip49.add("080301");
        List<String> locationShip50 = new ArrayList<>();
        locationShip50.add("040501");
        locationShip50.add("050501");

        List<List<String>> listLocationsShipsPlayer10Game05 = new ArrayList<>();
        listLocationsShipsPlayer10Game05.add(locationShip46);
        listLocationsShipsPlayer10Game05.add(locationShip47);
        listLocationsShipsPlayer10Game05.add(locationShip48);
        listLocationsShipsPlayer10Game05.add(locationShip49);
        listLocationsShipsPlayer10Game05.add(locationShip50);

        // Creation of Salvoes

        List<List<String>> listLocationsSalvoesPlayer10Game05 = createSalvoesList();

        Player Player10 = new Player("Player", "10","player10@example.com",encodedPassword);
        Player10.setRole("ADMIN");
        repositoryPlayers.save(Player10);

        Date gamePlayer10Date = new Date();
        CreateBoard boardPlayer10Game05 = new CreateBoard(Player10,Game05,gamePlayer10Date,listLocationsShipsPlayer10Game05,listLocationsSalvoesPlayer10Game05,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer10Game05=boardPlayer10Game05.getBoard();
        List<Salvo> salvoesPlayer10Game05=gamePlayerPlayer10Game05.getSalvoes();

        updateSalvo(salvoesPlayer10Game05,"0001",statusSalvoFired);
        updateSalvo(salvoesPlayer10Game05,"0002",statusSalvoFired);
        updateSalvo(salvoesPlayer10Game05,"0003",statusSalvoFired);
        updateSalvo(salvoesPlayer10Game05,"0004",statusSalvoFired);
        updateSalvo(salvoesPlayer10Game05,"0006",statusSalvoFired);

        updateSalvo(salvoesPlayer10Game05,"0101",statusSalvoFired);

        updateSalvo(salvoesPlayer10Game05,"0201",statusSalvoFired);
        updateSalvo(salvoesPlayer10Game05,"0201",statusSalvoFired);
        updateSalvo(salvoesPlayer10Game05,"0202",statusSalvoFired);
        updateSalvo(salvoesPlayer10Game05,"0203",statusSalvoFired);
        updateSalvo(salvoesPlayer10Game05,"0204",statusSalvoFired);

        updateSalvo(salvoesPlayer10Game05,"0206",statusSalvoFired);
        updateSalvo(salvoesPlayer10Game05,"0207",statusSalvoFired);
        updateSalvo(salvoesPlayer10Game05,"0208",statusSalvoFired);
        updateSalvo(salvoesPlayer10Game05,"0209",statusSalvoFired);

        //Update the Board Player09 vs Board Player10 in Game05
        UpdateShipsSalvos updateGame05SalvosAgainstShipsPlayer09Player10TwoWays= new UpdateShipsSalvos(gamePlayerPlayer09Game05,gamePlayerPlayer10Game05,repositoryShips,repositorySalvoes);
        updateGame05SalvosAgainstShipsPlayer09Player10TwoWays.UpdateSalvosAdversary();
        //_______________________________________________________________________________________________________
        // End of Game05
        //_______________________________________________________________________________________________________

        //_______________________________________________________________________________________________________
        // Creation of Game06
        //_______________________________________________________________________________________________________
        // with Player 09 y Player10 and the SameShips as Game05
        Date game_creation_date06= addHoursToJavaUtilDate(game_creation_date01,4);
        Game Game06 = new Game("Game 06", game_creation_date06);
        repositoryGames.save(Game06);

        // To Create the Board of Player05 in Game06
        Date gamePlayer11Date = new Date();
        CreateBoard boardPlayer05Game06 = new CreateBoard(Player05,Game06,gamePlayer11Date,listLocationsShipsPlayer09Game05,listLocationsSalvoesPlayer09Game05,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer09Game06=boardPlayer05Game06.getBoard();

        // To Create the Board of Player06 in Game06
        Date gamePlayer12Date = new Date();
        CreateBoard boardPlayer06Game06 = new CreateBoard(Player06,Game06,gamePlayer12Date,listLocationsShipsPlayer10Game05,listLocationsSalvoesPlayer10Game05,repositoryShips,repositorySalvoes,repositoryGamePlayer);
        GamePlayer gamePlayerPlayer10Game06=boardPlayer06Game06.getBoard();

        UpdateShipsSalvos updateGame06SalvosAgainstShipsPlayer09Player10TwoWays= new UpdateShipsSalvos(gamePlayerPlayer09Game06,gamePlayerPlayer10Game06,repositoryShips,repositorySalvoes);
        updateGame06SalvosAgainstShipsPlayer09Player10TwoWays.UpdateSalvosAdversary();

        //_____________________________________________________________
        // End Game06

        // Data to Test the Scores
        //Score for Boards in Game01
        Date score01FinishDate= new Date();
        Score scorePlayer01Game01 = new Score(1f,score01FinishDate,Game01,Player01);
        Score scorePlayer02Game01 = new Score(0f,score01FinishDate,Game01,Player02);
        repositoryScores.save(scorePlayer01Game01);
        repositoryScores.save(scorePlayer02Game01);
        gamePlayerPlayer01Game01.setScore(scorePlayer01Game01);
        gamePlayerPlayer02Game01.setScore(scorePlayer02Game01);
        repositoryGamePlayer.save(gamePlayerPlayer01Game01);
        repositoryGamePlayer.save(gamePlayerPlayer02Game01);

        //Score for Boards in Game02
        Date score02FinishDate= new Date();
        Score scorePlayer03Game02 = new Score(0f,score02FinishDate,Game02,Player03);
        Score scorePlayer04Game02 = new Score(1f,score02FinishDate,Game02,Player04);
        repositoryScores.save(scorePlayer03Game02);
        repositoryScores.save(scorePlayer04Game02);
        gamePlayerPlayer03Game02.setScore(scorePlayer03Game02);
        gamePlayerPlayer04Game02.setScore(scorePlayer04Game02);
        repositoryGamePlayer.save(gamePlayerPlayer03Game02);
        repositoryGamePlayer.save(gamePlayerPlayer04Game02);

        //Score for Boards in Game03
        Date score03FinishDate= new Date();
        Score scorePlayer05Game03 = new Score(0.5f,score03FinishDate,Game03,Player05);
        Score scorePlayer06Game03 = new Score(0.5f,score03FinishDate,Game03,Player06);
        repositoryScores.save(scorePlayer05Game03);
        repositoryScores.save(scorePlayer06Game03);
        gamePlayerPlayer05Game03.setScore(scorePlayer05Game03);
        gamePlayerPlayer06Game03.setScore(scorePlayer06Game03);
        repositoryGamePlayer.save(gamePlayerPlayer05Game03);
        repositoryGamePlayer.save(gamePlayerPlayer06Game03);

        //Score for Boards in Game06
        Date score04FinishDate= new Date();
        Score scorePlayer05Game06 = new Score(0.5f,score04FinishDate,Game06,Player05);
        Score scorePlayer06Game06 = new Score(0.5f,score04FinishDate,Game06,Player06);
        repositoryScores.save(scorePlayer05Game06);
        repositoryScores.save(scorePlayer06Game06);
        gamePlayerPlayer09Game06.setScore(scorePlayer05Game06);
        gamePlayerPlayer10Game06.setScore(scorePlayer06Game06);
        repositoryGamePlayer.save(gamePlayerPlayer09Game06);
        repositoryGamePlayer.save(gamePlayerPlayer10Game06);
        //Create game 07 to test add Ships
          Date game_creation_date07= addHoursToJavaUtilDate(game_creation_date01,4);
            Game Game07 = new Game("Game 07", game_creation_date07);
            repositoryGames.save(Game07);
        //GamePlayer First of the Game07
            Date gamePlayer13Date = new Date();
            List<String> locationShip5100 = new ArrayList<>();
            locationShip5100.add("000001");
            List<String> locationShip5201 = new ArrayList<>();
            locationShip5201.add("030201");
            locationShip5201.add("030301");
            List<String> locationShip5302 = new ArrayList<>();
            locationShip5302.add("070001");
            locationShip5302.add("080001");
            locationShip5302.add("090001");
            List<String> locationShip5403 = new ArrayList<>();
            locationShip5403.add("050501");
            locationShip5403.add("050601");
            locationShip5403.add("050701");
            locationShip5403.add("050801");
            List<String> locationShip5504 = new ArrayList<>();
            locationShip5504.add("070401");
            locationShip5504.add("070501");
            locationShip5504.add("070601");
            locationShip5504.add("070701");
            locationShip5504.add("070801");
            List<List<String>> listLocationsShipsPlayer07Game07 = new ArrayList<>();
            listLocationsShipsPlayer07Game07.add(locationShip5100);
            listLocationsShipsPlayer07Game07.add(locationShip5201);
            listLocationsShipsPlayer07Game07.add(locationShip5302);
            listLocationsShipsPlayer07Game07.add(locationShip5403);
            listLocationsShipsPlayer07Game07.add(locationShip5504);
            List<List<String>> listLocationsSalvoesPlayer07Game07 = new ArrayList<>();

            CreateBoard boardPlayer07Game07 = new CreateBoard(Player07,Game07,gamePlayer13Date,listLocationsShipsPlayer07Game07,listLocationsSalvoesPlayer07Game07,repositoryShips,repositorySalvoes,repositoryGamePlayer);
            GamePlayer gamePlayerPlayer07Game07=boardPlayer07Game07.getBoard();
        //GamePlayer Second of the Game07
        Date gamePlayer14Date = new Date();
            List<String> locationShip5600 = new ArrayList<>();
            locationShip5600.add("000001");
            List<String> locationShip5701 = new ArrayList<>();
            locationShip5701.add("030201");
            locationShip5701.add("030301");
            List<String> locationShip5802 = new ArrayList<>();
            locationShip5802.add("070001");
            locationShip5802.add("080001");
            locationShip5802.add("090001");
            List<String> locationShip5903 = new ArrayList<>();
            locationShip5903.add("050501");
            locationShip5903.add("050601");
            locationShip5903.add("050701");
            locationShip5903.add("050801");
            List<String> locationShip6004 = new ArrayList<>();
            locationShip6004.add("070401");
            locationShip6004.add("070501");
            locationShip6004.add("070601");
            locationShip6004.add("070701");
            locationShip6004.add("070801");
            List<List<String>> listLocationsShipsPlayer08Game07 = new ArrayList<>();
            listLocationsShipsPlayer08Game07.add(locationShip5600);
            listLocationsShipsPlayer08Game07.add(locationShip5701);
            listLocationsShipsPlayer08Game07.add(locationShip5802);
            listLocationsShipsPlayer08Game07.add(locationShip5903);
            listLocationsShipsPlayer08Game07.add(locationShip6004);
            List<List<String>> listLocationsSalvoesPlayer08Game07 = new ArrayList<>();
            //GamePlayer First of the Game07
            CreateBoard boardPlayer08Game07 = new CreateBoard(Player08,Game07,gamePlayer14Date,listLocationsShipsPlayer08Game07,listLocationsSalvoesPlayer08Game07,repositoryShips,repositorySalvoes,repositoryGamePlayer);
            GamePlayer gamePlayerPlayer08Game07=boardPlayer08Game07.getBoard();

    }
}
