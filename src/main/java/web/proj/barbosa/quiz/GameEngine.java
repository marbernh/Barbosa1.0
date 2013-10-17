/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Filip Husnjak
 */
public class GameEngine {

    private GameFactory gf;
    private ArrayList<String> answers;
    private String answer;
    private static Random generator;// = new Random();
    private Search searcher; //= new Search();
    private ArrayList<String> pics;

    public GameEngine() {
        generator = new Random();
        searcher = new Search();
        gf = new GameFactory();
        gf.createCompetition(); // Skapar test spelare.....
        this.answers = gf.getTestWords();
    }

    public void newGame() {
       this.answers = gf.getTestWords();
       getNewPics();
       
    }

    public void nextRound() {
        getNewPics();
    }

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
        System.out.println(pics);

    }
    
    public String getAnswer() {
        return answer;
    }
    
    public ArrayList<String> getPics() {
        return pics;
    }
    
}