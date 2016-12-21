package com.yasinyazici.riot.data.summoner.ranked;

import java.util.List;

/**
 * Created by Yasin on 21.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionStatsRanked {

    private long modifyDate;

    private List<ChampionStatsSummary> champions;

    private long summonerId;

    public ChampionStatsRanked(long modifyDate, List<ChampionStatsSummary> champions, long summonerId) {
        this.modifyDate = modifyDate;
        this.champions = champions;
        this.summonerId = summonerId;
    }

    public long getModifyDate() {
        return modifyDate;
    }


    public List<ChampionStatsSummary> getChampions() {
        return champions;
    }

    public long getSummonerId() {
        return summonerId;
    }
}
