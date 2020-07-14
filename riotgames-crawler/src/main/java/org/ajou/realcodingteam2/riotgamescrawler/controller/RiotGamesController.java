package org.ajou.realcodingteam2.riotgamescrawler.controller;

import org.ajou.realcodingteam2.riotgamescrawler.domain.Summoner;
import org.ajou.realcodingteam2.riotgamescrawler.service.RiotGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiotGamesController {

    @Autowired
    private RiotGamesService riotGamesService;

    @GetMapping("/riotGamesInfo-service/{summonerName}")
    public Summoner getSummonerInfo(@PathVariable String summonerName){
        return riotGamesService.getSummonerInform(summonerName);

    }

}
