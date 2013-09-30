/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import web.proj.barbosa.quiz.GameFactory;
import web.proj.barbosa.quiz.Leaderboard;
import web.proj.barbosa.quiz.Result;

/**
 *
 * @author Filip Husnjak
 */
@Named("leaderboardBean")
@RequestScoped
public class LeaderboardBB {
    
    private GameFactory data = new GameFactory();
    public Leaderboard board;  
    @Inject
    private GameBean game;
    
    public ArrayList<Result> getResult(){
        ArrayList<Result> result = new ArrayList<Result>();
        board = game.getLeaderboard();
        for(int i = 0; i < 10; i++){
            result;
        }
         
        return null;
        
    }

}