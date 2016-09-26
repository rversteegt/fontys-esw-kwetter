package sb.fontys.esw.kwetter.services.history;

/**
 *
 * @author Robert
 */
public class SearchTerm {

    private final String searchTerm;

    SearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String toString() {
        return searchTerm;
    }
}
