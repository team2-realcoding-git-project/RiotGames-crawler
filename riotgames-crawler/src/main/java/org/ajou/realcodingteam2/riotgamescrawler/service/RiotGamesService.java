package org.ajou.realcodingteam2.riotgamescrawler.service;

        import org.ajou.realcodingteam2.riotgamescrawler.domain.*;
        import org.ajou.realcodingteam2.riotgamescrawler.repository.RiotGamesRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.scheduling.annotation.EnableScheduling;
        import org.springframework.stereotype.Service;

        //import javax.xml.ws.soap.Addressing;

@Service
@EnableScheduling
public class RiotGamesService {
    @Autowired
    private RiotGamesRepository riotGamesRepository;

    public Summoner getSummonerInform(String summonerName) {
        return riotGamesRepository.getSummonerInform(summonerName);
    }

    public League getLeagueInform(String summonerName) {
        return riotGamesRepository.getLeagueInform(summonerName);
    }

    public Game getGameInfo(String summonerName) {
        return riotGamesRepository.getGameInfo(summonerName);
    }
/*
    public MatchDto getGameDetailInfo(String summonerName) {
        return riotGamesRepository.getGameDetailInfo(summonerName);
    }*/

    public FinalGameInformation getFinalGameInformation(String summonerName) {

        return riotGamesRepository.findFinalGameInformation(summonerName);
    }
}
