/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import javax.persistence.Entity;
import web.proj.barbosa.quiz.superbean.utils.AbstractEntity;

/**
 * The Player class holds the player information such as username, password and
 * top game score.
 *
 * @author Iron-Maven
 */
@Entity
public class Player extends AbstractEntity {

    private String userName, password;
    private int topGameScore = 0;
    private int gamesPlayed;

    public Player() {
    }

    public Player(String userName, String password) {
        this.userName = userName;
        this.password = password;
        gamesPlayed = 0;
    }

    public Player(Long id, String userName, String password) {
        super(id);
        this.userName = userName;
        this.password = password;
        gamesPlayed = 0;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void update(int score) {
        if (score > topGameScore) {
            topGameScore = score;
        }
        gamesPlayed++;
    }

    public int getTopGameScore() {
        return topGameScore;
    }
    
    public int getGamesPlayed(){
        return gamesPlayed;
    }

    public void setTopGameScore(int topGameScore) {
        this.topGameScore = topGameScore;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }
    
}
