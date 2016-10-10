package sb.fontys.esw.kwetter.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ejb.Stateless;
import sb.fontys.esw.kwetter.auth.Username;
import sb.fontys.esw.kwetter.auth.services.ViewTweetsToken;
import sb.fontys.esw.kwetter.auth.services.ViewUserToken;
import sb.fontys.esw.kwetter.model.tweets.Tweet;
import sb.fontys.esw.kwetter.model.users.User;
import sb.fontys.esw.kwetter.services.qualifiers.Secondary;

@Stateless
@Secondary
public class HistoryCollectionImpl implements History {

    private final Map<Username, User> users = new HashMap<>();

    protected HistoryCollectionImpl() {
    }
    
    @Override
    public Function<SearchTerm, List<Tweet>> search(ViewTweetsToken token) {
        return term ->
            users.values().stream().
                flatMap(
                    u ->
                        u.getTweets().stream()).
                filter(
                    tweet ->
                        tweet.getMessage().getMessage().contains(term.toString())).
                collect(Collectors.toList());
                
    }

    @Override
    public List<Tweet> timeline(ViewUserToken token) {
        final Username username = token.getData();
        
        final User user = Optional.ofNullable(users.get(username)).
            orElseThrow(() -> new IllegalArgumentException("User does not exist."));

        return Stream.concat(
            user.getTweets().stream(),
            user.getFollowing().stream().flatMap(u -> u.getTweets().stream())).
            sorted(
                (a, b) ->
                    a.getTimestamp().compareTo(b.getTimestamp())).
            collect(Collectors.toList());
    }

    @Override
    public Function<User, List<Tweet>> mentions(ViewTweetsToken token) {
        return user ->
            users.values().stream().
                flatMap(
                    u ->
                        u.getTweets().stream()).
                filter(
                    tweet ->
                        tweet.getMessage().getMessage().contains("@" + user.toString())).
                collect(Collectors.toList());
    }
    
}
