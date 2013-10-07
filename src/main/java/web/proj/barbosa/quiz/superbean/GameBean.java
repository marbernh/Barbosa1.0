/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import java.util.ArrayList;
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
    
    private ArrayList<String> lifes;
    private final GameEngine g = new GameEngine();
    private GameFactory gf = new GameFactory();
    private int life,score;
    private Leaderboard leaderboard;
    
    public GameBean() {

        life = 3;
        score = 0;
        g.newGame();
        leaderboard = gf.getLeaderboard();
    }
        
    public String newGame(){
        life = 3;
//        lifes.clear();
//        for(int i = 0; i < life; i++){
//            lifes.add("");
//        }
        score = 0;
        g.newGame();
        return "guess";
    }
    
    public void nextRound(){
        life = 3;
        g.nextRound();
    }
    
    public void increaseScore(){
        score = score + (life * 5);
    }
    
    public int looseLife(){


        life--;
        return life;
    }
    
    
    public ArrayList<String> getLifes(){
        return lifes;
    }
    
    public String getLife(){
        return Integer.toString(life);
    }
    
    public String getScore(){
        return Integer.toString(score);
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
