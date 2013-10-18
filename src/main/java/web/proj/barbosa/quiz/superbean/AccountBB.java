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
@SessionScoped
public class AccountBB implements Serializable {

    private boolean loggedIn = false;
    private String username,password,cPassword; //set by form
    private String errorReg,errorLgn = ""; 
    private LoginManager lm = new LoginManager();

    // Handled by GlassFish file realm
    public String login() {
        loggedIn = lm.login(username, password);
        if (loggedIn) {
            errorLgn = "";
            return "loginPass";
        } else {
            errorLgn = "Login Failed, confirm correct username and password!";
            return "LoginFail";
        }
    }

    public String register() {
        if (cPassword.equals(password)) { // controlles password
            if (lm.register(username, password)) {
                errorReg = "";
                errorLgn = "";
                return "registerPass";
            } else {
                errorReg = "Username already taken";
                return "registerFail";
            }
        } else {
            errorReg = "Please confirm passowrd";
            return "registerFail";
        }
    }
    
    
    public String logout() {
        loggedIn = false;
        username = "";
        password = "";
        return "logOut";
    }
    public int getHighscore(){
        return lm.getUserHighscore(username);
    }
    public int getGamesplayed(){
        return lm.getUserGamesplayed(username);
    }

    //Used to navigate to the correct page when account-button clicked
    public String checklogged() {
        if (loggedIn) {
            return "myacc";
        }
        return "loggedoff";
    }
    
    //Used to display the loggen in user in the game page
    public String logDisp() {
        if (loggedIn) {
            return "Logged in as: " + username;
        } else {
            return "";
        }
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

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getcPassword() {
        return cPassword;
    }

    public String getErrorLgn() {
        return errorLgn;
    }

    public String getErrorReg() {
        return errorReg;
    }
}
