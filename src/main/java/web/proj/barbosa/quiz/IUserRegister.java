/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import web.proj.barbosa.quiz.superbean.utils.IDAO;

/**
 *
 * @author husnjak
 */
public interface IUserRegister extends IDAO<UserDB, Long> {
    UserDB getByName(String name);
}
