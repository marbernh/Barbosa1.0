package web.proj.barbosa.quiz;

import web.proj.barbosa.quiz.search.ImageSearch;
import java.util.ArrayList;
import java.util.Random;
import web.proj.barbosa.quiz.answersGenerator.AnswersGenerator;
import web.proj.barbosa.quiz.answersGenerator.AnswersGeneratorFactory;
import web.proj.barbosa.quiz.search.ImageSearchFactory;

/**
 * This class handles new searches and new games. It generates a word and the
 * links fore the pictures and then it returns it to the gamebean.
 *
 * @author Iron-Maven
 */
public class Quiz implements IQuiz{
    
    private int life,score;
    private ArrayList<String> answers;      //answers contain the list of possible words
    private String answer;                  //answer is the current word
    private static Random generator;
    private ImageSearch searcher;
    private ArrayList<String> pics;         //the listof pucture url's
    
    public Quiz() {
        life = 3;
        score = 0;
        generator = new Random();
        searcher = (ImageSearch) ImageSearchFactory.getImageSearch();
        getWords();   //imports all words
    }
    
    @Override
    public String validate(String guess) {
        if ( answer.equals(guess)){
            increaseScore();
            nextRound();
            return "Your answer is correct";
        } else if(looseLife() == 0){
            return "";
        } else{
            return "Your answer is wrong";
        }
    }
    
    @Override
    public void updateScore(String name) {
        PlayerRegister playerRegister = (PlayerRegister) PlayerRegister.newInstance("quiz_pu");
        Player user = playerRegister.getByName(name);
        user.update(score);
        playerRegister.update(user);
    }
    
    //This method uses the ImageSearch class to search new pics from "answer"
    @Override
    public void newGame() {
        getWords();
        getNewPics();
        life = 3;
        score = 0;
    }
    
    @Override
    public void nextRound() {
        life = 3;
        getNewPics();
    }
    
    private void getNewPics() {
        boolean filled = false;
        while (!filled) {
            int newRandom = generator.nextInt(answers.size());
            this.answer = answers.get(newRandom);
            pics = searcher.searchAndFind(answer);
            answers.remove(answer);
            
            if (pics != null && !(pics.isEmpty())) {
                filled = true;
            }
        }
    }
    
    private void getWords() {
        AnswersGenerator answersGenerator = 
                (AnswersGenerator) AnswersGeneratorFactory.getAnswerGenerator();
        answers = answersGenerator.getWords();
    }
    
    public void increaseScore() {
        score = score + (life * 5);
    }
    
    public int looseLife() {
        life--;
        return life;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public ArrayList<String> getPics() {
        return pics;
    }
    
    public int getLife() {
        return life;
    }
    
    public void setLife(int life) {
        this.life = life;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
}