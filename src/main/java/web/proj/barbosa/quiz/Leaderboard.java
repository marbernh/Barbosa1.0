/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * The Leaderboard class takes the ten best players from the database and
 * puts them in a list. 
 *
 * @author Iron-Maven
 */
public class Leaderboard {
    
    private PlayerRegister reg;
    private List<Player> topList;
    
    
    public Leaderboard() {
        reg = (PlayerRegister) PlayerRegister.newInstance("quiz_pu");
        topList = new ArrayList<>();
    }
    
    public List<Player> getLeaderboard() {
        topList = reg.getTopTen();
        return topList;
    }
    
}
