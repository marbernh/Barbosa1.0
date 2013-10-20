package web.proj.barbosa.quiz;

import web.proj.barbosa.quiz.answersGenerator.AnswersGenerator;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class handles creation of hardcoded data. The data are: - Sample uses for
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

    // Creating some players to fill the leaderboard. Excluded in final release
    public static void createCompetition() {
        String[] Names = {"Marcus", "Daniel", "Vera", "Anton", "Sofia", "Patricia", "Ants"};
        PlayerRegister reg = (PlayerRegister) PlayerRegister.newInstance("quiz_pu");
        if (reg.getAll().isEmpty()) {
            Player u;
            for (int i = 0; i <= 6; i++) {
                u = new Player(Names[i], "password");
                u.update(scoreMaker.nextInt(800));
                reg.add(u);
            }
            u = new Player("Peter", "pass");
            u.update(10);
            reg.add(u);
            u = new Player("Josef", "pass");
            u.update(20);
            reg.add(u);
            u = new Player("Filip", "pass");
            u.update(9999);
            reg.add(u);
        }
    }


}