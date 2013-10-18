/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import web.proj.barbosa.quiz.Guess;
import web.proj.barbosa.quiz.UserRegister;

/**
 * GuessBB is a part of the game mechanics.
 * It takes the players guess and compares it to the answer through
 * the function validate.
 *
 * @author Iron-Maven
 */
@Named("guessBean")
@RequestScoped
public class GuessBB {
    
    private String guess;
    private String outcome = "";
    @Inject
    private GameBean game;
    private Guess guessHandler;
    
    public GuessBB() {
    }
    
    @PostConstruct
    public void postConstruct() {
        guessHandler = new Guess(game.getGameEngine());
    }
    
    public String validate() {
        //        guessHandler = new Guess(game.getGameEngine());
        outcome = guessHandler.validate(guess);
        guess = "";
        if(outcome.equals("gameOver")){
            return outcome;
        } else{
            return "index";
        }
    }
    //        if (game.getAnswer().equals(guess)) {
    //            outcome = "Your answer is correct";
    //            game.increaseScore();
    //            game.nextRound();
    //
    //        } else if (game.looseLife() == 0) {
    //            outcome = "GAME OVER";
    //            guess = "";
    //            return "gameOver";
    //        } else {
    //            outcome = "Your answer is wrong";
    //        }
    //        guess = "";
    //        return "index";
    //    }
    
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
