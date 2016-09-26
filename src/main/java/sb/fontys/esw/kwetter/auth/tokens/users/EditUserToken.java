package sb.fontys.esw.kwetter.auth.tokens.users;

import sb.fontys.esw.kwetter.auth.Username;
import sb.fontys.esw.kwetter.auth.tokens.Token;


public class EditUserToken extends Token<Username> {

    EditUserToken(Username data) {
        super(data);
    }
}
