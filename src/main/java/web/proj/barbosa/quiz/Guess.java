/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

/**
 *
 * @author marcus
 */
public class Guess {
    private GameEngine engine;

    
    public Guess(GameEngine engine){
        this.engine = engine;
    }

    public String validate(String guess) {
        if ( engine.getAnswer().equals(guess)){
            engine.increaseScore();
            engine.nextRound();
            return "Your answer is correct";
        } else if(engine.looseLife() == 0){
            return "gameOver";
        } else{
            return "Your answer is wrong";
        }
    }
}
