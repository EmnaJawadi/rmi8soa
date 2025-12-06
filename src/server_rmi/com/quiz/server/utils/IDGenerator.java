package server_rmi.com.quiz.server.utils;

import java.util.UUID;

public class IDGenerator {

    // Générer un ID joueur : P-XXXX
    public static String generatePlayerId() {
        return "P-" + UUID.randomUUID().toString().substring(0, 8);
    }

    // Générer un ID de jeu : G-XXXX
    public static String generateGameId() {
        return "G-" + UUID.randomUUID().toString().substring(0, 8);
    }
}
