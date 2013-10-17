package web.proj.barbosa.quiz.superbean.utils;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Base class for all entities (later to be stored in database), Users, Score
 * etc.
 *
 * @author hajo
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    public AbstractEntity() {
    }

    protected AbstractEntity(Long id) {
        this.id = id;
    }

    @XmlAttribute
    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
