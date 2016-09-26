package sb.fontys.esw.kwetter.auth;

/**
 *
 * @author Robert
 */
public class Credentials {

    private final Username username;

    private final Password password;

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
