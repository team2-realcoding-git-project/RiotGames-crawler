package org.ajou.realcodingteam2.riotgamescrawler.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Summoner {
    private String id;
    private String accountId;
    private String puuid;
    @Id
    private String name;
    private int profileIconId;
    private String revisionDate;
    private int summonerLevel;
}
