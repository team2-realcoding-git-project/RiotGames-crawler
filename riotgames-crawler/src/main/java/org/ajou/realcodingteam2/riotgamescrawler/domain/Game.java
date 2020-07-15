package org.ajou.realcodingteam2.riotgamescrawler.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Game {
    //@Id
    //private String accountId;
    private List<Matches> matches;
    @Data
    public static class Matches{
        private String gameId;
    }


}
