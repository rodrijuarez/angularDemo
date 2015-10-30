package ngdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by rodri on 10/25/2015.
 */
public class GenericDaoMongoDB<T> implements GenericDao<T> {

	private EntityManager entityManager;

	private final EntityManagerFactory entityManagerFactory;

	private final Class<T> persistentClass;

	public GenericDaoMongoDB(final Class<T> persistentClass) {
		this.entityManagerFactory = Persistence
				.createEntityManagerFactory("angularDemo-PU");
		this.persistentClass = persistentClass;
	}

	@Override
	public T save(final T object) throws Exception {
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
		entityManager.close();
		return object;
	}

	@Override
	public T get(final Integer id) {
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(persistentClass, id);
	}

	public List<T> getAll() {
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager.createQuery(
				"FROM " + persistentClass.getSimpleName(),
				persistentClass).getResultList();
	}
}
