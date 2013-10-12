/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.io.Serializable;
import java.util.Random;
/**
 *
 * @author Filip Husnjak
 */
public class User implements Serializable, Comparable<User>{
    
    private String userName, password;
    private Long id;
    public Result result;
    private static Random idMaker = new Random();
    
    public User(String userName, String password) {
        this.id = new Long(idMaker.nextInt(1000));
        this.userName = userName;
        this.password = password;
        result = new Result(id);
    }
    
    public User(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        result = new Result(id);
    }
    
    public Result getResult(){
        return result;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    //    public String getName() {
    //        return name;
    //    }
    //
    //    public void setName(String name) {
    //        this.name = name;
    //    }
    
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
    
    @Override
    public int compareTo(User o) {
        if (this.result.getTopGameScore() == o.result.getTopGameScore())
            return 0;
        else if ((this.result.getTopGameScore()) > o.result.getTopGameScore())
            return 1;
        else
            return -1;
    }
    
}
