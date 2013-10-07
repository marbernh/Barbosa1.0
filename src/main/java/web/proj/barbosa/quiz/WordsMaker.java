/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author Daniel Johansson
 */
public class WordsMaker {

    final static Charset ENCODING = StandardCharsets.UTF_8;

    public String[] getWords()  {
        ArrayList<String> ws = readFile();
        String[] list = new String[ws.size()];
        for (int i = 0; i < ws.size(); i++) {
            list[i] = ws.get(i);
        }
        return list;
    }

     public static ArrayList<String> readFile() {
        InputStream in =  WordsMaker.class.getResourceAsStream("/ord.txt");
    	
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
        }finally{
            return words;
        }
    }
}
