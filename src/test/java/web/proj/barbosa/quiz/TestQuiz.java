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
        GameEngine e = new GameEngine();
        e.newGame();
        Guess g = new Guess(e);
        String rightAnswer1 = e.getAnswer();
        assertTrue(g.validate(rightAnswer1).equals("Your answer is correct"));
        assertTrue(e.getScore() == 15);
        assertTrue(g.validate("fel svar 1").equals("Your answer is wrong"));
        assertTrue(e.getLife() == 2);
        assertTrue(g.validate("fel svar 2").equals("Your answer is wrong"));
        // Gameover after three wrong answers
        assertTrue(g.validate("fel svar 3").equals("gameOver"));
        
        // New game because gameover 
        String rightAnswer2 = e.getAnswer();
        assertFalse(rightAnswer1.equals(rightAnswer2));
        
    }
    
    
}