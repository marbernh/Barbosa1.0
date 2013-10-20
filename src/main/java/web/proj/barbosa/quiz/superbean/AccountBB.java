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

    /**
     * login()
     * This method makes the call to the loginManager that handles the log in
     * process, depending on if the login is sucsessfull or not the appropriate
     * outcome is returned for navigation. If login is unsuccessfull the 
     * appropriate error message will be displayed.
     * @return String outcome
     */
    public String login() {
        loggedIn = accountManager.login(username, password);
        if (loggedIn) {
            return "loginPass";
        } else {
            errorLgn = "Login Failed, confirm correct username and password!";
            return "LoginFail";
        }
    }

    /**
     * register()
     * This method makes the call to the loginManager that handles the register
     * process, depending on if the registration is sucsessfull or not the 
     * appropriate outcome is returned for navigation. If registration is 
     * unsuccessfull the appropriate error message will be displayed.
     * @return String outcome
     */
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
    
    /**
     * register()
     * This method makes the call to the loginManager that handles the register
     * process, depending on if the registration is sucsessfull or not the 
     * appropriate outcome is returned for navigation. If registration is 
     * unsuccessfull the appropriate error message will be displayed.
     * @return String outcome
     */
    public String logout() {
        loggedIn = false;
        username = "";
        password = "";
        
        errorLgn = "";
        errorReg = "";
        
        return "logOut"; 
    }
    
    /**
     * changePass()
     * This method makes the call to the loginManager that handles the change 
     * password process, depending on if the change is sucsessfull or not the 
     * appropriate outcome is returned for navigation. If the password change
     * is unsuccessfull the appropriate error message will be displayed.
     * @return String outcome
     */
    public String changePass(){
        String status = accountManager.changePass(username,oldPass,newPass,confirmPass);
        switch (status) {
            case "fail1":
                errorReg = "Please confirm your new password";
                return "changeFail";
            case "fail2":
                errorReg = "Please enter your current password";
                return "changeFail";
            default:
                return "changePass";
        }
    }
    
    /**
     * This method is used to help with navigation.
     * @return String outcome
     */
    public String checklogged() {
        if (loggedIn) {
            return "myacc";
        }
        return "loggedoff";
    }
    
    /**
     * This method is used to display the logged in user on the game page.
     * @return 
     */
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
