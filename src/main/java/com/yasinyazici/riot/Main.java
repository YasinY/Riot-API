package com.yasinyazici.riot;

import com.yasinyazici.riot.config.Config;
import com.yasinyazici.riot.data.champion.ChampionImage;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.currentgame.CurrentGameInfo;
import com.yasinyazici.riot.data.currentgame.data.CurrentGameParticipant;
import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.PropertyNotFound;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.data.game.Season;
import com.yasinyazici.riot.data.staticdata.Region;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStats;
import com.yasinyazici.riot.data.summoner.ranked.league.LeagueEntry;
import com.yasinyazici.riot.data.summoner.ranked.league.QueueType;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author Yasin on 11.03.2017.
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) throws ReplyException, DataException, IOException, WrongRequestFormatException, PropertyNotFound, InterruptedException, URISyntaxException {
        LeagueAPI leagueAPI = new LeagueAPI();
        Region parsedRegion = Region.EUW;
        Summoner summoner = leagueAPI.getSummoner(parsedRegion, "Azerlus");
        CurrentGameInfo currentGameInfo = summoner.getActiveGame(); // 1 req
        Map<String, Summoner> summoners = leagueAPI.getSummoners(Region.EUW, currentGameInfo.getParticipants().stream().filter(p -> p.getSummonerName()).collect());
        for(Map.Entry<String, Summoner> entry = summoners.entrySet()) {
            list.add(entry.getValue().getName()); // <---
        }
        for (CurrentGameParticipant currentGameParticipant : currentGameInfo.getParticipants()) {
            LeagueEntry entry = leagueAPI.getLeagueEntry(parsedRegion, currentGameParticipant.getSummonerId(), QueueType.RANKED_SOLO_5x5); // 2 req
            String rank = entry.getTier() + " " + entry.getEntries().get(0).getDivision();
            long championId = currentGameParticipant.getChampionId();
            if (championId != 0) {
                ChampionImage championData = leagueAPI.getChampionData(championId);
                System.out.println("Champion id: " + championId);
                if (championData != null) {
                    String imageUrl = leagueAPI.getImageUrl(parsedRegion, championId); // 3
                    ChampionMastery championMastery = leagueAPI.getChampionMastery(parsedRegion, summoner.getId(), championId); // 4
                    ChampionStats championStats = leagueAPI.getChampionStatsRanked(parsedRegion, summoner.getId(), championId, Season.SEASON_7); // 5
                    System.out.println(rank);
                    // ChampionData currentChampionPlayed = new ChampionData(championData.getName(), imageUrl, championMastery.getChampionPoints(), championMastery.getChampionLevel(), championStats.getAverageCreepScore(), championStats.displayAverageKDA(), championStats.displayWinrate(), championStats.getTotalSessionsPlayed());
                    //participants.add(new Participant(currentGameParticipant, rank, null));
                }
            }
        }
    }
}
