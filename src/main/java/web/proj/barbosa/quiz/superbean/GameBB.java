/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import web.proj.barbosa.quiz.Quiz;
import web.proj.barbosa.quiz.QuizFactory;

/**
 * The GameBB handles the game by starting a new game, round and
 * getting the url for the pictures.
 * It also handles the players life and score.
 *
 * @author Iron-Maven
 */
@Named("gameBean")
@SessionScoped
public class GameBB implements Serializable {
    
    @Inject
    private AccountBB account;
    private final Quiz quiz = (Quiz) QuizFactory.getQuiz(true);
    
    private String guess;
    private String outcome = "";
    
    public GameBB() {
        quiz.newGame();
    }
    
    public String validate() {
        outcome = quiz.validate(guess);
        guess = "";
        if(outcome.equals("")){
            return "gameOver";
        } else{
            return "index";
        }
    }
    
    public String newGame(){
        if(account.getLoggedIn()){
            quiz.updateScore(account.getUsername());
        }
        quiz.newGame();
        return "index";
    }
    
    public void nextRound(){
        //        life = 3;
        quiz.nextRound();
        quiz.getLife();
    }
    
    public void increaseScore(){
        quiz.increaseScore();
    }
    
    public int looseLife(){
        quiz.looseLife();
        return quiz.getLife();
    }
    
    public String getLife(){
        return Integer.toString(quiz.getLife());
    }
    
    public String getScore(){
        return Integer.toString(quiz.getScore());
    }
    
    public ArrayList<String> getPicUrl(){
        return quiz.getPics();
    }
    
    public String getAnswer(){
        return quiz.getAnswer();
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
    
    
}
