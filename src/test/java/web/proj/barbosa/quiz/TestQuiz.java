/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Test for OO-model Quiz
 * @author Marcus
 */
public class TestQuiz {
    
    public TestQuiz() {
    }
    
    @Before
    public void before() {
        
    }
    
    @Test
    public void testQuiz(){
        Quiz q = new Quiz();
        q.newGame();
        String rightAnswer1 = q.getAnswer();
        assertTrue(q.validate(rightAnswer1).equals("Your answer is correct"));
        assertTrue(q.getScore() == 15);
        assertTrue(q.validate("fel svar 1").equals("Your answer is wrong"));
        assertTrue(q.getLife() == 2);
        assertTrue(q.validate("fel svar 2").equals("Your answer is wrong"));
        // Gameover after three wrong answers
        assertTrue(q.validate("fel svar 3").equals(""));
        
        // New game because gameover 
        String rightAnswer2 = q.getAnswer();
        assertFalse(rightAnswer1.equals(rightAnswer2));   
    }
}