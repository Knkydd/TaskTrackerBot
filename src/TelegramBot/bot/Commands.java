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
    private MainMenu mainMenuControl;
    private GameMenu gameMenuControl;
    private Army armyMenuControl;
    private Builds buildsMenuControl;
    private long chatID;
    private Integer messageID;
    private String username;
    private AttackMenu attackMenuControl;

    public Commands(BotUtils botUtils) {
        commandsMap = new HashMap<>();
        databaseTools = botUtils.getDatabaseTools();
        userStateRepository = botUtils.getUserStateRepository();
        messageSender = botUtils.getMessageSender();
        nextMoveControl = new NextMove(botUtils);
        mainMenuControl = new MainMenu(botUtils);
        gameMenuControl = new GameMenu(botUtils);
        armyMenuControl = new Army(botUtils);
        buildsMenuControl = new Builds(botUtils);
        attackMenuControl = new AttackMenu(botUtils);

        //Начальный вызов начального меню
        commandsMap.put("/start", () ->
                mainMenuControl.setMainMenu(chatID));
        commandsMap.put(ConstantKB.MAIN_MENU, ()->
                mainMenuControl.setMainMenuInMSG(chatID, messageID));

        //Обработка начального меню
        commandsMap.put(ConstantKB.CALLBACK_START_BUTTON, () -> //startGame
                mainMenuControl.mainMenuHandler(chatID, ConstantKB.CALLBACK_START_BUTTON, messageID, username));
        commandsMap.put(ConstantKB.CALLBACK_CONTINUE_BUTTON, () ->
                mainMenuControl.mainMenuHandler(chatID, ConstantKB.CALLBACK_CONTINUE_BUTTON, messageID, username));
        commandsMap.put(ConstantKB.CALLBACK_LEADERBOARD_BUTTON, () ->
                mainMenuControl.mainMenuHandler(chatID, ConstantKB.CALLBACK_LEADERBOARD_BUTTON, messageID, username));

        //Обработка игрового меню
        commandsMap.put(ConstantKB.CALLBACK_BUILDS_BUTTON, () ->
                gameMenuControl.gameMenuHandler(chatID, ConstantKB.CALLBACK_BUILDS_BUTTON, messageID));
        commandsMap.put(ConstantKB.CALLBACK_ACTION_BUTTON, () ->
                gameMenuControl.gameMenuHandler(chatID, ConstantKB.CALLBACK_ACTION_BUTTON, messageID));
        commandsMap.put(ConstantKB.CALLBACK_ARMY_BUTTON, () ->
                gameMenuControl.gameMenuHandler(chatID, ConstantKB.CALLBACK_ARMY_BUTTON, messageID));

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
        commandsMap.put(ConstantKB.CALLBACK_ATTACK_BUTTON, () ->
                attackMenuControl.attackMenuHandler(chatID, ConstantKB.CALLBACK_ATTACK_BUTTON, messageID));

        //Обработка кнопки Атака(внутри меню атаки)
        commandsMap.put(ConstantKB.CALLBACK_ATTACK_ENEMY_BUTTON, () ->
                attackMenuControl.attackMenuHandler(chatID, ConstantKB.CALLBACK_ATTACK_ENEMY_BUTTON, messageID));

        //Обработка кнопки "Нанять"
        commandsMap.put(ConstantKB.CALLBACK_RECRUITING_BUTTON, ()->
                armyMenuControl.armyRecruitingHandler(chatID, ConstantKB.CALLBACK_RECRUITING_BUTTON, messageID));

        //Обработка кнопки найма войск
        commandsMap.put(ConstantDB.USER_WARRIOR_UNIT, () ->
                armyMenuControl.recruitingHandler(chatID, ConstantDB.USER_WARRIOR_UNIT, messageID));
        commandsMap.put(ConstantDB.USER_MAGE_UNIT, () ->
                armyMenuControl.recruitingHandler(chatID, ConstantDB.USER_MAGE_UNIT, messageID));
        commandsMap.put(ConstantDB.USER_ARCHER_UNIT, () ->
                armyMenuControl.recruitingHandler(chatID, ConstantDB.USER_ARCHER_UNIT, messageID));
        commandsMap.put(ConstantDB.USER_PALADIN_UNIT, () ->
                armyMenuControl.recruitingHandler(chatID, ConstantDB.USER_PALADIN_UNIT, messageID));
        commandsMap.put(ConstantDB.USER_HEALER_UNIT, () ->
                armyMenuControl.recruitingHandler(chatID, ConstantDB.USER_HEALER_UNIT, messageID));

        //Обработка кнопки построек
        commandsMap.put(ConstantKB.CALLBACK_UPBUILD_BUILD_BUTTON, () ->
                buildsMenuControl.buildsHandler(chatID, ConstantKB.CALLBACK_UPBUILD_BUILD_BUTTON, messageID));
        commandsMap.put(ConstantKB.CALLBACK_UPGRADE_BUILD_BUTTON, () ->
                buildsMenuControl.buildsHandler(chatID, ConstantKB.CALLBACK_UPGRADE_BUILD_BUTTON, messageID));

        //Обработка постройки зданий
        commandsMap.put(ConstantBuildUp.QUARRY_UPBUILD, () ->
                buildsMenuControl.buildsHandlerUpbuild(chatID, ConstantBuildUp.QUARRY_UPBUILD, messageID));
        commandsMap.put(ConstantBuildUp.TRADE_BUILD_UPBUILD, () ->
                buildsMenuControl.buildsHandlerUpbuild(chatID, ConstantBuildUp.TRADE_BUILD_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.MAGE_TOWER_UPBUILD, () ->
                buildsMenuControl.buildsHandlerUpbuild(chatID, ConstantBuildUp.MAGE_TOWER_UPBUILD, messageID));
        commandsMap.put(ConstantBuildUp.SHOOTING_RANGE_UPBUILD, () ->
                buildsMenuControl.buildsHandlerUpbuild(chatID, ConstantBuildUp.SHOOTING_RANGE_UPBUILD, messageID));
        commandsMap.put(ConstantBuildUp.CHAPEL_OF_LAST_HOPE_UPBUILD, () ->
                buildsMenuControl.buildsHandlerUpbuild(chatID, ConstantBuildUp.CHAPEL_OF_LAST_HOPE_UPBUILD, messageID));
        commandsMap.put(ConstantBuildUp.CHURCH_UPBUILD, () ->
                buildsMenuControl.buildsHandlerUpbuild(chatID, ConstantBuildUp.CHURCH_UPBUILD, messageID));

        //Обработка улучшения зданий
        commandsMap.put(ConstantBuildUp.TOWN_HALL_UPGRADE, ()->
                buildsMenuControl.buildsHandlerUpgrade(chatID, ConstantBuildUp.TOWN_HALL_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.SAWMILL_UPGRADE, ()->
                buildsMenuControl.buildsHandlerUpgrade(chatID, ConstantBuildUp.SAWMILL_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.QUARRY_UPGRADE, ()->
                buildsMenuControl.buildsHandlerUpgrade(chatID, ConstantBuildUp.QUARRY_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.FARM_UPGRADE, ()->
                buildsMenuControl.buildsHandlerUpgrade(chatID, ConstantBuildUp.FARM_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.TRADE_BUILD_UPGRADE, ()->
                buildsMenuControl.buildsHandlerUpgrade(chatID, ConstantBuildUp.TRADE_BUILD_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.BARRACKS_UPGRADE, ()->
                buildsMenuControl.buildsHandlerUpgrade(chatID, ConstantBuildUp.BARRACKS_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.MAGE_TOWER_UPGRADE, ()->
                buildsMenuControl.buildsHandlerUpgrade(chatID, ConstantBuildUp.MAGE_TOWER_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.SHOOTING_RANGE_UPGRADE, ()->
                buildsMenuControl.buildsHandlerUpgrade(chatID, ConstantBuildUp.SHOOTING_RANGE_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.CHAPEL_OF_LAST_HOPE_UPGRADE, ()->
                buildsMenuControl.buildsHandlerUpgrade(chatID, ConstantBuildUp.CHAPEL_OF_LAST_HOPE_UPGRADE, messageID));
        commandsMap.put(ConstantBuildUp.CHURCH_UPGRADE, ()->
                buildsMenuControl.buildsHandlerUpgrade(chatID, ConstantBuildUp.CHURCH_UPGRADE, messageID));

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
