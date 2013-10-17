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

    public static IUserRegister newInstance(String puName) {
        return new UserRegister(puName);
    }

    private UserRegister(String puName) {
        super(UserDB.class, puName);
    }

    @Override
    public UserDB getByName(String name) {
        EntityManager em = emf.createEntityManager();
        List<UserDB> us =  em.createQuery(
                "SELECT u FROM UserDB u WHERE u.userName LIKE :name ")
                .setParameter("name", name)
                .getResultList();
        if(us.isEmpty()){
            return null;
        }else{
            return us.get(0);
        }
    }

    public List<UserDB> getTopTen() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery(
                "SELECT u FROM UserDB u order by u.topGameScore desc").setMaxResults(10)
                .getResultList();
    }
    public List<UserDB> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createQuery(
                "SELECT u FROM UserDB u").getResultList();
    }
}
