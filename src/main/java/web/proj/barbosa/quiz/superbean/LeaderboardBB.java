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
@RequestScoped
public class LeaderboardBB implements Serializable{

    @Inject  
    private GameFactory gf;
    private ArrayList<User> topList = new ArrayList<>();
    private ArrayList<String> namesInTop = new ArrayList<>();
    private ArrayList<String> scoreInTop = new ArrayList<>();
    private int topListSize = 0;
    
    public LeaderboardBB(){

    }
    
    public int getTopListSize() {
        topList = gf.getLeaderboard().getTopList();
        setNamesInTop(topList);
        setScoreInTop(topList);
        topListSize = topList.size() - 1;
        return topListSize;
    }

//    public void updateLB(){
//
//    }
    
//    public ArrayList<String> getNamesInTop() {
//        return namesInTop;
//    }
    
    public String getNamesInTop(int i) {
        return namesInTop.get(i);
    }

    public void setNamesInTop(ArrayList<User> topList) {
        for(int i = 0; i < topList.size(); i++){
            this.namesInTop.add(i, topList.get(i).getUserName());
        }
        
    }

    public String getScoreInTop(int i) {
        return scoreInTop.get(i);
    }

    public void setScoreInTop(ArrayList<User> topList) {
        for(int i = 0; i < topList.size(); i++){
            this.scoreInTop.add(i, Integer.toString(topList.get(i)
                    .getResult().getTopGameScore()));
        }
    }
    
//    public ArrayList<User> get1TopList(){
//        return lBoard.getTopList();
//    }

    
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