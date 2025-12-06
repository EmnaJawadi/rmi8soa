package server_rmi.com.quiz.server.model;

public class Score {

    private String playerId;
    private String category;
    private int score;

    public Score() {}

    public Score(String playerId, String category, int score) {
        this.playerId = playerId;
        this.category = category;
        this.score = score;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
