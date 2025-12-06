package server_rmi.com.quiz.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface QuizService extends Remote {

    // Générer ID joueur
    String registerPlayer(String playerName) throws RemoteException;

    // Retourner catégories (ex: Science, Psychologie...)
    List<String> getCategories() throws RemoteException;

    // Charger questions par catégorie
    List<String> getQuestionsByCategory(String category) throws RemoteException;

    // Enregistrer score
    void submitScore(String playerId, int score) throws RemoteException;
}
