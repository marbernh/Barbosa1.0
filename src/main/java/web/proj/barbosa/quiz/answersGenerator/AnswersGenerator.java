/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.answersGenerator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * The AnswersGenerator imports the words from our dictionary to later be used in the
 * game.
 *
 * @author Iron-Maven
 */
public class AnswersGenerator implements IAnswersGenerator {
    
    final static Charset ENCODING = StandardCharsets.UTF_8;
    
    @Override
    public ArrayList<String> getWords() {
        ArrayList<String> ws = readFile();
        return ws;
    }

    public static ArrayList<String> readFile() {
        InputStream in = AnswersGenerator.class.getResourceAsStream("/ord.txt");

        ArrayList<String> words = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String word;

            while ((word = br.readLine()) != null) {
                words.add(word);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("FEL VID FILINLÄSNING");
        } finally {
            return words;
        }
    }
}
