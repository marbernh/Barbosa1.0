/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import web.proj.barbosa.quiz.GameFactory;
import web.proj.barbosa.quiz.User;

/**
 *
 * @author Filip Husnjak
 */
@Named("guessBean")
@RequestScoped
public class GuessBB {

    @Inject
    private GameFactory gf;
    private String guess;
    private String outcome = "";
    private String start = "Your Guess is?";
    private String timeOutString = "";
    @Inject
    private GameBean game;
    @Inject
    private LoginBean login;
    private static boolean timeOut = false;
    private Timer timer = new Timer();

    public String getStart() {
        timer.schedule(new AlertTask(this), 30000);
        return this.start;
    }

    public void setTimeOutString(String str) {
        timeOut = true;
        setOutcome("GAME OVER");
        timeOutString = str;
    }

    public String getTimeOutString() {
        return timeOutString;
    }

    public String validate() {

        if (!timeOut && game.getAnswer().equals(guess)) {
            outcome = "Your answer is correct";
            game.increaseScore();
            game.nextRound();
            guess = "";
            return "guess";
        } else if (game.looseLife() == 0){
            outcome = "GAME OVER";
            game.newGame();
//        } else if (timeOut) {
//            timeOutString = timeOut ? "Time is Out" : "";
//            outcome = "GAME OVER";
//            game.newGame();
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
