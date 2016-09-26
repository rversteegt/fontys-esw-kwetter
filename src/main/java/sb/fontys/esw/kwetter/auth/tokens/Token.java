package sb.fontys.esw.kwetter.auth.tokens;

/**
 *
 * @author Robert
 */
public abstract class Token<T> {
    private final T data;

    protected Token(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
