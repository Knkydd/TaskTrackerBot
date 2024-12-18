package TelegramBot.bot;

import TelegramBot.bot.logic.*;
import TelegramBot.data.ConstantDB;
import TelegramBot.data.DatabaseTools;
import TelegramBot.utility.ConstantBuildUp;
import TelegramBot.utility.MessageSender;
import TelegramBot.utility.keyboard.ConstantKB;

import java.util.HashMap;
import java.util.Map;

public class Commands {
    private Map<String, Runnable> commandsMap;
    private DatabaseTools databaseTools;
    private UserStateRepository userStateRepository;
    private MessageSender messageSender;
    private NextMove nextMoveControl;
    private MainMenu mainMenu;
    private GameMenu gameMenu;
    private Army armyHandler;
    private Builds buildsHandler;
    private long chatID;
    private Integer messageID;
    private String username;

    public Commands(BotUtils botUtils) {
        commandsMap = new HashMap<>();
        databaseTools = botUtils.getDatabaseTools();
        userStateRepository = botUtils.getUserStateRepository();
        messageSender = botUtils.getMessageSender();
        nextMoveControl = new NextMove(botUtils);
        mainMenu = new MainMenu(botUtils);
        gameMenu = new GameMenu(botUtils);
        armyHandler = new Army(botUtils);
        buildsHandler = new Builds(botUtils);

        //Начальный вызов начального меню
        commandsMap.put("/start", () ->
                mainMenu.setMainMenu(chatID));
        commandsMap.put(ConstantKB.MAIN_MENU, ()->
                mainMenu.setMainMenuInMSG(chatID, messageID));

        //Обработка начального меню
        commandsMap.put(ConstantKB.CALLBACK_START_BUTTON, () -> //startGame
                mainMenu.mainMenuHandler(chatID, ConstantKB.CALLBACK_START_BUTTON, messageID, username));
        commandsMap.put(ConstantKB.CALLBACK_CONTINUE_BUTTON, () ->
                mainMenu.mainMenuHandler(chatID, ConstantKB.CALLBACK_CONTINUE_BUTTON, messageID, username));
        commandsMap.put(ConstantKB.CALLBACK_LEADERBOARD_BUTTON, () ->
                mainMenu.mainMenuHandler(chatID, ConstantKB.CALLBACK_LEADERBOARD_BUTTON, messageID, username));

        //Обработка игрового меню
        commandsMap.put(ConstantKB.CALLBACK_BUILDS_BUTTON, () ->
                gameMenu.gameMenuHandler(chatID, ConstantKB.CALLBACK_BUILDS_BUTTON, messageID));
        commandsMap.put(ConstantKB.CALLBACK_ACTION_BUTTON, () ->
                gameMenu.gameMenuHandler(chatID, ConstantKB.CALLBACK_ACTION_BUTTON, messageID));
        commandsMap.put(ConstantKB.CALLBACK_ARMY_BUTTON, () ->
                gameMenu.gameMenuHandler(chatID, ConstantKB.CALLBACK_ARMY_BUTTON, messageID));

        //Обработка Действий
        commandsMap.put(ConstantKB.CALLBACK_NEXT_MOVE_BUTTON, () ->
                nextMoveControl.nextMoveHandler(chatID, ConstantKB.CALLBACK_NEXT_MOVE_BUTTON, messageID));
        commandsMap.put(ConstantKB.CALLBACK_MOVE_CHOP, () ->
                nextMoveControl.nextMoveHandler(chatID, ConstantKB.CALLBACK_MOVE_CHOP, messageID));
        commandsMap.put(ConstantKB.CALLBACK_MOVE_DIG, () ->
                nextMoveControl.nextMoveHandler(chatID, ConstantKB.CALLBACK_MOVE_DIG, messageID));
        commandsMap.put(ConstantKB.CALLBACK_MOVE_TRADE, () ->
                nextMoveControl.nextMoveHandler(chatID, ConstantKB.CALLBACK_MOVE_TRADE, messageID));
        commandsMap.put(ConstantKB.CALLBACK_MOVE_WORK_ON_FARM, () ->
                nextMoveControl.nextMoveHandler(chatID, ConstantKB.CALLBACK_MOVE_WORK_ON_FARM, messageID));

        //Обработка кнопки "Нанять"
        commandsMap.put(ConstantKB.CALLBACK_RECRUITING_BUTTON, ()->
                armyHandler.armyRecruitingHandler(chatID, ConstantKB.CALLBACK_RECRUITING_BUTTON, messageID));

        //Обработка кнопки найма войск
        commandsMap.put(ConstantDB.USER_WARRIOR_UNIT, () ->
                armyHandler.recruitingHandler(chatID, ConstantDB.USER_WARRIOR_UNIT, messageID));
        commandsMap.put(ConstantDB.USER_MAGE_UNIT, () ->
                armyHandler.recruitingHandler(chatID, ConstantDB.USER_MAGE_UNIT, messageID));
        commandsMap.put(ConstantDB.USER_ARCHER_UNIT, () ->
                armyHandler.recruitingHandler(chatID, ConstantDB.USER_ARCHER_UNIT, messageID));
        commandsMap.put(ConstantDB.USER_PALADIN_UNIT, () ->
                armyHandler.recruitingHandler(chatID, ConstantDB.USER_PALADIN_UNIT, messageID));
        commandsMap.put(ConstantDB.USER_HEALER_UNIT, () ->
                armyHandler.recruitingHandler(chatID, ConstantDB.USER_HEALER_UNIT, messageID));

        //Обработка кнопки построек
        commandsMap.put(ConstantKB.CALLBACK_UPBUILD_BUILD_BUTTON, () ->
                buildsHandler.buildsHandler(chatID, ConstantKB.CALLBACK_UPBUILD_BUILD_BUTTON, messageID));
        commandsMap.put(ConstantKB.CALLBACK_UPGRADE_BUILD_BUTTON, () ->
                buildsHandler.buildsHandler(chatID, ConstantKB.CALLBACK_UPGRADE_BUILD_BUTTON, messageID));

        //Обработка постройки зданий
        commandsMap.put(ConstantBuildUp.QUARRY_UPBUILD, () ->
                buildsHandler.buildsHandlerUpbuild(chatID, ConstantBuildUp.QUARRY_UPBUILD, messageID));
        commandsMap.put(ConstantBuildUp.TRADE_BUILD_UPBUILD, () ->
                buildsHandler.buildsHandlerUpbuild(chatID, ConstantBuildUp.TRADE_BUILD_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.MAGE_TOWER_UPBUILD, () ->
                buildsHandler.buildsHandlerUpbuild(chatID, ConstantBuildUp.MAGE_TOWER_UPBUILD, messageID));
        commandsMap.put(ConstantBuildUp.SHOOTING_RANGE_UPBUILD, () ->
                buildsHandler.buildsHandlerUpbuild(chatID, ConstantBuildUp.SHOOTING_RANGE_UPBUILD, messageID));
        commandsMap.put(ConstantBuildUp.CHAPEL_OF_LAST_HOPE_UPBUILD, () ->
                buildsHandler.buildsHandlerUpbuild(chatID, ConstantBuildUp.CHAPEL_OF_LAST_HOPE_UPBUILD, messageID));
        commandsMap.put(ConstantBuildUp.CHURCH_UPBUILD, () ->
                buildsHandler.buildsHandlerUpbuild(chatID, ConstantBuildUp.CHURCH_UPBUILD, messageID));

        //Обработка улучшения зданий
        commandsMap.put(ConstantBuildUp.TOWN_HALL_UPGRADE, ()->
                buildsHandler.buildsHandlerUpgrade(chatID, ConstantBuildUp.TOWN_HALL_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.SAWMILL_UPGRADE, ()->
                buildsHandler.buildsHandlerUpgrade(chatID, ConstantBuildUp.SAWMILL_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.QUARRY_UPGRADE, ()->
                buildsHandler.buildsHandlerUpgrade(chatID, ConstantBuildUp.QUARRY_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.FARM_UPGRADE, ()->
                buildsHandler.buildsHandlerUpgrade(chatID, ConstantBuildUp.FARM_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.TRADE_BUILD_UPGRADE, ()->
                buildsHandler.buildsHandlerUpgrade(chatID, ConstantBuildUp.TRADE_BUILD_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.BARRACKS_UPGRADE, ()->
                buildsHandler.buildsHandlerUpgrade(chatID, ConstantBuildUp.BARRACKS_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.MAGE_TOWER_UPGRADE, ()->
                buildsHandler.buildsHandlerUpgrade(chatID, ConstantBuildUp.MAGE_TOWER_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.SHOOTING_RANGE_UPGRADE, ()->
                buildsHandler.buildsHandlerUpgrade(chatID, ConstantBuildUp.SHOOTING_RANGE_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.CHAPEL_OF_LAST_HOPE_UPGRADE, ()->
                buildsHandler.buildsHandlerUpgrade(chatID, ConstantBuildUp.CHAPEL_OF_LAST_HOPE_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.CHURCH_UPGRADE, ()->
                buildsHandler.buildsHandlerUpgrade(chatID, ConstantBuildUp.CHURCH_UPGRADE, messageID));

    }

    public Runnable getCommand(String command) {
        return commandsMap.get(command);
    }

    public void setChatID(long chatID) {
        this.chatID = chatID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
