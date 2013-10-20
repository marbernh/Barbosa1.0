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

    
    @Override
    public String changePass(String name,String oldPass, String newPass, String cPass){
        String status;
        Player old = userRegister.getByName(name);
        
        if(old.getPassword().equals(oldPass)){
            if(newPass.equals(cPass)){
                Player updated = new Player(old.getId(),old.getUserName(),newPass);
                updated.setTopGameScore(old.getTopGameScore());
                updated.setGamesPlayed(old.getGamesPlayed());
                userRegister.update(updated);
                status = "pass";
            }else{
                status = "fail1"; // mismatch newPass and cPass
            }
        }else{
            status = "fail2"; // mismatch oldPass and the current password
        }
        return status;
    }
}
