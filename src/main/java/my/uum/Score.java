package my.uum;

public class Score {
    private final int golfer_id,score;

    public Score(int golfer_id,int score) {
        this.golfer_id = golfer_id;
        this.score = score;
    }



    public int getScore() {
        return score;
    }



    public int getGolf_id() {
        return golfer_id;
    }
}
