package client_rmi.src.com.quiz.client;

public class Resultats {

    public static void afficherResultats(String category, int score) {

        System.out.println("\n===== RÉSULTATS =====");
        System.out.println("Joueur : " + MenuAccueil.playerName
                + " (" + MenuAccueil.playerId + ")");
        System.out.println("Catégorie : " + category);
        System.out.println("Score final : " + score);

        System.out.println("\nMerci d'avoir joué !");
    }
}
