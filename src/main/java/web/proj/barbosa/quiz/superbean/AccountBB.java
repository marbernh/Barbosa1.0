/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import web.proj.barbosa.quiz.LoginManager;

/**
 * AccountBB handels the login function for the site.
 *
 * @author Iron-Maven
 */
@Named("AccountBean")
@SessionScoped  // NOTE enterprise package, else disaster!!!
public class AccountBB implements Serializable {

    private boolean loggedIn = false;
    private String username;
    private String password;
    private String cPassword;
    private LoginManager lm = new LoginManager();

    // Handled by GlassFish file realm
    public String login() {
        loggedIn = lm.login(username, password);
        if (loggedIn) {
            return "loginPass";
        } else {
            return "LoginFail";
        }
    }

    public String register() {
        if (lm.register(username, password)) {
            return "registerPass";
        } else {
            return "registerFail";
        }
    }

    public String checklogged() {
        if (loggedIn) {
            return "myacc";
        }
        return "loggedoff";
    }

    public String logDisp() {
        if (loggedIn) {
            return "Logged in as: " + username;
        } else {
            return "";
        }
    }

    public String logout() {
        loggedIn = false;
        username = "";
        password = "";
        return "logOut";
    }

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

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }
}
