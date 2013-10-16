/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.util.List;

/**
 *
 * @author Daniel
 */
public class LoginManager {
    private UserRegister ur = (UserRegister) UserRegister.newInstance("quiz_pu");
    
    public boolean login(UserDB user){
        List<UserDB> userChecker = ur.getByName(user.getUserName());
        if(userChecker.isEmpty()){
            return false;
        }else if(userChecker.get(0).getPassword().equals(user.getPassword())){
            return true;
        }else{
            return false;
        }
    }

    public boolean register(UserDB newUser) {
        List<UserDB> userChecker = ur.getByName(newUser.getUserName());
        if(userChecker.isEmpty()){
            ur.add(newUser);
            return true;
        }else{
            return false;
        }
    }
}
