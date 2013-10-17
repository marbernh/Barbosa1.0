/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.util.Timer;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * 
 * 
 * @author Iron-Maven
 */
@Named("guessBean")
@RequestScoped
public class GuessBB {

    private String guess;
    private String outcome = "";
    private String start = "Your Guess is?";
    @Inject
    private GameBean game;

    public String validate() {
        if (game.getAnswer().equals(guess)) {
            outcome = "Your answer is correct";
            game.increaseScore();
            game.nextRound();
            guess = "";
            return "guess";
        } else if (game.looseLife() == 0) {
            outcome = "GAME OVER";
            game.newGame();
        } else {
            outcome = "Your answer is wrong";
        }
        guess = "";
        return "guess";
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
