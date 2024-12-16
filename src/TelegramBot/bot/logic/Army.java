package TelegramBot.bot.logic;

import TelegramBot.data.ConstantDB;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Army {
    public static Integer getArmyPower(Map<String, Integer> builds, Map<String, Integer> army) {
        Integer armyPower = 0;
        return armyPower;
    }

    public static String armyMessage(Map<String, Integer> army, Integer armyPower) {
        String message = "Ваша могучая армия: \n";
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
        tempMessage = String.format("Мощь вашей армии составляет:   %s", armyPower);
        message+= tempMessage;
        return message;
    }
}
