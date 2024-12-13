package TelegramBot.bot;

import TelegramBot.data.DatabaseConnection;
import TelegramBot.utility.ConstantsMessages;
import TelegramBot.utility.keyboard.ConstantKB;
import TelegramBot.utility.EditMessage;
import TelegramBot.utility.keyboard.Keyboard;
import TelegramBot.utility.MessageSender;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;


public class BotController {
    private final MessageSender messageSender;
    private final DatabaseConnection dbConnection;

    public BotController(TelegramLongPollingBot bot) {
        messageSender = new MessageSender(bot);
        dbConnection = new DatabaseConnection();
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
        }
    }


    public void handleCallbackData(Update update) {
        long chatID = update.getCallbackQuery().getMessage().getChatId();
        String callbackData = update.getCallbackQuery().getData();
        Integer messageID = update.getCallbackQuery().getMessage().getMessageId();
        String username = update.getCallbackQuery().getFrom().getUserName();
        if (Arrays.asList(ConstantKB.listCallbackData).contains(callbackData)) {
            switch (callbackData) {
                case ConstantKB.CALLBACK_START_BUTTON:
                    if (!dbConnection.getDatabaseTools().isRegistered(chatID)) {
                        dbConnection.getDatabaseTools().registrationUser(chatID, username);
                        messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData));
                    } else {
                        messageSender.send(chatID, EditMessage.messageEdit(chatID,messageID, ConstantsMessages.CHECK_REGISTRATION_MESSAGE,1));
                    }
                    break;
                case ConstantKB.CALLBACK_CONTINUE_BUTTON:
                    if (dbConnection.getDatabaseTools().isRegistered(chatID)) {
                        messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData));
                    } else {
                        messageSender.send(chatID, EditMessage.messageEdit(chatID,messageID, ConstantsMessages.CHECK_CONTINUE_MESSAGE,1));
                        break;
                    }

            }
        }
    }


}
