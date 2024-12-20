package TelegramBot.bot.logic;

import TelegramBot.bot.BotUtils;
import TelegramBot.data.DatabaseTools;
import TelegramBot.utility.ConstantMessages;
import TelegramBot.utility.EditMessage;
import TelegramBot.utility.MessageSender;
import TelegramBot.utility.keyboard.ConstantKB;
import TelegramBot.utility.keyboard.Keyboard;

public class MainMenu {
    private final DatabaseTools databaseTools;
    private final MessageSender messageSender;
    private final UserStateRepository userStateRepository;
    private final Keyboard keyboard;
    private final EditMessage editMessage;

    public MainMenu(BotUtils botUtils) {
        databaseTools = botUtils.getDatabaseTools();
        messageSender = botUtils.getMessageSender();
        userStateRepository = botUtils.getUserStateRepository();
        keyboard = botUtils.getKeyboard();
        editMessage = botUtils.getEditMessage();
    }

    public void setMainMenu(long chatID) {
        messageSender.send(chatID, keyboard.startKeyboardMessage(chatID));
        if (userStateRepository.isEmpty()) {
            userStateRepository.setState(chatID, ConstantKB.MAIN_MENU);
        } else {
            userStateRepository.removeAll(chatID);
            userStateRepository.setState(chatID, ConstantKB.MAIN_MENU);
        }
    }

    public void setMainMenuInMSG(long chatID, Integer messageID) {
        messageSender.send(chatID, editMessage.messageEdit(chatID, messageID, ConstantKB.MAIN_MENU, ConstantMessages.START_MESSAGE));
        userStateRepository.setState(chatID, ConstantKB.MAIN_MENU);
    }

    public void mainMenuHandler(long chatID, String callbackData, Integer messageID, String username) {

        switch (callbackData) {

            case ConstantKB.MAIN_MENU:

                messageSender.send(chatID, editMessage.messageEdit(chatID, messageID, callbackData, ConstantMessages.START_MESSAGE));
                userStateRepository.setState(chatID, ConstantKB.MAIN_MENU);
                break;

            case ConstantKB.CALLBACK_START_BUTTON:

                if (!databaseTools.isRegistered(chatID)) {

                    databaseTools.registrationUser(chatID, username);
                    messageSender.send(chatID, editMessage.messageEdit(chatID, messageID, callbackData, ConstantMessages.GAME_MESSAGE + Resources.resourceMessage(databaseTools.getResources(chatID))));
                    userStateRepository.setState(chatID, ConstantKB.CALLBACK_START_BUTTON);

                } else {

                    messageSender.send(chatID, editMessage.warningMessage(chatID, messageID, ConstantMessages.CHECK_REGISTRATION_MESSAGE));

                }
                break;

            case ConstantKB.CALLBACK_CONTINUE_BUTTON:

                if (databaseTools.isRegistered(chatID)) {

                    messageSender.send(chatID, editMessage.messageEdit(chatID, messageID, callbackData, ConstantMessages.GAME_MESSAGE + Resources.resourceMessage(databaseTools.getResources(chatID))));
                    userStateRepository.setState(chatID, ConstantKB.CALLBACK_CONTINUE_BUTTON);

                } else {

                    messageSender.send(chatID, editMessage.warningMessage(chatID, messageID, ConstantMessages.CHECK_CONTINUE_MESSAGE));

                }
                break;

            case ConstantKB.CALLBACK_LEADERBOARD_BUTTON:
                messageSender.send(chatID, editMessage.messageEdit(chatID, messageID, callbackData, Leaderboard.leaderboardMessage(databaseTools.getLeaderboard())));
                userStateRepository.setState(chatID, ConstantKB.CALLBACK_LEADERBOARD_BUTTON);
                break;
        }
    }

}
