package com.yasinyazici.riot;

import com.sun.scenario.effect.ImageData;
import com.yasinyazici.riot.data.champion.ChampionImage;
import com.yasinyazici.riot.data.champion.ChampionStatsStatic;
import com.yasinyazici.riot.data.champion.impl.ChampionData;
import com.yasinyazici.riot.data.champion.impl.ChampionImageData;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.currentgame.CurrentGameInfo;
import com.yasinyazici.riot.data.exceptions.DataException;
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
import com.yasinyazici.riot.data.summoner.runes.RunePages;
import com.yasinyazici.riot.parsers.impl.*;
import com.yasinyazici.riot.request.handler.Response;
import com.yasinyazici.riot.request.types.RequestType;
import com.yasinyazici.riot.request.types.impl.ApiRequestType;
import com.yasinyazici.riot.request.types.impl.GlobalRequestType;
import com.yasinyazici.riot.request.types.impl.RegionalRequestType;
import com.yasinyazici.riot.request.web.Request;
import com.yasinyazici.riot.request.web.RequestCreator;
import com.yasinyazici.riot.request.web.RequestProperty;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * <p>Offers different kind of requests based on what is mostly demanded. Please note that yet not all features of the official REST-API from yet been implemented.</p>
 *
 * @author Yasin
 */
public class LeagueAPI {

    /**
     * The class containing static data essential for loading data locally
     */
    private StaticResources staticResources = new StaticResources();

    /**
     * The region the league api should perform requests in
     */
    private Region region;

