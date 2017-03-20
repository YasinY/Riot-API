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
import com.yasinyazici.riot.request.web.RequestProperty;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Yasin on 17.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class LeagueAPI {

    private StaticResources staticResources = new StaticResources(); //TODO SUMMONER CHAMPION LOCAL RESOURCE ACCESS ~~~

    public synchronized String[] getGameVersions(Region region) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new GameVersionParser(RequestCreator.create(new RequestProperty(GlobalRequestType.GET_GAME_VERSIONS, region.getShortCode()))).get();
    }
    public synchronized String getLatestGameVersion(Region region) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new GameVersionParser(RequestCreator.create(new RequestProperty(GlobalRequestType.GET_GAME_VERSIONS, region.getShortCode()))).get()[0];
    }

    public synchronized ChampionMastery getChampionMastery(Region region, long summonerId, long championId) throws PropertyNotFound, DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionMasteryParser(RequestCreator.create(new RequestProperty(RegionalRequestType.GET_CHAMPION_MASTERY, region.getShortCode(), region.getPlatformId(), summonerId, championId))).get();
    }

    public synchronized List<ChampionMastery> getChampionMasteries(Region region, long summonerId) throws PropertyNotFound, DataException, WrongRequestFormatException, ReplyException, IOException {
       return new ChampionMasteriesParser(RequestCreator.create(new RequestProperty(RegionalRequestType.GET_ALL_CHAMPION_MASTERIES, region.getShortCode(), region.getPlatformId(), summonerId))).get();
    }

    /**
     *
     * @param region
     * @param summonerName
     * @return
     * @throws DataException
     * @throws WrongRequestFormatException
     * @throws ReplyException
     * @throws IOException
     */
    public synchronized Summoner getSummoner(Region region, String summonerName) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        if(summonerName.length() == 0) {
            throw new DataException("Summoner name can't be nothing");
        }
        Summoner summoner = new SummonerParser(RequestCreator.create(new RequestProperty(ApiRequestType.GET_SUMMONER_DATA_BY_NAMES, region.getShortCode(), summonerName))).getFirstEntry();
        summoner.setRegion(region);
        return summoner;
    }

    public synchronized Map<String, Summoner> getSummoners(Region region, String... summonerNames) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        Map<String, Summoner> summoners = new SummonerParser(RequestCreator.create(new RequestProperty(ApiRequestType.GET_SUMMONER_DATA_BY_NAMES, region.getShortCode(), summonerNames))).get();
        summoners.entrySet().forEach(entry -> entry.getValue().setRegion(region));
        return summoners;
    }

    public synchronized ChampionStats getChampionInfo(Region region, long championId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionInfoParser(RequestCreator.create(new RequestProperty(GlobalRequestType.GET_CHAMPION_INFO_BY_CHAMPION_ID, region.getShortCode(), championId))).get();
    }

    public synchronized ChampionImage getChampionImage(Region region, long championId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
       return new ChampionImageParser(RequestCreator.create(new RequestProperty(GlobalRequestType.GET_CHAMPION_IMAGE_BY_CHAMPION_ID, region.getShortCode(), championId))).get();
    }

    public synchronized String getImageUrl(Region region, long championId) throws ReplyException, DataException, IOException, WrongRequestFormatException {
        return "http://ddragon.leagueoflegends.com/cdn/" + getLatestGameVersion(region) + "/img/champion/" + getChampionData(championId).getChampionImageData().getFull();
    }

    public synchronized CurrentGameInfo getActiveGame(Region region, long summonerId) throws PropertyNotFound, DataException, WrongRequestFormatException, ReplyException, IOException {
       return new CurrentGameInfoParser(RequestCreator.create(new RequestProperty(RegionalRequestType.GET_CURRENT_GAME, region.getShortCode(), region.getPlatformId(), summonerId))).get();
    }

    public synchronized ChampionStatsRanked getChampionStatsRanked(Region region, long summonerId, Season season) throws DataException, WrongRequestFormatException, ReplyException, IOException {
       return new ChampionStatsRankedParser(RequestCreator.create(new RequestProperty(ApiRequestType.GET_CHAMPION_STATS_BY_SUMMONER_ID, region.getShortCode(), summonerId, season.getSeasonName()))).get();
    }
    public synchronized Map<String, List<LeagueEntry>> getLeagueEntries(Region region, long  summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new LeagueEntryParser(RequestCreator.create(new RequestProperty(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID, region.getShortCode(), summonerId))).get();
    }
    public synchronized LeagueEntry getLeagueEntry(Region region, long summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new LeagueEntryParser(RequestCreator.create(new RequestProperty(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID, region.getShortCode(), summonerId))).getFirstLeagueEntry();
    }
    public synchronized Map<String, MasteryPages> getMasteryPages(Region region, long ... summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new MasteriesParser(RequestCreator.create(new RequestProperty(ApiRequestType.GET_SUMMONER_MASTERIES_BY_IDS, region.getShortCode(), summonerId))).get();
    }
    public synchronized Map<String, RunePages> getRunes(Region region, long ... summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new RunesParser(RequestCreator.create(new RequestProperty(ApiRequestType.GET_SUMMONER_RUNES_BY_ID, region.getShortCode(), summonerId))).get();
    }

    public synchronized ChampionImage getChampionData(long championId) {
        return staticResources.getChampionData(championId);
    }
    public synchronized MasteryData getMasteryData(int masteryId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return staticResources.getMasteryData(masteryId);
    }
    public synchronized RuneData getRuneData(int runeId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return staticResources.getRuneData(runeId);
    }



    public StaticResources getStaticResources() {
        return staticResources;
    }
}
