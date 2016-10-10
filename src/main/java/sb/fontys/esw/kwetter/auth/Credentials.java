package sb.fontys.esw.kwetter.auth;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Robert
 */
@Entity
public class Credentials implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    
    @Column
    private final Username username;

    @Column
    private final Password password;

    protected Credentials() {
        this(null, null);
    }

    public Credentials(Username username, Password password) {
        this.username = username;
        this.password = password;
    }

    public Username getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }
}
