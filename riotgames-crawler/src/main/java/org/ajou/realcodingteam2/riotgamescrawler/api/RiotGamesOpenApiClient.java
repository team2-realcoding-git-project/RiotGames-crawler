package org.ajou.realcodingteam2.riotgamescrawler.api;

import org.ajou.realcodingteam2.riotgamescrawler.domain.League;
import org.ajou.realcodingteam2.riotgamescrawler.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RiotGamesOpenApiClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SUMMONERINFO_REQUEST = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key=RGAPI-f82fb1ab-b032-4778-9272-536fcc8c501a";

    //do
    private static final String LEAGUEINFO_REQUEST = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{summonerId}?api_key=RGAPI-f82fb1ab-b032-4778-9272-536fcc8c501a";

    public Summoner getSummonerInfo(String summonerName){
        Summoner summoner = restTemplate.getForObject(SUMMONERINFO_REQUEST, Summoner.class, summonerName);
        return summoner;
    }

    //do
    public League getLeagueInfo(String summonerId){
        League[] leagues = restTemplate.getForObject(LEAGUEINFO_REQUEST, League[].class, summonerId);
        for(League league : leagues) {
            if (league.getQueueType().equals("RANKED_SOLO_5x5")) return league;
        }
        return null;
    }
}
