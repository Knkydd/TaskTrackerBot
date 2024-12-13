package TelegramBot.bot;

import java.util.Map;

public class GameLogic {
    public static String gameMessage(Map<String, Integer> resources) {
        String msg = String.format("Ресурсы: " +
                "\nЕда: %s\n" +
                "Дерево: %s\n" +
                "Золото: %s", resources.get("Food"), resources.get("Wood"), resources.get("Gold"));
        return msg;
    }

}
