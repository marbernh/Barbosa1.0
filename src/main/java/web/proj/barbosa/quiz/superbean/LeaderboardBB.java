/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import java.util.TreeMap;
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

    @Inject
    private GameBean game;
    
    private String score;

    public String getScore() {
        this.score = "" + getFirstResult().getScore();
        return score;
    }

    public Result getFirstResult() {
        Leaderboard list = game.getLeaderboard();
        Result result = list.getMap().firstEntry().getValue();
        System.out.println(list.getMap().firstEntry().getValue().getScore());
        return result;
    }
}