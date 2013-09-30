/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import javax.ejb.Singleton;
import web.proj.barbosa.quiz.GameEngine;
import web.proj.barbosa.quiz.Leaderboard;
import web.proj.barbosa.quiz.Result;

/**
 *
 * @author Filip Husnjak
 */
@Singleton
public class GameBean implements Serializable {
    
    private final GameEngine g = new GameEngine();

    public GameBean() {
    }
    


    public String getAnswer(){
        return g.getAnswer();
    }
    
}
