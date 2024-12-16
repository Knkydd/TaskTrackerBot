package TelegramBot.utility;

import TelegramBot.data.ConstantDB;

import java.util.HashMap;
import java.util.Map;

public class ConstantResourcesForBuilds {
    public final static Integer LIMIT_LEVEL_FOR_TOWN_HALL = 4;
    public final static Integer LIMIT_LEVEL_FOR_QUARRY = 5;
    public final static Integer LIMIT_LEVEL_FOR_SAWMILL = 5;
    public final static Integer LIMIT_LEVEL_FOR_FARM = 4;
    public final static Integer LIMIT_LEVEL_FOR_TRADE_BUILD = 4;
    public final static Integer LIMIT_LEVEL_FOR_BARRACKS = 3;
    public final static Integer LIMIT_LEVEL_FOR_MAGE_TOWER = 3;
    public final static Integer LIMIT_LEVEL_FOR_SHOOTING_RANGE = 3;
    public final static Integer LIMIT_LEVEL_FOR_CHURCH_OF_LAST_HOPE = 3;
    public final static Integer LIMIT_LEVEL_FOR_CHURCH = 3;

    public final static Map<String, Integer> LIST_LIMITS = new HashMap<>();

    public final static Map<String, Integer> RESOURCES_FOR_TOWN_HALL_UPGRADE_1 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_TOWN_HALL_UPGRADE_2 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_TOWN_HALL_UPGRADE_3 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_TOWN_HALL_UPGRADE_4 = new HashMap<>();

    public final static Map<String, Integer> RESOURCES_FOR_QUARRY_BUILD = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_QUARRY_UPGRADE_1 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_QUARRY_UPGRADE_2 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_QUARRY_UPGRADE_3 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_QUARRY_UPGRADE_4 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_QUARRY_UPGRADE_5 = new HashMap<>();

    public final static Map<String, Integer> RESOURCES_FOR_SAWMILL_UPGRADE_1 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_SAWMILL_UPGRADE_2 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_SAWMILL_UPGRADE_3 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_SAWMILL_UPGRADE_4 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_SAWMILL_UPGRADE_5 = new HashMap<>();

    public final static Map<String, Integer> RESOURCES_FOR_FARM_UPGRADE_1 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_FARM_UPGRADE_2 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_FARM_UPGRADE_3 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_FARM_UPGRADE_4 = new HashMap<>();

    public final static Map<String, Integer> RESOURCES_FOR_TRADE_BUILD_BUILD = new HashMap<>(); //калабур build_build (постройка_построить)
    public final static Map<String, Integer> RESOURCES_FOR_TRADE_BUILD_UPGRADE_1 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_TRADE_BUILD_UPGRADE_2 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_TRADE_BUILD_UPGRADE_3 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_TRADE_BUILD_UPGRADE_4 = new HashMap<>();

    public final static Map<String, Integer> RESOURCES_FOR_BARRACKS_UPGRADE_1 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_BARRACKS_UPGRADE_2 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_BARRACKS_UPGRADE_3 = new HashMap<>();

    public final static Map<String, Integer> RESOURCES_FOR_MAGE_TOWN_BUILD = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_MAGE_TOWN_UPGRADE_1 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_MAGE_TOWN_UPGRADE_2 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_MAGE_TOWN_UPGRADE_3 = new HashMap<>();

    public final static Map<String, Integer> RESOURCES_FOR_SHOOTING_RANGE_BUILD = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_SHOOTING_RANGE_UPGRADE_1 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_SHOOTING_RANGE_UPGRADE_2 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_SHOOTING_RANGE_UPGRADE_3 = new HashMap<>();

    public final static Map<String, Integer> RESOURCES_FOR_CHURCH_OF_LAST_HOPE_BUILD = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_CHURCH_OF_LAST_HOPE_UPGRADE_1 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_CHURCH_OF_LAST_HOPE_UPGRADE_2 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_CHURCH_OF_LAST_HOPE_UPGRADE_3 = new HashMap<>();

    public final static Map<String, Integer> RESOURCES_FOR_CHURCH_BUILD = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_CHURCH_UPGRADE_1 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_CHURCH_UPGRADE_2 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_CHURCH_UPGRADE_3 = new HashMap<>();

    static{
        LIST_LIMITS.put(ConstantDB.USER_TOWN_HALL, LIMIT_LEVEL_FOR_TOWN_HALL);
        LIST_LIMITS.put(ConstantDB.USER_QUARRY, LIMIT_LEVEL_FOR_QUARRY);
        LIST_LIMITS.put(ConstantDB.USER_SAWMILL, LIMIT_LEVEL_FOR_SAWMILL);
        LIST_LIMITS.put(ConstantDB.USER_FARM, LIMIT_LEVEL_FOR_FARM);
        LIST_LIMITS.put(ConstantDB.USER_TRADE_BUILD, LIMIT_LEVEL_FOR_TRADE_BUILD);
        LIST_LIMITS.put(ConstantDB.USER_BARRACKS, LIMIT_LEVEL_FOR_BARRACKS);
        LIST_LIMITS.put(ConstantDB.USER_MAGE_TOWER, LIMIT_LEVEL_FOR_MAGE_TOWER);
        LIST_LIMITS.put(ConstantDB.USER_SHOOTING_RANGE, LIMIT_LEVEL_FOR_SHOOTING_RANGE);
        LIST_LIMITS.put(ConstantDB.USER_CHURCH_OF_LAST_HOPE, LIMIT_LEVEL_FOR_CHURCH_OF_LAST_HOPE);
        LIST_LIMITS.put(ConstantDB.USER_CHURCH, LIMIT_LEVEL_FOR_CHURCH);


        RESOURCES_FOR_TOWN_HALL_UPGRADE_1.put("Wood", 50);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_1.put("Gold", 500);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_1.put("Stone", 30);

        RESOURCES_FOR_TOWN_HALL_UPGRADE_2.put("Wood", 100);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_2.put("Gold", 700);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_2.put("Stone", 70);

        RESOURCES_FOR_TOWN_HALL_UPGRADE_3.put("Wood", 150);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_3.put("Gold", 1000);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_3.put("Stone", 120);

        RESOURCES_FOR_CHURCH_BUILD.put("Wood", 40);
        RESOURCES_FOR_CHURCH_BUILD.put("Gold", 800);
        RESOURCES_FOR_CHURCH_BUILD.put("Stone", 100);

    }








}