/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Filip Husnjak
 */
@Named("guessBean")
@RequestScoped
public class GuessBB {
    
    private String guess;
    private String outcome = "";
    @Inject
    private GameBean game;
    
    public String validate(){
        System.out.println("validate");
 
        System.out.println("answer " + game.getAnswer());
        System.out.println("guess" + guess);
        if(game.getAnswer().equals(guess)){
            System.out.println("Stämmer " + guess);
            outcome = "Your answer is correct";
            return "guess";
        }else
            System.out.println("Stämmer ej");
            outcome = "Your answer is wrong";
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
