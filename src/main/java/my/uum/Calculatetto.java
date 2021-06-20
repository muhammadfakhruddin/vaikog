package my.uum;

import java.util.ArrayList;

public class Calculatetto {
    public static int [] tscore;
    ManageScore manageScore = new ManageScore();
    public void total_score(){
        manageScore.connect();
        ArrayList<Golfer> golfers = null;
        try {
            golfers = manageScore.player();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Score> score = null;
        try {
            for (int i=0;i<golfers.size();i++){
                //score = manageScore.totalScore(golfers.get(i).getGolfer_id());
                //System.out.println(score.get(i).getScore());
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
            //System.out.println(golfers.get(i).getGolfer_id());
        }
        ArrayList<Score> score = null;
        try {
            for (int i=0;i<golfers.size();i++){
                //System.out.println(golfers.get(i).getGolfer_id());
                score = manageScore.totalScore();
                //System.out.println(score.get(i).getScore());
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        int [] totalscore = new int[golfers.size()];
        for (int i=0;i<score.size();i++){
            //System.out.println(score.get(i).getScore());
            //System.out.println(score.get(i).getGolf_id());
        }
        int total = 0;
        for (int i = 0 ; i<golfers.size();i++){
            //System.out.println("GOlfID:"+golfers.get(i).getGolfer_id());
            for (int j = 0; j<score.size();j++) {

                if (golfers.get(i).getGolfer_id() == score.get(j).getGolf_id()) {
                    //System.out.println("Score: "+score.get(j).getScore());
                    total += score.get(j).getScore();
                }

            }
            //total += score.get(i).getScore();
            totalscore[i]=total;
            total=0;
        }
        ArrayList<TotalScore> student = new ArrayList<>();
        for (int i = 0 ; i<golfers.size();i++) {
            System.out.println("Golfer ID: " + golfers.get(i).getGolfer_id());
            System.out.println("Total Score: " + totalscore[i]);
            //System.out.println(golfers.get(i).getGolfer_handicap());
            int netscore = totalscore[i]-golfers.get(i).getGolfer_handicap();
            System.out.println("Net score: "+netscore);
            manageScore.insertScore(golfers.get(i).getGolfer_id(),netscore);
            TotalScore list = new TotalScore(golfers.get(i).getGolfer_id(),netscore);
        }
    }
}
