/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.util.ArrayList;

/**
 *
 * @author Filip Husnjak
 */
public class GameFactory {
    
    public static Leaderboard getTestboard(boolean testData){
      /*  Leaderboard lb = new Leaderboard();
        if(testData)
            testData(lb);
        return lb;*/
        return null;
    }
    public static String[] getTestWords(){
        String[] list = new String[]{"pig","lamp","book","tree","house","paris","duck","fork","table","sky"};
        return list;
    }
    
    
    private static void testData(Leaderboard testboard) {
        // Lägger in test data
            ArrayList<User> users = new ArrayList<User>();
        for(int i = 1; i < 6; i++){
            users.add(new User("user" + i, "pass"));
        }
        for(int i = 0; i<5; i++){
            testboard.add(users.get(i).getResult());
        }
    }
}
