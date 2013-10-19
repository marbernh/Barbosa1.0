/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.Account;

/**
 *
 * @author Daniel
 */
public class AccountManagerFactory {
    
    public static IAccountManager getAccountManager(){
        return new AccountManager();
    }
}
