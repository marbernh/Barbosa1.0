/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import javax.ejb.Singleton;
import javax.inject.Named;
import web.proj.barbosa.quiz.GameEngine;
import web.proj.barbosa.quiz.GameFactory;
import web.proj.barbosa.quiz.Leaderboard;

/**
 *
 * @author Filip Husnjak
 */
@Named("gameBean")
public class GameBean implements Serializable {
    
    private final GameEngine g = new GameEngine();
    private GameFactory gf = new GameFactory();
    private Leaderboard leaderboard;
    
    public GameBean() {
        leaderboard = gf.getLeaderboard();
        
        g.newGame();
    }
    public void submitGuess(){
        
    }
    
    public String getPicUrl(String num){
        return g.getPics().get(Integer.valueOf(num));
    }
    
    public Leaderboard getLeaderboard(){
        return leaderboard;
    }

    public String getAnswer(){
        return g.getAnswer();
    }
    
}
