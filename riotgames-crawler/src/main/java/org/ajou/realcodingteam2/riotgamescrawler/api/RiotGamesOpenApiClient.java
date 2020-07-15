package org.ajou.realcodingteam2.riotgamescrawler.api;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcodingteam2.riotgamescrawler.domain.Game;
import org.ajou.realcodingteam2.riotgamescrawler.domain.MatchDto;
import org.ajou.realcodingteam2.riotgamescrawler.domain.League;
import org.ajou.realcodingteam2.riotgamescrawler.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class RiotGamesOpenApiClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SUMMONERINFO_REQUEST = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key=RGAPI-442464bb-d44a-41b9-a930-1d718af5ab8e";

    private static final String LEAGUEINFO_REQUEST = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{summonerId}?api_key=RGAPI-442464bb-d44a-41b9-a930-1d718af5ab8e";

    private static final String GAMEINFO_REQUEST = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/{accountId}?api_key=RGAPI-442464bb-d44a-41b9-a930-1d718af5ab8e";

    private static final String MATCHGAME_REQUEST = "https://kr.api.riotgames.com/lol/match/v4/matches/{matchId}?api_key=RGAPI-442464bb-d44a-41b9-a930-1d718af5ab8e";



    public Summoner getSummonerInfo(String summonerName){
        Summoner summoner = restTemplate.getForObject(SUMMONERINFO_REQUEST, Summoner.class, summonerName);
        return summoner;
    }
/*
    public League getLeagueInfo(String summonerId){
        League[] leagues = restTemplate.getForObject(LEAGUEINFO_REQUEST, League[].class, summonerId);
        for(League league : leagues) {
            if (league.getQueueType().equals("RANKED_SOLO_5x5")) return league;
        }
        return null;
    }

 */
    public League getLeagueInfo(String summonerId){

        log.info("summonerId : {}", summonerId);
        League league = restTemplate.getForObject(LEAGUEINFO_REQUEST, League.class, summonerId);


        log.info("summonerId : {}", summonerId);
        return league;
    }


    public Game getGameInfo(String accountId){
        Game game = restTemplate.getForObject(GAMEINFO_REQUEST, Game.class, accountId);
        return game;
    }
    public MatchDto getMatchDtoInfo(String matchId){
        MatchDto matchDto = restTemplate.getForObject(MATCHGAME_REQUEST, MatchDto.class, matchId);

        return matchDto;
    }
}
