package ngdemo.dao;

import ngdemo.domain.Receta;

import org.springframework.stereotype.Repository;

/**
 * Created by rodri on 10/24/2015.
 */
@Repository
public class RecetaDaoMongoDB extends GenericDaoMongoDB<Receta> implements
		RecetaDao {

	public RecetaDaoMongoDB() {
		super(Receta.class);
	}
}
