package client_rmi.src.com.quiz.client;

import java.util.List;
import java.util.Scanner;

public class MenuCategories {

    public static void showCategories() {
        try {
            List<String> categories = ClientMain.quizService.getCategories();

            System.out.println("\n===== CHOISISSEZ UNE CATÉGORIE =====");
            for (int i = 0; i < categories.size(); i++) {
                System.out.println((i + 1) + " - " + categories.get(i));
            }

            Scanner sc = new Scanner(System.in);
            System.out.print("Votre choix : ");
            int choix = sc.nextInt();

            String category = categories.get(choix - 1);
            System.out.println("\n✔ Catégorie choisie : " + category);

            QuizSession.startQuiz(category);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
