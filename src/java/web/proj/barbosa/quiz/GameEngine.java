/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

/**
 *
 * @author Filip Husnjak
 */
public class GameEngine {
   
    private Result result;
    private int life;
    private int score;
    private String answer = "gurka"; //  ändra sen.
    
    public GameEngine(){
        life = 3;
        score = 0;
        //this.answer = answer;
    }
    
    public String getAnswer(){
        return answer;
    }
}
