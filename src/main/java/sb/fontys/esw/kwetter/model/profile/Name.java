package sb.fontys.esw.kwetter.model.profile;

import java.io.Serializable;

/**
 *
 * @author Robert
 */
public class Name implements Serializable {
    
    private final String name;

    public Name(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
