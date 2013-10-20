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
        String[] Names = {"Marcus", "Daniel", "Vera", "Anton", "Sofia", "Patricia", "Ants", "Barbosa", "Jack Sparrow"};
        PlayerRegister reg = (PlayerRegister) PlayerRegister.newInstance("quiz_pu");
        if (reg.getAll().isEmpty()) {
            Player u;
            for (int i = 0; i <= 8; i++) {
                u = new Player(Names[i], "password");
                u.update(scoreMaker.nextInt(800));
                reg.add(u);
            }
            u = new Player("Filip", "pass");
            u.update(9999);
            reg.add(u);
        }
    }


}