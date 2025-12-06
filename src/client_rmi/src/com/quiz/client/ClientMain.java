package client_rmi.src.com.quiz.client;


import server_rmi.com.quiz.server.rmi.QuizService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain {

    public static QuizService quizService;

    public static void main(String[] args) {
        try {
            // Connexion au registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Récupérer le service
            quizService = (QuizService) registry.lookup("QuizService");

            System.out.println("✔ Connexion au serveur RMI réussie !");

            // Lancer menu d’accueil
            MenuAccueil.startMenu();

        } catch (Exception e) {
            System.err.println("❌ Erreur de connexion au serveur RMI");
            e.printStackTrace();
        }
    }
}
