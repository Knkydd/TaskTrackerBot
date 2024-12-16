package TelegramBot.bot.logic;

import TelegramBot.data.ConstantDB;
import TelegramBot.utility.ConstantBuildUp;
import TelegramBot.utility.ConstantResourcesForBuilds;
import TelegramBot.utility.keyboard.ConstantKB;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Builds {
    public static String buildsMessage(Map<String, Integer> builds) {
        String message = "Постройки, которые у вас есть: \n";
        Set<String> buildsKeys = builds.keySet();
        Iterator iterator = buildsKeys.iterator();
        while (iterator.hasNext()) {
            String temp = (String) iterator.next();
            String tempMessage = "";
            if (!builds.get(temp).equals(0)) {
                tempMessage = String.format("%s:    Уровень %s\n", ConstantDB.accordanceListOfBuilds.get(temp), builds.get(temp));
                message = message + tempMessage;
            }
        }
        return message;
    }

    public static String upgradeBuildsMessage(Map<String, Integer> builds) {
        String message = "Постройки, которые вы можете улучшить: \n";
        Set<String> buildsKeys = builds.keySet();
        Iterator iteratorBuildsKeys = buildsKeys.iterator();
        int i = 1;
        while (iteratorBuildsKeys.hasNext()) {
            String temp = (String) iteratorBuildsKeys.next();
            String tempMessage = "";
            if(builds.get(temp) + 1 > ConstantResourcesForBuilds.LIST_LIMITS.get(temp)){
                tempMessage = String.format("%s:      %s(Максимум)\n", i, ConstantDB.accordanceListOfBuilds.get(temp));
            } else if (builds.get(temp).equals(0)){
                continue;
            } else {
                tempMessage = String.format("%s:     %s     Уровень %s -> Уровень %s \n",
                        i, ConstantDB.accordanceListOfBuilds.get(temp), builds.get(temp), builds.get(temp)+1);

            }
            message += tempMessage;
            i++;
        }
        return message;
    }

    public static boolean checkUpgradeBuilds(Map<String, Integer> builds, String build) {
        if(builds.get(build) >= ConstantResourcesForBuilds.LIST_LIMITS.get(build)){
            return false;
        }
        return true;
    }

    public static Map<String, Integer> upgradeBuilds(Map<String, Integer> builds, String build) {
        builds.put(build, builds.get(build)+1);
        return builds;
    }

    public static String upbuildBuildsMessage(Map<String, Integer> builds) {
        String message = "Постройки, которые вы можете построить:\n";
        Set<String> buildsKeys = builds.keySet();
        buildsKeys.remove(ConstantDB.USER_TOWN_HALL);
        buildsKeys.remove(ConstantDB.USER_BARRACKS);
        buildsKeys.remove(ConstantDB.USER_FARM);
        buildsKeys.remove(ConstantDB.USER_SAWMILL);
        int i = 1;
        Iterator iteratorBuildsKeys = buildsKeys.iterator();
        while (iteratorBuildsKeys.hasNext()) {
            String temp = (String) iteratorBuildsKeys.next();
            String tempMessage = String.format("%s  %s  \n", i, ConstantDB.accordanceListOfBuilds.get(temp));
            if (!builds.get(temp).equals(0)) {
                tempMessage += "(Построено)\n";
            }
            message += tempMessage;
            i++;
        }
        return message;
    }

    public static boolean checkUpbuildBuilds(Map<String, Integer> builds, String build) {
        if (!builds.get(build).equals(0)) {
            return false;
        }
        return true;
    }

    public static Map<String, Integer> upbuildBuilds(Map<String, Integer> builds, String build) {
        builds.put(build, 1);
        return builds;
    }
}
