package com.yasinyazici.riot;

import com.yasinyazici.riot.data.champion.ChampionImage;
import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.data.masteries.MasteryData;
import com.yasinyazici.riot.data.runes.RuneData;
import com.yasinyazici.riot.data.staticdata.StaticResources;
import com.yasinyazici.riot.data.summoner.masteries.MasteryPages;
import com.yasinyazici.riot.parsers.impl.*;
import com.yasinyazici.riot.data.currentgame.CurrentGameInfo;
import com.yasinyazici.riot.data.champion.ChampionStats;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.exceptions.PropertyNotFound;
import com.yasinyazici.riot.data.game.Season;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsRanked;
import com.yasinyazici.riot.data.summoner.ranked.league.LeagueEntry;
import com.yasinyazici.riot.data.summoner.runes.RunePages;
import com.yasinyazici.riot.request.types.impl.ApiRequestType;
import com.yasinyazici.riot.request.types.impl.GlobalRequestType;
import com.yasinyazici.riot.request.types.impl.RegionalRequestType;
import com.yasinyazici.riot.request.web.RequestCreator;
import com.yasinyazici.riot.data.staticdata.Region;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Yasin on 17.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class LeagueAPI {

    protected RequestCreator requestCreator = new RequestCreator();

    protected StaticResources staticResources = new StaticResources(); //TODO SUMMONER CHAMPION LOCAL RESOURCE ACCESS ~~~

    public synchronized String[] getGameVersions(Region region) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(GlobalRequestType.GET_GAME_VERSIONS);
        requestCreator.getRequestProperty().setParameters(region.getShortCode());
        return new GameVersionParser(requestCreator.create().getResponseMessage()).get();
    }
    public synchronized String getLatestGameVersion(Region region) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(GlobalRequestType.GET_GAME_VERSIONS);
        requestCreator.getRequestProperty().setParameters(region.getShortCode());
        return new GameVersionParser(requestCreator.create().getResponseMessage()).get()[0];
    }

    public synchronized ChampionMastery getChampionMastery(Region region, long summonerId, long championId) throws PropertyNotFound, DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(RegionalRequestType.GET_CHAMPION_MASTERY);
        requestCreator.getRequestProperty().setParameters(region.getShortCode(), region.getPlatformId(), summonerId, championId);
        return new ChampionMasteryParser(requestCreator.create().getResponseMessage()).get();
    }

    public synchronized List<ChampionMastery> getChampionMasteries(Region region, long summonerId) throws PropertyNotFound, DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(RegionalRequestType.GET_ALL_CHAMPION_MASTERIES);
        requestCreator.getRequestProperty().setParameters(region.getShortCode(), region.getPlatformId(), summonerId);
        return new ChampionMasteriesParser(requestCreator.create().getResponseMessage()).get();
    }
    public synchronized Summoner getSummoner(Region region, String summonerName) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_SUMMONER_DATA_BY_NAMES);
        requestCreator.getRequestProperty().setParameters(region.getShortCode(), summonerName);
        Summoner summoner = new SummonerParser(requestCreator.create().getResponseMessage()).getFirstEntry();
        summoner.setRegion(region);
        return summoner;
    }

    public synchronized List<Summoner> getSummoners(Region region, String... summonerNames) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_SUMMONER_DATA_BY_NAMES);
        requestCreator.getRequestProperty().setParameters(region.getShortCode(), summonerNames);
        return new SummonerParser(requestCreator.create().getResponseMessage()).get().entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public synchronized ChampionStats getChampionInfo(Region region, long championId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(GlobalRequestType.GET_CHAMPION_INFO_BY_CHAMPION_ID);
        requestCreator.getRequestProperty().setParameters(region.getShortCode(), championId);
        return new ChampionInfoParser(requestCreator.create().getResponseMessage()).get();
    }

    public synchronized ChampionImage getChampionImage(Region region, long championId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(GlobalRequestType.GET_CHAMPION_IMAGE_BY_CHAMPION_ID);
        requestCreator.getRequestProperty().setParameters(region.getShortCode(), championId);
        return new ChampionImageParser(requestCreator.create().getResponseMessage()).get();
    }

    public synchronized String getImageUrl(Region region, long championId) throws ReplyException, DataException, IOException, WrongRequestFormatException {
        return "http://ddragon.leagueoflegends.com/cdn/" + getLatestGameVersion(region) + "/img/champion/" + getChampionImage(region, championId).getChampionImageData().getFull();
    }

    public synchronized CurrentGameInfo getActiveGame(Region region, long summonerId) throws PropertyNotFound, DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(RegionalRequestType.GET_CURRENT_GAME);
        requestCreator.getRequestProperty().setParameters(region.getShortCode(), region.getPlatformId(), summonerId);
        return new CurrentGameInfoParser(requestCreator.create().getResponseMessage()).get();
    }

    public synchronized ChampionStatsRanked getChampionStatsRanked(Region region, long summonerId, Season season) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_CHAMPION_STATS_BY_SUMMONER_ID);
        requestCreator.getRequestProperty().setParameters(region.getShortCode(), summonerId, season.getSeasonName());
        return new ChampionStatsRankedParser(requestCreator.create().getResponseMessage()).get();
    }
    public synchronized Map<String, List<LeagueEntry>> getLeagueEntries(Region region, long  summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID);
        requestCreator.getRequestProperty().setParameters(region.getShortCode(), summonerId);
        return new LeagueEntryParser(requestCreator.create().getResponseMessage()).get();
    }
    public synchronized LeagueEntry getLeagueEntry(Region region, long summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID);
        requestCreator.getRequestProperty().setParameters(region.getShortCode(), summonerId);
        return new LeagueEntryParser(requestCreator.create().getResponseMessage()).getFirstLeagueEntry();
    }
    public synchronized Map<String, MasteryPages> getMasteryPages(Region region, long ... summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_SUMMONER_MASTERIES_BY_IDS);
        requestCreator.getRequestProperty().setParameters(region.getShortCode(), summonerId);
        return new MasteriesParser(requestCreator.create().getResponseMessage()).get();
    }
    public synchronized Map<String, RunePages> getRunes(Region region, long ... summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_SUMMONER_RUNES_BY_ID);
        requestCreator.getRequestProperty().setParameters(region.getShortCode(), summonerId);
        return new RunesParser(requestCreator.create().getResponseMessage()).get();
    }

    public synchronized MasteryData getMasteryData(int masteryId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return staticResources.getMasteryData(masteryId);
    }
    public synchronized RuneData getRune(int runeId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return staticResources.getRuneData(runeId);
    }



    public StaticResources getStaticResources() {
        return staticResources;
    }
}
