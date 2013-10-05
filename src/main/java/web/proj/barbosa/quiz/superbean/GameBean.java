/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import javax.ejb.Singleton;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import web.proj.barbosa.quiz.GameEngine;
import web.proj.barbosa.quiz.GameFactory;
import web.proj.barbosa.quiz.Leaderboard;

/**
 *
 * @author Filip Husnjak
 */
@Named("gameBean")
@SessionScoped
public class GameBean implements Serializable {
    
    private final GameEngine g = new GameEngine();
    private GameFactory gf = new GameFactory();
    private Leaderboard leaderboard;
    
    public GameBean() {
        g.newGame();
        leaderboard = gf.getLeaderboard();
    }
    public String newGame(){
        g.newGame();
        return "guess";
    }
    public void nextRound(){
        g.nextRound();
    }
    
    public String getPicUrl(String num){
        return g.getPics().get(Integer.valueOf(num));
    }
    
    public Leaderboard getLeaderboard(){
        return leaderboard;
    }

    public String getAnswer(){
        System.out.println("getanswer gamebean");
        return g.getAnswer();
    }
    
}
