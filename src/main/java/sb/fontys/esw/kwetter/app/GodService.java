package sb.fontys.esw.kwetter.app;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sb.fontys.esw.kwetter.auth.services.Authorizer;
import sb.fontys.esw.kwetter.services.Core;
import sb.fontys.esw.kwetter.services.History;
import sb.fontys.esw.kwetter.services.Trends;
import sb.fontys.esw.kwetter.services.qualifiers.Primary;

/**
 *
 * @author Robert
 */
class GodService {

    private final Authorizer auth;

    private final Core core;

    private final History history;

    private final Trends trends;

    @PersistenceContext(unitName = "kwetter-main")
    private final EntityManager entityManager;

    /**
     * @deprecated
     */
    protected GodService() {
        this(null, null, null, null, null);
    }

    @Inject
    GodService(@Primary Authorizer auth, @Primary Core core, @Primary History history, @Primary Trends trends, EntityManager entityManager) {
        this.auth = auth;
        this.core = core;
        this.history = history;
        this.trends = trends;
        this.entityManager = entityManager;
    }

    Authorizer getAuth() {
        return auth;
    }

    Core getCore() {
        return core;
    }

    History getHistory() {
        return history;
    }

    Trends getTrends() {
        return trends;
    }

    EntityManager getEntityManager() {
        return entityManager;
    }



}
