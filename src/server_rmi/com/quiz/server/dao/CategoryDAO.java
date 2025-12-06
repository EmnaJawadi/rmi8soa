package server_rmi.com.quiz.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public List<String> getAllCategories() {
        List<String> categories = new ArrayList<>();

        String sql = "SELECT name FROM categories";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                categories.add(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }
}
