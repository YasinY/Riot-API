package com.yasinyazici.riot;

import com.yasinyazici.riot.data.activegame.CurrentGameInfo;
import com.yasinyazici.riot.data.activegame.data.CurrentGameParticipant;
import com.yasinyazici.riot.data.champion.ChampionInfo;
import com.yasinyazici.riot.data.summoner.Summoner;

/**
 * Created by Yasin on 09/02/2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Main {

    public static void main(String[] args) throws Exception {
        LeagueAPI leagueAPI = new LeagueAPI();
        Summoner summoner = leagueAPI.getSummoner("euw", "jungleíslife");
        CurrentGameInfo currentGameInfo = leagueAPI.getActiveGame("euw", String.valueOf(summoner.getSummonerProperties().getId()));
        for(CurrentGameParticipant currentGameParticipant : currentGameInfo.getParticipants()) {
            long championId = currentGameParticipant.getChampionId();
            ChampionInfo info = leagueAPI.getChampionInfo(summoner.getRegion(), String.valueOf(championId));
            System.out.println(info.getName());
        }
    }
}
