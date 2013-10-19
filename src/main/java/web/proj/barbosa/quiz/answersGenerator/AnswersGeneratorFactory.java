/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.answersGenerator;

/**
 *
 * @author marcus
 */
public class AnswersGeneratorFactory {
        public AnswersGeneratorFactory() {
    }
    
    public static IAnswersGenerator getAnswerGenerator(){
        return new AnswersGenerator();
    }
}
