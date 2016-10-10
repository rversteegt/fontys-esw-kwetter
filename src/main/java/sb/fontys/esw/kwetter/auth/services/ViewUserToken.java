package sb.fontys.esw.kwetter.auth.services;

import sb.fontys.esw.kwetter.auth.Username;

/**
 *
 * @author Robert
 */
public class ViewUserToken extends Token<Username> {

    ViewUserToken(Username data) {
        super(data);
    }
}
