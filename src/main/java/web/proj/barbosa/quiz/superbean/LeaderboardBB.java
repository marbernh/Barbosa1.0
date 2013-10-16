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
        System.out.println("Im alive!" + this);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("*************************PostConstr");
        reg = (UserRegister) UserRegister.newInstance("quiz_pu");
        reg.add(new UserDB("nnn", "sdfsad"));
    }

    public String getHello() {
        return "sadsad";
    }

    public List<UserDB> getLeaderboard() {
        topList = reg.getTopTen();
        return topList;
    }
}