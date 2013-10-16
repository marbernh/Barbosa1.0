/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.util.TimerTask;

/**
 *
 * @author Vera
 */
public class AlertTask extends TimerTask {
    
    private GuessBB beanObj;
    
    public AlertTask(GuessBB obj){
        this.beanObj = obj;
    }
    @Override
    public void run(){
        beanObj.setTimeOutString("Time Ran Out");
    }
}
