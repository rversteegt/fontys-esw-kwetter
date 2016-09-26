package sb.fontys.esw.kwetter.model.tweets;

import java.util.Date;

/**
 *
 * @author Robert
 */
public class Tweet {

    private final Message message;

    private final Date timestamp;

    public Tweet(Message message, Date timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public Message getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
