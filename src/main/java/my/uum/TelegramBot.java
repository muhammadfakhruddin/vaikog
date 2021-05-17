package my.uum;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "STIW3054_A202_VaikoG_bot";
    }

    @Override
    public String getBotToken() {
        return "1829263649:AAFqY9ygdh2RwVAElflBU4ZSV8ZZ0meTwwM";
    }

    @Override
    public void onUpdateReceived(Update update) {
        new Thread(()->{
            String command=update.getMessage().getText();
            SendMessage message = new SendMessage();
            if (update.hasMessage()&&update.getMessage().hasText()) {
                //bot.submitted(Integer.parseInt(command));
                message.setText(command);
            }
            message.setChatId(String.valueOf(update.getMessage().getChatId()));
            try{
                execute(message);
            }catch (TelegramApiException e){
                e.printStackTrace();
            }
        }).start();
    }
}
