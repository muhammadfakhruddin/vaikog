package my.uum;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class TelegramBot extends TelegramLongPollingBot {
    ArrayList<String> hole = new ArrayList<String>();

    @Override
    public String getBotUsername() {
        return "STIW3054_A202_VaikoG_bot";
    }

    @Override
    public String getBotToken() {
        return "1815551796:AAH1eS5b2QglGGmFdSQg5SytuRRRPOujUAA";
    }

    @Override
    public void onUpdateReceived(Update update) {
        new Thread(()->{

            String command = update.getMessage().getText();
            SubString sub = new SubString();
            sub.test(command);
            keepArray(command);
            if (update.hasMessage() && update.getMessage().hasText()){
                if (update.getMessage().getText().equals("/Start")){
                    sendMessage("/Admin\n/Player",update);
                }else if (update.getMessage().getText().equals("/Admin")){
                    sendMessage("/Hole\n/Golfer\n/Tournament",update);
                }else if (update.getMessage().getText().equals("/Hole")){
                    sendMessage("HoleNumber:\nHoleIndex:\nHolePar:",update);
                }else if (update.getMessage().getText().equals("/Golfer")){
                    sendMessage("GolderID:\nGolferName:\nGolferHandicap:\nTelegramID:",update);
                }else if (update.getMessage().getText().equals("/Tournament")){
                    sendMessage("TournamentID:\nTournamentDate:\nModeOfPlay:",update);
                }else if (update.getMessage().getText().equals("/Player")){
                    sendMessage("Score Submission\n" +
                            "GolferID:\n" +
                            "MarkerID:\n" +
                            "Hole 1: \n" +
                            "Hole 2: \n" +
                            "Hole 3: \n" +
                            "Hole 4: \n" +
                            "Hole 5: \n" +
                            "Hole 6: \n" +
                            "Hole 7: \n" +
                            "Hole 8: \n" +
                            "Hole 9: \n" +
                            "Hole 10:\n" +
                            "Hole 11:\n" +
                            "Hole 12:\n" +
                            "Hole 13:\n" +
                            "Hole 14:\n" +
                            "Hole 15:\n" +
                            "Hole 16:\n" +
                            "Hole 17:\n" +
                            "Hole 18:",update);
                }
            }
        }).start();
    }

    private void keepArray(String command){

    }

    private void sendMessage(String string, Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        message.setText(string);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

