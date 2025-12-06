package server_rmi.com.quiz.server.dao;

import server_rmi.com.quiz.server.model.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {

    // 1️⃣ Récupérer toutes les questions d'une catégorie (texte seul)
    public List<String> getQuestionsByCategory(String categoryName) {
        List<String> questions = new ArrayList<>();
        String sql = """
                SELECT q.question_text
                FROM questions q
                JOIN categories c ON q.category_id = c.id
                WHERE c.name = ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, categoryName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                questions.add(rs.getString("question_text"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }

    // 2️⃣ Récupérer les questions complètes (objet Question) d'une catégorie
    public List<Question> getQuestionsByCategoryObjects(String categoryName) {
        List<Question> questions = new ArrayList<>();
        String sql = """
                SELECT q.id, q.question_text, q.option1, q.option2, q.option3, q.option4, q.correct_option
                FROM questions q
                JOIN categories c ON q.category_id = c.id
                WHERE c.name = ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, categoryName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Question q = new Question();
                q.setId(rs.getInt("id"));
                q.setText(rs.getString("question_text"));
                q.setOption1(rs.getString("option1"));
                q.setOption2(rs.getString("option2"));
                q.setOption3(rs.getString("option3"));
                q.setOption4(rs.getString("option4"));
                q.setCorrectOption(rs.getInt("correct_option"));
                questions.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }

    // 3️⃣ Récupérer une question par ID
    public Question getQuestionById(int id) {
        Question q = null;
        String sql = """
                SELECT id, question_text, option1, option2, option3, option4, correct_option
                FROM questions
                WHERE id = ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                q = new Question();
                q.setId(rs.getInt("id"));
                q.setText(rs.getString("question_text"));
                q.setOption1(rs.getString("option1"));
                q.setOption2(rs.getString("option2"));
                q.setOption3(rs.getString("option3"));
                q.setOption4(rs.getString("option4"));
                q.setCorrectOption(rs.getInt("correct_option"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return q;
    }

    // 4️⃣ Ajouter une nouvelle question
    public boolean insertQuestion(Question question, int categoryId) {
        String sql = """
                INSERT INTO questions (category_id, question_text, option1, option2, option3, option4, correct_option)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, categoryId);
            ps.setString(2, question.getText());
            ps.setString(3, question.getOption1());
            ps.setString(4, question.getOption2());
            ps.setString(5, question.getOption3());
            ps.setString(6, question.getOption4());
            ps.setInt(7, question.getCorrectOption());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 5️⃣ Mettre à jour une question
    public boolean updateQuestion(Question question) {
        String sql = """
                UPDATE questions
                SET question_text=?, option1=?, option2=?, option3=?, option4=?, correct_option=?
                WHERE id=?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, question.getText());
            ps.setString(2, question.getOption1());
            ps.setString(3, question.getOption2());
            ps.setString(4, question.getOption3());
            ps.setString(5, question.getOption4());
            ps.setInt(6, question.getCorrectOption());
            ps.setInt(7, question.getId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 6️⃣ Supprimer une question
    public boolean deleteQuestion(int id) {
        String sql = "DELETE FROM questions WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
