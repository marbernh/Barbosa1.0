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

    private int life;
    private int score;
    private int guessRight, guessWrong;
    private GameFactory gf;
    private String[] answers;
    private String answer;
    private static Random generator;// = new Random();
    private Search searcher; //= new Search();
    private ArrayList<String> pics;

    public GameEngine() {
        generator = new Random();
        searcher = new Search();
        gf = new GameFactory();
        this.answers = gf.getTestWords();
    }

    public void newGame() {
        getNewPics();
    }

    public void nextRound() {
        getNewPics();
    }

    public void getNewPics() {
        pics = null;
        while (pics == null) {
            int newRandom = generator.nextInt(answers.length);
            this.answer = answers[newRandom];
            pics = searcher.searchAndFind(answer);
        }

    }

    public String makeGuess(String guess) {
        if (guess.equals(answer)) {
            score = life * 15;
            this.guessRight++;
            return "correct";
        } else if (!(guess.equals(answer)) && life-- > 0) {
            guessWrong++;
            return "try again";
        } else if (!(guess.equals(answer)) && life-- == 0) {
            guessWrong++;
            return "game over";
        } else {
            return "error";
        }
    }
//
//    public void gameOver(User user) {
//        user.getResult().update(guessRight, guessWrong, score);
//    }
//
    public String getAnswer() {

        System.out.println("getanswer engine");
        return answer;
    }

    public int getScore() {
        return this.score;
    }

    public ArrayList<String> getPics() {
        return pics;
    }
}
