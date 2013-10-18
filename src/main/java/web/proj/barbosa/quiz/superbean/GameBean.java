/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import web.proj.barbosa.quiz.GameEngine;
import web.proj.barbosa.quiz.UserRegister;

/**
 * The GameBean handles the game by starting a new game, round and
 * getting the url for the pictures.
 * It also handles the players life and score.
 *
 * @author Iron-Maven
 */
@Named("gameBean")
@SessionScoped
public class GameBean implements Serializable {
    
    
    @Inject
    private AccountBB lb;
    private final GameEngine g = new GameEngine();
//    private int life,score;
//    private ArrayList<String> picUrl = new ArrayList<>();
//    private UserRegister ur = (UserRegister) UserRegister.newInstance("quiz_pu");
    
    
    public GameBean() {
        g.newGame();
    }
    
    public GameEngine getGameEngine(){
        return g;
    }
    
    public String newGame(){
        if(lb.getLoggedIn()){
            g.updateScore(lb.getUsername());
        }
        g.newGame();
        return "index";
    }
    
    public void nextRound(){
        //        life = 3;
        g.nextRound();
        g.getLife();
    }
    
    public void increaseScore(){
        g.increaseScore();
    }
    
    public int looseLife(){
        g.looseLife();
//        life--;
        return g.getLife();
    }
    
    public String getLife(){
        return Integer.toString(g.getLife());
    }
    
    public String getScore(){
        return Integer.toString(g.getScore());
    }
    
    public ArrayList<String> getPicUrl(){
        return g.getPics();
    }
    
    public String getAnswer(){
        return g.getAnswer();
    }
}
