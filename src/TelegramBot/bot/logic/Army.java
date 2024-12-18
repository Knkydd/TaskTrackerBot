package TelegramBot.bot.logic;

import TelegramBot.bot.BotUtils;
import TelegramBot.data.ConstantDB;
import TelegramBot.data.DatabaseConnection;
import TelegramBot.data.DatabaseTools;
import TelegramBot.utility.ConstantMessages;
import TelegramBot.utility.ConstantResourcesForArmy;
import TelegramBot.utility.EditMessage;
import TelegramBot.utility.MessageSender;
import TelegramBot.utility.keyboard.ConstantKB;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Army {
    private DatabaseTools databaseTools;
    private MessageSender messageSender;
    private UserStateRepository userStateRepository;
    private EditMessage editMessage;

    public Army(BotUtils botUtils) {
        this.databaseTools = botUtils.getDatabaseTools();
        this.messageSender = botUtils.getMessageSender();
        this.userStateRepository = botUtils.getUserStateRepository();
        this.editMessage = botUtils.getEditMessage();
    }

    public static Integer getArmyPower(Map<String, Integer> builds, Map<String, Integer> army) {
        Integer armyPower = 0;
        return armyPower;
    }

    public static String armyMessage(Map<String, Integer> army, Integer armyPower) {
        String message = "Ваша могучая армия: \n\n";
        String tempMessage = "";
        Set<String> armyKeys = army.keySet();
        Iterator iteratorArmyKeys = armyKeys.iterator();
        Integer i = 1;
        while (iteratorArmyKeys.hasNext()) {
            String temp = (String) iteratorArmyKeys.next();
            tempMessage = String.format("%s        %s         Юнитов: %s\n", i, ConstantDB.accordanceListOfArmy.get(temp), army.get(temp));
            message += tempMessage;
            i++;
        }
        message += "\n";
        tempMessage = String.format("Мощь вашей армии составляет:   %s", armyPower);
        message += tempMessage;
        return message;
    }

    public static Map<String, Integer> recruitingArmy(Map<String, Integer> army, String unit) {
        army.put(unit, army.get(unit) + 1);
        return army;
    }

    public static String recruitingMessage(Map<String, Integer> army, Integer Gold) {
        String message = "Кого вы хотите нанять?\n";
        String tempMessage = "";
        Set<String> armyKeys = army.keySet();
        Integer i = 1;
        Iterator iteratorArmyKeys = armyKeys.iterator();
        while (iteratorArmyKeys.hasNext()) {
            String temp = (String) iteratorArmyKeys.next();
            tempMessage = String.format("%s     %s      %s\n", i, ConstantDB.accordanceListOfArmy.get(temp), ConstantResourcesForArmy.LIST_GOLD_FOR_ARMY.get(temp).get("Gold"));
            message += tempMessage;
            i++;
        }
        message += "\n";
        tempMessage = String.format("Ваше золото:     %s", Gold);
        message += tempMessage;
        return message;
    }

    public void armyRecruitingHandler(long chatID, String callbackData, Integer messageID){
        userStateRepository.setState(chatID, ConstantKB.CALLBACK_RECRUITING_BUTTON);
        messageSender.send(chatID, editMessage.messageEdit(chatID, messageID, callbackData, recruitingMessage(databaseTools.getArmy(chatID), databaseTools.getResources(chatID).get(ConstantDB.USER_GOLD))));
    }

    public void recruitingHandler(long chatID, String callbackData, Integer messageID) {
        userStateRepository.setState(chatID, ConstantKB.CALLBACK_ARMY_BUTTON);

        Map<String, Integer> army = databaseTools.getArmy(chatID);
        Map<String, Integer> resources = databaseTools.getResources(chatID);

        if (Resources.checkResourcesOnSpending(resources, ConstantResourcesForArmy.LIST_GOLD_FOR_ARMY.get(callbackData))) {

            databaseTools.setResources(chatID, Resources.updateResources(resources, ConstantResourcesForArmy.LIST_GOLD_FOR_ARMY.get(callbackData)));
            databaseTools.setArmy(chatID, Army.recruitingArmy(army, callbackData));
            messageSender.send(chatID, editMessage.warningMessage(chatID, messageID, ConstantMessages.RECRUITING_UNIT_SUCCESSFUL));

        } else {

            messageSender.send(chatID, editMessage.warningMessage(chatID, messageID, ConstantMessages.RECRUITING_UNIT_FAILED));

        }

    }
}