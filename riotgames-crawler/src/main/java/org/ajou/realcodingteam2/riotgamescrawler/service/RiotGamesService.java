package org.ajou.realcodingteam2.riotgamescrawler.service;

import org.ajou.realcodingteam2.riotgamescrawler.api.RiotGamesOpenApiClient;
import org.ajou.realcodingteam2.riotgamescrawler.domain.*;
        import org.ajou.realcodingteam2.riotgamescrawler.repository.RiotGamesRepository;
        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

//import javax.xml.ws.soap.Addressing;

@Service
@EnableScheduling
public class RiotGamesService {
    @Autowired
    private RiotGamesRepository riotGamesRepository;
    @Autowired
    private RiotGamesOpenApiClient riotGamesOpenApiClient;

    @Autowired
    private MongoTemplate mongoTemplate;

    public FinalGameInformation getFinalGameInformation(String summonerName) {

        return riotGamesRepository.findFinalGameInformation(summonerName);
    }

}
