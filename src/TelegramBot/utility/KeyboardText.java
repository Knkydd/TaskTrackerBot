package TelegramBot.utility;

import java.util.HashMap;

public class KeyboardText {
    public static String startText(){
        return "Добро пожаловать!\n" +
                "Этот бот пока умеет только выдавать 1 сообщение с 1 кнопкой, но в скором времени он научится большему\n" +
                "Пожелайте ему удачи!";
    }

    public static String gameText(HashMap resourses, String name){
        return "Королевство: {name}\n" +
                "Ресурсы: \uD83C\uDF32: {resourses.get('Wood')}\n" +
                "\uD83D\uDCB0: {resourses.get('Gold')}\n" +
                "\uD83E\uDD69: {resourses.get('Food')}";
    }
}
