package client_rmi.src.com.quiz.client;

import java.util.List;
import java.util.Scanner;

public class QuizSession {

    public static void startQuiz(String category) {
        int score = 0;

        try {
            List<String> questions =
                    ClientMain.quizService.getQuestionsByCategory(category);

            Scanner sc = new Scanner(System.in);

            System.out.println("\n===== QUIZ : " + category + " =====");

            for (String q : questions) {
                System.out.println("\n" + q);
                System.out.print("Votre réponse (appuyez Entrée) : ");
                sc.nextLine(); // aucune correction, juste simulation

                score++;
            }

            // Envoyer score vers RMI
            ClientMain.quizService.submitScore(MenuAccueil.playerId, score);

            Resultats.afficherResultats(category, score);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
