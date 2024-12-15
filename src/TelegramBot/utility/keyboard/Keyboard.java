package TelegramBot.utility.keyboard;


import TelegramBot.utility.ConstantsMessages;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.HashMap;
import java.util.Map;

public class Keyboard {
    public static SendMessage startKeyboardMessage(long chatID) {
        SendMessage message = new SendMessage();
        message.setChatId(chatID);
        message.setText(ConstantsMessages.START_MESSAGE);
        InlineKeyboardMarkup keyboard = startKeyboard();
        message.setReplyMarkup(keyboard);
        return message;
    }

    public static InlineKeyboardMarkup startKeyboard() {
        InlineKeyboardMarkup keyboard = KeyboardBuilder.createKeyboard(ButtonsMaps.startButtons);
        return keyboard;
    }

    public static InlineKeyboardMarkup gameKeyboard() {
        InlineKeyboardMarkup keyboard = KeyboardBuilder.createKeyboard(ButtonsMaps.gameButtons);
        return keyboard;
    }

    public static InlineKeyboardMarkup actionKeyboard() {
        InlineKeyboardMarkup keyboard = KeyboardBuilder.createKeyboard(ButtonsMaps.actionsButtons);
        return keyboard;
    }

    public static InlineKeyboardMarkup warningKeyboard() {
        InlineKeyboardMarkup keyboard = KeyboardBuilder.createKeyboard(ButtonsMaps.oneBackButton);
        return keyboard;
    }

    public static InlineKeyboardMarkup leaderboardKeyboard() {
        InlineKeyboardMarkup keyboard = KeyboardBuilder.createKeyboard(ButtonsMaps.oneBackButton);
        return keyboard;
    }

    public static InlineKeyboardMarkup buildKeyboard() {
        InlineKeyboardMarkup keyboard = KeyboardBuilder.createKeyboard(ButtonsMaps.buildMenuButtons);
        return keyboard;
    }
}




