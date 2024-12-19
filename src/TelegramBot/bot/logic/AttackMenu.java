package TelegramBot.bot.logic;

import TelegramBot.bot.BotUtils;
import TelegramBot.data.ConstantDB;
import TelegramBot.data.DatabaseTools;
import TelegramBot.utility.ConstantAttackMenu;
import TelegramBot.utility.ConstantMessages;
import TelegramBot.utility.EditMessage;
import TelegramBot.utility.MessageSender;
import TelegramBot.utility.keyboard.ConstantKB;

public class AttackMenu {
    private UserStateRepository userStateRepository;
    private DatabaseTools databaseTools;
    private MessageSender messageSender;
    private EditMessage editMessage;

    public AttackMenu(BotUtils botUtils){
        this.databaseTools = botUtils.getDatabaseTools();
        this.userStateRepository = botUtils.getUserStateRepository();
        this.messageSender = botUtils.getMessageSender();
        this.editMessage = botUtils.getEditMessage();
    }

    private String attackMessage(Integer armyPower, Integer currentLevel) {
        String message = "";
        String tempMessage = "";
        if (!currentLevel.equals(11)) {
            tempMessage = String.format("Уровень:   %s\n\n" +
                                        "Для того, чтобы атаковать, вам нужно %s мощи армии\n\n" +
                                        "На данный момент мощь вашей армии составляет: %s\n", currentLevel, ConstantAttackMenu.ATTACK_LEVELS.get(currentLevel), armyPower);
        } else {
            tempMessage = "Вы уже прошли игру, атаковать больше некого)";
        }
        message += tempMessage;
        return message;
    }

    public void attackMenuHandler(long chatID, String callbackData, Integer messageID){
        Integer armyPower = databaseTools.getArmyPower(chatID);
        Integer currentLevel = databaseTools.getCurrentAttackLevel(chatID);
        switch (callbackData) {
            case ConstantKB.CALLBACK_ATTACK_BUTTON:

                userStateRepository.setState(chatID, ConstantKB.CALLBACK_ATTACK_BUTTON);
                messageSender.send(chatID, editMessage.messageEdit(chatID, messageID, ConstantKB.CALLBACK_ATTACK_BUTTON, attackMessage(armyPower, currentLevel)));

                break;
            case ConstantKB.CALLBACK_ATTACK_ENEMY_BUTTON:
                if(armyPower > ConstantAttackMenu.ATTACK_LEVELS.get(currentLevel)) {
                    databaseTools.setCurrentLevelAttack(chatID, currentLevel + 1);
                    messageSender.send(chatID, editMessage.warningMessage(chatID, messageID, ConstantMessages.ATTACK_ENEMY_SUCCESSFUL));
                } else {
                    messageSender.send(chatID, editMessage.warningMessage(chatID, messageID, ConstantMessages.ATTACK_ENEMY_FAILED));
                }
        }
    }

}
