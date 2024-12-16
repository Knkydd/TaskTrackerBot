package TelegramBot.bot.logic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Resources {
    public static String resourceMessage(Map<String, Integer> resources) {
        String msg = String.format("Ресурсы, которые у вас есть: " +
                "\nЕда: %s\n" +
                "Дерево: %s\n" +
                "Золото: %s\n" +
                "Камень: %s\n", resources.get("Food"), resources.get("Wood"), resources.get("Gold"), resources.get("Stone"));
        return msg;
    }

    public static boolean checkResourcesOnSpending(Map<String, Integer> resources, Map<String, Integer> expendedResources) {
        Set<String> resourcesKeys = resources.keySet();
        Iterator iterator = resourcesKeys.iterator();
        while (iterator.hasNext()) {
            Object temp = iterator.next();
            if (resources.get(temp) < expendedResources.get(temp)) {
                return false;
            }
        }
        return true;
    }

    public static Map<String, Integer> updateResources(Map<String, Integer> resources, Map<String, Integer> expendedResources) {
        Map<String, Integer> updatedResources = new HashMap<>();
        Set<String> resourcesKeys = resources.keySet();
        Iterator iterator = resourcesKeys.iterator();
        while (iterator.hasNext()) {
            String temp = (String) iterator.next();
            Integer value = resources.get(temp) - expendedResources.get(temp);
            updatedResources.put(temp, value);
        }

        return updatedResources;
    }
}
