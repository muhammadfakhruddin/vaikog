package my.uum;

public class Golfer {
    private final int golfer_id,golfer_handicap;

    public Golfer(int golfer_id, int golfer_handicap) {
        this.golfer_id = golfer_id;
        this.golfer_handicap = golfer_handicap;
    }

    public int getGolfer_id() {
        return golfer_id;
    }

    public int getGolfer_handicap() {
        return golfer_handicap;
    }
}
