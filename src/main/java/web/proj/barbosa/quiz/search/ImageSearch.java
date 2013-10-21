/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * The search class uses the given quiz word and finds images for the game
 * throught Google image search and returns the urls.
 *
 * @author Iron-Maven
 */
public class ImageSearch implements IImageSearch{

    private int num = 6; //Antalet biler som skall hämtas från Google
    
    /**
     * This method uses the help method search to make a google image search
     * for the word from the parameter. Then the help method filter is used 
     * to filter the response to get the correct image url's. 
     * @param word
     * @return A list of image url's
     */
    @Override
    public ArrayList<String> searchAndFind(String word) {
        String str = search(word);
        if (str != null && !(str.equals("error"))) {
            ArrayList<String> urlResults = filter(str);
            return urlResults;
        } else {
            return null;
        }
    }

    private String search(String word) {
        try {
            URL url = new URL("http://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=" + word + "&rsz=" + this.num);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.8.1.6) Gecko/20070723 Iceweasel/2.0.0.6 (Debian-2.0.0.6-0etch1)");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String str = in.readLine();
            in.close();
            return str;
            
        } catch (MalformedURLException e) {
            return "error";
        } catch (IOException e) {
            return "error";
        }
    }

    private ArrayList<String> filter(String result) {
        ArrayList<String> url = new ArrayList<>();
        String[] chopped = result.split("\"");

        for (int i = 0; i < chopped.length; i++) {
            if (chopped[i].equals("unescapedUrl")) {
                url.add(chopped[i + 2]); //Skippar commateccken sedan tas URL (+2)
            }
        }
        return url;
    }
}