package TelegramBot.user;

import java.util.HashMap;

public class User {
    private String kingdomName;
    private final long chatID;
    private HashMap<String, Integer> kingdomResources = new HashMap<>();
    private HashMap<String, Integer> structures = new HashMap<>(); //Здание: Уровень
    private HashMap<String, Integer> army = new HashMap<>(); // Тип воина: Кол-во

    public User(long charID){
        this.kingdomName = kingdomName;
        this.chatID = charID;
        this.kingdomResources.put("Wood", 10);
        this.kingdomResources.put("Food", 15);
        this.kingdomResources.put("Gold", 100);
    }

    public void setResource(String resource, int value){
        if (resource == "Wood"){
            this.kingdomResources.put("Wood", value);
        } else if (resource == "Gold"){
            this.kingdomResources.put("Gold", value);
        } else if (resource == "Food"){
            this.kingdomResources.put("Food", value);
        }
    }

    public int getResource(String resource){
        int value = 0;
        if (resource == "Wood"){
            value = this.kingdomResources.get("Wood");
        } else if (resource == "Gold"){
            value = this.kingdomResources.get("Gold");
        } else if (resource == "Food") {
            value = this.kingdomResources.get("Wood");
        }
        return value;
    }


    public void sendUserInformation(){
        System.out.println(this.chatID);
        System.out.println(this.kingdomName);
        System.out.println(this.kingdomResources);
    }
}


