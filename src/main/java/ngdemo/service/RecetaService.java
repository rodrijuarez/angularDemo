package ngdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ngdemo.dao.RecetaDao;
import ngdemo.domain.Receta;

@Service
public class RecetaService {

    private final RecetaDao dao;
    
    @Autowired
    private ServicioTrucho servicioTrucho;

    public RecetaService(){
        dao = new RecetaDao();
    }

    public Receta getDefaultReceta() {
        final Receta receta = new Receta();
        receta.setNombre("JonFromREST");
        receta.setDescripcion("DoeFromREST");
        return receta;
    }

    public void create(final Receta receta){
        dao.create(receta);
    }
}
