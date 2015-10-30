package ngdemo.dao;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

import ngdemo.domain.Receta;

import org.springframework.stereotype.Repository;

/**
 * Created by rodri on 10/24/2015.
 */
@Repository
public class RecetaDaoMongoDB extends GenericDaoMongoDB<Receta> implements
		RecetaDao {

	public Receta create(final Receta receta) throws NotSupportedException,
			SystemException, Exception {
		// entityManager.find(Receta.class,receta.getNombre());
		persist(receta);
		get(Receta.class, receta.getId());
		return receta;
	}
}
