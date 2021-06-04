package my.uum;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class TelegramBot extends TelegramLongPollingBot {

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
            if (update.hasMessage() && update.getMessage().hasText()){
                if (update.getMessage().getText().equals("/start")){
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
                    sendMessage("Score Submission\n" + "GolferID:\n" + "MarkerID:\n" + "Hole 1: \n" + "Hole 2: \n" + "Hole 3: \n" + "Hole 4: \n" + "Hole 5: \n" + "Hole 6: \n" + "Hole 7: \n" + "Hole 8: \n" + "Hole 9: \n" + "Hole 10:\n" + "Hole 11:\n" + "Hole 12:\n" + "Hole 13:\n" + "Hole 14:\n" + "Hole 15:\n" + "Hole 16:\n" + "Hole 17:\n" + "Hole 18:",update);
                }else if(update.getMessage().getText().equals("/Delete")){
                    sendMessage("/DeleteHole\n/DeleteGolfer\n/DeleteTournament",update);
                }else if(update.getMessage().getText().equals("/DeleteHole")){
                    sendMessage("Hole Number:",update);
                }else if(update.getMessage().getText().equals("/DeleteGolfer")){
                    sendMessage("Golfer ID:",update);
                }else if(update.getMessage().getText().equals("/DeleteTournament")){
                    sendMessage("Tournament ID:",update);
                }else if(update.getMessage().getText().equals("/Update")){
                    sendMessage("/UpdateHole\n/UpdateGolfer\n/UpdateTournament",update);
                }else if(update.getMessage().getText().equals("/UpdateHole")){
                    sendMessage("Update Hole\nHole number:\nHole index:\nHole par:",update);
                }else if(update.getMessage().getText().equals("/UpdateGolfer")){
                    sendMessage("Update Golfer\nGolder ID:\nGolfer Name:\nGolfer Handicap:\nTelegram ID:",update);
                }else if(update.getMessage().getText().equals("/UpdateTournament")){
                    sendMessage("Update Tournament\nTournament id:\nTournament Date:\nMode Of Play:",update);
                }

            }
        }).start();
    }

    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

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

