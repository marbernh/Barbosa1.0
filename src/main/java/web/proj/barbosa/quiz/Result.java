/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.io.Serializable;

/**
 *
 * @author Filip Husnjak
 */
public class Result implements Serializable {

    private Long id;
    private int gamesPlayed, totalScore, topGameScore;

    protected Result() {
    }

    protected Result(Long id) {
        this.id = id;
        gamesPlayed = 0;
//        win = 0;
//        lose = 0;
        totalScore = 0;
        topGameScore = 0;
    }

    public void update(int score) {
        System.out.println("update");
        gamesPlayed = gamesPlayed + 1;
//        this.win += win;
//        this.lose += lose;
        this.totalScore += score;
        if (score > topGameScore) {
            topGameScore = score;
        }
    }

    public Long getId() {
        return id;
    }

    public int getTotalScore() {
        return totalScore;
    }

//    public int getWin() {
//        return win;
//    }
//
//    public int getLost() {
//        return lose;
//    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getTopGameScore() {
        return topGameScore;
    }
}
