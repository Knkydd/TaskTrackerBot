package TelegramBot.utility;

import TelegramBot.utility.keyboard.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

public class EditMessage {
    public static EditMessageText messageEdit(long chatID, Integer messageID, String callbackData, String text) {
        EditMessageText messageEdited = new EditMessageText();
        messageEdited.setMessageId(messageID);
        messageEdited.setChatId(chatID);
        switch (callbackData) {
            case ConstantKB.CALLBACK_START_BUTTON:
                messageEdited.setText(text);
                messageEdited.setReplyMarkup(Keyboard.gameKeyboard());
                break;
            case ConstantKB.CALLBACK_ACTION_BUTTON:
                messageEdited.setText(ConstantsMessages.ACTIONS_MESSAGE);
                messageEdited.setReplyMarkup(Keyboard.actionKeyboard());
            case ConstantKB.CALLBACK_CONTINUE_BUTTON:
                messageEdited.setText(text);
                messageEdited.setReplyMarkup(Keyboard.gameKeyboard());
        }
        return messageEdited;
    }

    public static EditMessageText messageEdit(long chatID, Integer messageID, String messageText, int a) {
        EditMessageText messageEdited = new EditMessageText();
        messageEdited.setText(messageText);
        messageEdited.setMessageId(messageID);
        messageEdited.setChatId(chatID);
        messageEdited.setReplyMarkup(Keyboard.startKeyboard());
        return messageEdited;
    }
}
