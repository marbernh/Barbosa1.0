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
        
        UserDBTest u1 = new UserDBTest("Daniel", "1234567");
        

        
        //Test add
        r.add(u1);
        assertTrue(r.find(u1.getId()).getUserName().equals("Daniel"));
        
        //Test find
        UserDBTest u2 = r.find(u1.getId());
        assertTrue(u2.equals(u1));
        assertTrue(!(u1 == u2));   
        
        //Test Update
        UserDBTest u3 = new UserDBTest(u1.getId(),"Filip","1234567");
        r.update(u3);
        assertTrue(!(u1.getUserName().equals(r.find(u3.getId()).getUserName())));
        
        //Test getById 
//        UserDBTest collectedU1 = r.getById(u3.getId()).get(0);
//        assertTrue(collectedU1.equals(u1));
        
        //TEST getByName
        UserDBTest collectedU1 = r.getByName("Filip").get(0);
        assertTrue(collectedU1.getUserName().equals("Filip"));
        
        
        //Test Remove
        r.remove(u1.getId());
        assertTrue(r.find(u1.getId())== null);
    }
}