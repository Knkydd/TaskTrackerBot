package TelegramBot.utility;

import TelegramBot.utility.keyboard.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

import java.security.Key;

public class EditMessage {
    public static EditMessageText messageEdit(long chatID, Integer messageID, String callbackData, String text) {
        EditMessageText messageEdited = new EditMessageText();
        messageEdited.setMessageId(messageID);
        messageEdited.setChatId(chatID);
        switch (callbackData) {
            case ConstantKB.MAIN_MENU:
                messageEdited.setText(text);
                messageEdited.setReplyMarkup(Keyboard.startKeyboard());
                break;
            case ConstantKB.CALLBACK_START_BUTTON:
            case ConstantKB.CALLBACK_CONTINUE_BUTTON:
                messageEdited.setText(text);
                messageEdited.setReplyMarkup(Keyboard.gameKeyboard());
                break;
            case ConstantKB.CALLBACK_ACTION_BUTTON:
                messageEdited.setText(ConstantsMessages.ACTIONS_MESSAGE);
                messageEdited.setReplyMarkup(Keyboard.actionKeyboard());
                break;
            case ConstantKB.CALLBACK_LEADERBOARD_BUTTON:
                messageEdited.setText(text);
                messageEdited.setReplyMarkup(Keyboard.leaderboardKeyboard());
                break;
            case ConstantKB.CALLBACK_BUILDS_BUTTON:
                messageEdited.setText(text);
                messageEdited.setReplyMarkup(Keyboard.buildKeyboard());
                break;
            case ConstantKB.CALLBACK_NEXT_MOVE_BUTTON:
                messageEdited.setText(text);
                messageEdited.setReplyMarkup(Keyboard.warningKeyboard());
                break;

        }
        return messageEdited;
    }

    public static EditMessageText warningMessage(long chatID, Integer messageID, String messageText, int a) {
        EditMessageText messageEdited = new EditMessageText();
        messageEdited.setText(messageText);
        messageEdited.setMessageId(messageID);
        messageEdited.setChatId(chatID);
        messageEdited.setReplyMarkup(Keyboard.warningKeyboard());
        return messageEdited;
    }
}
