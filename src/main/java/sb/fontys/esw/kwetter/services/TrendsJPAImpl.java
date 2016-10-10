package sb.fontys.esw.kwetter.services;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sb.fontys.esw.kwetter.auth.services.ViewTweetsToken;
import sb.fontys.esw.kwetter.model.tweets.Tweet;
import sb.fontys.esw.kwetter.services.qualifiers.Primary;

@Stateless
@Primary
public class TrendsJPAImpl implements Trends {

    private static final int BATCH_SIZE = 1000;

    @PersistenceContext(unitName = "kwetter-main")
    private final EntityManager entityManager;

    /**
     * @deprecated
     */
    protected TrendsJPAImpl() {
        this(null);
    }

    public TrendsJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Hashtag> listHastags(ViewTweetsToken token) {
        return ((List<HashtagHistory>) entityManager.
            createQuery("SELECT h FROM HashtagHistory h").
            getResultList()).stream().
            map(h -> h.getHashtag()).
            collect(Collectors.toList());
    }

    @Override
    public Function<Hashtag, List<Tweet>> viewTweetsWithHastag(ViewTweetsToken token) {
        return hashtag ->
            entityManager.
                createQuery("SELECT t FROM Tweet t WHERE t.message LIKE :term").
                setParameter("term", "%#" + hashtag + "%").
                setMaxResults(BATCH_SIZE).
                getResultList();
    }

}
