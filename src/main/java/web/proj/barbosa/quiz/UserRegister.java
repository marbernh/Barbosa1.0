/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityManager;
import web.proj.barbosa.quiz.superbean.utils.AbstractDAO;

/**
 *
 * @author husnjak
 */
public class UserRegister extends AbstractDAO<UserDB, Long>
        implements IUserRegister {

    public static IUserRegister newInstance(String pooName) {
        return new UserRegister(pooName);
    }

    private UserRegister(String puName) {
        super(UserDB.class, puName);
    }

    @Override
    public List<UserDB> getByName(String name) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery(
                "SELECT u FROM UserDB u WHERE u.userName LIKE :name ")
                .setParameter("name", name)
                .getResultList();
    }

    public List<UserDB> getTopTen() {
        System.out.println("getTopTen");
        EntityManager em = emf.createEntityManager();
        return em.createQuery(
                "SELECT u FROM UserDB u").setMaxResults(10)
                .getResultList();
    }
}
