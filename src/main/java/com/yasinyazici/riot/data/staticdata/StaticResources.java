package com.yasinyazici.riot.data.staticdata;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.config.Config;
import com.yasinyazici.riot.data.masteries.MasteryData;

import java.util.Map;

/**
 * Created by Yasin on 07.02.2017
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class StaticResources {

    private Map<Integer, MasteryData> masteryList;

   public StaticResources() {
       Gson gson = new Gson();
       try {
           masteryList = gson.fromJson(Files.toString(Config.MASTERIES, Charsets.UTF_8), new TypeToken<Map<Integer, MasteryData>>() {}.getType());
       } catch(Exception e) {
           e.printStackTrace();
       }
   }

    public MasteryData getMasteryData(int masteryId) {
        return masteryList.values().stream().filter(p -> p.getId() == masteryId).findFirst().orElse(null);
    }
}
