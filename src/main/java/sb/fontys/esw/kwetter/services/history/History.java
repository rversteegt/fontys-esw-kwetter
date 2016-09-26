package sb.fontys.esw.kwetter.services.history;

import java.util.List;
import java.util.function.Function;
import sb.fontys.esw.kwetter.auth.tokens.tweets.ViewTweetsToken;
import sb.fontys.esw.kwetter.model.tweets.Tweet;
import sb.fontys.esw.kwetter.services.core.User;

/**
 *
 * @author Robert
 */
public interface History {

    /**
     * Provides the ability to obtain tweets based on a search term.
     * @param token
     * @return
     */
    public abstract Function<SearchTerm, List<Tweet>> search(ViewTweetsToken token);

    /**
     * Provides the ability to view the timeline of a user.
     * @param token
     * @return
     */
    public abstract Function<User, List<Tweet>> timeline(ViewTweetsToken token);

    /**
     * Provides the ability to view tweets that mention a given user.
     * @param token
     * @return
     */
    public abstract Function<User, List<Tweet>> mentions(ViewTweetsToken token);
}
