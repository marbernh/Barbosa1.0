package web.proj.barbosa.quiz;

import java.util.List;
import web.proj.barbosa.quiz.superbean.utils.IDAO;

/**
 * This is the interface for UserRegister
 *
 * @author Iron-Maven
 */
public interface IPlayerRegister extends IDAO<Player, Long> {
    
    Player getByName(String name);
    
    List<Player> getTopTen();
    
    List<Player> getAll();
}
