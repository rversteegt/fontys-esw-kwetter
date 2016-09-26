package sb.fontys.esw.kwetter.services.core;

import java.util.function.Consumer;
import java.util.function.Supplier;
import sb.fontys.esw.kwetter.auth.tokens.users.EditUserToken;
import sb.fontys.esw.kwetter.auth.tokens.users.ViewUserToken;
import sb.fontys.esw.kwetter.model.profile.Profile;
import sb.fontys.esw.kwetter.model.tweets.Tweet;

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
    public abstract Supplier<User> viewUser(ViewUserToken token);

    /**
     * Provides the ability to add a tweet.
     * @param token
     * @return
     */
    public abstract Consumer<Tweet> addTweet(EditUserToken token);

    /**
     * Provides the ability to add a follower.
     * @param token
     * @return
     */
    public abstract Consumer<User> addFollower(EditUserToken token);

    /**
     * Provides the ability to update a profile.
     * @param token
     * @return
     */
    public abstract Consumer<Profile> updateProfile(EditUserToken token);
}
