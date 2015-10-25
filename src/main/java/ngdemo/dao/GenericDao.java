package ngdemo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by rodri on 10/25/2015.
 */
public class GenericDao {
    @PersistenceContext(unitName = "angularDemo-PU")
    EntityManager entityManager;
}
