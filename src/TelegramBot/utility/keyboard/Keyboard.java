package TelegramBot.utility.keyboard;


import TelegramBot.utility.ConstantMessages;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class Keyboard {
    private KeyboardBuilder keyboardBuilder;

    public Keyboard() {
        this.keyboardBuilder = new KeyboardBuilder();

    }

    public SendMessage startKeyboardMessage(long chatID) {
        SendMessage message = new SendMessage();
        message.setChatId(chatID);
        message.setText(ConstantMessages.START_MESSAGE);
        InlineKeyboardMarkup keyboard = startKeyboard();
        message.setReplyMarkup(keyboard);
        return message;
    }

    public InlineKeyboardMarkup startKeyboard() {
        InlineKeyboardMarkup keyboard = keyboardBuilder.createKeyboard(ButtonsMaps.startButtons, 1);
        return keyboard;
    }

    public InlineKeyboardMarkup gameKeyboard() {
        InlineKeyboardMarkup keyboard = keyboardBuilder.createKeyboard(ButtonsMaps.gameButtons, 2);
        return keyboard;
    }

    public InlineKeyboardMarkup actionKeyboard() {
        InlineKeyboardMarkup keyboard = keyboardBuilder.createKeyboard(ButtonsMaps.actionsButtons, 3);
        return keyboard;
    }

    public InlineKeyboardMarkup warningKeyboard() {
        InlineKeyboardMarkup keyboard = keyboardBuilder.createKeyboard(ButtonsMaps.oneBackButton, 1);
        return keyboard;
    }

    public InlineKeyboardMarkup leaderboardKeyboard() {
        InlineKeyboardMarkup keyboard = keyboardBuilder.createKeyboard(ButtonsMaps.oneBackButton, 1);
        return keyboard;
    }

    public InlineKeyboardMarkup buildsKeyboard() {
        InlineKeyboardMarkup keyboard = keyboardBuilder.createKeyboard(ButtonsMaps.buildMenuButtons, 2);
        return keyboard;
    }

    public InlineKeyboardMarkup upgradeBuildsKeyboard() {
        InlineKeyboardMarkup keyboard = keyboardBuilder.createKeyboard(ButtonsMaps.upgradeButtons, 3);
        return keyboard;
    }

    public InlineKeyboardMarkup upbuildBuildsKeyboard() {
        InlineKeyboardMarkup keyboard = keyboardBuilder.createKeyboard(ButtonsMaps.upbuildButtons, 3);
        return keyboard;
    }

    public InlineKeyboardMarkup armyKeyboard() {
        InlineKeyboardMarkup keyboard = keyboardBuilder.createKeyboard(ButtonsMaps.armyButtons, 2);
        return keyboard;
    }

    public InlineKeyboardMarkup recruitingKeyboard() {
        InlineKeyboardMarkup keyboard = keyboardBuilder.createKeyboard(ButtonsMaps.recruitingButtons, 3);
        return keyboard;
    }

    public InlineKeyboardMarkup attackKeyboard() {
        InlineKeyboardMarkup keyboard = keyboardBuilder.createKeyboard(ButtonsMaps.attackButtons, 1);
        return keyboard;
    }
}




