package sb.fontys.esw.kwetter.services;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.inject.Inject;
import sb.fontys.esw.kwetter.auth.Username;
import sb.fontys.esw.kwetter.auth.tokens.tweets.ViewTweetsToken;
import sb.fontys.esw.kwetter.model.tweets.Tweet;
import sb.fontys.esw.kwetter.model.users.User;


public class TrendsCollectionImpl implements Trends {

    private final Map<Username, User> users;

    @Inject
    public TrendsCollectionImpl(Map<Username, User> users) {
        this.users = users;
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
