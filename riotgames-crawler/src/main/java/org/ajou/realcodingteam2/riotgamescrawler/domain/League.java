package org.ajou.realcodingteam2.riotgamescrawler.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class League {
    private String leagueId;
    private String queueType;
    private String tier;
    private String rank;
    private String summonerId;
    @Id
    private String summonerName;
    private String leaguePoints;
    private int wins;
    private int losses;
    private boolean veteran;
    private boolean inactive;
    private boolean freshBlood;
    private boolean hotStreak;
}