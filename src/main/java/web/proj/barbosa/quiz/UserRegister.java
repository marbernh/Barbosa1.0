/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.util.List;
import javax.persistence.EntityManager;
import web.proj.barbosa.quiz.superbean.utils.AbstractDAO;

/**
 * The UserRegister acts as a middle class between the game and the database.
 * every call to the database is done from here.
 *
 * @author Iron-Maven
 */
public class UserRegister extends AbstractDAO<UserDB, Long>
        implements IUserRegister {

    public static IUserRegister newInstance(String puName) {
        return new UserRegister(puName);
    }

    private UserRegister(String puName) {
        super(UserDB.class, puName);
    }

    @Override
    public UserDB getByName(String name) {
        EntityManager em = emf.createEntityManager();
        List<UserDB> us = em.createQuery(
                "SELECT u FROM UserDB u WHERE u.userName LIKE :name ")
                .setParameter("name", name)
                .getResultList();
        if (us.isEmpty()) {
            return null;
        } else {
            return us.get(0);
        }
    }

    @Override
    public List<UserDB> getTopTen() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery(
                "SELECT u FROM UserDB u order by u.topGameScore desc").setMaxResults(10)
                .getResultList();
    }

    @Override
    public List<UserDB> getAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery(
                "SELECT u FROM UserDB u").getResultList();
    }
}
