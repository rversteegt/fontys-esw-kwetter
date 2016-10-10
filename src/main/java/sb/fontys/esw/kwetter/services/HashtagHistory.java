package sb.fontys.esw.kwetter.services;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import sb.fontys.esw.kwetter.model.tweets.Tweet;

/**
 *
 * @author Robert
 */
@Entity
public class HashtagHistory implements Serializable {

    @Column
    @Id
    private final Hashtag hashtag;

    @Column
    @OneToMany
    private final List<Tweet> tweets;

    /**
     * @deprecated
     */
    protected HashtagHistory() {
        this(null, null);
    }

    public HashtagHistory(Hashtag hashtag, List<Tweet> tweets) {
        this.hashtag = hashtag;
        this.tweets = tweets;
    }

    public Hashtag getHashtag() {
        return hashtag;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }
}
