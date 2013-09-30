/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Filip Husnjak
 */
public class GameEngine {
   
    private Result result;
    private int life;
    private int score;
    private String[] answers; 
    private String answer;
    private static Random generator;
    private Search searcher;
    private ArrayList<String> pics = new ArrayList<String>();
    
    public void newGame(){
        life = 3;
        score = 0;
        int random = generator.nextInt(answers.length);
        this.answer  = answers[random];
        pics = searcher.searchAndFind(answer);
    }
    public void nextImage(){
        
    }
    
    public String getAnswer(){
        return answer;
    }
}
