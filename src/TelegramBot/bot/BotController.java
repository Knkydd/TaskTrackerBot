package TelegramBot.bot;

import TelegramBot.bot.logic.Builds;
import TelegramBot.bot.logic.Leaderboard;
import TelegramBot.bot.logic.Resources;
import TelegramBot.bot.logic.UserStateRepository;
import TelegramBot.data.DatabaseConnection;
import TelegramBot.utility.*;
import TelegramBot.utility.keyboard.ConstantKB;
import TelegramBot.utility.keyboard.Keyboard;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;

public class BotController {
    private final MessageSender messageSender;
    private final DatabaseConnection dbConnection;
    private final UserStateRepository userStateRepository;

    public BotController(TelegramLongPollingBot bot) {
        messageSender = new MessageSender(bot);
        dbConnection = new DatabaseConnection();
        userStateRepository = new UserStateRepository();
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
            messageSender.send(chatID, Keyboard.startKeyboardMessage(chatID));
            if (userStateRepository.isEmpty()) {
                userStateRepository.setState(chatID, ConstantKB.MAIN_MENU);
            } else {
                userStateRepository.removeAll();
                userStateRepository.setState(chatID, ConstantKB.MAIN_MENU);
            }
        }
    }

    public void handleCallbackData(Update update) {
        long chatID = update.getCallbackQuery().getMessage().getChatId();
        String callbackData = update.getCallbackQuery().getData();
        Integer messageID = update.getCallbackQuery().getMessage().getMessageId();
        String username = update.getCallbackQuery().getFrom().getUserName();
        if (callbackData.equalsIgnoreCase(ConstantKB.CALLBACK_BACK_BUTTON)) {
            callbackData = userStateRepository.getState(chatID);
        }
        if (Arrays.asList(ConstantKB.LIST_CALLBACK_DATA).contains(callbackData)) {
            switch (callbackData) {
                case ConstantKB.MAIN_MENU:
                    messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, ConstantMessages.START_MESSAGE));
                    break;

                case ConstantKB.CALLBACK_START_BUTTON:
                    if (!dbConnection.getDatabaseTools().isRegistered(chatID)) {
                        dbConnection.getDatabaseTools().registrationUser(chatID, username);
                        messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, ConstantMessages.GAME_MESSAGE+Resources.resourceMessage(dbConnection.getDatabaseTools().getResources(chatID))));
                        userStateRepository.setState(chatID, ConstantKB.CALLBACK_START_BUTTON);
                    } else {
                        messageSender.send(chatID, EditMessage.warningMessage(chatID, messageID, ConstantMessages.CHECK_REGISTRATION_MESSAGE));
                    }
                    break;

                case ConstantKB.CALLBACK_CONTINUE_BUTTON:
                    if (dbConnection.getDatabaseTools().isRegistered(chatID)) {
                        messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, ConstantMessages.GAME_MESSAGE+Resources.resourceMessage(dbConnection.getDatabaseTools().getResources(chatID))));
                        userStateRepository.setState(chatID, ConstantKB.CALLBACK_CONTINUE_BUTTON);
                    } else {
                        messageSender.send(chatID, EditMessage.warningMessage(chatID, messageID, ConstantMessages.CHECK_CONTINUE_MESSAGE));
                    }
                    break;

                case ConstantKB.CALLBACK_LEADERBOARD_BUTTON:
                    messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, Leaderboard.leaderboardMessage(dbConnection.getDatabaseTools().getLeaderboard())));
                    userStateRepository.setState(chatID, ConstantKB.CALLBACK_LEADERBOARD_BUTTON);
                    break;

                case ConstantKB.CALLBACK_ACTION_BUTTON:
                    messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, "В разработке"));
                    userStateRepository.setState(chatID, ConstantKB.CALLBACK_ACTION_BUTTON);
                    break;

                case ConstantKB.CALLBACK_BUILDS_BUTTON:
                    messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, Builds.buildsMessage(dbConnection.getDatabaseTools().getBuilds(chatID))));
                    userStateRepository.setState(chatID, ConstantKB.CALLBACK_BUILDS_BUTTON);
                    break;
                case ConstantKB.CALLBACK_ARMY_BUTTON:
                    messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, "В разработке"));
                    userStateRepository.setState(chatID, ConstantKB.CALLBACK_ARMY_BUTTON);
                    break;

                case ConstantKB.CALLBACK_NEXT_MOVE_BUTTON:
                    messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, "В разработке"));
                    userStateRepository.setState(chatID, ConstantKB.CALLBACK_NEXT_MOVE_BUTTON);
                    break;

                case ConstantKB.CALLBACK_UPBUILD_BUILD_BUTTON:
                    messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, Builds.upbuildBuildsMessage(dbConnection.getDatabaseTools().getBuilds(chatID))));
                    userStateRepository.setState(chatID, ConstantKB.CALLBACK_UPBUILD_BUILD_BUTTON);
                    break;

                case ConstantKB.CALLBACK_UPGRADE_BUILD_BUTTON:
                    messageSender.send(chatID, EditMessage.messageEdit(chatID, messageID, callbackData, Builds.upgradeBuildsMessage(dbConnection.getDatabaseTools().getBuilds(chatID))));
                    userStateRepository.setState(chatID, ConstantKB.CALLBACK_UPGRADE_BUILD_BUTTON);
                    break;

            }

        } else if (Arrays.asList(ConstantBuildUp.LIST_UPBUILD_BUILD_CALLBACK).contains(callbackData)) {
            userStateRepository.setState(chatID, ConstantKB.CALLBACK_UPBUILD_BUILD_BUTTON);
            callbackData = callbackData.substring(0, callbackData.length() - 7);
            if (Builds.checkUpbuildBuilds(dbConnection.getDatabaseTools().getBuilds(chatID), callbackData)) {
                if (Resources.checkResourcesOnSpending(dbConnection.getDatabaseTools().getResources(chatID), ConstantResourcesForBuilds.RESOURCES_FOR_BUILD.get(callbackData))) {
                    dbConnection.getDatabaseTools().setResources(chatID, Resources.updateResources(dbConnection.getDatabaseTools().getResources(chatID), ConstantResourcesForBuilds.RESOURCES_FOR_BUILD.get(callbackData)));
                    dbConnection.getDatabaseTools().setBuilds(chatID, Builds.upbuildBuilds(dbConnection.getDatabaseTools().getBuilds(chatID), callbackData));
                    messageSender.send(chatID, EditMessage.warningMessage(chatID, messageID, ConstantMessages.BUILD_SUCCESSFUL));

                } else {
                    messageSender.send(chatID, EditMessage.warningMessage(chatID, messageID, ConstantMessages.BUILD_FAILED_RESOURCES));
                }

            } else {

                messageSender.send(chatID, EditMessage.warningMessage(chatID, messageID, ConstantMessages.BUILD_FAILED));

            }

        } else if (Arrays.asList(ConstantBuildUp.LIST_UPGRADE_BUILD_CALLBACK).contains(callbackData)) {
            userStateRepository.setState(chatID, ConstantKB.CALLBACK_UPGRADE_BUILD_BUTTON);
            callbackData = callbackData.substring(0, callbackData.length() - 7);
            if(Builds.checkUpgradeBuilds(dbConnection.getDatabaseTools().getBuilds(chatID), callbackData)){
                if(Resources.checkResourcesOnSpending(dbConnection.getDatabaseTools().getResources(chatID), ConstantResourcesForBuilds.RESOURCES_FOR_UPGRADE.get(callbackData).get(dbConnection.getDatabaseTools().getBuilds(chatID).get(callbackData)))){
                    dbConnection.getDatabaseTools().setResources(chatID, Resources.updateResources(dbConnection.getDatabaseTools().getResources(chatID), ConstantResourcesForBuilds.RESOURCES_FOR_UPGRADE.get(callbackData).get(dbConnection.getDatabaseTools().getBuilds(chatID).get(callbackData))));
                    dbConnection.getDatabaseTools().setBuilds(chatID, Builds.upgradeBuilds(dbConnection.getDatabaseTools().getBuilds(chatID), callbackData));
                    messageSender.send(chatID, EditMessage.warningMessage(chatID, messageID, ConstantMessages.UPGRADE_BUILD_SUCCESSFUL));
                } else {
                    messageSender.send(chatID,EditMessage.warningMessage(chatID,messageID,ConstantMessages.BUILD_FAILED_RESOURCES));
                }
            } else {
                messageSender.send(chatID, EditMessage.warningMessage(chatID, messageID, ConstantMessages.UPGRADE_BUILD_FAILED));
            }
        }
    }
}
