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
 * The LeaderboardBB handels the leaderboard by taking the ten best
 * players from the database and displays them on the game page. 
 * 
 * @author Iron-Maven
 */
@Named
@RequestScoped
public class LeaderboardBB implements Serializable {

    private UserRegister reg;
    private List<UserDB> topList;

    public LeaderboardBB() {
    }

    @PostConstruct
    public void postConstruct() {
        reg = (UserRegister) UserRegister.newInstance("quiz_pu");
        topList = new ArrayList<>();
    }

    public List<UserDB> getLeaderboard() {
        topList = reg.getTopTen();
        return topList;
    }
}