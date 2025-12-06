package client_rmi.src.com.quiz.client;

import java.util.Scanner;

public class MenuAccueil {

    public static String playerId;
    public static String playerName;

    public static void startMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== QUIZ MULTIJOUEURS =====");
        System.out.print("Entrez votre nom : ");
        playerName = sc.nextLine();

        try {
            playerId = ClientMain.quizService.registerPlayer(playerName);
            System.out.println("✔ Votre ID joueur : " + playerId);

            MenuCategories.showCategories();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
