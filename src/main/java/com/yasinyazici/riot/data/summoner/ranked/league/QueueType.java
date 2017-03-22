package com.yasinyazici.riot.data.summoner.ranked.league;

import java.util.stream.Stream;

/**
 * @author Yasin on 22.03.2017.
 * @version 1.0
 */
public enum QueueType {
    CUSTOM(0, "CUSTOM GAME"),
    NORMAL_3x3(8, "Normal 3v3"),
    NORMAL_5x5_BLIND(2, "Normal 5v5 (Blind pick)"),
    NORMAL_5x5_DRAFT(14, "Normal 5v5 (Draft pick)"),
    RANKED_SOLO_5x5(4, "Ranked 5v5 Solo"),
    RANKED_PREMADE_5x5(6, "Ranked 5v5 Duo"),
    RANKED_PREMADE_3x3(9, "Ranked 3v3"),
    RANKED_TEAM_3x3(41, "Ranked team 3v3"),
    RANKED_TEAM_5v5(42, "Ranked team 5v5"),
    ODIN_5x5_BLIND(16, "Dominion 5v5 (Blind)"),
    ODIN_5x5_DRAFT(17, "Dominion 5v5 (Draft)"),
    BOT_5x5(7, "Coop vs AI (5v5)"),
    BOT_ODIN_5x5(25, "Dominion Coop vs AI (5v5)"),
    BOT_5x5_INTRO(31, "Intro Coop vs AI"),
    BOT_5x5_BEGINNER(32, "Beginner Coop vs AI"),
    BOT_5x5_INTERMEDIATE(33, "Intermediate Coop vs AI"),
    BOT_TT_3x3(52, "Twisted Treeline Coop vs AI"),
    GROUP_FINDER_5x5(61, "Team Builder"),
    ARAM_5x5(65, "ARAM"),
    ONEFORALL_5x5(70, "One for all 5v5"),
    FIRSTBLOOD_1x1(72, "Snowdown showdown (1v1)"),
    FIRSTBLOOD_2x2(73, "Snowdown showdown (2v2)"),
    SR_6x6(75, "Hexakill (Summoners Rift)"),
    URF_5x5(76, "URF"),
    ONEFORALL_MIRRORMODE_5x5(78, "One for all (Mirror)"),
    BOT_URF_5x5(83, "URF (vs Bots)"),
    NIGHTMARE_BOT_5x5_RANK1(91, "Doom Bots of Doom - Rank 1"),
    NIGHTMARE_BOT_5x5_RANK2(92, "Doom Bots of Doom - Rank 2"),
    NIGHTMARE_BOT_5x5_RANK5(93, "Doom Bots of doom - Rank 5"),
    ASCENSION_5x5(96, "Ascension 5v5"),
    HEXAKILL(98, "Hexakill (Twisted Treeline)"),
    BILGEWATER_ARAM_5x5(100, "Butcher's Bridge"),
    KING_PORO_5x5(300, "King Poro"),
    COUNTER_PICK(310, "Nemesis"),
    BILGEWATER_5x5(313, "Black Market Brawler"),
    SIEGE(315, "Nexus Siege"),
    DEFINITELY_NOT_DOMINION_5x5(317, "Definitely not dominion"),
    ARURF_5X5(318, "AR URF"),
    TEAM_BUILDER_DRAFT_UNRANKED_5x5(400, "Normal 5v5 Draft pick"),
    TEAM_BUILDER_RANKED_SOLO(420, "Ranked Solo"),
    RANKED_FLEX_SR(440, "Ranked Flex Summoners Rift"),
    ASSASSINATE_5x5(600, "Blood Hunt");


    private int id;

    private String name;

    QueueType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static QueueType identifyQueueType(String name) {
        return Stream.of(values()).filter(queueType -> queueType.name().toLowerCase().equalsIgnoreCase(name.toLowerCase())).findFirst().orElse(null);
    }
}
