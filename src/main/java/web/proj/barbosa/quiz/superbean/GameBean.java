/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import java.util.ArrayList;
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
    private ArrayList<String> picUrl = new ArrayList<String>();
    
    public GameBean() {

        life = 3;
        score = 0;
        g.newGame();
        picUrl = g.getPics();
        leaderboard = gf.getLeaderboard(); // test Leaderboard.
    }
        
    public String newGame(){
        life = 3;
//        lifes.clear();
//        for(int i = 0; i < life; i++){
//            lifes.add("");
//        }
        score = 0;
        g.newGame();
        picUrl = g.getPics();
        return "guess";
    }
    
    public void nextRound(){
        life = 3;
        g.nextRound();
        picUrl = g.getPics();
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
    
    public ArrayList<String> getPicUrl(){
        return picUrl;
    }
    
    public Leaderboard getLeaderboard(){
        return leaderboard;
    }

    public String getAnswer(){
        System.out.println("getanswer gamebean");
        return g.getAnswer();
    }
    
}
