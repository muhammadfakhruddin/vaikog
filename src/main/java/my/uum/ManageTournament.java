package my.uum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManageTournament {
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
    public void insertTournament(String tournament_id, String tournament_date, String mode_of_play) {
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
    public void deleteTournament(String delete_tournament) {
        String sql = "DELETE FROM golf_tournament WHERE tournament_id = ?";
        Connection conn = this.connect();
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, Integer.parseInt((delete_tournament)));

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
