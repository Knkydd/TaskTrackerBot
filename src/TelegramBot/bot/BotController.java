package TelegramBot.bot;

import TelegramBot.bot.logic.*;
import TelegramBot.data.DatabaseConnection;
import TelegramBot.utility.*;
import TelegramBot.utility.keyboard.ConstantKB;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BotController {
    private final MessageSender messageSender;
    private final BotUtils botUtils;
    private final DatabaseConnection dbConnection;
    private final UserStateRepository userStateRepository;
    private final Commands commands;

    public BotController(TelegramLongPollingBot bot) {
        messageSender = new MessageSender(bot);
        botUtils = new BotUtils(messageSender);
        dbConnection = botUtils.getDbConnection();
        userStateRepository = botUtils.getUserStateRepository();
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
        if (text.equalsIgnoreCase("/start")) {
            TriConsumer<Long, Integer, String> command = commands.getCommand("/start");
            command.accept(chatID, 0, "");

        }
    }

    private void handleCallbackData(Update update) {
        long chatID = update.getCallbackQuery().getMessage().getChatId();
        String callbackData = update.getCallbackQuery().getData();
        Integer messageID = update.getCallbackQuery().getMessage().getMessageId();
        String username = update.getCallbackQuery().getFrom().getUserName();
        if (callbackData.equalsIgnoreCase(ConstantKB.CALLBACK_BACK_BUTTON)) {
            callbackData = userStateRepository.getState(chatID);
        }
        try {
            TriConsumer<Long, Integer, String> command = commands.getCommand(callbackData);
            command.accept(chatID, messageID, username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
