package com.yasinyazici.riot;

import com.yasinyazici.riot.data.champion.ChampionImage;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.currentgame.CurrentGameInfo;
import com.yasinyazici.riot.data.currentgame.data.CurrentGameParticipant;
import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.PropertyNotFoundException;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.data.game.Season;
import com.yasinyazici.riot.data.staticdata.Region;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStats;
import com.yasinyazici.riot.data.summoner.ranked.league.LeagueEntry;
import com.yasinyazici.riot.data.summoner.ranked.league.QueueType;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Yasin on 11.03.2017.
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) throws ReplyException, DataException, IOException, WrongRequestFormatException, PropertyNotFoundException, InterruptedException, URISyntaxException {
        LeagueAPI leagueAPI = new LeagueAPI(Region.EUW);
        Summoner summoner = leagueAPI.getSummoner( "Azerlus");
        CurrentGameInfo currentGameInfo = summoner.getActiveGame(); // First request
        for (CurrentGameParticipant currentGameParticipant : currentGameInfo.getParticipants()) {
            LeagueEntry entry = leagueAPI.getLeagueEntry( currentGameParticipant.getSummonerId(), QueueType.RANKED_SOLO_5x5); // Second
            String rank = entry.getTier() + " " + entry.getEntries().get(0).getDivision();
            long championId = currentGameParticipant.getChampionId();
            if (championId != 0) {
                ChampionImage championData = leagueAPI.getChampionData(championId);
                System.out.println("Champion id: " + championId);
                if (championData != null) {
                    String imageUrl = leagueAPI.getImageUrl(championId); // 3
                    ChampionMastery championMastery = leagueAPI.getChampionMastery(summoner.getId(), championId); // 4
                    ChampionStats championStats = leagueAPI.getChampionStatsRanked(summoner.getId(), championId, Season.SEASON_7); // 5
                    System.out.println(rank);
                    // ChampionData currentChampionPlayed = new ChampionData(championData.getName(), imageUrl, championMastery.getChampionPoints(), championMastery.getChampionLevel(), championStats.getAverageCreepScore(), championStats.displayAverageKDA(), championStats.displayWinrate(), championStats.getTotalSessionsPlayed());
                    //participants.add(new Participant(currentGameParticipant, rank, null));
                }
            }
        }
    }
}
