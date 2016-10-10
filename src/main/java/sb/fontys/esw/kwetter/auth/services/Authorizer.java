package sb.fontys.esw.kwetter.auth.services;

import java.util.Optional;
import sb.fontys.esw.kwetter.auth.Credentials;
import sb.fontys.esw.kwetter.auth.Username;
import sb.fontys.esw.kwetter.model.users.User;

/**
 *
 * @author Robert
 */
public interface Authorizer {

    /**
     * Negotiates identity based on credentials.
     * 
     * @param credentials
     * @return
     */
    public Optional<User> claimIdentity(Credentials credentials);

    /**
     * Negotiates a token for viewing tweets.
     *
     * @param claimant
     * @return
     */
    public Optional<ViewTweetsToken> claimViewTweets(User claimant);

    /**
     * Negotiates a token for viewing a user.
     *
     * @param claimant
     * @param subject
     * @return
     */
    public Optional<ViewUserToken> claimViewUser(User claimant, Username subject);

    /**
     * Negotiates a token for editing a user.
     *
     * @param claimant
     * @param subject
     * @return
     */
    public Optional<EditUserToken> claimEditUser(User claimant, Username subject);
}
