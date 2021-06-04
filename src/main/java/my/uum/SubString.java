package my.uum;

public class SubString {
    ManageScore manageScore = new ManageScore();
    ManageHole manageHole = new ManageHole();
    ManageGolfer manageGolfer = new ManageGolfer();
    ManageTournament manageTournament = new ManageTournament();

    public void test(String command) {
        manageScore.connect();
        manageHole.connect();
        manageGolfer.connect();
        manageTournament.connect();
        if (command.contains("HoleNumber")){
            String[] arr = command.split("\n", 0);
            String hole_number = arr[0].substring(11,arr[0].length());
            String hole_index = arr[1].substring(10,arr[1].length());
            String hole_par = arr[2].substring(8,arr[2].length());
            manageHole.insertHole(hole_number,hole_index,hole_par);
        }else if (command.contains("GolderID")){
            String[] arr = command.split("\n", 0);
            String golfer_id = arr[0].substring(9,arr[0].length());
            String golfer_name = arr[1].substring(11,arr[1].length());
            String golfer_handicap = arr[2].substring(15,arr[2].length());
            String telegram_id = arr[3].substring(11,arr[3].length());
            manageGolfer.insertGolfer(golfer_id,golfer_name,golfer_handicap,telegram_id);
        }else if (command.contains("TournamentID")){
            String[] arr = command.split("\n", 0);
            String tournament_id = arr[0].substring(13,arr[0].length());
            String tournament_date = arr[1].substring(15,arr[1].length());
            String mode_of_play = arr[2].substring(11,arr[2].length());
            manageTournament.insertTournament(tournament_id,tournament_date,mode_of_play);
        }else if (command.contains("Score Submission")){
            String [] arr = command.split("\n",0);
            String [] ars = new String[18];
            String golfer_id=arr[1].substring(9, arr[1].length());
            String marker_id=arr[2].substring(9, arr[2].length());
            for (int i=0;i< ars.length;i++){ ars[i]= arr[i+3].substring(8, arr[i+3].length()); }
            for (int i=0;i< ars.length;i++){ manageScore.score(golfer_id,marker_id,(i+1),ars[i]); }
        }else if (command.contains("Hole Number:")){
            String delete_hole = command.substring(12,command.length());
            manageHole.deleteHole(delete_hole);
        }else if (command.contains("Golfer ID:")){
            String delete_golfer = command.substring(10,command.length());
            manageGolfer.deleteGolfer(delete_golfer);
        }else if (command.contains("Tournament ID:")){
            String delete_tournament = command.substring(14,command.length());
            manageTournament.deleteTournament(delete_tournament);
        }else if (command.contains("Update Hole")){
            String[] arr = command.split("\n", 0);

            String hole_number = arr[1].substring(12,arr[1].length());
            String hole_index = arr[2].substring(11,arr[2].length());
            String hole_par = arr[3].substring(9,arr[3].length());
            manageHole.updateHole(hole_index,hole_par,hole_number);
        }else if (command.contains("Update Golfer")){
            String[] arr = command.split("\n", 0);

            String golfer_id = arr[1].substring(10,arr[1].length());
            String golfer_name = arr[2].substring(12,arr[2].length());
            String golfer_handicap = arr[3].substring(16,arr[3].length());
            String telegram_id = arr[4].substring(12,arr[4].length());

            manageGolfer.updateGolfer(golfer_name,golfer_handicap,telegram_id,golfer_id);
        }else if (command.contains("Update Tournament")){
            String[] arr = command.split("\n", 0);

            String tournament_id = arr[1].substring(14,arr[1].length());
            String tournament_date = arr[2].substring(16,arr[2].length());
            String mode_of_play = arr[3].substring(13,arr[3].length());

            manageTournament.updateTournament(tournament_date,mode_of_play,tournament_id);
        }
    }

    public static void main(String[]args){
        String command = "Update Tournament\n" +
                "Tournament ID:123\n" +
                "Tournament Date:123\n" +
                "Mode Of Play:123";
        //String command = "Update Golfer\n" + "GolderID:\n" + "GolferName:\n" + "GolferHandicap:\n" + "TelegramID:";
        //String command = "Update Tournament\n" + "TournamentID:\n" + "TournamentDate:\n" + "ModeOfPlay:";
        if (command.contains("Update Hole")){
            String[] arr = command.split("\n", 0);

            String hole_number = arr[1].substring(12,arr[1].length());
            String hole_index = arr[2].substring(11,arr[2].length());
            String hole_par = arr[3].substring(9,arr[3].length());
            System.out.println("hole number " +hole_number);
            System.out.println("hole index "+hole_index);
            System.out.println("hole par "+hole_par);
        }else if (command.contains("Update Golfer")){
            String[] arr = command.split("\n", 0);

            String golfer_id = arr[1].substring(9,arr[0].length());
            String golfer_name = arr[2].substring(11,arr[1].length());
            String golfer_handicap = arr[3].substring(15,arr[2].length());
            String telegram_id = arr[4].substring(11,arr[3].length());

        }else if (command.contains("Update Tournament")){
            String[] arr = command.split("\n", 0);

            String tournament_id = arr[1].substring(14,arr[1].length());
            String tournament_date = arr[2].substring(16,arr[2].length());
            String mode_of_play = arr[3].substring(13,arr[3].length());
            System.out.println(tournament_date);
            System.out.println(tournament_id);
            System.out.println(mode_of_play);

        }
    }

}


