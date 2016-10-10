package sb.fontys.esw.kwetter.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import sb.fontys.esw.kwetter.auth.Username;
import sb.fontys.esw.kwetter.auth.services.ViewTweetsToken;
import sb.fontys.esw.kwetter.model.tweets.Tweet;
import sb.fontys.esw.kwetter.model.users.User;
import sb.fontys.esw.kwetter.services.qualifiers.Secondary;

@Stateless
@Secondary
public class TrendsCollectionImpl implements Trends {

    private final Map<Username, User> users = new HashMap<>();

    /**
     * @deprecated
     */
    protected TrendsCollectionImpl() {
    }
    
    @Override
    public List<Hashtag> listHastags(ViewTweetsToken token) {
        // fun exercise for practicing streams though
        throw new UnsupportedOperationException();
    }

    @Override
    public Function<Hashtag, List<Tweet>> viewTweetsWithHastag(ViewTweetsToken token) {
        return hashtag ->
            users.values().stream().
                flatMap(
                    user ->
                        user.getTweets().stream()).
                filter(
                    tweet ->
                        tweet.getMessage().getMessage().contains("#" + hashtag.toString())).
                collect(Collectors.toList());
    }
    
}
