package sb.fontys.esw.kwetter.services.core;

/**
 *
 * @author Robert
 */
public class User {

    private final sb.fontys.esw.kwetter.model.users.User user;

    User(sb.fontys.esw.kwetter.model.users.User user) {
        this.user = user;
    }

    public sb.fontys.esw.kwetter.model.users.User getUser() {
        return user;
    }
}
