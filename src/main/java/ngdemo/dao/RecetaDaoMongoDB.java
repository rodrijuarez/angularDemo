package ngdemo.dao;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

import org.springframework.stereotype.Repository;

import ngdemo.domain.Receta;

/**
 * Created by rodri on 10/24/2015.
 */
@Repository
public class RecetaDaoMongoDB extends GenericDaoMongoDB implements RecetaDao{

    public Receta create(final Receta receta) throws NotSupportedException, SystemException, Exception {
        //entityManager.find(Receta.class,receta.getNombre());
    	persist(receta);
    	return receta;
    }
}
