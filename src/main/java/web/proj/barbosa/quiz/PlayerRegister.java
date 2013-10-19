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
public class PlayerRegister extends AbstractDAO<Player, Long>
        implements IPlayerRegister {

    public static IPlayerRegister newInstance(String puName) {
        return new PlayerRegister(puName);
    }

    private PlayerRegister(String puName) {
        super(Player.class, puName);
    }

    @Override
    public Player getByName(String name) {
        EntityManager em = emf.createEntityManager();
        List<Player> us = em.createQuery(
                "SELECT u FROM Player u WHERE u.userName LIKE :name ")
                .setParameter("name", name)
                .getResultList();
        if (us.isEmpty()) {
            return null;
        } else {
            return us.get(0);
        }
    }

    @Override
    public List<Player> getTopTen() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery(
                "SELECT u FROM Player u order by u.topGameScore desc").setMaxResults(10)
                .getResultList();
    }

    @Override
    public List<Player> getAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery(
                "SELECT u FROM Player u").getResultList();
    }
}
