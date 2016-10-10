package sb.fontys.esw.kwetter.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sb.fontys.esw.kwetter.auth.Username;
import sb.fontys.esw.kwetter.auth.tokens.users.EditUserToken;
import sb.fontys.esw.kwetter.auth.tokens.users.ViewUserToken;
import sb.fontys.esw.kwetter.model.profile.Profile;
import sb.fontys.esw.kwetter.model.tweets.Tweet;
import sb.fontys.esw.kwetter.model.users.User;
import sb.fontys.esw.kwetter.services.qualifiers.Primary;

@Stateless
@Primary
public class CoreJPAImpl implements Core {
    
    @PersistenceContext(unitName = "kwetter-main")
    private final EntityManager entityManager;

    /**
     * @deprecated
     */
    protected CoreJPAImpl() {
        this(null);
    }

    @Inject
    public CoreJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<User> viewUser(ViewUserToken token) {
        final Username username = token.getData();
        
        return Optional.ofNullable(
            entityManager.find(User.class, username));
    }

    @Override
    public User addTweet(EditUserToken token, Tweet tweet) {
        final Username username = token.getData();
        
        final User user = Optional.
            ofNullable(entityManager.find(User.class, username)).
            orElseThrow(() -> new IllegalArgumentException());
        
        user.getTweets().add(tweet);
        
        return entityManager.merge(user);
    }

    @Override
    public User addFollower(EditUserToken token, User follower) {
        final Username username = token.getData();
        
        final User user = Optional.
            ofNullable(entityManager.find(User.class, username)).
            orElseThrow(() -> new IllegalArgumentException());
        
        final List<User> newFollowing = Stream.
            concat(follower.getFollowing().stream(), Stream.of(user)).
            collect(Collectors.toList());
        
        final List<User> newFollowers = Stream.
            concat(user.getFollowers().stream(), Stream.of(follower)).
            collect(Collectors.toList());

        final User newOtherUser = new User(
            follower.getId(),
            follower.getCredentials(),
            follower.getProfile(),
            newFollowing,
            follower.getFollowers(),
            follower.getTweets());

        entityManager.merge(newOtherUser);
        
        final User newUser = new User(
            user.getId(),
            user.getCredentials(),
            user.getProfile(),
            user.getFollowing(),
            newFollowers,
            user.getTweets());
        
        return entityManager.merge(newUser);
    }

    @Override
    public User updateProfile(EditUserToken token, Profile profile) {
        final Username username = token.getData();
        
        final User user = Optional.
            ofNullable(entityManager.find(User.class, username)).
            orElseThrow(() -> new IllegalArgumentException());
        
        final User newUser = new User(
            user.getId(),
            user.getCredentials(),
            profile,
            user.getFollowing(),
            user.getFollowers(),
            user.getTweets());
        
        return entityManager.merge(newUser);
    }
}
