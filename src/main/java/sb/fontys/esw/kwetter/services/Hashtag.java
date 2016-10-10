package sb.fontys.esw.kwetter.services;

import java.io.Serializable;

/**
 *
 * @author Robert
 */
public class Hashtag implements Serializable {

    private final String hashtag;

    public Hashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    @Override
    public String toString() {
        return hashtag;
    }
}
