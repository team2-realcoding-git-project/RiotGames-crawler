package org.ajou.realcodingteam2.riotgamescrawler.domain;

        import lombok.Data;
        import org.springframework.data.annotation.Id;

@Data
public class LeagueEntryDto {

    private String tier;
    private String rank;
    private String queueType;
    @Id
    private String summonerId;
    private String summonerName;


}