package my.uum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDb {
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


    public void updateHole(String hole_index, String hole_par, String hole_number) {
        String sql = "UPDATE golf_hole SET hole_index = ? , hole_par = ? WHERE hole_no = ?";

        Connection conn = this.connect();
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, Integer.parseInt((hole_index)));
            stmt.setInt(2, Integer.parseInt((hole_par)));
            stmt.setInt(3, Integer.parseInt((hole_number)));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateGolfer(String golfer_name, String golfer_handicap, String telegram_id, String golfer_id) {
        String sql = "UPDATE golf_golfer SET golfer_name = ? , golfer_handicap = ? , telegram_id = ? WHERE golfer_id = ?";

        Connection conn = this.connect();
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, (golfer_name));
            stmt.setInt(2, Integer.parseInt((golfer_handicap)));
            stmt.setInt(3, Integer.parseInt((telegram_id)));
            stmt.setInt(4, Integer.parseInt((golfer_id)));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTournament(String tournament_date, String mode_of_play, String tournament_id) {

        String sql = "UPDATE golf_tournament SET tournament_date = ? , tournament_mode_of_play = ?  WHERE tournament_id = ?";

        Connection conn = this.connect();
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, (tournament_date));
            stmt.setString(2, (mode_of_play));
            stmt.setInt(3, Integer.parseInt((tournament_id)));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
