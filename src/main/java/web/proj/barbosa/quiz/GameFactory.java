/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author Filip Husnjak
 */
public class GameFactory {
    
    // Leaderboarden ligger här så länge....
    private ArrayList<User> users = new ArrayList<User>();
    private Leaderboard testboard;
    private WordsMaker wm = new WordsMaker();
    
    public GameFactory(){
        testboard = new Leaderboard(testData());
    }
    
    public Leaderboard getLeaderboard(){
        return testboard;
    }
    
    public void setUser(User user){
        users.add(user);
    }
    
    public User getUser(String userName){
        for(User user: users){
            System.out.println("mf " + user.getUserName());
            if(user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }
    
    public ArrayList<String> getTestWords(){
        ArrayList<String> list = wm.getWords();
        return list;
    }
    
    private TreeMap<Long, Result> testData() {
        // Lägger in test data
//            ArrayList<User> users = new ArrayList<User>();
            TreeMap<Long, Result> list = new TreeMap<Long, Result>();
        for(int i = 0; i < 5; i++){
            users.add(new User("user" + i, "pass"));
        }
        for(int i = 0; i<5; i++){
            list.put(users.get(i).getId(), users.get(i).getResult());
        }
        return list;
    }
}
