/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.util.Comparator;
import java.util.List;
import web.proj.barbosa.quiz.superbean.utils.AbstractDAO;

/**
 *
 * @author husnjak
 */
public class UserRegister extends AbstractDAO<UserDBTest, Long> 
            implements IUserRegister{
    
    public static IUserRegister newInstance(String pooName) {
        return new UserRegister(pooName);
    }

    private UserRegister(String puName) {
        super(UserDBTest.class, puName);
    }
}
