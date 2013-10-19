package web.proj.barbosa.quiz;

import web.proj.barbosa.quiz.search.ImageSearch;
import java.util.ArrayList;
import java.util.Random;
import web.proj.barbosa.quiz.search.ImageSearchFactory;

/**
 * This class handles new searches and new games. It generates a word and the
 * links fore the pictures and then it returns it to the gamebean.
 *
 * @author Iron-Maven
 */
public class GameEngine {
    
    private int life,score;
    private GameFactory gf;                 //GameFactory contains hardcoded data for testing
    private ArrayList<String> answers;      //answers contain the list of possible words
    private String answer;                  //answer is the current word
    private static Random generator;
    private ImageSearch searcher;
    private ArrayList<String> pics;         //the listof pucture url's
    private UserRegister ur = (UserRegister) UserRegister.newInstance("quiz_pu");
    
    
    
    public GameEngine() {
        life = 3;
        score = 0;
        generator = new Random();
        searcher = (ImageSearch) ImageSearchFactory.getImageSearch();
        gf = new GameFactory();
        gf.createCompetition();             // creates some users to fill the leaderboard
        this.answers = gf.getTestWords();   //imports the words
    }
    
    //This method uses the ImageSearch class to search new pics from "answer"
    public void getNewPics() {
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
    
    public void newGame() {
        this.answers = gf.getTestWords();
        getNewPics();
        life = 3;
        score = 0;
    }
    
    public void nextRound() {
        life = 3;
        getNewPics();
    }
    
    public String validate(String guess) {
        if ( answer.equals(guess)){
            increaseScore();
            nextRound();
            return "Your answer is correct";
        } else if(looseLife() == 0){
            return "gameOver";
        } else{
            return "Your answer is wrong";
        }
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
    
    public void increaseScore() {
        score = score + (life * 5);
    }
    
    public int looseLife() {
        life--;
        return life;
    }
    
    public void updateScore(String name) {
        UserDB user = ur.getByName(name);
        if(score > user.getTopGameScore()){
            user.update(score);
            ur.update(user);
        }
    }
}