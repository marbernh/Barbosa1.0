/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import web.proj.barbosa.quiz.GameFactory;
import web.proj.barbosa.quiz.UserDB;
import web.proj.barbosa.quiz.UserRegister;


/*
 * @author Filip Husnjak
 */
@Named //("leaderboardBean")
@RequestScoped
public class LeaderboardBB implements Serializable {

    private UserRegister reg = (UserRegister) UserRegister.newInstance("quiz_pu");
    private List<UserDB> topList = new ArrayList<>();
    
    public LeaderboardBB() {
    }

    @PostConstruct
    public void postConstruct() {
        reg = (UserRegister) UserRegister.newInstance("quiz_pu");
    }

    public List<UserDB> getLeaderboard() {
        topList = reg.getTopTen();
        return topList;
    }
}