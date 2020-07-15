package org.ajou.realcodingteam2.riotgamescrawler.repository;

import org.ajou.realcodingteam2.riotgamescrawler.api.RiotGamesOpenApiClient;
import org.ajou.realcodingteam2.riotgamescrawler.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RiotGamesRepository {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private RiotGamesOpenApiClient riotGamesOpenApiClient;
    @Autowired
    private MongoTemplate summonerNameDb;
    @Autowired
    private MongoTemplate leagueDb;
    @Autowired
    private MongoTemplate gameDb;
    @Autowired
    private MongoTemplate matchDtoDb;
    @Autowired
    private MongoTemplate finalGameInformationDb;

    @Autowired
    private FinalGameInformation saveFinalGameInformation;



    public void saveSummonerInfo(Summoner summoner){
        Summoner savedSummoner = mongoTemplate.save(summoner);

    }



    public Summoner getSummonerInform(String summonerName) {
        Query query = Query.query(Criteria.where("_name").is(summonerName));
        Summoner summonerA = mongoTemplate.findOne(query, Summoner.class);

        if(summonerA == null){
            Summoner summoner = riotGamesOpenApiClient.getSummonerInfo(summonerName);
            saveSummonerInfo(summoner);
            return summoner;
        }else{
            return summonerA;
        }
    }

    //do
    public void saveLeagueInfo(League league){

        League savedLeague = mongoTemplate.save(league);
    }

    //do
    public League getLeagueInform(String summonerName){
        Summoner summoner = getSummonerInform(summonerName);
        Query query = Query.query(Criteria.where("_id").is(summoner.getId()));
        League leagueA = mongoTemplate.findOne(query, League.class);
        if(leagueA == null){
            League league = riotGamesOpenApiClient.getLeagueInfo(summoner.getId());
            saveLeagueInfo(league);
            return league;
        } else {
            return leagueA;
        }
    }
    public void saveGameInfo(Game game){
        Game savedGame = mongoTemplate.save(game);
    }

    public Game getGameInfo(String summonerName) {
        /*Summoner summoner = getSummonerInform(summonerName);
        Query query = Query.query(Criteria.where("_accountId").is(summoner.getAccountId()));
        Game gameA = mongoTemplate.findOne(query, Game.class);
        if(gameA == null){
            Game game = null;
            Game.matches A = riotGamesOpenApiClient.getGameInfo(summoner.getAccountId());
            game.setAccountId(summoner.getAccountId());
            game.setGameId(A);
            return game;
        }
        else{
            return gameA;
        }*/
        Summoner summoner = getSummonerInform(summonerName);
        Game game = riotGamesOpenApiClient.getGameInfo(summoner.getAccountId());
        game.setAccountId(summoner.getAccountId());
        saveGameInfo(game);
        return game;
    }


    public FinalGameInformation findFinalGameInformation(String summonerName) {
        Query query = Query.query(Criteria.where("_id").is(summonerName);
        FinalGameInformation finalGameInformation = finalGameInformationDb.findOne(query, FinalGameInformation.class);
        if(finalGameInformation == null){
            Summoner summoner = riotGamesOpenApiClient.getSummonerInfo(summonerName);
            summonerNameDb.save(summoner);

            saveFinalGameInformation.setSummonerName(summonerName);

            League league = riotGamesOpenApiClient.getLeagueInfo(summoner.getId());
            leagueDb.save(league);

            saveFinalGameInformation.setRank(league.getRank());
            saveFinalGameInformation.setTier(league.getTier());

            Game game = riotGamesOpenApiClient.getGameInfo(summoner.getAccountId());
            gameDb.save(game);

            for(int i=0;i<5;i++) {
                game.getMatches().get(0).getGameId();

            }

        }
        return finalGameInformation;
    }
}
