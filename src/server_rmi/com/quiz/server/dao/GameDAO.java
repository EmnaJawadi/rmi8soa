package server_rmi.com.quiz.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class GameDAO {

    public void saveScore(String playerId, String category, int score) {

        String sql = "INSERT INTO scores(player_id, category, score) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, playerId);
            ps.setString(2, category);
            ps.setInt(3, score);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
