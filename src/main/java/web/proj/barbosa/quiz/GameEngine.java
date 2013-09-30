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
    private int guessRight,guessWrong;
    private String[] answers = GameFactory.getTestWords();
    private String answer;
    private static Random generator;
    private Search searcher;
    private ArrayList<String> pics = new ArrayList<String>();

    public void newGame() {
        life = 3;
        score = 0;
        int random = generator.nextInt(answers.length);
        this.answer = answers[random];
        pics = searcher.searchAndFind(answer);
    }

    public void nextRound() {
        life = 3;
        int newRandom = generator.nextInt(answers.length);
        this.answer = answers[newRandom];
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
    public void gameOver(User user){
        user.result.update(guessRight,guessWrong,score);
    }

    public String getAnswer() {
        return answer;
    }
    
    public int getScore(){
        return this.score;
    }
    
    public ArrayList<String> getPics(){
        return pics;
    }
}
