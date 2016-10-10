package sb.fontys.esw.kwetter.services;

import java.util.Optional;
import sb.fontys.esw.kwetter.auth.services.EditUserToken;
import sb.fontys.esw.kwetter.auth.services.ViewUserToken;
import sb.fontys.esw.kwetter.model.profile.Profile;
import sb.fontys.esw.kwetter.model.tweets.Tweet;
import sb.fontys.esw.kwetter.model.users.User;

/**
 *
 * @author Robert
 */
public interface Core {

    /**
     * Provides the ability to obtain a user.
     * @param token
     * @return
     */
    public abstract Optional<User> viewUser(ViewUserToken token);

    /**
     * Provides the ability to add a tweet.
     * @param token
     * @param tweet
     * @return
     */
    public abstract User addTweet(EditUserToken token, Tweet tweet);

    /**
     * Provides the ability to add a follower.
     * @param token
     * @param follower
     * @return
     */
    public abstract User addFollower(EditUserToken token, User follower);

    /**
     * Provides the ability to update a profile.
     * @param token
     * @param profile
     * @return
     */
    public abstract User updateProfile(EditUserToken token, Profile profile);
}
