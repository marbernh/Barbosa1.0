/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.io.Serializable;
import java.util.Random;
import javax.persistence.*;
import web.proj.barbosa.quiz.superbean.utils.AbstractDAO;
import web.proj.barbosa.quiz.superbean.utils.AbstractEntity;
/**
 *
 * @author Filip Husnjak
 */
@Entity
public class UserDBTest extends AbstractEntity implements Serializable{
    
    private String userName, password;

    public UserDBTest() {
    }

    public UserDBTest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserDBTest(Long id, String userName, String password) {
        super(id);
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    /*
     * vill vi ha ett mer komplicerat lösen?
     */

    public void setPassword(String password) {
        this.password = password;
    }
}
