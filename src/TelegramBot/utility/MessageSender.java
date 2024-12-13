package TelegramBot.utility;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MessageSender {
    private final SendMessage newMessage;
    private final TelegramLongPollingBot bot;

    public MessageSender(TelegramLongPollingBot bot) {
        newMessage = new SendMessage();
        this.bot = bot;
    }

    public void send(long chatID, SendMessage message) {
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void send(long chatID, EditMessageText message) {
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void send(long chatID, String Text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatID);
        message.setText(Text);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
