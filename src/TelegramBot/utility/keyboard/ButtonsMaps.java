package TelegramBot.utility.keyboard;

import TelegramBot.data.ConstantDB;
import TelegramBot.utility.ConstantBuildUp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ButtonsMaps {
    public final static Map<String, String> startButtons = new LinkedHashMap<>();
    public final static Map<String, String> gameButtons = new LinkedHashMap<>();
    public final static Map<String, String> actionsButtons = new LinkedHashMap<>();
    public final static Map<String, String> oneBackButton = new LinkedHashMap<>();
    public final static Map<String, String> buildMenuButtons = new LinkedHashMap<>();
    public final static Map<String, String> upgradeButtons = new LinkedHashMap<>();
    public final static Map<String, String> upbuildButtons = new LinkedHashMap<>();


    static {
        startButtons.put(ConstantKB.START_BUTTON, ConstantKB.CALLBACK_START_BUTTON);
        startButtons.put(ConstantKB.CONTINUE_BUTTON, ConstantKB.CALLBACK_CONTINUE_BUTTON);
        startButtons.put(ConstantKB.LEADERBOARD_BUTTON, ConstantKB.CALLBACK_LEADERBOARD_BUTTON);

        gameButtons.put(ConstantKB.BUILDS_BUTTON, ConstantKB.CALLBACK_BUILDS_BUTTON);
        gameButtons.put(ConstantKB.ACTIONS_BUTTON, ConstantKB.CALLBACK_ACTION_BUTTON);
        gameButtons.put(ConstantKB.ARMY_BUTTON, ConstantKB.CALLBACK_ARMY_BUTTON);
        gameButtons.put(ConstantKB.BACK_BUTTON, ConstantKB.CALLBACK_BACK_BUTTON);

        buildMenuButtons.put(ConstantKB.UPBUILD_BUILD_BUTTON, ConstantKB.CALLBACK_UPBUILD_BUILD_BUTTON);
        buildMenuButtons.put(ConstantKB.UPGRADE_BUILD_BUTTON, ConstantKB.CALLBACK_UPGRADE_BUILD_BUTTON);
        buildMenuButtons.put(ConstantKB.BACK_BUTTON, ConstantKB.CALLBACK_BACK_BUTTON);

        oneBackButton.put(ConstantKB.BACK_BUTTON, ConstantKB.CALLBACK_BACK_BUTTON);

        actionsButtons.put(ConstantKB.ATTACK_BUTTON, ConstantKB.CALLBACK_ATTACK_BUTTON);
        actionsButtons.put(ConstantKB.NEXT_MOVE_BUTTON, ConstantKB.CALLBACK_NEXT_MOVE_BUTTON);
        actionsButtons.put(ConstantKB.BACK_BUTTON, ConstantKB.CALLBACK_BACK_BUTTON);

        upgradeButtons.put(ConstantDB.SHOOTING_RANGE, ConstantBuildUp.USER_SHOOTING_RANGE_UPGRADE);
        upgradeButtons.put(ConstantDB.MAGE_TOWER, ConstantBuildUp.USER_MAGE_TOWER_UPGRADE);
        upgradeButtons.put(ConstantDB.CHURCH_OF_LAST_HOPE, ConstantBuildUp.USER_CHURCH_OF_LAST_HOPE_UPGRADE);
        upgradeButtons.put(ConstantDB.BARRACKS, ConstantBuildUp.USER_BARRACKS_UPGRADE);
        upgradeButtons.put(ConstantDB.TOWN_HALL, ConstantBuildUp.USER_TOWN_HALL_UPGRADE);
        upgradeButtons.put(ConstantDB.SAWMILL, ConstantBuildUp.USER_SAWMILL_UPGRADE);
        upgradeButtons.put(ConstantDB.CHURCH, ConstantBuildUp.USER_CHURCH_UPGRADE);
        upgradeButtons.put(ConstantDB.FARM, ConstantBuildUp.USER_FARM_UPGRADE);
        upgradeButtons.put(ConstantDB.QUARRY, ConstantBuildUp.USER_QUARRY_UPGRADE);
        upgradeButtons.put(ConstantDB.TRADE_BUILD, ConstantBuildUp.USER_TRADE_BUILD_UPGRADE);
        upgradeButtons.put(ConstantKB.BACK_BUTTON, ConstantKB.CALLBACK_BACK_BUTTON);

        upbuildButtons.put(ConstantDB.SHOOTING_RANGE, ConstantBuildUp.USER_SHOOTING_RANGE_UPBUILD);
        upbuildButtons.put(ConstantDB.MAGE_TOWER, ConstantBuildUp.USER_MAGE_TOWER_UPBUILD);
        upbuildButtons.put(ConstantDB.CHURCH_OF_LAST_HOPE, ConstantBuildUp.USER_CHURCH_OF_LAST_HOPE_UPBUILD);
        upbuildButtons.put(ConstantDB.CHURCH, ConstantBuildUp.USER_CHURCH_UPBUILD);
        upbuildButtons.put(ConstantDB.TRADE_BUILD, ConstantBuildUp.USER_TRADE_BUILD_UPBUILD);
        upbuildButtons.put(ConstantDB.QUARRY, ConstantBuildUp.USER_QUARRY_UPBUILD);
        upbuildButtons.put(ConstantKB.BACK_BUTTON, ConstantKB.CALLBACK_BACK_BUTTON);

    }
}
