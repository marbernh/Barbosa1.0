/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.superbean.utils;

/**
 * The interface class for AbstractDAO
 *
 * @author hajo
 */
public interface IDAO<T, K> {

    public void add(T t);

    public void remove(K id);

    public void update(T t);

    public T find(K id);
}
