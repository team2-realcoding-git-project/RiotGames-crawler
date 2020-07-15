package org.ajou.realcodingteam2.riotgamescrawler.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class MatchDto {

    private List<ParticipantIdentityDto> participantIdentities;
    private List<ParticipantDto> participants;

    @Data
    public static class ParticipantIdentityDto {

        int participantId;
        PlayerDto player;
    }
    @Data
    public static class PlayerDto{
        @Id
        String summonerName;
    }


    @Data
    public static class ParticipantDto{
        int participantId;
        int championId;
        ParticipantStatsDto stats;
    }
    @Data
    public static class ParticipantStatsDto{
        int deaths;
        int kills;
        int assists;
        boolean win;
    }



}
