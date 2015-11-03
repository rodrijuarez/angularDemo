package ngdemo.service;

import java.util.List;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

import ngdemo.dao.ProductoDao;
import ngdemo.dao.ProductoDaoMongoDB;
import ngdemo.domain.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

	@Autowired
	private ProductoDao productoDao;

	public Producto create(final Producto producto)
			throws NotSupportedException, SystemException, Exception {
		return productoDao.save(producto);
	}

	public void delete(final int id) {
		productoDao.delete(id);
	}

	public void update(final Producto producto) {
		productoDao.update(producto);
	}

	public List<Producto> getAll() {
		return ((ProductoDaoMongoDB) productoDao).getAll();
	}

	public Producto get(final int id) {
		return ((ProductoDaoMongoDB) productoDao).get(id);
	}

	public void setDao(final ProductoDaoMongoDB productoDao) {
		this.productoDao = productoDao;
	}
}
