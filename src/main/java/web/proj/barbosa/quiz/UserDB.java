/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import web.proj.barbosa.quiz.superbean.utils.AbstractEntity;

/**
 * The UserDB class holds the player information such as username, password and
 * top game score.
 *
 * @author Iron-Maven
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class UserDB extends AbstractEntity {

    private String userName, password;
    private int topGameScore = 0;

    public UserDB() {
    }

    public UserDB(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserDB(Long id, String userName, String password) {
        super(id);
        this.userName = userName;
        this.password = password;
    }

    @XmlElement
    public String getUserName() {
        return userName;
    }

    @XmlElement
    public String getPassword() {
        return password;
    }

    public void update(int score) {
        if (score > topGameScore) {
            topGameScore = score;
        }
    }

    public int getTopGameScore() {
        return topGameScore;
    }
}
