package sb.fontys.esw.kwetter.services;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import javax.inject.Inject;
import sb.fontys.esw.kwetter.auth.Username;
import sb.fontys.esw.kwetter.auth.tokens.tweets.ViewTweetsToken;
import sb.fontys.esw.kwetter.model.tweets.Tweet;
import sb.fontys.esw.kwetter.services.User;


public class TrendsCollectionImpl implements Trends {

    private final Map<Username, User> users;

    @Inject
    public TrendsCollectionImpl(Map<Username, User> users) {
        this.users = users;
    }
    
    @Override
    public Supplier<List<Hashtag>> listHastags(ViewTweetsToken token) {
        () ->
            users.values().stream().
                flatMap(
                    u -> u.getUser().getTweets().stream()).
                collect(
                    Collectors.groupingBy(
                        tweet ->
                            tweet.getMessage().getMessage().
                            ))
    }

    @Override
    public Function<Hashtag, List<Tweet>> viewTweetsWithHastag(ViewTweetsToken token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
