package org.ajou.realcodingteam2.riotgamescrawler.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class FinalGameInformation {
    private List<GameDetail> gameInformation;

    @Data
    public static class GameDetail {
        @Id
        private String summonerName;

        private boolean win;
        private int championId;
        private int kills;
        private int deaths;
        private int assists;
        private String tier;
        private String rank;
    }
}
