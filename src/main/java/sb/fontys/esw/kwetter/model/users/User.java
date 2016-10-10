package sb.fontys.esw.kwetter.model.users;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import sb.fontys.esw.kwetter.auth.Credentials;
import sb.fontys.esw.kwetter.model.profile.Profile;
import sb.fontys.esw.kwetter.model.tweets.Tweet;

/**
 *
 * @author Robert
 */
@Entity
public class User implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column
    @OneToOne
    private final Credentials credentials;

    @Column
    @OneToOne
    private final Profile profile;

    @Column
    @ManyToOne
    private final List<User> following;

    @Column
    @ManyToOne
    private final List<User> followers;

    @Column
    @ManyToOne
    private final List<Tweet> tweets;

    protected User() {
        this(Optional.empty(), null, null, null, null, null);
    }

    public User(
        Optional<Integer> id,
        Credentials credentials,
        Profile profile,
        List<User> following,
        List<User> followers,
        List<Tweet> tweets
    ) {
        this.id = id.orElse(null);
        this.credentials = credentials;
        this.profile = profile;
        this.following = following;
        this.followers = followers;
        this.tweets = tweets;
    }
    
    public Optional<Integer> getId() {
        return Optional.ofNullable(id);
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
