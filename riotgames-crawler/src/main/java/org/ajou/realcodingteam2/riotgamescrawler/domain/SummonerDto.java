package org.ajou.realcodingteam2.riotgamescrawler.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SummonerDto {
    private String id;
    private String accountId;
    @Id
    private String name;

}
