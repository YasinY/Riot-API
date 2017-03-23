package com.yasinyazici.riot;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.yasinyazici.riot.config.Config;
import com.yasinyazici.riot.data.champion.ChampionImage;
import com.yasinyazici.riot.data.champion.ChampionStatsStatic;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.currentgame.CurrentGameInfo;
import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.PropertyNotFoundException;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.data.game.Season;
import com.yasinyazici.riot.data.masteries.MasteryData;
import com.yasinyazici.riot.data.runes.RuneData;
import com.yasinyazici.riot.data.staticdata.Region;
import com.yasinyazici.riot.data.staticdata.StaticResources;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.masteries.MasteryPages;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStats;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsRanked;
import com.yasinyazici.riot.data.summoner.ranked.league.LeagueEntry;
import com.yasinyazici.riot.data.summoner.ranked.league.QueueType;
import com.yasinyazici.riot.data.summoner.runes.Runes;
import com.yasinyazici.riot.parsers.impl.*;
import com.yasinyazici.riot.request.handler.Response;
import com.yasinyazici.riot.request.types.impl.ApiRequestType;
import com.yasinyazici.riot.request.types.impl.GlobalRequestType;
import com.yasinyazici.riot.request.types.impl.RegionalRequestType;
import com.yasinyazici.riot.request.web.RequestCreator;
import com.yasinyazici.riot.request.web.RequestProperty;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Created by Yasin on 17.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class LeagueAPI {

    private StaticResources staticResources = new StaticResources();

    private Region region;

    /**
     * <p>Creates a new {@link LeagueAPI} instance</p>
     *
     * @param region the region to forward the requests (made within the class) to
     * @see ApiRequestType
     * @see GlobalRequestType
     * @see RegionalRequestType
     */
    public LeagueAPI(Region region) {
        this.region = region;
        updateVersion();
    }

    /**
     * <p>Updates the version of the API so any kind of request in context with game version
     * can access the latest version locally (spares requests)</p>
     *
     * @see #getLatestGameVersion()
     */
    private void updateVersion() {
        try {
            File versionFile = getLocalVersionFile();
            String content = getLocalVersion();
            String latestVersion = retrieveLatestGameVersion();
            if (!content.equalsIgnoreCase(latestVersion)) { //so if empty or different game version
                Files.write(latestVersion.getBytes(), versionFile);
            }
        } catch (IOException | WrongRequestFormatException | ReplyException | DataException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Gets the local version file so it can be accessed interacted with
     * Used for version checking</p>
     *
     * @return a {@link File} instance representing the InputStream {@link Config#VERSION_FILE}
     */
    private File getLocalVersionFile() {
        try {
            return Paths.get(Config.VERSION_FILE.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new File("");
    }

    /**
     * <p>Grabs the local version generated by {@link #updateVersion()}</p>
     *
     * @return a string containing the local version or an empty string
     */
    private String getLocalVersion() {
        try {
            return getLocalVersionFile() != null ? Files.toString(getLocalVersionFile(), Charsets.UTF_8) : "";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * <p>Grabs the first {@link String} element of {@link #getGameVersions()} which is equally the newest element</p>
     *
     * @return a String parsed by {@link GameVersionParser#get()}
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     * @see Response reference for all request responses
     */
    private synchronized String retrieveLatestGameVersion() throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return getGameVersions()[0];
    }

    /**
     * <p>Creates a new request within the context of getting all game versions declared within constructing a new {@link RequestProperty} instance. <!-- -->
     * Used as interface for {@link #retrieveLatestGameVersion()} and uses {@link GlobalRequestType#GET_GAME_VERSIONS} as base for the request</p>
     *
     * @return a multi-dimensional (2d) {@link String} array containing all game versions
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    private synchronized String[] getGameVersions() throws
            DataException, WrongRequestFormatException, ReplyException, IOException {
        return new GameVersionParser(RequestCreator.createRequest(new RequestProperty(GlobalRequestType.GET_GAME_VERSIONS, region.getShortCode()))).get();
    }

    /**
     * <p>Grabs the latest game version either stored locally (generated by method {@link #updateVersion()}), unless
     * the string returned is empty. <!-- --> If that is the case, a request is being made through {@link #retrieveLatestGameVersion()}</p>
     *
     * @return a String containing the version of the game itself
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized String getLatestGameVersion() throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return !getLocalVersion().isEmpty() ? getLocalVersion() : retrieveLatestGameVersion();
    }

    /**
     * <p>Gets the champion mastery for a {@link Summoner} by creating a Request with the Type {@link RegionalRequestType#GET_CHAMPION_MASTERY}</p>
     *
     * @param summonerId the summoner id to get the champion mastery for
     * @param championId the champion id to get the champion mastery for
     * @return a new {@link ChampionMastery} instance which got parsed by it's parser ({@link ChampionMasteryParser}
     * @throws PropertyNotFoundException   thrown when the champion mastery has not been found for the given summoner
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized ChampionMastery getChampionMastery(long summonerId, long championId) throws PropertyNotFoundException, DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionMasteryParser(RequestCreator.createRequest(new RequestProperty(RegionalRequestType.GET_CHAMPION_MASTERY, region.getShortCode(), region.getPlatformId(), summonerId, championId))).get();
    }

    /**
     * @param summonerId
     * @return
     * @throws PropertyNotFoundException   thrown when the champion mastery has not been found for the given summoner
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized List<ChampionMastery> getChampionMasteries(long summonerId) throws PropertyNotFoundException, DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionMasteriesParser(RequestCreator.createRequest(new RequestProperty(RegionalRequestType.GET_ALL_CHAMPION_MASTERIES, region.getShortCode(), region.getPlatformId(), summonerId))).get();
    }

    /**
     * @param summonerName
     * @return
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized Summoner getSummoner(String summonerName) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        if (summonerName.length() == 0) {
            throw new DataException("Summoner name can't be nothing");
        }
        Summoner summoner = new SummonerParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_SUMMONER_DATA_BY_NAMES, region.getShortCode(), summonerName))).getFirstEntry();
        summoner.setRegion(region);
        return summoner;
    }

    /**
     * @param summonerNames
     * @return
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized Map<String, Summoner> getSummoners(String... summonerNames) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        Map<String, Summoner> summoners = new SummonerParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_SUMMONER_DATA_BY_NAMES, region.getShortCode(), summonerNames))).get();
        summoners.entrySet().forEach(entry -> entry.getValue().setRegion(region));
        return summoners;
    }

    /**
     * @param championId
     * @return
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized ChampionStatsStatic getChampionStats(long championId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionInfoParser(RequestCreator.createRequest(new RequestProperty(GlobalRequestType.GET_CHAMPION_INFO_BY_CHAMPION_ID, region.getShortCode(), championId))).get();
    }

    /**
     * @param championId
     * @return
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized ChampionImage getChampionImage(long championId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionImageParser(RequestCreator.createRequest(new RequestProperty(GlobalRequestType.GET_CHAMPION_IMAGE_BY_CHAMPION_ID, region.getShortCode(), championId))).get();
    }

    /**
     * @param championId
     * @return
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized String getImageUrl(long championId) throws ReplyException, DataException, IOException, WrongRequestFormatException {
        return "http://ddragon.leagueoflegends.com/cdn/" + getLatestGameVersion() + "/img/champion/" + getChampionData(championId).getChampionImageData().getFull();
    }

    /**
     * <p>Gets an actively running game the summoner (identified by the summoner id given) is currently in and offers corresponding data. </p>
     * @param summonerId
     * @return
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized CurrentGameInfo getActiveGame(long summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new CurrentGameInfoParser(RequestCreator.createRequest(new RequestProperty(RegionalRequestType.GET_CURRENT_GAME, region.getShortCode(), region.getPlatformId(), summonerId))).get();
    }

    /**
     * <p>Get champion statistics of the g</p>
     * @param summonerId
     * @param season
     * @return
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized ChampionStatsRanked getChampionStatsRanked(long summonerId, Season season) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionStatsRankedParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_CHAMPION_STATS_BY_SUMMONER_ID, region.getShortCode(), summonerId, season.getSeasonName()))).get();
    }

    /**
     * @param summonerId
     * @param championId
     * @param season
     * @return
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized ChampionStats getChampionStatsRanked(long summonerId, long championId, Season season) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionStatsRankedParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_CHAMPION_STATS_BY_SUMMONER_ID, region.getShortCode(), summonerId, season.getSeasonName()))).getStatsForChampion(championId);
    }

    /**
     * @param summonerId
     * @return
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized Map<String, List<LeagueEntry>> getLeagueEntries(long summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new LeagueEntryParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID, region.getShortCode(), summonerId))).get();
    }

    /**
     * @param summonerId
     * @param queueType
     * @return
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized LeagueEntry getLeagueEntry(long summonerId, QueueType queueType) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new LeagueEntryParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID, region.getShortCode(), summonerId))).getLeagueEntryByQueueType(queueType);
    }

    /**
     * @param summonerId
     * @return
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized LeagueEntry getLeagueEntry(long summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new LeagueEntryParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID, region.getShortCode(), summonerId))).getFirstLeagueEntry();
    }

    /**
     * @param summonerId
     * @return
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized Map<String, MasteryPages> getMasteryPages(long... summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new MasteriesParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_SUMMONER_MASTERIES_BY_IDS, region.getShortCode(), summonerId))).get();
    }

    /**
     * @param summonerId
     * @return
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-api
     */
    public synchronized Map<String, Runes> getRunes(long... summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new RunesParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_SUMMONER_RUNES_BY_ID, region.getShortCode(), summonerId))).get();
    }

    /**
     * @param championId
     * @return
     */
    public synchronized ChampionImage getChampionData(long championId) {
        return staticResources.getChampionData(championId);
    }

    /**
     * @param masteryId
     * @return
     */
    public synchronized MasteryData getMasteryData(int masteryId) {
        return staticResources.getMasteryData(masteryId);
    }

    /**
     * @param runeId
     * @return
     */
    public synchronized RuneData getRuneData(int runeId) {
        return staticResources.getRuneData(runeId);
    }


    /**
     * @return
     */
    public StaticResources getStaticResources() {
        return staticResources;
    }
}
