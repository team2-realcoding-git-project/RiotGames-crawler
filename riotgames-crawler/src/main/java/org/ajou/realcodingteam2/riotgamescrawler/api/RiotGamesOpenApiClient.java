package org.ajou.realcodingteam2.riotgamescrawler.api;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcodingteam2.riotgamescrawler.domain.MatchlistDto;
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

    private static final String SUMMONERINFO_REQUEST = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key=RGAPI-042ddc06-283d-4f72-9891-7eb5f920cc58";

    private static final String LEAGUEINFO_REQUEST = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{summonerId}?api_key=RGAPI-042ddc06-283d-4f72-9891-7eb5f920cc58";

    private static final String GAMEINFO_REQUEST = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/{accountId}?api_key=RGAPI-042ddc06-283d-4f72-9891-7eb5f920cc58";

    private static final String MATCHGAME_REQUEST = "https://kr.api.riotgames.com/lol/match/v4/matches/{matchId}?api_key=RGAPI-042ddc06-283d-4f72-9891-7eb5f920cc58";


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





    public MatchlistDto getGameInfo(String accountId){
        MatchlistDto game = restTemplate.getForObject(GAMEINFO_REQUEST, MatchlistDto.class, accountId);
        return game;
    }
    public MatchDto getMatchDtoInfo(String matchId){
        MatchDto matchDto = restTemplate.getForObject(MATCHGAME_REQUEST, MatchDto.class, matchId);

        return matchDto;
    }
}
