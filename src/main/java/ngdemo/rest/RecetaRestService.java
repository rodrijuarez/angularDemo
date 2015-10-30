package ngdemo.rest;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ngdemo.domain.Receta;
import ngdemo.service.RecetaService;

@Path("/recetas")
@Component
public class RecetaRestService {

    @Autowired
    private RecetaService recetaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Receta[] getRecetas() {
        return recetaService.getAll().toArray(new Receta[] {});
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Receta create(final Receta receta) throws NotSupportedException, SystemException, Exception {
        return recetaService.create(receta);
    }

    public void setRecetaService(final RecetaService recetaService) {
        this.recetaService = recetaService;
    }
}
