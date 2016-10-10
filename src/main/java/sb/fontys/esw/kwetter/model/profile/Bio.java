package sb.fontys.esw.kwetter.model.profile;

import java.io.Serializable;

/**
 *
 * @author Robert
 */
public class Bio implements Serializable {
    
    private final String bio;

    public Bio(String bio) {
        this.bio = bio;
    }

    public String toString() {
        return bio;
    }
}
