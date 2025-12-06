package common.src.com.quiz.common;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String playerId;
    private String name;

    public UserDTO() {}

    public UserDTO(String playerId, String name) {
        this.playerId = playerId;
        this.name = name;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
