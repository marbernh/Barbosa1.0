/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import web.proj.barbosa.quiz.LoginManager;
import web.proj.barbosa.quiz.UserDB;

/**
 *
 * @author hajo
 */
@Named("loginBean")
@SessionScoped  // NOTE enterprise package, else disaster!!!
public class LoginBean implements Serializable {

    private boolean loggedIn = false;
    private String username;
    private String password;
    private LoginManager lm = new LoginManager();

    // Handled by GlassFish file realm
    public String login() {
        UserDB user = new UserDB(username, password);
        loggedIn = lm.login(user);
        if (loggedIn) {
            return "loginPass";
        } else {
            return "LoginFail";
        }
    }

    public String register() {
        UserDB newUser = new UserDB(username, password);
        if (lm.register(newUser)) {
            return "registerPass";
        } else {
            return "registerFail";
        }
    }

    public String checkLogged() {
        if (loggedIn) {
            return "Logged in as: " + username;
        } else {
            return "";
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
