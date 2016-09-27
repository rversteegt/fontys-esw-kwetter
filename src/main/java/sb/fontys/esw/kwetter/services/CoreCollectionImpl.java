package sb.fontys.esw.kwetter.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import sb.fontys.esw.kwetter.auth.Username;
import sb.fontys.esw.kwetter.auth.tokens.users.EditUserToken;
import sb.fontys.esw.kwetter.auth.tokens.users.ViewUserToken;
import sb.fontys.esw.kwetter.model.profile.Profile;
import sb.fontys.esw.kwetter.model.tweets.Tweet;

public class CoreCollectionImpl implements Core {

    private final Map<Username, User> users;

    @Inject
    public CoreCollectionImpl(Map<Username, User> users) {
        this.users = users;
    }
    
    @Override
    public Supplier<Optional<User>> viewUser(ViewUserToken token) {
        return () ->
            Optional.ofNullable(users.get(token.getData()));
    }

    @Override
    public Consumer<Tweet> addTweet(EditUserToken token) {        
        return tweet -> {            
            final sb.fontys.esw.kwetter.model.users.User user = 
                Optional.ofNullable(users.get(token.getData())).
                    orElseThrow(() -> new IllegalArgumentException("User does not exist.")).
                    getUser();
        
            final List<Tweet> newTweets =
                Stream.concat(
                    user.getTweets().stream(),
                    Stream.of(tweet)
                ).collect(Collectors.toList());
        
            final User newUser = new User(
                new sb.fontys.esw.kwetter.model.users.User(
                    user.getCredentials(),
                    user.getProfile(),
                    user.getFollowing(),
                    user.getFollowers(),
                    newTweets
                )
            );
            
            users.put(token.getData(), newUser);
        };            
    }

    @Override
    public Consumer<User> addFollower(EditUserToken token) {        
        return follower -> {
            final sb.fontys.esw.kwetter.model.users.User user = 
                Optional.ofNullable(users.get(token.getData())).
                    orElseThrow(() -> new IllegalArgumentException("User does not exist.")).
                    getUser();
            
            final List<sb.fontys.esw.kwetter.model.users.User> newFollowers =
                Stream.concat(
                    user.getFollowers().stream(),
                    Stream.of(follower.getUser())
                ).collect(Collectors.toList());
        
            final User newUser = new User(
                new sb.fontys.esw.kwetter.model.users.User(
                    user.getCredentials(),
                    user.getProfile(),
                    user.getFollowing(),
                    newFollowers,
                    user.getTweets()
                )
            );
            
            users.put(token.getData(), newUser);
        };
        
    }

    @Override
    public Consumer<Profile> updateProfile(EditUserToken token) {
        
        return profile -> {
            final sb.fontys.esw.kwetter.model.users.User user = 
                Optional.ofNullable(users.get(token.getData())).
                    orElseThrow(() -> new IllegalArgumentException("User does not exist.")).
                    getUser();
            
            final User newUser = new User(
                new sb.fontys.esw.kwetter.model.users.User(
                    user.getCredentials(),
                    profile,
                    user.getFollowing(),
                    user.getFollowers(),
                    user.getTweets()
                )
            );
            
            users.put(token.getData(), newUser);
        };
    }
}
