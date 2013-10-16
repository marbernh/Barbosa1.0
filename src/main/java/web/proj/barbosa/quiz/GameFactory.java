/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

/**
 *
 * @author Filip Husnjak
 */
public class GameFactory {

    private WordsMaker wm = new WordsMaker();
    private UserRegister reg = (UserRegister) UserRegister.newInstance("quiz_pu");
    private static Random scoreMaker = new Random();

    public GameFactory() {
    }

    public void createCompetition(int players) {
        for (int i = 1; i <= players; i++) {
            UserDB u = new UserDB("Player nr: " + i, "password");
            u.update(scoreMaker.nextInt(1000));
            reg.add(u);
            System.out.println("player: "+u.getUserName()+"  score: "+u.getTopGameScore() );
        }
    }

    public ArrayList<String> getTestWords() {
        ArrayList<String> list = wm.getWords();
        return list;
    }
}