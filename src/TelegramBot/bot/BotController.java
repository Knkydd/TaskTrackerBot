package TelegramBot.bot;

import TelegramBot.data.DatabaseConnection;
import TelegramBot.utility.ConstantsMessages;
import TelegramBot.utility.EditMessage;
import TelegramBot.utility.MessageSender;
import TelegramBot.utility.keyboard.ConstantKB;
import TelegramBot.utility.keyboard.Keyboard;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;

public class BotController {
    private final MessageSender messageSender;
    private final DatabaseConnection dbConnection;
    private final UserStateRepository userStateRepository;

    public BotController(TelegramLongPollingBot bot) {
        messageSender = new MessageSender(bot);
        dbConnection = new DatabaseConnection();
        userStateRepository = new UserStateRepository();
    }

    public void updateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            try {
                handleCommands(update);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (update.hasCallbackQuery()) {
            try {
                handleCallbackData(update);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void handleCommands(Update update) {
        long chatID = update.getMessage().getChatId();
        String text = update.getMessage().getText();
        if (text.equalsIgnoreCase("/start")) {
            messageSender.send(chatID, Keyboard.startKeyboardMessage(chatID));
            userStateRepository.setState(chatID, ConstantKB.MAIN_MENU);
        }
    }

    public void handleCallbackData(Update update) {
        long chatID = update.getCallbackQuery().getMessage().getChatId();
        String callbackData = update.getCallbackQuery().getData();
        Integer messageID = update.getCallbackQuery().getMessage().getMessageId();
        String username = update.getCallbackQuery().getFrom().getUserName();
        if (callbackData.equalsIgnoreCase(ConstantKB.CALLBACK_BACK_BUTTON)) {
            callbackData = userStateRepository.getState(chatID);
        }
        if (Arrays.asList(ConstantKB.listCallbackData).contains(callbackData)) {
            switch (callbackData) {
                case ConstantKB.MAIN_MENU:
                    messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, ConstantsMessages.START_MESSAGE));
                    break;
                case ConstantKB.CALLBACK_START_BUTTON:
                    if (!dbConnection.getDatabaseTools().isRegistered(chatID)) {
                        dbConnection.getDatabaseTools().registrationUser(chatID, username);
                        messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, ConstantsMessages.GAME_MESSAGE));
                        userStateRepository.setState(chatID, ConstantKB.CALLBACK_START_BUTTON);
                    } else {
                        messageSender.send(chatID, EditMessage.warningMessage(chatID, messageID, ConstantsMessages.CHECK_REGISTRATION_MESSAGE, 1));
                    }
                    break;
                case ConstantKB.CALLBACK_CONTINUE_BUTTON:
                    if (dbConnection.getDatabaseTools().isRegistered(chatID)) {
                        messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, ConstantsMessages.GAME_MESSAGE));
                        userStateRepository.setState(chatID, ConstantKB.CALLBACK_CONTINUE_BUTTON);
                    } else {
                        messageSender.send(chatID, EditMessage.warningMessage(chatID, messageID, ConstantsMessages.CHECK_CONTINUE_MESSAGE, 1));
                    }
                    break;
                case ConstantKB.CALLBACK_LEADERBOARD_BUTTON:
                    messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, Leaderboard.leaderboardMessage(dbConnection.getDatabaseTools().getLeaderboard())));
                    userStateRepository.setState(chatID, ConstantKB.CALLBACK_LEADERBOARD_BUTTON);
                    break;
                case ConstantKB.CALLBACK_ACTION_BUTTON:
                    messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, "В разработке"));
                    userStateRepository.setState(chatID, ConstantKB.CALLBACK_ACTION_BUTTON);
                    break;
                case ConstantKB.CALLBACK_BUILDS_BUTTON:
                    messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, GameLogic.gameMessage(dbConnection.getDatabaseTools().getResources(chatID))));
                    userStateRepository.setState(chatID, ConstantKB.CALLBACK_BUILDS_BUTTON);
                    break;
                case ConstantKB.CALLBACK_NEXT_MOVE_BUTTON:
                    messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, "В разработке"));
                    userStateRepository.setState(chatID, ConstantKB.CALLBACK_NEXT_MOVE_BUTTON);
                    break;
            }
        }
    }


}
