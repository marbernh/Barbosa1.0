/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.Account;

import web.proj.barbosa.quiz.Player;
import web.proj.barbosa.quiz.PlayerRegister;

/**
 * The AccountManager handels the login and register function.
 *
 * @author Iron-Maven
 */
public class AccountManager implements IAccountManager{

    private PlayerRegister userRegister = (PlayerRegister) PlayerRegister.newInstance("quiz_pu");

    @Override
    public boolean login(String name, String pass) {
        Player user = new Player(name, pass);
        Player userChecker = userRegister.getByName(user.getUserName());
        if (userChecker == null) {
            return false;
        } else if (userChecker.getPassword().equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean register(String name, String pass) {
        Player newUser = new Player(name, pass);
        Player userChecker = userRegister.getByName(newUser.getUserName());
        if (userChecker == null) {
            userRegister.add(newUser);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int getUserHighscore(String name){
        Player user = userRegister.getByName(name);
        return user.getTopGameScore();
    }
    
    @Override
    public int getUserGamesPlayed(String name){
        Player user = userRegister.getByName(name);
        return user.getGamesPlayed();
    }

    //Not implemented!
    public String newPass(String name, String oldPass, String newPass){
        Player checkUser = userRegister.getByName(name);
        if(checkUser.getPassword().equals(oldPass)){
            Player updatedUser  = new Player(checkUser.getId(),name,newPass);
            userRegister.update(updatedUser);
            return "updatePass";
        }else{
            return "updateFail";
        }
    }
}
