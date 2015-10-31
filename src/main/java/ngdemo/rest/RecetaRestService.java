package ngdemo.rest;

import java.util.List;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    public List<Receta> getRecetas() {
        return recetaService.getAll();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Receta getReceta(@PathParam("id") int id) {
        return recetaService.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Receta create(final Receta receta) throws NotSupportedException, SystemException, Exception {
        return recetaService.create(receta);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int id) {
        recetaService.delete(id);
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void update(Receta receta){
        recetaService.update(receta);
    }

    public void setRecetaService(final RecetaService recetaService) {
        this.recetaService = recetaService;
    }
}
