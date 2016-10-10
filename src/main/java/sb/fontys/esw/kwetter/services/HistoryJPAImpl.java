package sb.fontys.esw.kwetter.services;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sb.fontys.esw.kwetter.auth.Username;
import sb.fontys.esw.kwetter.auth.services.ViewTweetsToken;
import sb.fontys.esw.kwetter.auth.services.ViewUserToken;
import sb.fontys.esw.kwetter.model.tweets.Tweet;
import sb.fontys.esw.kwetter.model.users.User;
import sb.fontys.esw.kwetter.services.qualifiers.Primary;

@Stateless
@Primary
public class HistoryJPAImpl implements History {

    private static final int BATCH_SIZE = 1000;

    @PersistenceContext(unitName = "kwetter-main")
    private final EntityManager entityManager;

    /**
     * @deprecated
     */
    protected HistoryJPAImpl() {
        this(null);
    }

    public HistoryJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Function<SearchTerm, List<Tweet>> search(ViewTweetsToken token) {
        return term ->
            entityManager.
                createQuery("SELECT t FROM Tweet t WHERE t.message LIKE :term").
                setParameter("term", "%" + term + "%").
                setMaxResults(BATCH_SIZE).
                getResultList();
    }

    @Override
    public List<Tweet> timeline(ViewUserToken token) {
        Username id = token.getData();

        User user = entityManager.find(User.class, id);

        return Stream.concat(
            user.getTweets().stream(),
            user.getFollowing().stream().
                flatMap(u ->
                    u.getTweets().stream()).
                distinct()).
            collect(Collectors.toList());
    }

    @Override
    public Function<User, List<Tweet>> mentions(ViewTweetsToken token) {
        return user ->
            entityManager.
                createQuery("SELECT t FROM Tweet t WHERE t.message LIKE :term").
                setParameter("term", "%@" + user.getCredentials().getUsername().toString() + "%").
                setMaxResults(BATCH_SIZE).
                getResultList();
    }

}
