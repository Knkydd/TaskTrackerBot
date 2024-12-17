package TelegramBot.utility;

import TelegramBot.data.ConstantDB;

import java.util.HashMap;
import java.util.Map;

public class ConstantResourcesForArmy {
    public final static Map<String, Integer> WARRIOR_GOLD_RECRUIT = new HashMap<>();
    public final static Map<String, Integer> MAGE_GOLD_RECRUIT = new HashMap<>();
    public final static Map<String, Integer> ARCHER_GOLD_RECRUIT = new HashMap<>();
    public final static Map<String, Integer> PALADIN_GOLD_RECRUIT = new HashMap<>();
    public final static Map<String, Integer> HEALER_GOLD_RECRUIT = new HashMap<>();

    public final static Map<String, Map<String, Integer>> LIST_GOLD_FOR_ARMY = new HashMap<>();

    static {
        WARRIOR_GOLD_RECRUIT.put("Wood", 0);
        WARRIOR_GOLD_RECRUIT.put("Gold", 250);
        WARRIOR_GOLD_RECRUIT.put("Stone", 0);
        WARRIOR_GOLD_RECRUIT.put("Food", 0);

        MAGE_GOLD_RECRUIT.put("Wood", 0);
        MAGE_GOLD_RECRUIT.put("Gold", 300);
        MAGE_GOLD_RECRUIT.put("Stone", 0);
        MAGE_GOLD_RECRUIT.put("Food", 0);

        ARCHER_GOLD_RECRUIT.put("Wood", 0);
        ARCHER_GOLD_RECRUIT.put("Gold", 400);
        ARCHER_GOLD_RECRUIT.put("Stone", 0);
        ARCHER_GOLD_RECRUIT.put("Food", 0);

        PALADIN_GOLD_RECRUIT.put("Wood", 0);
        PALADIN_GOLD_RECRUIT.put("Gold", 500);
        PALADIN_GOLD_RECRUIT.put("Stone", 0);
        PALADIN_GOLD_RECRUIT.put("Food", 0);

        HEALER_GOLD_RECRUIT.put("Wood", 0);
        HEALER_GOLD_RECRUIT.put("Gold", 600);
        HEALER_GOLD_RECRUIT.put("Stone", 0);
        HEALER_GOLD_RECRUIT.put("Food", 0);

        LIST_GOLD_FOR_ARMY.put(ConstantDB.USER_WARRIOR_UNIT, WARRIOR_GOLD_RECRUIT);
        LIST_GOLD_FOR_ARMY.put(ConstantDB.USER_MAGE_UNIT, MAGE_GOLD_RECRUIT);
        LIST_GOLD_FOR_ARMY.put(ConstantDB.USER_ARCHER_UNIT, ARCHER_GOLD_RECRUIT);
        LIST_GOLD_FOR_ARMY.put(ConstantDB.USER_PALADIN_UNIT, PALADIN_GOLD_RECRUIT);
        LIST_GOLD_FOR_ARMY.put(ConstantDB.USER_HEALER_UNIT, HEALER_GOLD_RECRUIT);
    }
}
