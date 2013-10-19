/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import web.proj.barbosa.quiz.Leaderboard;
import web.proj.barbosa.quiz.UserDB;
import web.proj.barbosa.quiz.UserRegister;


/*
 * The LeaderboardBB handels the leaderboard by taking the ten best
 * players from the database and displays them on the game page. 
 * 
 * @author Iron-Maven
 */
@Named
@SessionScoped
public class LeaderboardBB implements Serializable {

    private Leaderboard leaderboard;

    public LeaderboardBB() {
        leaderboard = new Leaderboard();
    }

    public List<UserDB> getLeaderboard() {
        return leaderboard.getLeaderboard();
    }
}