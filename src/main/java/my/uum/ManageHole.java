package my.uum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManageHole {
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
    public void insertHole(String hole_number, String hole_index, String hole_par) {

        String sql = "INSERT INTO golf_hole(hole_no,hole_index,hole_par) VALUES(?,?,?)";

        Connection conn = this.connect();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt((hole_number)));
            stmt.setInt(2, Integer.parseInt((hole_index)));
            stmt.setInt(3, Integer.parseInt((hole_par)));

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
    }    public void deleteHole(String delete_hole) {
        String sql = "DELETE FROM golf_hole WHERE hole_no = ?";
        Connection conn = this.connect();
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, Integer.parseInt((delete_hole)));

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
