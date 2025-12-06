package server_rmi.com.quiz.server.model;

public class Game {

    private String gameId;
    private String playerId;
    private String category;
    private int score;

    public Game() {}

    public Game(String gameId, String playerId, String category, int score) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.category = category;
        this.score = score;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
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
