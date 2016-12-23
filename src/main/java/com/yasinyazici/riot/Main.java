package com.yasinyazici.riot;

import com.yasinyazici.riot.data.game.Season;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsRanked;

/**
 * Created by Yasin on 23.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Main {

    public static void main(String[] args) throws Exception {
        LeagueAPI leagueAPI = new LeagueAPI();
        Summoner summoner = leagueAPI.getSummoner("euw", "jungleíslife");
        ChampionStatsRanked championStatsRanked = leagueAPI.getChampionStatsRanked("euw", summoner.getSummonerProperties().getId(), Season.SEASON_6);
        championStatsRanked.getChampionStatsSummary().forEach(p -> {
            System.out.println("WR: " + p.getChampionStatsList().getWinrate());
            System.out.println("Average kda: " + p.getChampionStatsList().displayAverageKDA());
            System.out.println("Average cs: " + p.getChampionStatsList().displayAverageCreepScore());
        });
    }
}
