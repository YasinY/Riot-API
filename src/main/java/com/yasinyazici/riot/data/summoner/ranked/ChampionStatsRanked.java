package com.yasinyazici.riot.data.summoner.ranked;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Yasin on 21.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionStatsRanked {

    private long modifyDate;

    @SerializedName("champions")
    private List<ChampionStatsSummary> championStatsSummaries;

    private long summonerId;

    public ChampionStatsRanked(long modifyDate, List<ChampionStatsSummary> championStatsSummaries, long summonerId) {
        this.modifyDate = modifyDate;
        this.championStatsSummaries = championStatsSummaries;
        this.summonerId = summonerId;
    }

    public long getModifyDate() {
        return modifyDate;
    }


    public List<ChampionStatsSummary> getChampionStatsSummary() {
        return championStatsSummaries;
    }

    public long getSummonerId() {
        return summonerId;
    }
}
