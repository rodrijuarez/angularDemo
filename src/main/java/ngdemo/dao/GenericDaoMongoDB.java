package ngdemo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;

import org.jboss.jandex.Main;
import org.springframework.stereotype.Repository;

/**
 * Created by rodri on 10/25/2015.
 */
@Repository
public class GenericDaoMongoDB<T> implements GenericDao<T> {
	private EntityManager entityManager;

	private final EntityManagerFactory entityManagerFactory;

	public GenericDaoMongoDB() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("angularDemo-PU");
	}

	private static final String JBOSS_TM_CLASS_NAME = "com.arjuna.ats.jta.TransactionManager";

	@Override
	public void persist(final T object) throws Exception {
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public TransactionManager getTransactionManager() throws Exception {
		final Class<?> tmClass = Main.class.getClassLoader().loadClass(
				JBOSS_TM_CLASS_NAME);
		return (TransactionManager) tmClass.getMethod("transactionManager")
				.invoke(null);
	}
}
