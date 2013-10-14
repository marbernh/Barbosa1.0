/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Search {
        private int num = 6; //Antalet biler som skall hämtas från Google
        
	public ArrayList<String> searchAndFind(String word) {
		String str = search(word);
		if (str != null && !(str.equals("error"))) {
			ArrayList<String> urlResults = filter(str);
                        return urlResults;
		} else {
                    System.out.println("fel");
			return null;
		}
	}

	private String search(String word) {
		try {
			URL url = new URL("http://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=" + word+"&rsz="+this.num);
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
		ArrayList<String> url = new ArrayList<String>();
		String[] chopped = result.split("\"");

		for(int i = 0 ; i<chopped.length ;i++){
			if(chopped[i].equals("unescapedUrl")){
				url.add(chopped[i+2]); //Skippar commateccken sedan tas URL (+2)
			}
		}
		return url;
	}

}