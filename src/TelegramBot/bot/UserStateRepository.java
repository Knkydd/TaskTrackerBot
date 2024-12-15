package TelegramBot.bot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserStateRepository {
    private final Map<Long, List<String>> userStates = new HashMap<>();

    public void setState(long chatID, String newState) {
        if (userStates.isEmpty()) {
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
        return result;
    }
}

