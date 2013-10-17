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
import web.proj.barbosa.quiz.UserDB;
import web.proj.barbosa.quiz.UserRegister;

/**
 * The GameBean handels the game by starting a new game, round and
 * getting the url for the pictures. 
 * It also handels the players life and score.
 * 
 * @author Iron-Maven
 */
@Named("gameBean")
@SessionScoped
public class GameBean implements Serializable {
    
    
    @Inject
    private AccountBB lb;
    private ArrayList<String> lifes;
    private final GameEngine g = new GameEngine();
    private int life,score;
    private ArrayList<String> picUrl = new ArrayList<>();
    private UserRegister ur = (UserRegister) UserRegister.newInstance("quiz_pu");

    
    public GameBean() {
        life = 3;
        score = 0;
        g.newGame();
        picUrl = g.getPics();
    }
      
    public String newGame(){
        if(lb.getLoggedIn()){
            UserDB user = ur.getByName(lb.getUsername());
            if(score > user.getTopGameScore()){
                user.update(score);
                ur.update(user);
            }
        }
        life = 3;
        score = 0;
        g.newGame();
        picUrl = g.getPics();
        return "index";
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

    public String getAnswer(){
        return g.getAnswer();
    }
}
