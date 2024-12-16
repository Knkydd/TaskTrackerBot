package TelegramBot.utility.keyboard;


import TelegramBot.utility.ConstantMessages;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class Keyboard {
    public static SendMessage startKeyboardMessage(long chatID) {
        SendMessage message = new SendMessage();
        message.setChatId(chatID);
        message.setText(ConstantMessages.START_MESSAGE);
        InlineKeyboardMarkup keyboard = startKeyboard();
        message.setReplyMarkup(keyboard);
        return message;
    }

    public static InlineKeyboardMarkup startKeyboard() {
        InlineKeyboardMarkup keyboard = KeyboardBuilder.createKeyboard(ButtonsMaps.startButtons,1);
        return keyboard;
    }

    public static InlineKeyboardMarkup gameKeyboard() {
        InlineKeyboardMarkup keyboard = KeyboardBuilder.createKeyboard(ButtonsMaps.gameButtons,2);
        return keyboard;
    }

    public static InlineKeyboardMarkup actionKeyboard() {
        InlineKeyboardMarkup keyboard = KeyboardBuilder.createKeyboard(ButtonsMaps.actionsButtons,2);
        return keyboard;
    }

    public static InlineKeyboardMarkup warningKeyboard() {
        InlineKeyboardMarkup keyboard = KeyboardBuilder.createKeyboard(ButtonsMaps.oneBackButton,1);
        return keyboard;
    }

    public static InlineKeyboardMarkup leaderboardKeyboard() {
        InlineKeyboardMarkup keyboard = KeyboardBuilder.createKeyboard(ButtonsMaps.oneBackButton,1);
        return keyboard;
    }

    public static InlineKeyboardMarkup buildsKeyboard() {
        InlineKeyboardMarkup keyboard = KeyboardBuilder.createKeyboard(ButtonsMaps.buildMenuButtons, 2);
        return keyboard;
    }

    public static InlineKeyboardMarkup upgradeBuildsKeyboard(){
        InlineKeyboardMarkup keyboard = KeyboardBuilder.createKeyboard(ButtonsMaps.upgradeButtons, 3);
        return keyboard;
    }

    public static InlineKeyboardMarkup upbuildBuildsKeyboard(){
        InlineKeyboardMarkup keyboard = KeyboardBuilder.createKeyboard(ButtonsMaps.upbuildButtons, 3);
        return keyboard;
    }
}




