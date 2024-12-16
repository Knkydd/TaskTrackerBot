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
    public final static Integer LIMIT_LEVEL_FOR_CHAPEL_OF_LAST_HOPE = 3;
    public final static Integer LIMIT_LEVEL_FOR_CHURCH = 3;

    public final static Map<String, Integer> LIST_LIMITS = new HashMap<>();

    public final static Map<String, Map<String, Integer>> RESOURCES_FOR_BUILD = new HashMap<>();
    public final static Map<String, Map<Integer, Map<String, Integer>>> RESOURCES_FOR_UPGRADE = new HashMap<>();

    public final static Map<Integer, Map<String, Integer>> RESOURCES_FOR_TOWN_HALL_UPGRADE = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_TOWN_HALL_UPGRADE_1 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_TOWN_HALL_UPGRADE_2 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_TOWN_HALL_UPGRADE_3 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_TOWN_HALL_UPGRADE_4 = new HashMap<>();

    public final static Map<String, Integer> RESOURCES_FOR_QUARRY_BUILD = new HashMap<>();
    public final static Map<Integer, Map<String, Integer>> RESOURCES_FOR_QUARRY_UPGRADE = new HashMap<>();

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

    public final static Map<String, Integer> RESOURCES_FOR_CHAPEL_OF_LAST_HOPE_BUILD = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_CHAPEL_OF_LAST_HOPE_UPGRADE_1 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_CHAPEL_OF_LAST_HOPE_UPGRADE_2 = new HashMap<>();
    public final static Map<String, Integer> RESOURCES_FOR_CHAPEL_OF_LAST_HOPE_UPGRADE_3 = new HashMap<>();


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
        LIST_LIMITS.put(ConstantDB.USER_CHAPEL_OF_LAST_HOPE, LIMIT_LEVEL_FOR_CHAPEL_OF_LAST_HOPE);
        LIST_LIMITS.put(ConstantDB.USER_CHURCH, LIMIT_LEVEL_FOR_CHURCH);

        RESOURCES_FOR_QUARRY_BUILD.put("Wood", 30);
        RESOURCES_FOR_QUARRY_BUILD.put("Gold", 500);
        RESOURCES_FOR_QUARRY_BUILD.put("Stone", 20);
        RESOURCES_FOR_QUARRY_BUILD.put("Food", 0);

        RESOURCES_FOR_TRADE_BUILD_BUILD.put("Wood",20);
        RESOURCES_FOR_TRADE_BUILD_BUILD.put("Gold",500);
        RESOURCES_FOR_TRADE_BUILD_BUILD.put("Stone",10);
        RESOURCES_FOR_TRADE_BUILD_BUILD.put("Food",0);

        RESOURCES_FOR_MAGE_TOWN_BUILD.put("Wood", 100);
        RESOURCES_FOR_MAGE_TOWN_BUILD.put("Gold", 1000);
        RESOURCES_FOR_MAGE_TOWN_BUILD.put("Stone", 150);
        RESOURCES_FOR_MAGE_TOWN_BUILD.put("Food", 0);

        RESOURCES_FOR_CHAPEL_OF_LAST_HOPE_BUILD.put("Wood", 40);
        RESOURCES_FOR_CHAPEL_OF_LAST_HOPE_BUILD.put("Gold", 400);
        RESOURCES_FOR_CHAPEL_OF_LAST_HOPE_BUILD.put("Stone", 25);
        RESOURCES_FOR_CHAPEL_OF_LAST_HOPE_BUILD.put("Food", 0);

        RESOURCES_FOR_CHURCH_BUILD.put("Wood", 40);
        RESOURCES_FOR_CHURCH_BUILD.put("Gold", 800);
        RESOURCES_FOR_CHURCH_BUILD.put("Stone", 100);
        RESOURCES_FOR_CHURCH_BUILD.put("Food", 0);

        RESOURCES_FOR_SHOOTING_RANGE_BUILD.put("Wood", 30);
        RESOURCES_FOR_SHOOTING_RANGE_BUILD.put("Gold", 30);
        RESOURCES_FOR_SHOOTING_RANGE_BUILD.put("Stone", 30);
        RESOURCES_FOR_SHOOTING_RANGE_BUILD.put("Food", 0);

        RESOURCES_FOR_BUILD.put(ConstantDB.USER_QUARRY, RESOURCES_FOR_QUARRY_BUILD);
        RESOURCES_FOR_BUILD.put(ConstantDB.USER_TRADE_BUILD, RESOURCES_FOR_TRADE_BUILD_BUILD);
        RESOURCES_FOR_BUILD.put(ConstantDB.USER_MAGE_TOWER, RESOURCES_FOR_MAGE_TOWN_BUILD);
        RESOURCES_FOR_BUILD.put(ConstantDB.USER_CHURCH, RESOURCES_FOR_CHURCH_BUILD);
        RESOURCES_FOR_BUILD.put(ConstantDB.USER_SHOOTING_RANGE, RESOURCES_FOR_SHOOTING_RANGE_BUILD);
        RESOURCES_FOR_BUILD.put(ConstantDB.USER_CHAPEL_OF_LAST_HOPE, RESOURCES_FOR_CHAPEL_OF_LAST_HOPE_BUILD);


        RESOURCES_FOR_TOWN_HALL_UPGRADE_1.put("Wood", 50);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_1.put("Gold", 500);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_1.put("Stone", 30);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_1.put("Food", 0);

        RESOURCES_FOR_TOWN_HALL_UPGRADE_2.put("Wood", 100);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_2.put("Gold", 700);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_2.put("Stone", 70);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_2.put("Food", 0);

        RESOURCES_FOR_TOWN_HALL_UPGRADE_3.put("Wood", 150);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_3.put("Gold", 1000);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_3.put("Stone", 120);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_3.put("Food", 0);

        RESOURCES_FOR_TOWN_HALL_UPGRADE_4.put("Wood", 250);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_4.put("Gold", 1500);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_4.put("Stone", 200);
        RESOURCES_FOR_TOWN_HALL_UPGRADE_4.put("Food", 0);

        RESOURCES_FOR_TOWN_HALL_UPGRADE.put(1,RESOURCES_FOR_TOWN_HALL_UPGRADE_1);
        RESOURCES_FOR_TOWN_HALL_UPGRADE.put(2,RESOURCES_FOR_TOWN_HALL_UPGRADE_2);
        RESOURCES_FOR_TOWN_HALL_UPGRADE.put(3,RESOURCES_FOR_TOWN_HALL_UPGRADE_3);
        RESOURCES_FOR_TOWN_HALL_UPGRADE.put(4,RESOURCES_FOR_TOWN_HALL_UPGRADE_4);
        RESOURCES_FOR_UPGRADE.put(ConstantDB.USER_TOWN_HALL,RESOURCES_FOR_TOWN_HALL_UPGRADE);





    }








}