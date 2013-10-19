/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

/**
 *
 * @author Daniel
 */
public interface IQuiz {
    public void newGame();
    public void nextRound();
    public String validate(String guess);
    public void updateScore(String name);
}
