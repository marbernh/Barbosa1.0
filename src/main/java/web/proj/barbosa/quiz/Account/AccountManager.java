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

    
    /**
     * This handles the login process, it finds the user in the database and
     * compares the input password with the users password. Returns a boolean,
     * true if the login was successful or false if it failed.
     */
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
    
    /**
     * This method handles the register process, if the input player name is
     * available and the confirm-password matches the password a new player is 
     * added to the database. Returns a Boolean true if the register was 
     * successful and false if it failed.
     * @param name
     * @param pass
     * @return 
     */
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
    
    /**
     * This method is used to display the high-score of a player in the player's
     * page.
     * @param name
     * @return 
     */
    @Override
    public int getUserHighscore(String name){
        Player user = userRegister.getByName(name);
        return user.getTopGameScore();
    }
    
    /**
     * This method is used to display the number of games a player has played
     * on the players page.
     * @param name
     * @return 
     */
    @Override
    public int getUserGamesPlayed(String name){
        Player user = userRegister.getByName(name);
        return user.getGamesPlayed();
    }

    /**
     * This method handles the process for changing a players password. 
     * If the correct old password is given and the new password matches the
     * confirm-password the player is updated with the new password in the 
     * database. The status is set for the caller to handle fails and successes
     * when changing password.
     * @param name
     * @param oldPass
     * @param newPass
     * @param cPass
     * @return 
     */
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
