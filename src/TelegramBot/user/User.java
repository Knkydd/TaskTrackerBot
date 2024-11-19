package TelegramBot.user;

public class User {
    private String kingdomName;
    private int wood, stone, gold, eat;

    public User(String kingdomName, int root){
        this.kingdomName = kingdomName;
        this.stone = this.wood = 10;
        this.eat = 15;
        this.gold = 100;
    }

    public void setWood(int value){
        this.wood = this.wood + value;
    }

    public int getWood(){
        return this.wood;
    }


}


