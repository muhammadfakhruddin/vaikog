package my.uum;

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
        }else if (command.contains("Score Submission")){
            String [] arr = command.split("\n",0);
            String [] ars = new String[18];
            String golfer_id=arr[1].substring(9, arr[1].length());
            String marker_id=arr[2].substring(9, arr[2].length());

            for (int i=0;i< ars.length;i++){ ars[i]= arr[i+3].substring(8, arr[i+3].length()); }

            for (int i=0;i< ars.length;i++){ db.score(golfer_id,marker_id,(i+1),ars[i]); }
        }
    }

    public static void main(String[]args){
}

}


