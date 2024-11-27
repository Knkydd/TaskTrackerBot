package TelegramBot.bot;

import TelegramBot.utility.Keyboard;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class KingdomBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "KingdomBot";
    }

    @Override
    public String getBotToken() {
        return Token.readToken();
    }

    public void sendMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(long chatID, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatID);
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatID = update.getMessage().getChatId();
            if (messageText.equalsIgnoreCase("/start")) {
                sendMessage(Keyboard.sendStartKeyboard(chatID));
            } else {
                sendMsg(chatID, "Извините, команда не распознана.");
            }
        }
        if (update.hasCallbackQuery()) {
            long chatID = update.getCallbackQuery().getMessage().getChatId();
            String call_data = update.getCallbackQuery().getData();
            if (call_data.equalsIgnoreCase("startGame")) {
                Game.initializationUser(chatID);
            }
        }

    }
}