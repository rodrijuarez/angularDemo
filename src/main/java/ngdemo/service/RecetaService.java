package ngdemo.service;

import java.util.List;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

import ngdemo.dao.RecetaDao;
import ngdemo.dao.RecetaDaoMongoDB;
import ngdemo.domain.Receta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecetaService {

	@Autowired
	private RecetaDao recetaDao;

	public Receta getDefaultReceta() {
		final Receta receta = new Receta();
		receta.setNombre("JonFromREST");
		receta.setDescripcion("DoeFromREST");
		return receta;
	}

	public Receta create(final Receta receta) throws NotSupportedException,
			SystemException, Exception {
		return recetaDao.save(receta);
	}

	public List<Receta> getAll() {
		return ((RecetaDaoMongoDB) recetaDao).getAll();
	}

	public void setDao(final RecetaDaoMongoDB recetaDao) {
		this.recetaDao = recetaDao;
	}
}
