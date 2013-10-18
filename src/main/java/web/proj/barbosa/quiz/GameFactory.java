package web.proj.barbosa.quiz;

import java.util.ArrayList;
import java.util.Random;

/**
 * This clas handles creation of hardcoded data. The data are: - Sample uses for
 * the leaderboard - Reads the words from a file
 *
 * @author Iron-Maven
 */
public class GameFactory {

    private WordsMaker wm = new WordsMaker();
    private UserRegister reg = (UserRegister) UserRegister.newInstance("quiz_pu");
    private static Random scoreMaker = new Random();

    public GameFactory() {
    }

    public void createCompetition() {
        if (reg.getAll().isEmpty()) {
            UserDB u;
            for (int i = 1; i <= 10; i++) {
                u = new UserDB("Player nr: " + i, "password");
                u.update(scoreMaker.nextInt(750));
                reg.add(u);
            }
            u = new UserDB("Filip", "pass");
            u.update(9999);
            reg.add(u);
        }
    }

    public ArrayList<String> getTestWords() {
        ArrayList<String> list = wm.getWords();
        return list;
    }
}