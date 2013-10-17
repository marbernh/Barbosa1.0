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
 *
 * @author Filip Husnjak
 */
@Named("gameBean")
@SessionScoped
public class GameBean implements Serializable {
    
    
    @Inject
    private LoginBean lb;
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
            UserDB user = ur.getByName(lb.getUsername()).get(0);
            if(score > user.getTopGameScore()){
                user.update(score);
                ur.update(user);
            }
        }
        life = 3;
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

    public String getAnswer(){
        return g.getAnswer();
    }
}
