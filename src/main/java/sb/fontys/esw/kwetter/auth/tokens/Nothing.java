package sb.fontys.esw.kwetter.auth.tokens;

import java.util.Optional;

/**
 * Class representing the empty half of Optional.
 * @author Robert
 */
public class Nothing {

    public Optional<Nothing> toOptional() {
        return Optional.empty();
    }
}
