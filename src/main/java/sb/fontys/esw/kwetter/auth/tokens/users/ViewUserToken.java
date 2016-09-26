package sb.fontys.esw.kwetter.auth.tokens.users;

import sb.fontys.esw.kwetter.auth.Username;
import sb.fontys.esw.kwetter.auth.tokens.Token;

/**
 *
 * @author Robert
 */
public class ViewUserToken extends Token<Username> {

    ViewUserToken(Username data) {
        super(data);
    }
}
