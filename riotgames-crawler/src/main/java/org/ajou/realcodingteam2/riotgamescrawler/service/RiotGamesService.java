package org.ajou.realcodingteam2.riotgamescrawler.service;

import org.ajou.realcodingteam2.riotgamescrawler.domain.Summoner;
import org.ajou.realcodingteam2.riotgamescrawler.repository.RiotGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;

@Service
@EnableScheduling
public class RiotGamesService {
    @Autowired
    private RiotGamesRepository riotGamesRepository;

    public Summoner getSummonerInform(String summonerName) {
        return riotGamesRepository.getSummonerInform(summonerName);
    }
}