    /**
     * The game version league of legends currently is versioned with
     */
    private String gameVersion;

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
        setGameVersion();
    }

    private void setGameVersion() {
        try {
            this.gameVersion = getLatestGameVersion();
        } catch (DataException | WrongRequestFormatException | ReplyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Grabs the first {@link String} element of {@link #getGameVersions()} which is equally the newest game version of league of legends (the game)</p>
     *
     * @return a String parsed by {@link GameVersionParser#get()}
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     * @see Response reference for all request responses
     * @see #getGameVersions() for further information about the request type
     */
    private synchronized String getLatestGameVersion() throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return getGameVersions()[0];
    }

    /**
     * <p>Creates a new request within the context of getting all game versions declared within constructing a new {@link RequestProperty} instance. <!-- -->
     * Used as interface for {@link #getLatestGameVersion()} ()} and uses {@link GlobalRequestType#GET_GAME_VERSIONS} as reference for the {@link Request}</p>
     *
     * @return a multi-dimensional (2d) {@link String} array containing all game versions
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    private synchronized String[] getGameVersions() throws
            DataException, WrongRequestFormatException, ReplyException, IOException {
        return new GameVersionParser(RequestCreator.createRequest(new RequestProperty(GlobalRequestType.GET_GAME_VERSIONS, region.getShortCode()))).get();
    }

    /**
     * <p>Gets the champion mastery for a {@link Summoner}. <!-- -->Uses {@link RegionalRequestType#GET_CHAMPION_MASTERY} as reference for the {@link Request}.</p>
     *
     * @param summonerId the summoner id to get the champion mastery for
     * @param championId the champion id to get the champion mastery for
     * @return a new {@link ChampionMastery} instance which got parsed by it's corresponding parser ({@link ChampionMasteryParser})
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public synchronized ChampionMastery getChampionMastery(long summonerId, long championId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionMasteryParser(RequestCreator.createRequest(new RequestProperty(RegionalRequestType.GET_CHAMPION_MASTERY, region.getShortCode(), region.getPlatformId(), summonerId, championId))).get();
    }

    /**
     * <p>Gets all champion masteries for a {@link Summoner}. <!-- --> Uses {@link RegionalRequestType#GET_ALL_CHAMPION_MASTERIES} as reference for the {@link Request}.</p>
     *
     * @param summonerId the summoner id (later accessed by {@link Summoner#getId()}) to get the champion masteries for
     * @return a new {@link ChampionMastery} instance in a {@link List} which got parsed by it's corresponding parser ({@link ChampionMasteriesParser})
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public synchronized List<ChampionMastery> getChampionMasteries(long summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionMasteriesParser(RequestCreator.createRequest(new RequestProperty(RegionalRequestType.GET_ALL_CHAMPION_MASTERIES, region.getShortCode(), region.getPlatformId(), summonerId))).get();
    }

    /**
     * <p>Requests a {@link Summoner} by its summoner name. <!-- -->Creates a Request using {@link #getSummoners(String...)}, but only passing one parameter so therefore only one entry is being returned (if found). </p>
     *
     * @param summonerName the {@link Summoner} to look up
     * @return a new instance of {@link Summoner} if the data has been found
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     * @see #getSummoners(String...)
     */
    public synchronized Summoner getSummoner(String summonerName) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        if (summonerName.length() == 0) {
            throw new DataException("Summoner name can't be nothing");
        }
        Summoner summoner = getSummoners(summonerName).entrySet().stream().filter(entry -> entry.getValue().getName().equalsIgnoreCase(summonerName)).findAny().orElseGet(null).getValue();
        summoner.setRegion(region);
        return summoner;
    }

    /**
     * <p>Requests multiple {@link Summoner}'s by their summoner names. <!-- --> Uses {@link ApiRequestType#GET_SUMMONER_DATA_BY_NAMES} as reference for the {@link Request}</p>
     *
     * @param summonerNames the summoner names to look up
     * @return new {@link Map} instance, which offers both the Summoner name as {@link String} (key) and the {@link Summoner} itself (value) for accessing the data.
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public synchronized Map<String, Summoner> getSummoners(String... summonerNames) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        Map<String, Summoner> summoners = new SummonerParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_SUMMONER_DATA_BY_NAMES, region.getShortCode(), summonerNames))).get();
        summoners.entrySet().forEach(entry -> entry.getValue().setRegion(region));
        return summoners;
    }

    /**
     * <p>Retrieves data <b>from the official REST-API of Riot</b> for a champion which, for instance, can be used to represent the champion played for a player. <!-- -->
     * Uses {@link GlobalRequestType#GET_CHAMPION_INFO_BY_CHAMPION_ID} as reference for the {@link Request}</p>
     *
     * @param championId the champion id to get the data for
     * @return a new {@link ChampionStatsStatic} instance representing the data of the champion
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public synchronized ChampionStatsStatic getChampionStats(long championId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionInfoParser(RequestCreator.createRequest(new RequestProperty(GlobalRequestType.GET_CHAMPION_INFO_BY_CHAMPION_ID, region.getShortCode(), championId))).get();
    }

    /**
     * <p>Retrieves data <b>from the official REST-API of Riot</b>, optionally offering image data for the champion. <!-- -->
     * Uses {@link GlobalRequestType#GET_CHAMPION_IMAGE_BY_CHAMPION_ID} as reference for the {@link Request}</p>
     *
     * @param championId the champion id to identify the champion the data is being requested for
     * @return a new {@link ChampionImage} instance representing champion data, including image data
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public synchronized ChampionImage getChampionData(long championId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionImageParser(RequestCreator.createRequest(new RequestProperty(GlobalRequestType.GET_CHAMPION_IMAGE_BY_CHAMPION_ID, region.getShortCode(), championId))).get();
    }

    /**
     * <p>Puts together an always up-to-date image url for a champion by the given champion id.</p>
     *
     * @param championId the champion id to generate the url for
     * @return a new {@link String} containing the generated url
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public synchronized String getImageUrl(long championId) throws ReplyException, DataException, IOException, WrongRequestFormatException {
        return "http://ddragon.leagueoflegends.com/cdn/" + gameVersion + "/img/champion/" + getChampionData(championId).getChampionImageData().getFull();
    }

    /**
     * <p>Puts together animage url for a champion from the given champion data. <!-- --> Hence {@link ChampionImageData} is given as parameter, it's not guaranteed that the data is correct and/or working
     * as it can be even a custom instance being passed.</p>
     *
     * @return a new {@link String} containing the generated url
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public synchronized String getImageUrl(ChampionImage championData) throws ReplyException, DataException, IOException, WrongRequestFormatException {
        return "http://ddragon.leagueoflegends.com/cdn/" + gameVersion + "/img/champion/" + championData.getChampionImageData().getFull();
    }

    /**
     * <p>Gets an actively running game the summoner (identified by the summoner id given) is currently in and offers corresponding data about it. <!-- -->
     * Uses {@link RegionalRequestType#GET_CURRENT_GAME} as reference for the {@link Request}</p>
     *
     * @param summonerId the required summoner id to look if the summoner is in an active game
     * @return a new {@link CurrentGameInfo} instance if the summoner is ingame
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     * @see CurrentGameInfo as reference for reviewing what kind of data is being represented
     */
    public synchronized CurrentGameInfo getActiveGame(long summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new CurrentGameInfoParser(RequestCreator.createRequest(new RequestProperty(RegionalRequestType.GET_CURRENT_GAME, region.getShortCode(), region.getPlatformId(), summonerId))).get();
    }

    /**
     * <p>Get the performance/statistics of all champions the summoner (identified by the summoner id) has, filtered by {@link Season}. <!-- -->
     * Uses {@link ApiRequestType#GET_CHAMPION_STATS_BY_SUMMONER_ID} as reference for the {@link Request}</p>
     *
     * @param summonerId the summoner id to look the statistics up for
     * @param season     the season the summoner was in while playing the champions
     * @return a new {@link ChampionStatsRanked} representing all relevant statistics
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public synchronized ChampionStatsRanked getChampionStatsRanked(long summonerId, Season season) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionStatsRankedParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_CHAMPION_STATS_BY_SUMMONER_ID, region.getShortCode(), summonerId, season.getSeasonName()))).get();
    }

    /**
     * <p>Get the performance/statistics of a specific champion the summoner (identified by the summoner id) has played, filtered by {@link Season} by using {@link #getChampionStatsRanked(long, Season)} and filtering with a {@link Stream} by champion id given. <!-- -->
     *
     * @param summonerId the summoner id to look the statistics up for
     * @param championId the champion id to filter the statistics for
     * @param season     the season the summoner was in while playing the champions
     * @return a new {@link ChampionStatsRanked} representing all relevant statistics
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     * @see #getChampionStatsRanked(long, Season) for reference on what {@link RequestType} is being used
     * //TODO UPDATE!!!
     */
    public synchronized ChampionStats getChampionStatsRanked(long summonerId, long championId, Season season) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return getChampionStatsRanked(summonerId, season).getChampionStatsSummary().stream().filter(championStatsSummary -> championId == championStatsSummary.getId()).findAny().orElse(null).getChampionStats();
    }

    /**
     * <p>Gets all kind of league entries (representing rank, state of league etc.) from a specified summoner (identified by a summoner id). <!-- -->
     * Uses {@link ApiRequestType#GET_LEAGUE_ENTRY_BY_SUMMONER_ID} as reference for the {@link Request}</p>
     *
     * @param summonerId the summoner id used for identifying the summoner the league entries are being requested for
     * @return a new {@link Map} instance containing the summoner's name as key and a {@link List} of league entries
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public synchronized Map<String, List<LeagueEntry>> getLeagueEntries(long summonerId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new LeagueEntryParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID, region.getShortCode(), summonerId))).get();
    }

    /**
     * <p>Gets a {@link LeagueEntry} for a given {@link QueueType}, representing rank, state of league etc.<!-- --> from a specified summoner which gets identified by summoner id. <!-- -->
     * Uses {@link ApiRequestType#GET_LEAGUE_ENTRY_BY_SUMMONER_ID} as reference for the {@link Request}</p>
     *
     * @param summonerId the summoner id to identify the summoner with and get the league entry for
     * @param queueType  the queue type to filter the league entry after
     * @return a new {@link LeagueEntry instance}
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public synchronized LeagueEntry getLeagueEntry(long summonerId, QueueType queueType) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new LeagueEntryParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID, region.getShortCode(), summonerId))).getLeagueEntryByQueueType(queueType);
    }

    /**
     * <p>Gets mastery pages for different {@link Summoner}'s, identified and grabbed by their summoner ids</p>
     *
     * @param summonerIds the summoner ids to identify the summoners with so the {@link MasteryPages} can be grabbed
     * @return a new {@link Map} containing each summoner name as {@link String} (Key) and {@link MasteryPages} (Value)
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public synchronized Map<String, MasteryPages> getMasteryPages(long... summonerIds) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new MasteriesParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_SUMMONER_MASTERIES_BY_IDS, region.getShortCode(), summonerIds))).get();
    }

    /**
     * <p>Gets rune pages for different {@link Summoner}'s, identified and grabbed by their summoner ids</p>
     *
     * @param summonerIds the summoner ids to identify the summoners with so the {@link RunePages} can be grabbed
     * @return a new {@link Map} instance containing each summoner name as {@link String} (key) and {@link RunePages} (value)
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public synchronized Map<String, RunePages> getRunes(long... summonerIds) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new RunesParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_SUMMONER_RUNES_BY_ID, region.getShortCode(), summonerIds))).get();
    }


    /**
     * <p>Locally loads mastery data to spare requests to the official Riot REST-API</p>
     *
     * @param masteryId the mastery id to locally grab the data for
     * @return a new {@link MasteryData} instance representing the data of the mastery which has been found (by mastery id)
     */
    public synchronized MasteryData getMasteryData(int masteryId) {
        return staticResources.getMasteryData(masteryId);
    }

    /**
     * <p>Locally loads rune data to spare requests to the official Riot REST-API</p>
     *
     * @param runeId the rune id to get the rune data for
     * @return a new {@link RuneData} instance representing the data of the found rune (by rune id)
     */
    public synchronized RuneData getRuneData(int runeId) {
        return staticResources.getRuneData(runeId);
    }

    public String getGameVersion() {
        return gameVersion;
    }
}
