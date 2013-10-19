package web.proj.barbosa.quiz;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author husnjak
 */
public class TestDB {

    private Random scoreMaker = new Random();

    @Before
    public void before() {
    }

    @Test
    public void TestQuizBase() {
        PlayerRegister r = (PlayerRegister) PlayerRegister.newInstance("quiz_pu");

        Player u1 = new Player("Daniel", "1234567");
        
        //Test add
        r.add(u1);
        assertTrue(r.find(u1.getId()).getUserName().equals("Daniel"));

        //Test find
        Player u2 = r.find(u1.getId());
        assertTrue(u2.equals(u1));
        assertTrue(!(u1 == u2));

        //Test Update
        Player u3 = new Player(u1.getId(), "Filip", "1234567");
        r.update(u3);
        assertTrue(!(u1.getUserName().equals(r.find(u3.getId()).getUserName())));

        //TEST getByName
        Player collectedU1 = r.getByName("Filip");
        assertTrue(collectedU1.getUserName().equals("Filip"));

        //Test Remove
        r.remove(u1.getId());
        assertTrue(r.find(u1.getId()) == null);

        /**
         * ********************Result*******************************
         */
        Player u5 = new Player("Marcus", "lösen");
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
            Player u = new Player("Player nr: " + i, "password");
            r.add(u);
            u = r.find(u.getId());
            u.update(scoreMaker.nextInt(500));
            r.update(u);
            System.out.println("name: " + r.find(u.getId()).getUserName() + " Score: " + r.find(u.getId()).getTopGameScore());
        }
        assertTrue((r.getTopTen().size()) == 10);
    }
}
