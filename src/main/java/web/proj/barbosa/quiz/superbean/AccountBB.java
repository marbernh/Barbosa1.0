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
@SessionScoped
public class AccountBB implements Serializable {

    private boolean loggedIn = false;
    private String username,password,cPassword,newPass;
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
        if (cPassword.equals(password)) {
            if (lm.register(username, password)) {
                errorReg = "";
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
    public String setNewPass(){
        if(cPassword.equals(newPass)){
            return lm.newPass(username,password,newPass);
        }else{
            errorReg = "Please confirm passowrd";
            return "updateFail";
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

    public String getErrorLgn() {
        return errorLgn;
    }

    public void setErrorLgn(String errorMsg) {
        this.errorLgn = errorMsg;
    }

    public String getErrorReg() {
        return errorReg;
    }

    public void setErrorReg(String errorReg) {
        this.errorReg = errorReg;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
    
    
}
