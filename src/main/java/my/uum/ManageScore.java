package my.uum;

import java.sql.*;
import java.util.ArrayList;

public class ManageScore {

    public Connection connect() {
        String url = "jdbc:sqlite:D:\\UUM\\A202\\InteliJ\\group-project-vaikog\\golfdb.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void score(String golfer_id, String marker_id, int hole_number, String score) {
        String sql = "INSERT INTO golf_score(golfer_id,marker_id,hole_number,score) VALUES(?,?,?,?)";

        Connection conn = this.connect();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt((golfer_id)));
            stmt.setInt(2, Integer.parseInt(((marker_id))));
            stmt.setInt(3, (hole_number));
            stmt.setInt(4, Integer.parseInt((score)));

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Golfer> player() throws ClassNotFoundException, SQLException {
        String sql = "SELECT golfer_id FROM golf_golfer";
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            ArrayList<Golfer> golfers = new ArrayList<>();
            while (rs.next()) {
                Golfer list = new Golfer(rs.getInt("golfer_id"));
                golfers.add(list);
            }
            return golfers;
        }
    }

    public ArrayList<Score> totalScore() throws ClassNotFoundException, SQLException {
        String sql = "SELECT golfer_id, score  FROM golf_score ";

        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            ArrayList<Score> scores = new ArrayList<>();
            while (rs.next()) {
                Score list = new Score(rs.getInt("golfer_id"),rs.getInt("score"));
                scores.add(list);
            }
            return scores;
        }
    }
}
