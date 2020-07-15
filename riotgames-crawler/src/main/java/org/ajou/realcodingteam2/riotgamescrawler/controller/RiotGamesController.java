package org.ajou.realcodingteam2.riotgamescrawler.controller;

import org.ajou.realcodingteam2.riotgamescrawler.domain.Game;
import org.ajou.realcodingteam2.riotgamescrawler.domain.MatchDto;
import org.ajou.realcodingteam2.riotgamescrawler.domain.League;
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
    @GetMapping("/riotGamesInfo-league/{summonerName}")
    public League getLeagueInfo(@PathVariable String summonerName){
        return riotGamesService.getLeagueInform(summonerName);
    }
    @GetMapping("/riotGamesInfo-game/{summonerName}")
    public Game getGameInfo(@PathVariable String summonerName){
        return riotGamesService.getGameInfo(summonerName);

    }
    @GetMapping
    public MatchDto getGameDetailInfo(@PathVariable String summonerName){
        return riotGamesService.getGameDetailInfo(summonerName);
    }

}
