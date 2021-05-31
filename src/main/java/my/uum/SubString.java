package my.uum;

import java.util.ArrayList;

public class SubString {
Database db = new Database();
    public void test(String command) {
        db.connect();
        if (command.contains("HoleNumber")){
            String[] arr = command.split("\n", 0);
            String hole_number = arr[0].substring(11,arr[0].length());
            String hole_index = arr[1].substring(10,arr[1].length());
            String hole_par = arr[2].substring(8,arr[2].length());
            db.hole(hole_number,hole_index,hole_par);
        }else if (command.contains("GolderID")){
            String[] arr = command.split("\n", 0);
            String golfer_id = arr[0].substring(9,arr[0].length());
            String golfer_name = arr[1].substring(11,arr[1].length());
            String golfer_handicap = arr[2].substring(15,arr[2].length());
            String telegram_id = arr[3].substring(11,arr[3].length());
            db.golfer(golfer_id,golfer_name,golfer_handicap,telegram_id);
        }else if (command.contains("TournamentID")){
            String[] arr = command.split("\n", 0);
            String tournament_id = arr[0].substring(13,arr[0].length());
            String tournament_date = arr[1].substring(15,arr[1].length());
            String mode_of_play = arr[2].substring(11,arr[2].length());
            db.tournament(tournament_id,tournament_date,mode_of_play);
        }
    }

    public static void main(String[]args){

        String command = "HoleNumber:123\n" +
                "HoleIndex:123\n" +
                "HolePar:123";

        if (command.contains("HoleNumber")){
            String[] arr = command.split("\n", 0);

            String hole_number = arr[0].substring(11,arr[0].length());
            String hole_index = arr[1].substring(10,arr[1].length());
            String hole_par = arr[2].substring(8,arr[2].length());
            System.out.println(hole_number);
            System.out.println(hole_index);
            System.out.println(hole_par);
        }else if (command.contains("GolderID")){
            String[] arr = command.split("\n", 0);
            String golfer_id = arr[0].substring(9,arr[0].length());
            String golfer_name = arr[1].substring(11,arr[1].length());
            String golfer_handicap = arr[2].substring(15,arr[2].length());
            String telegram_id = arr[3].substring(11,arr[3].length());
            System.out.println(golfer_id);
            System.out.println(golfer_name);
            System.out.println(golfer_handicap);
            System.out.println(telegram_id);

        }else if (command.contains("TournamentID")){
            String[] arr = command.split("\n", 0);

            String tournament_id = arr[0].substring(13,arr[0].length());
            String tournament_date = arr[1].substring(15,arr[1].length());
            String mode_of_play = arr[2].substring(11,arr[2].length());

            System.out.println(tournament_id);
            System.out.println(tournament_date);
            System.out.println(mode_of_play);
        }
}

}


