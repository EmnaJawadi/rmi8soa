package server_rmi.com.quiz.server.rmi;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {

    public static void main(String[] args) {
        try {
            // Lancer le registre RMI
            Registry registry = LocateRegistry.createRegistry(1099);

            // Créer service
            QuizService quizService = new QuizServiceImpl();

            // Binder le service dans le registre
            registry.rebind("QuizService", quizService);

            System.out.println("🎯 Serveur RMI démarré sur le port 1099...");
            System.out.println("Service enregistré sous le nom : QuizService");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
