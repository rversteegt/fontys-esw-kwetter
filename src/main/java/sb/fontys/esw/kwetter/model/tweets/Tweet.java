package sb.fontys.esw.kwetter.model.tweets;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Robert
 */
@Entity
public class Tweet implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    
    @Column
    private final Message message;

    @Column
    @Temporal(value=TemporalType.TIMESTAMP)
    private final Date timestamp;

    protected Tweet() {
        this(Optional.empty(), null, null);
    }
    
    public Tweet(Optional<Integer> id, Message message, Date timestamp) {
        this.id = id.orElse(null);
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }
    
    public Message getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }    
}
