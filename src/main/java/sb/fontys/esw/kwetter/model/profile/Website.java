package sb.fontys.esw.kwetter.model.profile;

import java.io.Serializable;
import java.net.URL;

/**
 *
 * @author Robert
 */
public class Website implements Serializable {
    
    private final URL url;

    public Website(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }
}
