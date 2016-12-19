package com.yasinyazici.riot;

import com.yasinyazici.riot.data.activegame.CurrentGameInfo;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.summoner.Summoner;

import java.util.Objects;

/**
 * Created by Yasin on 09/02/2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Main {

    public static void main(String[] args) throws Exception {
            LeagueAPI leagueAPI = new LeagueAPI();
            Summoner summoner = leagueAPI.getSummoner("euw", "Mélibé");
            System.out.println(summoner.getSummonerProperties().getId());
            CurrentGameInfo currentGameInfo = leagueAPI.getActiveGame(summoner.getRegion(), summoner.getSummonerProperties().getId());
            currentGameInfo.getParticipants().stream().filter(Objects::nonNull).forEachOrdered(p -> {
                long championId = p.getChampionId();
                try {
                    ChampionMastery championMastery = leagueAPI.getChampionMastery(summoner.getRegion(), summoner.getSummonerProperties().getId(), championId);
                    System.out.println("Name: " + p.getSummonerName() + ", Champion: " + leagueAPI.getChampionInfo(summoner.getRegion(), championId).getName());
                    System.out.println("Mastery with champion: " + championMastery.getChampionLevel() + " (" + championMastery.getChampionPoints() + ")");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
    }
}
