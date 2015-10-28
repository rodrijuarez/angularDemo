package ngdemo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionManager;

import org.jboss.jandex.Main;
import org.springframework.stereotype.Repository;

/**
 * Created by rodri on 10/25/2015.
 */
@Repository
public class GenericDaoMongoDB implements GenericDao {
	@PersistenceContext(unitName = "angularDemo-PU")
	EntityManager entityManager;

	private static final String JBOSS_TM_CLASS_NAME = "com.arjuna.ats.jta.TransactionManager";

	@Override
	public void persist(final Object object) throws Exception {
		final TransactionManager transactionManager = getTransactionManager();
		transactionManager.begin();
		entityManager.persist(object);
		entityManager.flush();
		entityManager.close();
		transactionManager.commit();
	}

	public TransactionManager getTransactionManager() throws Exception {
		final Class<?> tmClass = Main.class.getClassLoader().loadClass(
				JBOSS_TM_CLASS_NAME);
		return (TransactionManager) tmClass.getMethod("transactionManager")
				.invoke(null);
	}
}
