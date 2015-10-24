package ngdemo.service;

import ngdemo.dao.RecetaDao;
import ngdemo.domain.Receta;

public class RecetaService {

    public Receta getDefaultReceta() {
        Receta receta = new Receta();
        receta.setNombre("JonFromREST");
        receta.setDescripcion("DoeFromREST");
        return receta;
    }

    public void create(Receta receta){
        RecetaDao recetaDao = new RecetaDao();
        recetaDao.create(receta);
    }
}
