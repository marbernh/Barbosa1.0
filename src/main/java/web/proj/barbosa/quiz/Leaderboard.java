/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Filip Husnjak
 */
public class Leaderboard implements Comparator<Result> {

    private TreeMap<Long, Result> resultboard = new TreeMap<Long, Result>();

    public Leaderboard(TreeMap<Long, Result> resultboard) {
        this.resultboard = resultboard;
    }

    Leaderboard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(Result newResult) {
        resultboard.put(newResult.getId(), newResult);
        sortList();
    }
    public Result getResult(Long id){
        return resultboard.get(id);
    }

    public void sortList() {
        // gör något
    }
    
    public TreeMap<Long, Result> getMap(){
        return resultboard;
    }

    @Override
    public int compare(Result x, Result y) {
        // TODO: Handle null x or y values
        int startComparison = compare(x.getScore(), y.getScore());
        return startComparison != 0 ? startComparison
                : compare(x.getWin(), y.getWin());
    }

    // I don't know why this isn't in Long...
    private static int compare(int a, int b) {
        return a < b ? -1
                : a > b ? 1
                : 0;
    }

    void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
