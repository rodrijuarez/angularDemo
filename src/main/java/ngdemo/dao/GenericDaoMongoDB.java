package ngdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

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
	public void persist(final T object) throws Exception {
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public T get(final Integer id) {
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(persistentClass, id);
	}

	public List<T> getAll() {
		return entityManager.createQuery(
				"FROM " + persistentClass.getSimpleName(),
				persistentClass).getResultList();
	}
}
