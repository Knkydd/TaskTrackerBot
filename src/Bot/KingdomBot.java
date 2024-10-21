package Bot;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;


public class KingdomBot extends TelegramLongPollingBot {



    @Override
    public String getBotUsername(){
        return "KingdomBots";
    }

    @Override
    public String getBotToken()
    {
        return Token.readToken();
    }

    public void onUpdateReceived(Update update){

    }
}
