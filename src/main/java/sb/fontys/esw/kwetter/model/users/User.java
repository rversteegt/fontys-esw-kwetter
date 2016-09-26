package sb.fontys.esw.kwetter.model.users;

import java.util.List;
import sb.fontys.esw.kwetter.auth.Credentials;
import sb.fontys.esw.kwetter.model.profile.Profile;
import sb.fontys.esw.kwetter.model.tweets.Tweet;

/**
 *
 * @author Robert
 */
public class User {

    private final Credentials credentials;

    private final Profile profile;

    private final List<User> following;

    private final List<User> followers;

    private final List<Tweet> tweets;

    public User(Credentials credentials, Profile profile, List<User> following, List<User> followers, List<Tweet> tweets) {
        this.credentials = credentials;
        this.profile = profile;
        this.following = following;
        this.followers = followers;
        this.tweets = tweets;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<User> getFollowing() {
        return following;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }
}
