package server_rmi.com.quiz.server.rmi;

import server_rmi.com.quiz.server.dao.*;
import server_rmi.com.quiz.server.model.*;
import server_rmi.com.quiz.server.utils.IDGenerator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class QuizServiceImpl extends UnicastRemoteObject implements QuizService {

    private UserDAO userDAO;
    private CategoryDAO categoryDAO;
    private QuestionDAO questionDAO;
    private GameDAO gameDAO;

    public QuizServiceImpl() throws RemoteException {
        super();
        userDAO = new UserDAO();
        categoryDAO = new CategoryDAO();
        questionDAO = new QuestionDAO();
        gameDAO = new GameDAO();
    }

    @Override
    public String registerPlayer(String playerName) throws RemoteException {
        // Générer ID joueur
        String playerId = IDGenerator.generatePlayerId();

        // Créer objet User
        User user = new User(playerId, playerName);

        // Enregistrer dans la DB
        userDAO.insertUser(playerId, playerName);

        System.out.println("✔ Joueur enregistré : " + playerName + " | ID=" + playerId);
        return playerId;
    }

    @Override
    public List<String> getCategories() throws RemoteException {
        // Retourner liste des catégories depuis DB
        return categoryDAO.getAllCategories();
    }

    @Override
    public List<String> getQuestionsByCategory(String category) throws RemoteException {
        // Récupérer toutes les questions de la catégorie
        List<Question> questions = questionDAO.getQuestionsByCategoryObjects(category);

        List<String> formattedQuestions = new ArrayList<>();
        for (Question q : questions) {
            String qText = q.getText() + "\n" +
                    "1) " + q.getOption1() + "\n" +
                    "2) " + q.getOption2() + "\n" +
                    "3) " + q.getOption3() + "\n" +
                    "4) " + q.getOption4();
            formattedQuestions.add(qText);
        }

        return formattedQuestions;
    }

    @Override
    public void submitScore(String playerId, int score) throws RemoteException {
        // Créer un ID de jeu
        String gameId = IDGenerator.generateGameId();

        // Pour simplifier, on prend la dernière catégorie jouée (à améliorer si multijoueur réel)
        // Ici tu peux modifier pour passer la catégorie depuis le client
        String category = "Science";

        // Créer objet Game
        Game game = new Game(gameId, playerId, category, score);

        // Enregistrer score dans la DB
        gameDAO.saveScore(playerId, category, score);

        System.out.println("✔ Score reçu : Player=" + playerId + " | Score=" + score);
    }
}
