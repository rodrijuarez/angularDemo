package ngdemo.service;

import ngdemo.dao.RecetaDao;
import ngdemo.domain.Receta;

import javax.ejb.Stateless;

@Stateless
public class RecetaService {

    private RecetaDao dao;

    public RecetaService(){
        dao = new RecetaDao();
    }

    public Receta getDefaultReceta() {
        Receta receta = new Receta();
        receta.setNombre("JonFromREST");
        receta.setDescripcion("DoeFromREST");
        return receta;
    }

    public void create(Receta receta){
        dao.create(receta);
    }
}
