package server_rmi.com.quiz.server.model;

public class Question {

    private int id;
    private String text;
    private int categoryId;

    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int correctOption; // 1-4

    public Question() {}

    public Question(int id, String text, int categoryId,
                    String option1, String option2, String option3, String option4,
                    int correctOption) {
        this.id = id;
        this.text = text;
        this.categoryId = categoryId;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctOption = correctOption;
    }

    // ----- Getters & Setters -----
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public String getOption1() { return option1; }
    public void setOption1(String option1) { this.option1 = option1; }

    public String getOption2() { return option2; }
    public void setOption2(String option2) { this.option2 = option2; }

    public String getOption3() { return option3; }
    public void setOption3(String option3) { this.option3 = option3; }

    public String getOption4() { return option4; }
    public void setOption4(String option4) { this.option4 = option4; }

    public int getCorrectOption() { return correctOption; }
    public void setCorrectOption(int correctOption) { this.correctOption = correctOption; }
}
