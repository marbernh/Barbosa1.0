/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import web.proj.barbosa.quiz.GameFactory;
import web.proj.barbosa.quiz.Leaderboard;
import web.proj.barbosa.quiz.Result;
import web.proj.barbosa.quiz.User;

/**
 *
 * @author Filip Husnjak
 */
@Named("leaderboardBean")
@SessionScoped
public class LeaderboardBB implements Serializable{

    @Inject
    private GameBean game;
    @Inject
    private Leaderboard lBoard;
    private ArrayList<User> topList;
    
//    public ArrayList<User> get1TopList(){
//        return lBoard.getTopList();
//    }
    public void updateLB(){
                topList = lBoard.getTopList();
    }
    
    public ArrayList<User> getTopList(){
        return topList;
    }
    
//    private String score;

//    public String getScore() {
//        this.score = "" + getFirstResult().getTotalScore();
//        return score;
//    }
//
//    public Result getFirstResult() {
//        Leaderboard list = game.getLeaderboard();
//        Result result = list.getMap().firstEntry().getValue();
//        System.out.println(list.getMap().firstEntry().getValue().getTotalScore());
//        return result;
//    }
}