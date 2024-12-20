package TelegramBot.bot.logic;

import java.util.*;

public class UserStateRepository {
    private final static Map<Long, List<String>> userStates = new HashMap<>();

    public boolean isEmpty(){
        if(userStates.isEmpty())
            return true;
        return false;
    }

    public void removeAll(long chatID){
        userStates.get(chatID).clear();
    }

    public void setState(long chatID, String newState) {
        if (userStates.get(chatID).isEmpty()) {
            userStates.computeIfAbsent(chatID, k -> new ArrayList<>()).add("mainMenu");
        } else {
            List<String> states = userStates.get(chatID);
            states.add(newState);
            userStates.put(chatID, states);
        }
    }

    public String getState(long chatID){
        List<String> states = userStates.get(chatID);
        String result = "";
        if(!states.isEmpty()) {
            states.removeLast();
        }
        if(states.isEmpty()){
            result = "mainMenu";
        } else {
            result = states.getLast();
            states.removeLast();
        }
        System.out.println(userStates);
        return result;
    }
}

