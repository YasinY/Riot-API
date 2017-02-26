package com.yasinyazici.riot.data.summoner;

import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.currentgame.CurrentGameInfo;
import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.PropertyNotFound;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.data.game.Season;
import com.yasinyazici.riot.data.staticdata.Region;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsRanked;
import com.yasinyazici.riot.data.summoner.ranked.league.LeagueEntry;
import com.yasinyazici.riot.data.summoner.runes.RunePages;
import com.yasinyazici.riot.parsers.impl.*;
import com.yasinyazici.riot.request.types.impl.ApiRequestType;
import com.yasinyazici.riot.request.types.impl.RegionalRequestType;
import com.yasinyazici.riot.request.web.RequestCreator;
import com.yasinyazici.riot.request.web.RequestProperty;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Yasin on 08.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Summoner {

    private Region region;

    private final int id;

    private final String name;

    private final int profileIconId;

    private final int summonerLevel;

    private final long revisionDate;

    public Summoner(Region region, int id, String name, int profileIconId, int summonerLevel, long revisionDate) {
        this.region = region;
        this.id = id;
        this.name = name;
        this.profileIconId = profileIconId;
        this.summonerLevel = summonerLevel;
        this.revisionDate = revisionDate;
    }

    public ChampionMastery getChampionMastery(int championId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionMasteryParser(RequestCreator.create(new RequestProperty(RegionalRequestType.GET_CHAMPION_MASTERY, region.getShortCode(), region.getPlatformId(), id, championId))).get();
    }

    public Map<String, RunePages> getRunes() throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new RunesParser(RequestCreator.create(new RequestProperty(ApiRequestType.GET_SUMMONER_RUNES_BY_ID, region.getShortCode(), id))).get();
    }

    public ChampionStatsRanked getChampionStatsRanked(Season season) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionStatsRankedParser(RequestCreator.create(new RequestProperty(ApiRequestType.GET_CHAMPION_STATS_BY_SUMMONER_ID, region.getShortCode(), id, season.getSeasonName()))).get();
    }
    public LeagueEntry getFirstLeagueEntry() throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new LeagueEntryParser(RequestCreator.create(new RequestProperty(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID, region.getShortCode(), id))).getFirstLeagueEntry();
    }

    public synchronized CurrentGameInfo getActiveGame() throws PropertyNotFound, DataException, WrongRequestFormatException, ReplyException, IOException {
        return new CurrentGameInfoParser(RequestCreator.create(new RequestProperty(RegionalRequestType.GET_CURRENT_GAME, region.getShortCode(), region.getPlatformId(), id))).get();
    }


    public Region getRegion() {
        return region;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public long getRevisionDate() {
        return revisionDate;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
