package common.src.com.quiz.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface QuizService extends Remote {

    // Enregistrer joueur + retourner UserDTO
    UserDTO registerPlayer(String playerName) throws RemoteException;

    // Retourner la liste des catégories
    List<String> getCategories() throws RemoteException;

    // Retourner les questions d’une catégorie (DTO)
    List<QuestionDTO> getQuestionsByCategory(String category) throws RemoteException;

    // Enregistrer score + retourner GameDTO
    GameDTO submitScore(String playerId, String category, int score) throws RemoteException;
}
