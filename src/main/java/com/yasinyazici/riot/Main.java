package com.yasinyazici.riot;

import com.yasinyazici.riot.config.Config;
import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.PropertyNotFound;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.data.staticdata.Region;
import com.yasinyazici.riot.data.summoner.Summoner;
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
        Summoner summoner = leagueAPI.getSummoner(Region.EUW, "jungle ís life");
        LeagueEntry leagueEntry = leagueAPI.getLeagueEntry(Region.EUW, summoner.getId(), QueueType.RANKED_FLEX_SR);
        System.out.println(leagueEntry.getTier());
//        Map<String, Summoner> summonerList = leagueAPI.getSummoners(Region.EUW, "jungle ís life", "irelia is life", "PurPurr");
//        summonerList.forEach((name, summoner) -> {
//            try {
//                System.out.println(summoner.getName());
//                summoner.getLeagueEntry().forEach((x,y ) -> {
//                    y.forEach(leagueEntry -> System.out.println(leagueEntry.getName()));
//                });
//            } catch (DataException e) {
//                e.printStackTrace();
//            } catch (WrongRequestFormatException e) {
//                e.printStackTrace();
//            } catch (ReplyException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        });
    }
}
