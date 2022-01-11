package Factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class ConnectionFactory {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("PU");

    public EntityManager getConnection(){
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}