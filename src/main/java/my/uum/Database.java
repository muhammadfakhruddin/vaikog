package my.uum;

import java.sql.*;

public class Database {

    public Connection connect(){
        String url="jdbc:sqlite:D:\\UUM\\A202\\InteliJ\\group-project-vaikog\\golfdb.sqlite";
        Connection conn = null;
        try{
            conn= DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void hole(String hole_number, String hole_index, String hole_par) {

        String sql = "INSERT INTO golf_hole(hole_no,hole_index,hole_par) VALUES(?,?,?)";

        Connection conn = this.connect();
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, Integer.parseInt((hole_number)));
            stmt.setInt(2, Integer.parseInt((hole_index)));
            stmt.setInt(3, Integer.parseInt((hole_par)));

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void golfer(String golfer_id, String golfer_name, String golfer_handicap, String telegram_id) {
        String sql = "INSERT INTO golf_golfer(golfer_id,golfer_name,golfer_handicap,telegram_id) VALUES(?,?,?,?)";

        Connection conn = this.connect();
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, Integer.parseInt((golfer_id)));
            stmt.setString(2, (golfer_name));
            stmt.setInt(3, Integer.parseInt((golfer_handicap)));
            stmt.setInt(4, Integer.parseInt((telegram_id)));

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void tournament(String tournament_id, String tournament_date, String mode_of_play) {
        String sql = "INSERT INTO golf_tournament(tournament_id,tounament_date,tournament_mode_of_play) VALUES(?,?,?)";

        Connection conn = this.connect();
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, Integer.parseInt((tournament_id)));
            stmt.setString(2, ((tournament_date)));
            stmt.setString(3, (mode_of_play));

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
