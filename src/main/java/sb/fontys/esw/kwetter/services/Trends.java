package sb.fontys.esw.kwetter.services;

import java.util.List;
import java.util.function.Function;
import sb.fontys.esw.kwetter.auth.services.ViewTweetsToken;
import sb.fontys.esw.kwetter.model.tweets.Tweet;

/**
 *
 * @author Robert
 */
public interface Trends {

    /**
     * Provides the ability to obtain a list of popular hashtags.
     * @param token
     * @return
     */
    public abstract List<Hashtag> listHastags(ViewTweetsToken token);

    /**
     * Provides the ability to obtain all tweets that mention a given hashtag.
     * @param token
     * @return
     */
    public abstract Function<Hashtag, List<Tweet>> viewTweetsWithHastag(ViewTweetsToken token);
}
