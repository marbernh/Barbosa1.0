/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import web.proj.barbosa.quiz.GameFactory;
import web.proj.barbosa.quiz.User;

/**
 *
 * @author hajo
 */
@Named("loginBean")
@SessionScoped  // NOTE enterprise package, else disaster!!!
public class LoginBean implements Serializable {

    @Inject  
    private GameFactory gf;
    private boolean loggedIn = false;
    private String username;
    private String password;

    // Handled by GlassFish file realm
    public String login() {
        User user = gf.getUser(username);
        if (user == null){
            return "loginFail";
        }
        if (user.getPassword().equals(password)){
            loggedIn = true;
            return "loginPass";
        }
        
        else {
            return "loginFail";
        }
    }

//    public String logout() {
//        return "";
//    }
   
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public boolean getLoggedIn() {
        return loggedIn;
    }
}
