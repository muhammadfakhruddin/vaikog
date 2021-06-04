package my.uum;

import java.sql.*;

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
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, Integer.parseInt((golfer_id)));
            stmt.setInt(2, Integer.parseInt(((marker_id))));
            stmt.setInt(3, (hole_number));
            stmt.setInt(4, Integer.parseInt((score)));

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
