package web.proj.barbosa.quiz;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class handles new searches and new games. It generates a word and the
 * links fore the pictures and then it returns it to the gamebean.
 *
 * @author Iron-Maven
 */
public class GameEngine {

    private GameFactory gf;                 //GameFactory contains hardcoded data for testing
    private ArrayList<String> answers;      //answers contain the list of possible words
    private String answer;                  //answer is the current word
    private static Random generator;
    private Search searcher;
    private ArrayList<String> pics;         //the listof pucture url's

    public GameEngine() {
        generator = new Random();
        searcher = new Search();
        gf = new GameFactory();
        gf.createCompetition();             // creates some users to fill the leaderboard
        this.answers = gf.getTestWords();   //imports the words
    }

    //This method uses the Search class to search new pics from "answer"
    public void getNewPics() {
        boolean filled = false;
        while (!filled) {
            int newRandom = generator.nextInt(answers.size());
            this.answer = answers.get(newRandom);
            pics = searcher.searchAndFind(answer);
            answers.remove(answer);
            if (pics != null && !(pics.isEmpty())) {
                filled = true;
            }
        }
    }

    public void newGame() {
        this.answers = gf.getTestWords();
        getNewPics();
    }

    public void nextRound() {
        getNewPics();
    }

    public String getAnswer() {
        return answer;
    }

    public ArrayList<String> getPics() {
        return pics;
    }
}