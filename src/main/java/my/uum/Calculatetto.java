package my.uum;

import java.util.ArrayList;

public class Calculatetto {
    ManageScore manageScore = new ManageScore();
    public void total_score(){
        manageScore.connect();
        ArrayList<Golfer> golfers = null;
        try {
            golfers = manageScore.player();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Golfer> score = null;
        try {
            for (int i=0;i<golfers.size();i++){
                score = manageScore.totalScore(golfers.get(i).getGolfer_id());
                System.out.println(golfers.get(i).getGolfer_id());
        }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String [] args){
        ManageScore manageScore = new ManageScore();
        manageScore.connect();
        ArrayList<Golfer> golfers = null;
        try {
            golfers = manageScore.player();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i=0;i<golfers.size();i++){
            System.out.println(golfers.get(i).getGolfer_id());
        }
    }
}
