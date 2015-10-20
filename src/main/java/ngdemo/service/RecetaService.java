package ngdemo.service;

import ngdemo.domain.Receta;

public class RecetaService {

    public Receta getDefaultReceta() {
        Receta receta = new Receta();
        receta.setNombre("JonFromREST");
        receta.setDescripcion("DoeFromREST");
        return receta;
    }
}
