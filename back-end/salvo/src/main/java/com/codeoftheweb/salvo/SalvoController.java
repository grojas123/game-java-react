package com.codeoftheweb.salvo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SalvoController {
    private static final Logger log = LoggerFactory.getLogger(SalvoController.class);
    @Autowired
    private GameRepository gamesRepository;
    @RequestMapping("/games_ids")
    public List<String> getAllGamesIds() {
    List allGames= gamesRepository.findAll();
        List<String> listTemp = new ArrayList<>();
      for (Game game : gamesRepository.findAll()) {
           listTemp.add(String.valueOf(game.getId()));
       }
    //log.info(String.valueOf(listTemp));
    return listTemp;
}
}
