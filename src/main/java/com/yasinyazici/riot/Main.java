package com.yasinyazici.riot;

import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.PropertyNotFound;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.data.staticdata.Region;
import com.yasinyazici.riot.data.summoner.Summoner;

import java.io.IOException;
import java.util.Map;

/**
 * @author Yasin on 11.03.2017.
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) throws ReplyException, DataException, IOException, WrongRequestFormatException, PropertyNotFound {
        LeagueAPI leagueAPI = new LeagueAPI();
        Map<String, Summoner> summonerList = leagueAPI.getSummoners(Region.EUW, "jungle ís life", "irelia is life", "PurPurr");
        summonerList.forEach((name, summoner) -> {
            try {
                summoner.getLeagueEntry().forEach((x,y ) -> {
                    y.forEach(leagueEntry -> System.out.println(leagueEntry.getName()));
                });
            } catch (DataException e) {
                e.printStackTrace();
            } catch (WrongRequestFormatException e) {
                e.printStackTrace();
            } catch (ReplyException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}
