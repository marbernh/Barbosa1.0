/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

/**
 * This is the interface for Quiz 
 *
 * @author Iron-Maven
 */
public interface IQuiz {
    public void newGame();
    public String validate(String guess);
    public void updateScore(String name);
}
