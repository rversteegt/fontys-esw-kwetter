package meuk;

/**
 *
 * @author Robert
 */
public interface Findable<T, I> {
    public T find(I identifier);
}
