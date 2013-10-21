/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.Account;

/**
 * This is the interface for AccountManager.
 *
 * @author Daniel
 */
public interface IAccountManager {
    
    public boolean login(String name, String pass);
    
    public boolean register(String name, String pass);
    
    public int getUserHighscore(String name);
    
    public int getUserGamesPlayed(String name);
    
    public String changePass(String name,String oldPass, String newPass, String confirmPass);
}
