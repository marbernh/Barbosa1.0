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

    public void createCompetition() {
        if (reg.getAll().isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                UserDB u = new UserDB("Player nr: " + i, "password");
                u.update(scoreMaker.nextInt(750));
                reg.add(u);
            }
        }
    }

    public ArrayList<String> getTestWords() {
        ArrayList<String> list = wm.getWords();
        return list;
    }
}