package com.yasinyazici.riot.data.summoner;

import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.currentgame.CurrentGameInfo;
import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.data.game.Season;
import com.yasinyazici.riot.data.staticdata.Region;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsRanked;
import com.yasinyazici.riot.data.summoner.ranked.league.LeagueEntry;
import com.yasinyazici.riot.data.summoner.ranked.league.QueueType;
import com.yasinyazici.riot.data.summoner.runes.RunePages;
import com.yasinyazici.riot.parsers.impl.*;
import com.yasinyazici.riot.request.handler.Response;
import com.yasinyazici.riot.request.types.impl.ApiRequestType;
import com.yasinyazici.riot.request.types.impl.RegionalRequestType;
import com.yasinyazici.riot.request.web.Request;
import com.yasinyazici.riot.request.web.RequestCreator;
import com.yasinyazici.riot.request.web.RequestProperty;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>Represents a single summoner and his properties</p>
 *
 * @author Yasin
 */
public class Summoner {

    private Region region;

    private final long id;

    private final String name;

    private final long profileIconId;

    private final int summonerLevel;

    private final long revisionDate;

    /**
     * Creates a new instance of {@link Summoner}
     *
     * @param region        the region to place the summoner in
     * @param id            the id of the summoner
     * @param name          the name of the summoner
     * @param profileIconId the id of the current profile icon the summoner has set
     * @param summonerLevel the latest known summoner level of the summoner
     * @param revisionDate  the date of revision of the summoner
     */
    public Summoner(Region region, int id, String name, int profileIconId, int summonerLevel, long revisionDate) {
        this.region = region;
        this.id = id;
        this.name = name;
        this.profileIconId = profileIconId;
        this.summonerLevel = summonerLevel;
        this.revisionDate = revisionDate;
    }

    /**
     * <p>Gets the champion mastery for this summoner (identified by the locally defined id). <!-- -->Uses {@link RegionalRequestType#GET_CHAMPION_MASTERY} as reference for the {@link Request}.</p>
     *
     * @param championId the champion id to get the champion mastery for
     * @return a new {@link ChampionMastery} instance which got parsed by it's corresponding parser ({@link ChampionMasteryParser})
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public ChampionMastery getChampionMastery(int championId) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionMasteryParser(RequestCreator.createRequest(new RequestProperty(RegionalRequestType.GET_CHAMPION_MASTERY, region.getShortCode(), region.getPlatformId(), id, championId))).parse();
    }

    /**
     * <p>Gets rune pages for the current summoner identified and grabbed by the locally defined summoner id.</p>
     *
     * @return a new {@link Map} instance containing each summoner name as {@link String} (key) and {@link RunePages} (value)
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public Map<String, RunePages> getRunes() throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new RunesParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_SUMMONER_RUNES_BY_ID, region.getShortCode(), id))).parse();
    }

    /**
     * <p>Get the performance/statistics of all champions the summoner (identified by the locally defined summoner id) owns, filtered by {@link Season}. <!-- -->
     * Uses {@link ApiRequestType#GET_CHAMPION_STATS_BY_SUMMONER_ID} as reference for the {@link Request}</p>
     *
     * @param season the season the summoner was in while playing the champions
     * @return a new {@link ChampionStatsRanked} representing all relevant statistics
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public ChampionStatsRanked getChampionStatsRanked(Season season) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new ChampionStatsRankedParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_CHAMPION_STATS_BY_SUMMONER_ID, region.getShortCode(), id, season.getSeasonName()))).parse();
    }

    /**
     * <p>Gets all kind of league entries (representing rank, state of league etc.) from a specified summoner (identified by summoner id locally defined). <!-- -->
     * Uses {@link ApiRequestType#GET_LEAGUE_ENTRY_BY_SUMMONER_ID} as reference for the {@link Request}</p>
     *
     * @return a new {@link Map} instance containing the summoner's name as key and a {@link List} of league entries
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public Map<String, List<LeagueEntry>> getLeagueEntries() throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new LeagueEntryParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID, region.getShortCode(), id))).parse();
    }

    /**
     * <p>Gets a {@link LeagueEntry} for a given {@link QueueType}, representing rank, state of league etc.<!-- --> from a specified summoner which gets identified by summoner id. <!-- -->
     * Uses {@link ApiRequestType#GET_LEAGUE_ENTRY_BY_SUMMONER_ID} as reference for the {@link Request}</p>
     *
     * @param queueType the queue type to filter the league entry after
     * @return a new {@link LeagueEntry instance}
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     */
    public synchronized LeagueEntry getLeagueEntry(QueueType queueType) throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new LeagueEntryParser(RequestCreator.createRequest(new RequestProperty(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID, region.getShortCode(), id))).getLeagueEntryByQueueType(queueType);
    }

    /**
     * <p>Gets an actively running game the summoner (identified by the local summoner id) is currently in and offers corresponding data about it. <!-- -->
     * Uses {@link RegionalRequestType#GET_CURRENT_GAME} as reference for the {@link Request}</p>
     *
     * @return a new {@link CurrentGameInfo} instance if the summoner is ingame
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with Riot's official REST-API
     * @see CurrentGameInfo as reference for reviewing what kind of data is being represented
     */
    public synchronized CurrentGameInfo getActiveGame() throws DataException, WrongRequestFormatException, ReplyException, IOException {
        return new CurrentGameInfoParser(RequestCreator.createRequest(new RequestProperty(RegionalRequestType.GET_CURRENT_GAME, region.getShortCode(), region.getPlatformId(), id))).parse();
    }


    /**
     * Gets the region of the summoner
     *
     * @return the region the summoner currently is located at
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Gets the id of the summoner
     *
     * @return the id the summoner has
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the name of the summoner
     *
     * @return the name of the summoner represented as String
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the id of the icon the summoner has currently set
     *
     * @return the profile icon id
     */
    public long getProfileIconId() {
        return profileIconId;
    }

    /**
     * Gets the level of the summoner
     *
     * @return the summoner level
     */
    public int getSummonerLevel() {
        return summonerLevel;
    }

    /**
     * Gets the revision date of the summoner
     *
     * @return the revision date
     */
    public long getRevisionDate() {
        return revisionDate;
    }

    /**
     * Sets the region of the summoner so he can be identified
     *
     * @param region the region to place the summoner in
     */
    public void setRegion(Region region) {
        this.region = region;
    }
}
