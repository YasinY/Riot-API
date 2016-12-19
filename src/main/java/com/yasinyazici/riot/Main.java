package com.yasinyazici.riot;

import com.yasinyazici.riot.data.activegame.CurrentGameInfo;
import com.yasinyazici.riot.data.summoner.Summoner;

/**
 * Created by Yasin on 09/02/2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Main {

    public static void main(String[] args) throws Exception {
            LeagueAPI leagueAPI = new LeagueAPI();
            Summoner summoner = leagueAPI.getSummoner("euw", "eíleen");
            System.out.println(summoner.getSummonerProperties().getId());
            CurrentGameInfo currentGameInfo = leagueAPI.getActiveGame(summoner.getRegion(), summoner.getSummonerProperties().getId());
            System.out.println("Red team:");
            currentGameInfo.getParticipants().stream().filter(p -> p.getTeam().equalsIgnoreCase("red")).forEach(p -> {
                long championId = p.getChampionId();
                try {
                    System.out.println("Name: " + p.getSummonerName() + ", Champion: " + leagueAPI.getChampionInfo(summoner.getRegion(), championId).getName());
                    System.out.println("Mastery with champion: " + p);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
    }
}
