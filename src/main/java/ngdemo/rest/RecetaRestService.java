package ngdemo.rest;

import ngdemo.domain.Receta;
import ngdemo.service.RecetaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/recetas")
public class RecetaRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Receta getDefaultRecetaInJSON() {
        RecetaService recetaService = new RecetaService();
        return recetaService.getDefaultReceta();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Receta create(Receta receta) {
        System.out.println(receta);
        RecetaService recetaService = new RecetaService();
        return recetaService.getDefaultReceta();
    }
}
