package web.proj.barbosa.quiz;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author husnjak
 */
public class TestTest {

    private IUserRegister r;
        
    @Before
    public void before() {
       //UserRegister r = (UserRegister) UserRegister.newInstance("embedded_image_quiz_PU");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        UserRegister r = (UserRegister) UserRegister.newInstance("quiz_test_pu");
        UserDBTest testUser = new UserDBTest("Daniel", "1234567");
        assertTrue(testUser.getUserName().equals("Daniel")); 
        
        System.out.println(testUser.getUserName());
        r.add(testUser);
    }
}