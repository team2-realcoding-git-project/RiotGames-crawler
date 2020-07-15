package org.ajou.realcodingteam2.riotgamescrawler.service;

import org.ajou.realcodingteam2.riotgamescrawler.domain.League;
import org.ajou.realcodingteam2.riotgamescrawler.domain.Summoner;
import org.ajou.realcodingteam2.riotgamescrawler.repository.RiotGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class RiotGamesService {
    @Autowired
    private RiotGamesRepository riotGamesRepository;

    public Summoner getSummonerInform(String summonerName) {
        return riotGamesRepository.getSummonerInform(summonerName);
    }

    //do
    public League getLeagueInform(String summonerName) {
        return riotGamesRepository.getLeagueInform(summonerName);
    }

}
