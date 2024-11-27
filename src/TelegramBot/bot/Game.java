package TelegramBot.bot;

import TelegramBot.user.User;

public class Game {
    public static void initializationUser(long chatId){
        User user = new User(chatId);

    }

    public static void Game(long chatID, String name){
        initializationUser(chatID);
    }
}
