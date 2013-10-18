/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

/**
 * The LoginManager handels the login and register function.
 *
 * @author Iron-Maven
 */
public class LoginManager {

    private UserRegister ur = (UserRegister) UserRegister.newInstance("quiz_pu");

    public boolean login(String name, String pass) {
        UserDB user = new UserDB(name, pass);
        UserDB userChecker = ur.getByName(user.getUserName());
        if (userChecker == null) {
            return false;
        } else if (userChecker.getPassword().equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean register(String name, String pass) {
        UserDB newUser = new UserDB(name, pass);
        UserDB userChecker = ur.getByName(newUser.getUserName());
        if (userChecker == null) {
            ur.add(newUser);
            return true;
        } else {
            return false;
        }
    }
    
    public int getUserHighscore(String name){
        UserDB user = ur.getByName(name);
        return user.getTopGameScore();
    }
    
    
    
    
    public String newPass(String name, String oldPass, String newPass){
        UserDB checkUser = ur.getByName(name);
        if(checkUser.getPassword().equals(oldPass)){
            UserDB updatedUser  = new UserDB(checkUser.getId(),name,newPass);
            ur.update(updatedUser);
            return "updatePass";
        }else{
            return "updateFail";
        }
    }
}
