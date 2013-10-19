package web.proj.barbosa.quiz;

import web.proj.barbosa.quiz.answersGenerator.AnswersGenerator;
import java.util.ArrayList;
import java.util.Random;

/**
 * This clas handles creation of hardcoded data. The data are: - Sample uses for
 * the leaderboard - Reads the words from a file
 *
 * @author Iron-Maven
 */
public class QuizFactory {

    
//    private static PlayerRegister reg = (PlayerRegister) PlayerRegister.newInstance("quiz_pu");
    private static Random scoreMaker = new Random();
    
    public static IQuiz getQuiz(Boolean fill){
        if(fill){
            createCompetition();
        }
        return new Quiz();
    }

    public static void createCompetition() {
        PlayerRegister reg = (PlayerRegister) PlayerRegister.newInstance("quiz_pu");
        if (reg.getAll().isEmpty()) {
            Player u;
            for (int i = 1; i <= 10; i++) {
                u = new Player("Player nr: " + i, "password");
                u.update(scoreMaker.nextInt(750));
                reg.add(u);
            }
            u = new Player("Filip", "pass");
            u.update(9999);
            reg.add(u);
        }
    }


}