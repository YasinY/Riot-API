package com.yasinyazici.riot;

import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.data.game.Season;
import com.yasinyazici.riot.data.staticdata.Region;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsSummary;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Yasin on 11.03.2017.
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) throws ReplyException, DataException, IOException, WrongRequestFormatException, InterruptedException, URISyntaxException {
        LeagueAPI leagueAPI = new LeagueAPI(Region.EUW);
        Summoner summoner = leagueAPI.getSummoner("jungle ís life");
        List<ChampionStatsSummary> championStatsSummary = leagueAPI.getChampionStatsRanked(summoner.getId(), Season.SEASON_7).getChampionStatsSummary();
        championStatsSummary.forEach(p -> {
            System.out.println(p.getId());
        });
    }
}
