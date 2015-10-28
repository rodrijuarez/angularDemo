package ngdemo.service;

import ngdemo.dao.RecetaDao;
import ngdemo.domain.Receta;

import org.springframework.stereotype.Service;

@Service
public class RecetaService {

	private final RecetaDao dao;

	public RecetaService() {
		dao = new RecetaDao();
	}

	public Receta getDefaultReceta() {
		final Receta receta = new Receta();
		receta.setNombre("JonFromREST");
		receta.setDescripcion("DoeFromREST");
		return receta;
	}

	public void create(final Receta receta) {
		dao.create(receta);
	}
}
