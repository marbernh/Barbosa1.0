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
        getAnswers();   //imports all words
    }
    
    /**
     * This is the most immoprtant method in Quiz, it handles the guess made
     * by the user. It returns a message to be displayed on the client depending
     * on if the guess was correct or incorrect.
     * @param guess 
     * @return String message
     */
    @Override
    public String validate(String guess) {
        guess = guess.trim().toLowerCase();
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
    
    /**
     * This method updates the score of a user. 
     * @param name 
     */
    @Override
    public void updateScore(String name) {
        PlayerRegister playerRegister = (PlayerRegister) PlayerRegister.newInstance("quiz_pu");
        Player user = playerRegister.getByName(name);
        user.update(score);
        playerRegister.update(user);
    }
    
    /**
     * This method initiates a new game, it resets the score, the lifes, gets a
     * new set of words and lastly it searches for new images. 
     * This method is called when a player gets game over.
     */
    @Override
    public void newGame() {
        getAnswers();
        getNewPics();
        life = 3;
        score = 0;
    }
    
    /**
     * This method searches for a new set of pictures and resets the life.
     * The method is called when a player get the correct answer. 
     */
    private void nextRound() {
        life = 3;
        getNewPics();
    }
    
    /**
     * When this method is called it randomizes an answer from a random index.
     * Then it uses the ImageSearch service to get a list of image url's related
     * to that word(answer).
     */
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
    /**
     * This method uses the AnswersGenerator service to generate aa list of 
     * possible answers.
     */
    private void getAnswers() {
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