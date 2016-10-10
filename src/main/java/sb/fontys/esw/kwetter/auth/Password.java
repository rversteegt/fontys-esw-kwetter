package sb.fontys.esw.kwetter.auth;

import java.io.Serializable;

/**
 *
 * @author Robert
 */
public class Password implements Serializable {
    
    private final String password;

    public Password(String password) {
        this.password = password;
    }

    public String toString() {
        return password;
    }
}
