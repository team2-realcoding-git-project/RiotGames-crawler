package org.ajou.realcodingteam2.riotgamescrawler.api;

import io.swagger.models.HttpMethod;
import org.ajou.realcodingteam2.riotgamescrawler.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiotGamesOpenApiClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SUMMONERINFO_REQUEST = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key=RGAPI-27cfbedd-ba4b-4b0f-8eb9-1c42338d3b37";

    public Summoner getSummonerInfo(String summonerName){
        Summoner summoner = restTemplate.getForObject(SUMMONERINFO_REQUEST, Summoner.class, summonerName);
        return summoner;
    }
}
