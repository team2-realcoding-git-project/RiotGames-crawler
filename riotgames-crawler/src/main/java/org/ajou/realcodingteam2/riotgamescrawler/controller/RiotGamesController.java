package org.ajou.realcodingteam2.riotgamescrawler.controller;

import org.ajou.realcodingteam2.riotgamescrawler.domain.*;
import org.ajou.realcodingteam2.riotgamescrawler.service.RiotGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiotGamesController {

    @Autowired
    private RiotGamesService riotGamesService;

    @GetMapping("/riotGamesInfo-game/{summonerName}")
    public FinalGameInformation getGameDetailInfo(@RequestParam String summonerName){
        return riotGamesService.getFinalGameInformation(summonerName);
    }


}
