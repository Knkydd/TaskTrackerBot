package TelegramBot.bot;

import TelegramBot.bot.logic.*;
import TelegramBot.data.DatabaseConnection;
import TelegramBot.utility.*;
import TelegramBot.utility.keyboard.ConstantKB;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.sql.SQLException;

public class BotController {
    private final MessageSender messageSender;
    private final BotUtils botUtils;
    private final DatabaseConnection dbConnection;
    private final UserStateRepository userStateRepository;
    private final Commands commands;
    private final EditMessage editMessage;

    public BotController(TelegramLongPollingBot bot) {
        messageSender = new MessageSender(bot);
        botUtils = new BotUtils(messageSender);
        dbConnection = botUtils.getDbConnection();
        userStateRepository = botUtils.getUserStateRepository();
        editMessage = botUtils.getEditMessage();
        commands = new Commands(botUtils);
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
        commands.setChatID(chatID);
        if (text.equalsIgnoreCase("/start")) {
            System.out.println(dbConnection);
            commands.getCommand("/start").run();
        }
    }

    public void handleCallbackData(Update update) {
        long chatID = update.getCallbackQuery().getMessage().getChatId();
        String callbackData = update.getCallbackQuery().getData();
        Integer messageID = update.getCallbackQuery().getMessage().getMessageId();
        String username = update.getCallbackQuery().getFrom().getUserName();
        commands.setChatID(chatID);
        commands.setUsername(username);
        commands.setMessageID(messageID);
        if (callbackData.equalsIgnoreCase(ConstantKB.CALLBACK_BACK_BUTTON)) {
            callbackData = userStateRepository.getState(chatID);
        }
        try {
            commands.getCommand(callbackData).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
