package TelegramBot.utility;


import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Keyboard {
    public static SendMessage sendInlineKeyboard(long chatID) {
        SendMessage message = new SendMessage();
        message.setChatId(chatID);
        message.setText("Добро пожаловать!");

        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsKeyboard = new ArrayList<>();
        List<InlineKeyboardButton> rowsKeyboard1 = new ArrayList<>();
        InlineKeyboardButton inlineButton = new InlineKeyboardButton();
        inlineButton.setText("Начать");
        inlineButton.setCallbackData("startGame");
        rowsKeyboard1.add(inlineButton);
        rowsKeyboard.add(rowsKeyboard1);
        keyboard.setKeyboard(rowsKeyboard);
        message.setReplyMarkup(keyboard);

        return message;
    }
    public static SendMessage sendCustomKeyboard(long chatID){
        SendMessage message = new SendMessage();
        message.setText("");
        message.setChatId(chatID);

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("/start");
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);
        return message;
    }
}
