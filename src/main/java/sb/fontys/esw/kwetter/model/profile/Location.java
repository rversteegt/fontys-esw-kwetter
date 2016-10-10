package sb.fontys.esw.kwetter.model.profile;

import java.io.Serializable;

/**
 *
 * @author Robert
 */
public class Location implements Serializable {
    
    private final String location;

    public Location(String location) {
        this.location = location;
    }

    public String toString() {
        return location;
    }
}
