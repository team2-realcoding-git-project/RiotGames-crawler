package org.ajou.realcodingteam2.riotgamescrawler.service;

import org.ajou.realcodingteam2.riotgamescrawler.domain.*;
import org.ajou.realcodingteam2.riotgamescrawler.repository.RiotGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class RiotGamesService {
    @Autowired
    private RiotGamesRepository riotGamesRepository;

    public FinalGameInformation getFinalGameInformation(String summonerName) {

        return riotGamesRepository.findFinalGameInformation(summonerName);

    }
}
