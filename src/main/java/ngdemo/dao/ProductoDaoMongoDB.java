package ngdemo.dao;

import ngdemo.domain.Producto;

import org.springframework.stereotype.Repository;

/**
 * Created by rodri on 10/24/2015.
 */
@Repository
public class ProductoDaoMongoDB extends GenericDaoMongoDB<Producto> implements
		ProductoDao {

	public ProductoDaoMongoDB() {
		super(Producto.class);
	}
}
