/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean.utils;

import java.io.Serializable;
import javax.annotation.PreDestroy;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This abstract class is "copied" from the JPA lab and first athured by hajo
 * but later changed by us in the workshop and in this project.
 *
 * @author Iron-Maven
 */
@Startup
public abstract class AbstractDAO<T, K> implements Serializable {

    protected EntityManagerFactory emf;
    private EntityManager em;
    private final Class<T> clazz;

    protected AbstractDAO(Class<T> clazz, String puName) {
        this.clazz = clazz;
        emf = Persistence.createEntityManagerFactory("quiz_pu");
    }

    public void add(T t) {
         em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();

            }
        }
    }

    public void remove(K id) {
         em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            T t = em.getReference(clazz, id);
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(T t) {
         em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public T find(K id) {
         em = emf.createEntityManager();
        T item = em.find(clazz, id);
        em.close();
        return item;
    }
    @PreDestroy
    public void closeEntity(){
        em.getEntityManagerFactory().close();
    }
}
