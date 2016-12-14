package com.yasinyazici.riot.data.activegame;

import com.yasinyazici.riot.data.activegame.state.ActiveGameState;
import com.yasinyazici.riot.data.activegame.properties.ActiveGameProperties;

/**
 * Created by Yasin on 14.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ActiveGame {

    private ActiveGameProperties activeGameProperties;

    private ActiveGameState activeGameState;

    public ActiveGame(ActiveGameProperties activeGameProperties, ActiveGameState activeGameState) {
        this.activeGameProperties = activeGameProperties;
        this.activeGameState = activeGameState;
    }

    public ActiveGameProperties getActiveGameProperties() {
        return activeGameProperties;
    }

    public ActiveGameState getActiveGameState() {
        return activeGameState;
    }
}
