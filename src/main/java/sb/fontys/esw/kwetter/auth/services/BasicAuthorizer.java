package sb.fontys.esw.kwetter.auth.services;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import sb.fontys.esw.kwetter.auth.Credentials;
import sb.fontys.esw.kwetter.auth.Username;
import sb.fontys.esw.kwetter.model.users.User;

/**
 *
 * @author Robert
 */
public class BasicAuthorizer implements Authorizer {

    @PersistenceContext(unitName = "kwetter-main")
    private final EntityManager entityManager;

    /**
     * @deprecated
     */
    protected BasicAuthorizer() {
        this(null);
    }

    public BasicAuthorizer(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * A user can claim its identity by providing a matching username and password.
     * @param credentials
     * @return
     */
    @Override
    public Optional<User> claimIdentity(Credentials credentials) {
        try {
            return Optional.of(
                (User) entityManager.
                    createQuery(
                        "SELECT u " +
                        "FROM User u " +
                        "WHERE u.credentials.username LIKE :username " +
                        "AND u.credentials.password LIKE :password").
                    setParameter("username", credentials.getUsername().toString()).
                    setParameter("password", credentials.getPassword().toString()).
                    getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    /**
     * Everyone can see all tweets.
     * @param claimant
     * @return
     */
    @Override
    public Optional<ViewTweetsToken> claimViewTweets(User claimant) {
        return Optional.of(
            new ViewTweetsToken(Nothing.nothing()));
    }

    /**
     * Everyone can see all users.
     * @param claimant
     * @param subject
     * @return
     */
    @Override
    public Optional<ViewUserToken> claimViewUser(User claimant, Username subject) {
        return Optional.of(
            new ViewUserToken(subject));
    }

    /**
     * Users can edit only their own profile.
     * @param claimant
     * @param subject
     * @return 
     */
    @Override
    public Optional<EditUserToken> claimEditUser(User claimant, Username subject) {
        return claimant.getCredentials().getUsername().equals(subject) ?
            Optional.of(new EditUserToken(subject)) :
            Optional.empty();
    }
}