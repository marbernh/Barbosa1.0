package web.proj.barbosa.quiz;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class handles new searches and new games.
 * It generates a word and the links fore the pictures
 * and then it returns it to the gamebean.
 * 
 * @author Filip Husnjak
 */
public class GameEngine {

    //GameFactory contains hardcoded data for testing
    private GameFactory gf; 
    //answers contain the list of possible words
    private ArrayList<String> answers; 
    //answer is the current word
    private String answer;
    //Random
    private static Random generator;
    private Search searcher;
    //the listof pucture url's
    private ArrayList<String> pics;

    public GameEngine() {
        
        generator = new Random();
        searcher = new Search();
        gf = new GameFactory();
        gf.createCompetition(); // creates some users to fill the leaderboard
        this.answers = gf.getTestWords(); //imports the words
    }

    //This method uses the Search class to search new pics from "answer"
    public void getNewPics() {
        boolean filled = false;
        while (!filled) {
            int newRandom = generator.nextInt(answers.size());
            this.answer = answers.get(newRandom);
            pics = searcher.searchAndFind(answer);
            answers.remove(answer);
            if(pics != null && !(pics.isEmpty()))
                filled = true;
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