package TelegramBot.bot;

import TelegramBot.bot.logic.UserStateRepository;
import TelegramBot.data.DatabaseConnection;
import TelegramBot.data.DatabaseTools;
import TelegramBot.utility.EditMessage;
import TelegramBot.utility.MessageSender;
import TelegramBot.utility.keyboard.Keyboard;

public class BotUtils {
    private final DatabaseTools databaseTools;
    private final DatabaseConnection dbConnection;
    private final MessageSender messageSender;
    private final UserStateRepository userStateRepository;
    private final EditMessage editMessage;
    private final Keyboard keyboard;

    public BotUtils(MessageSender messageSender) {
        dbConnection = new DatabaseConnection();
        this.messageSender = messageSender;
        databaseTools = dbConnection.getDatabaseTools();
        userStateRepository = new UserStateRepository();
        editMessage = new EditMessage();
        keyboard = new Keyboard();
    }

    public DatabaseTools getDatabaseTools() {
        return databaseTools;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public EditMessage getEditMessage() {
        return editMessage;
    }

    public MessageSender getMessageSender() {
        return messageSender;
    }

    public UserStateRepository getUserStateRepository() {
        return userStateRepository;
    }

    public DatabaseConnection getDbConnection() {
        return dbConnection;
    }
}
