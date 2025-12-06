package server_rmi.com.quiz.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // Enregistrer un nouveau joueur
    public void insertUser(String playerId, String playerName) {
        String sql = "INSERT INTO users(player_id, name) VALUES(?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, playerId);
            ps.setString(2, playerName);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Vérifier si un joueur existe
    public boolean userExists(String playerId) {
        String sql = "SELECT player_id FROM users WHERE player_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, playerId);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
