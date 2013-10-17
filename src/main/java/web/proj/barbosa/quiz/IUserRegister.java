package web.proj.barbosa.quiz;

import java.util.List;
import web.proj.barbosa.quiz.superbean.utils.IDAO;

/**
 * This is the interface for UserRegister
 *
 * @author husnjak
 */
public interface IUserRegister extends IDAO<UserDB, Long> {
    UserDB getByName(String name);
    List<UserDB> getTopTen();
    List<UserDB> getAll();
}
