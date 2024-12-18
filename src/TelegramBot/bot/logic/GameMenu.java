package TelegramBot.bot.logic;

import TelegramBot.bot.BotUtils;
import TelegramBot.data.DatabaseConnection;
import TelegramBot.data.DatabaseTools;
import TelegramBot.utility.EditMessage;
import TelegramBot.utility.MessageSender;
import TelegramBot.utility.keyboard.ConstantKB;

public class GameMenu {
    private DatabaseTools databaseTools;
    private MessageSender messageSender;
    private UserStateRepository userStateRepository;
    private EditMessage editMessage;

    public GameMenu(BotUtils botUtils){
        this.messageSender = botUtils.getMessageSender();
        this.databaseTools = botUtils.getDatabaseTools();
        this.userStateRepository = botUtils.getUserStateRepository();
        this.editMessage = botUtils.getEditMessage();
    }

    public void gameMenuHandler(long chatID, String callbackData, Integer messageID){
        switch (callbackData) {
            case ConstantKB.CALLBACK_ACTION_BUTTON:
                messageSender.send(chatID, editMessage.messageEdit(chatID, messageID, callbackData, "Действия: "));
                userStateRepository.setState(chatID, ConstantKB.CALLBACK_ACTION_BUTTON);
                break;

            case ConstantKB.CALLBACK_BUILDS_BUTTON:
                messageSender.send(chatID, editMessage.messageEdit(chatID, messageID, callbackData, Builds.buildsMessage(databaseTools.getBuilds(chatID))));
                userStateRepository.setState(chatID, ConstantKB.CALLBACK_BUILDS_BUTTON);
                break;
            case ConstantKB.CALLBACK_ARMY_BUTTON:
                messageSender.send(chatID, editMessage.messageEdit(chatID, messageID, callbackData, Army.armyMessage(databaseTools.getArmy(chatID), databaseTools.getArmyPower(chatID))));
                userStateRepository.setState(chatID, ConstantKB.CALLBACK_ARMY_BUTTON);
                break;
        }
    }
}
