package my.uum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManageGolfer {
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
    public void insertGolfer(String golfer_id, String golfer_name, String golfer_handicap, String telegram_id) {
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
}
