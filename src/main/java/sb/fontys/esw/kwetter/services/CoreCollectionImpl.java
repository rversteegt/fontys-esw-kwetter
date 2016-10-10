package sb.fontys.esw.kwetter.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ejb.Stateless;
import sb.fontys.esw.kwetter.auth.Username;
import sb.fontys.esw.kwetter.auth.services.EditUserToken;
import sb.fontys.esw.kwetter.auth.services.ViewUserToken;
import sb.fontys.esw.kwetter.model.profile.Profile;
import sb.fontys.esw.kwetter.model.tweets.Tweet;
import sb.fontys.esw.kwetter.model.users.User;
import sb.fontys.esw.kwetter.services.qualifiers.Secondary;

@Stateless
@Secondary
public class CoreCollectionImpl implements Core {

    private final Map<Username, User> users = new HashMap<>();

    protected CoreCollectionImpl() {
    }

    @Override
    public Optional<User> viewUser(ViewUserToken token) {
        return Optional.ofNullable(users.get(token.getData()));
    }

    @Override
    public User addTweet(EditUserToken token, Tweet tweet) {
        final User user = Optional.ofNullable(users.get(token.getData())).
            orElseThrow(() -> new IllegalArgumentException("User does not exist."));
        
        final List<Tweet> newTweets =
            Stream.concat(
                user.getTweets().stream(),
                Stream.of(tweet)
            ).collect(Collectors.toList());

        final User newUser = new User(
            user.getId(),
            user.getCredentials(),
            user.getProfile(),
            user.getFollowing(),
            user.getFollowers(),
            newTweets
        );

        users.put(token.getData(), newUser);
        
        return newUser;
    }

    @Override
    public User addFollower(EditUserToken token, User follower) {
        
        final Username userName = token.getData();
        
        final User user = Optional.ofNullable(users.get(userName)).
            orElseThrow(() -> new IllegalArgumentException("User does not exist."));
            
        final List<User> newFollowers =
            Stream.concat(
                user.getFollowers().stream(),
                Stream.of(follower)
            ).collect(Collectors.toList());

        final User newUser = new User(
            user.getId(),
            user.getCredentials(),
            user.getProfile(),
            user.getFollowing(),
            newFollowers,
            user.getTweets()
        );

        users.put(userName, newUser);

        return newUser;
    }

    @Override
    public User updateProfile(EditUserToken token, Profile profile) {
        final User user = 
                Optional.ofNullable(users.get(token.getData())).
                    orElseThrow(() -> new IllegalArgumentException("User does not exist."));
            
        final User newUser = new User(
            user.getId(),
            user.getCredentials(),
            profile,
            user.getFollowing(),
            user.getFollowers(),
            user.getTweets()
        );

        users.put(token.getData(), newUser);
        
        return newUser;
    }
}
