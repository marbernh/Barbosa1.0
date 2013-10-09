/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

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
    @Inject
    private GameBean game;
    @Inject
    private LoginBean login;
    
    
    public String validate(){
        if(game.getAnswer().equals(guess)){
            outcome = "Your answer is correct";
            game.increaseScore();
            game.nextRound();
            return "guess";
        }else
            if (game.looseLife() == 0){
                if (login.getLoggedIn()){
                    gf.getUser(login.getUsername()).getResult().update(Integer.parseInt(game.getScore()));
                }
                outcome="GAME OVER";
                game.newGame();
            }else{
            outcome = "Your answer is wrong";
            }
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
