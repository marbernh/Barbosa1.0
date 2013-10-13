/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Filip Husnjak
 */
public class Leaderboard implements Serializable{

//    private TreeMap<Long, Result> resultboard = new TreeMap<Long, Result>();
    private ArrayList<User> topList = new ArrayList<>();
    public Leaderboard(ArrayList<User> users) {
        buildTopList(users);
    }

    Leaderboard() {
    }
    
    private void buildTopList(ArrayList<User> users){
        Collections.sort(users);
    }
    
    public ArrayList<User> getTopList(){
        return topList;
    }
          
    public void addResult(User user){
        topList.add(user);
        Collections.sort(topList);
    }
//            
//    public void add(Result newResult) {
//        resultboard.put(newResult.getId(), newResult);
//    }
//    public Result getResult(Long id){
//        return resultboard.get(id);
//    }
//    
//    public TreeMap<Long, Result> getMap(){
//        return resultboard;
//    }

//    @Override
//    public int compare(Result x, Result y) {
//        // TODO: Handle null x or y values
//        int startComparison = compare(x.getTotalScore(), y.getTotalScore());
//        return startComparison != 0 ? startComparison
//                : compare(x.getWin(), y.getWin());
//    }

    // I don't know why this isn't in Long...
    
//    private static int compare(int a, int b) {
//        return a < b ? -1
//                : a > b ? 1
//                : 0;
//    }
//
//
//    @Override
//    public int compare(User o1, User o2) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
