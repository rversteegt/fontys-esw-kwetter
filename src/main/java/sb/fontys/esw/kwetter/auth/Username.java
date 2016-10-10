package sb.fontys.esw.kwetter.auth;

import java.io.Serializable;

/**
 *
 * @author Robert
 */
public class Username implements Serializable {

    private final String username;

    public Username(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public boolean equals(Username b) {
        return this.username.equals(b.username);
    }
}
