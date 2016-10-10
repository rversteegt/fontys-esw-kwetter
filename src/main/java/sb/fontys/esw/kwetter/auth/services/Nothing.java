package sb.fontys.esw.kwetter.auth.services;

import java.util.Optional;

/**
 * Class representing the empty half of Optional.
 * @author Robert
 */
public class Nothing {

    private Nothing() {}

    public Optional<Nothing> toOptional() {
        return Optional.empty();
    }

    public static Nothing nothing() {
        return new Nothing();
    }
}
