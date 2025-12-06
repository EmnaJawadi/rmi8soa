package common.src.com.quiz.common;

import java.io.Serializable;

public class QuestionDTO implements Serializable {

    private int id;
    private String text;
    private String category;

    public QuestionDTO() {}

    public QuestionDTO(int id, String text, String category) {
        this.id = id;
        this.text = text;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
