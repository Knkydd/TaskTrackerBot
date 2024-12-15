package TelegramBot.utility.keyboard;

import TelegramBot.utility.keyboard.ConstantKB;

import java.util.HashMap;
import java.util.Map;

public class ButtonsMaps {
    public final static Map<String, String> startButtons = new HashMap<>();
    public final static Map<String, String> gameButtons = new HashMap<>();
    public final static Map<String, String> actionsButtons = new HashMap<>();
    public final static Map<String, String> oneBackButton = new HashMap<>();

    static {
        startButtons.put(ConstantKB.START_BUTTON, ConstantKB.CALLBACK_START_BUTTON);
        startButtons.put(ConstantKB.CONTINUE_BUTTON, ConstantKB.CALLBACK_CONTINUE_BUTTON);
        startButtons.put(ConstantKB.LEADERBOARD_BUTTON, ConstantKB.CALLBACK_LEADERBOARD_BUTTON);

        gameButtons.put(ConstantKB.BUILDS_BUTTON, ConstantKB.CALLBACK_BUILDS_BUTTON);
        gameButtons.put(ConstantKB.NEXT_MOVE_BUTTON, ConstantKB.CALLBACK_NEXT_MOVE_BUTTON);
        gameButtons.put(ConstantKB.ACTIONS_BUTTON, ConstantKB.CALLBACK_ACTION_BUTTON);
        gameButtons.put(ConstantKB.ARMY_BUTTON, ConstantKB.CALLBACK_ARMY_BUTTON);
        gameButtons.put(ConstantKB.BACK_BUTTON, ConstantKB.CALLBACK_BACK_BUTTON);

        oneBackButton.put(ConstantKB.BACK_BUTTON, ConstantKB.CALLBACK_BACK_BUTTON);

        actionsButtons.put(ConstantKB.ATTACK_BUTTON, ConstantKB.CALLBACK_ATTACK_BUTTON);
        actionsButtons.put(ConstantKB.BACK_BUTTON, ConstantKB.CALLBACK_BACK_BUTTON);
    }
}
