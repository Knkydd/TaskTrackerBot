package TelegramBot.bot.logic;

import TelegramBot.data.ConstantDB;
import TelegramBot.utility.ConstantResourcesForArmy;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Army {
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
        while(iteratorArmyKeys.hasNext()){
            String temp = (String) iteratorArmyKeys.next();
            tempMessage = String.format("%s        %s         Юнитов: %s\n", i, ConstantDB.accordanceListOfArmy.get(temp), army.get(temp));
            message += tempMessage;
            i++;
        }
        message+="\n";
        tempMessage = String.format("Мощь вашей армии составляет:   %s", armyPower);
        message+= tempMessage;
        return message;
    }

    public static Map<String, Integer> recruitingArmy(Map<String, Integer> army, String unit){
        army.put(unit, army.get(unit) + 1);
        return army;
    }

    public static String recruitingMessage(Map<String, Integer> army, Integer Gold){
        String message = "Кого вы хотите нанять?\n";
        String tempMessage = "";
        Set<String> armyKeys = army.keySet();
        Integer i = 1;
        Iterator iteratorArmyKeys = armyKeys.iterator();
        while(iteratorArmyKeys.hasNext()){
            String temp = (String) iteratorArmyKeys.next();
            tempMessage = String.format("%s     %s      %s\n", i, ConstantDB.accordanceListOfArmy.get(temp), ConstantResourcesForArmy.LIST_GOLD_FOR_ARMY.get(temp).get("Gold"));
            message+=tempMessage;
            i++;
        }
        message+="\n";
        tempMessage = String.format("Ваше золото:     %s", Gold);
        message+=tempMessage;
        return message;
    }
}
