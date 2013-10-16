package web.proj.barbosa.quiz;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author husnjak
 */
public class TestTest {

    private Random scoreMaker = new Random();

    @Before
    public void before() {
    }

    @Test
    public void TestQuizBase() {
        UserRegister r = (UserRegister) UserRegister.newInstance("quiz_pu");

        UserDB u1 = new UserDB("Daniel", "1234567");
        
        //Test add
        r.add(u1);
        assertTrue(r.find(u1.getId()).getUserName().equals("Daniel"));

        //Test find
        UserDB u2 = r.find(u1.getId());
        assertTrue(u2.equals(u1));
        assertTrue(!(u1 == u2));

        //Test Update
        UserDB u3 = new UserDB(u1.getId(), "Filip", "1234567");
        r.update(u3);
        assertTrue(!(u1.getUserName().equals(r.find(u3.getId()).getUserName())));

        //TEST getByName
        UserDB collectedU1 = r.getByName("Filip").get(0);
        assertTrue(collectedU1.getUserName().equals("Filip"));

        //Test Remove
        r.remove(u1.getId());
        assertTrue(r.find(u1.getId()) == null);

        /**
         * ********************Result*******************************
         */
        UserDB u5 = new UserDB("Marcus", "lösen");
        r.add(u5);
        u5 = r.find(u5.getId());
        u5.update(150);
        r.update(u5);
        System.out.println("" + r.find(u5.getId()).getTopGameScore());
        assertTrue((r.find(u5.getId()).getTopGameScore()) == 150);

        /**
         * ***************getTopTen*******************************
         */
        for (int i = 1; i < 10; i++) {
            UserDB u = new UserDB("Player nr: " + i, "password");
            r.add(u);
            u = r.find(u.getId());
            u.update(scoreMaker.nextInt(500));
            r.update(u);
            System.out.println("name: " + r.find(u.getId()).getUserName() + " Score: " + r.find(u.getId()).getTopGameScore());
        }
        assertTrue((r.getTopTen().size()) == 10);
    }
}
