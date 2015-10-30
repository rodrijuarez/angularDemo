package ngdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

/**
 * Created by rodri on 10/25/2015.
 */
@Repository
public class GenericDaoMongoDB<T> implements GenericDao<T> {

	private EntityManager entityManager;

	private final EntityManagerFactory entityManagerFactory;

	public GenericDaoMongoDB() {
		this.entityManagerFactory = Persistence
				.createEntityManagerFactory("angularDemo-PU");
	}

	@Override
	public void persist(final T object) throws Exception {
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public T get(final Class<T> type,final Integer id) {
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(type, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(final String className) {
		return entityManager.createQuery("SELECT * FROM Receta")
				.getResultList();
	}
}
