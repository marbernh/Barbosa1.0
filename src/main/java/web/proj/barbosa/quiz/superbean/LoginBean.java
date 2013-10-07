/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import web.proj.barbosa.quiz.GameFactory;

/**
 *
 * @author hajo
 */
@Named("loginBean")
@RequestScoped  // NOTE enterprise package, else disaster!!!
public class LoginBean implements Serializable {

    @Inject  
    private GameFactory gf;
    private String username;
    private String password;
    // We don't use FacesMessage, to avful...
    private String loginMessage = "";

    // Handled by GlassFish file realm
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        return "";
    }

    public String logout() {
        return "";
    }
   
    public String getLoginMessage() {
        return loginMessage;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
