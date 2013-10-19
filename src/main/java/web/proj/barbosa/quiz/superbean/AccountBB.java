/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import web.proj.barbosa.quiz.Account.AccountManager;
import web.proj.barbosa.quiz.Account.AccountManagerFactory;

/**
 * AccountBB handels the login function for the site.
 *
 * @author Iron-Maven
 */
@Named("AccountBean")
@SessionScoped
public class AccountBB implements Serializable {

    private boolean loggedIn = false;
    private String username,password,confirmPass;
    private String oldPass, newPass;
    private String errorReg,errorLgn = "";
    private AccountManager accountManager = (AccountManager) AccountManagerFactory.getAccountManager();

    
    public String login() {
        loggedIn = accountManager.login(username, password);
        if (loggedIn) {
            return "loginPass";
        } else {
            errorLgn = "Login Failed, confirm correct username and password!";
            return "LoginFail";
        }
    }

    public String register() {
        if (confirmPass.equals(password)) {
            if (accountManager.register(username, password)) {
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
        
        errorLgn = "";
        errorReg = "";
        
        return "logOut"; 
    }
    public String changePass(){
        String status = accountManager.changePass(username,oldPass,newPass,confirmPass);
        if(status.equals("fail1")){
            errorReg = "Please confirm your new password";
            return "changeFail";
        }else if(status.equals("fail2")){
            errorReg = "Please enter your current password";
            return "changeFail";
        }else{
            return "changePass";
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

    public int getHighscore(){
        return accountManager.getUserHighscore(username);
    }
    public int getGamesPlayed(){
        return accountManager.getUserGamesPlayed(username);
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

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String cPass) {
        this.confirmPass = cPass;
    }
}
