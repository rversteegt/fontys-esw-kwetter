package sb.fontys.esw.kwetter.auth;

/**
 *
 * @author Robert
 */
public class Username {
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
