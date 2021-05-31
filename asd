            if (update.getMessage().getText().equals("/Start")){
                sendMessage("/Admin\n/Player",update);
            }else if (update.getMessage().getText().equals("/Admin")){
                sendMessage("/Hole\n/Golfer\n/Tournament",update);
            }else if (update.getMessage().getText().equals("/Hole")){
                sendMessage("/HoleNumber\n/HoleIndex\n/HolePar",update);
            }else if (update.getMessage().getText().equals("/Golfer")){
                sendMessage("/GolderID\n/GolferName\n/GolferHandicap\n/TelegramID",update);
            }else if (update.getMessage().getText().equals("/Tournament")){
                sendMessage("/TournamentID\n/TournamentDate\n/ModeOfPlay",update);
            }else if (update.getMessage().getText().equals("/HoleNumber")){
                sendMessage(update.getMessage().getText(),update);
            }else if (update.getMessage().getText().equals("/HoleIndex")){

            }else if (update.getMessage().getText().equals("/HolePar")){

            }else if (update.getMessage().getText().equals("/GolferID")){

            }else if (update.getMessage().getText().equals("/GolferName")){

            }else if (update.getMessage().getText().equals("/GolferHandicap")){

            }else if (update.getMessage().getText().equals("/TelegramID")){

            }else if (update.getMessage().getText().equals("/TournamentID")){

            }else if (update.getMessage().getText().equals("/TournamentDate")){

            }else if (update.getMessage().getText().equals("/ModeOfPlay")){

            }