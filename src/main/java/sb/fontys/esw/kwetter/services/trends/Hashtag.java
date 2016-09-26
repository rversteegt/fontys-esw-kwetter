package sb.fontys.esw.kwetter.services.trends;

/**
 *
 * @author Robert
 */
public class Hashtag {

    private final String hashtag;

    Hashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    @Override
    public String toString() {
        return hashtag;
    }
}
