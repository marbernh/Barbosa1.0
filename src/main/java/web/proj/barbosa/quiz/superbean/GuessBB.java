/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
