package org.ajou.realcodingteam2.riotgamescrawler.api;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcodingteam2.riotgamescrawler.domain.MatchListDto;
import org.ajou.realcodingteam2.riotgamescrawler.domain.MatchDto;
import org.ajou.realcodingteam2.riotgamescrawler.domain.LeagueEntryDto;
import org.ajou.realcodingteam2.riotgamescrawler.domain.SummonerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class RiotGamesOpenApiClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SUMMONERINFO_REQUEST = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key=RGAPI-2c484922-2e11-4acc-a79d-a1cb78210959";

    private static final String LEAGUEINFO_REQUEST = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{summonerId}?api_key=RGAPI-2c484922-2e11-4acc-a79d-a1cb78210959";

    private static final String GAMEINFO_REQUEST = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/{accountId}?api_key=RGAPI-2c484922-2e11-4acc-a79d-a1cb78210959";

    private static final String MATCHGAME_REQUEST = "https://kr.api.riotgames.com/lol/match/v4/matches/{matchId}?api_key=RGAPI-2c484922-2e11-4acc-a79d-a1cb78210959";


    public SummonerDto getSummonerInfo(String summonerName){
        SummonerDto summoner = restTemplate.getForObject(SUMMONERINFO_REQUEST, SummonerDto.class, summonerName);
        return summoner;
    }

    public LeagueEntryDto getLeagueInfo(String summonerId){
        LeagueEntryDto[] leagues = restTemplate.getForObject(LEAGUEINFO_REQUEST, LeagueEntryDto[].class, summonerId);
        for(LeagueEntryDto league : leagues) {
            if (league.getQueueType().equals("RANKED_SOLO_5x5")) return league;
        }
        return null;
    }





    public MatchListDto getGameInfo(String accountId){
        MatchListDto game = restTemplate.getForObject(GAMEINFO_REQUEST, MatchListDto.class, accountId);
        return game;
    }
    public MatchDto getMatchDtoInfo(String matchId){
        MatchDto matchDto = restTemplate.getForObject(MATCHGAME_REQUEST, MatchDto.class, matchId);

        return matchDto;
    }
}
