package my.uum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDb {
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
    public void deleteHole(String delete_hole) {
        String sql = "DELETE FROM golf_hole WHERE hole_no = ?";
        Connection conn = this.connect();
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, Integer.parseInt((delete_hole)));

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteGolfer(String delete_golfer) {
        String sql = "DELETE FROM golf_golfer WHERE golfer_id = ?";
        Connection conn = this.connect();
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, Integer.parseInt((delete_golfer)));

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
