package meuk;

import java.util.function.Supplier;
import javax.persistence.EntityManager;

/**
 *
 * @author Robert
 */
public class BetterEntityManager<T, I> implements Findable<T, I>, Creatable<T>, Removable<T>, Editable<T> {
    private final Class<T> entityClass;
    
    private final EntityManager entityManager;

    public BetterEntityManager(Class<T> entityClass, Supplier<EntityManager> entityManager) {
        this.entityClass = entityClass;
        this.entityManager = entityManager.get();
    }
    
    public void create(T t) {
        entityManager.persist(t);
    }
    
    public void edit(T t) {
        entityManager.merge(t);
    }
    
    public void remove(T t) {
        entityManager.remove(entityManager.merge(t));
    }
    
    public T find(I id) {
        return entityManager.find(entityClass, id);
    }
}
