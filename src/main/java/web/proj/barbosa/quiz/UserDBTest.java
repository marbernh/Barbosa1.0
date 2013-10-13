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
 *
 * @author Filip Husnjak
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class UserDBTest extends AbstractEntity {
    
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
    @XmlElement
    public String getUserName() {
        return userName;
    }
    
    @XmlElement
    public String getPassword() {
        return password;
    }
}
