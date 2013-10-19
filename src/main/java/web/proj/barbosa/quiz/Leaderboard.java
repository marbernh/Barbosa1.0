/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcus
 */
public class Leaderboard {
    
    private UserRegister reg;
    private List<UserDB> topList;
    
    
    public Leaderboard() {
        reg = (UserRegister) UserRegister.newInstance("quiz_pu");
        topList = new ArrayList<>();
    }
    
    public List<UserDB> getLeaderboard() {
        topList = reg.getTopTen();
        return topList;
    }
    
}
