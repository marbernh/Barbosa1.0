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
public class UserRegister extends AbstractDAO<UserDBTest, Long> 
            implements IUserRegister{
    
    public static IUserRegister newInstance(String pooName) {
        return new UserRegister(pooName);
    }

    private UserRegister(String puName) {
        super(UserDBTest.class, puName);
    }

    @Override
        public List<UserDBTest> getByName(String name) {
         EntityManager em = emf.createEntityManager();
         return em.createQuery(
                 "SELECT u FROM UserDBTest u WHERE u.userName LIKE :name ")
                 .setParameter("name", name)
                 .getResultList();
    }
    
    public List<UserDBTest> getById(Long id){
        EntityManager em = emf.createEntityManager();
         return em.createQuery(
                 "SELECT u FROM UserDBTest u WHERE u.id LIKE :id ")
                 .setParameter("id", id)
                 .getResultList();
    }
    
}
