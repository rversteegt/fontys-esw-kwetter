package sb.fontys.esw.kwetter.auth.services;

import sb.fontys.esw.kwetter.auth.Username;


public class EditUserToken extends Token<Username> {

    EditUserToken(Username data) {
        super(data);
    }
}
