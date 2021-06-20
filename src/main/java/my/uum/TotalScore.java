package my.uum;

public class TotalScore {
    private final int golfer_id,totalScore;

    public TotalScore(int golfer_id,int totalScore) {
        this.golfer_id = golfer_id;
        this.totalScore = totalScore;
    }

    public int getGolfer_id() {
        return golfer_id;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
