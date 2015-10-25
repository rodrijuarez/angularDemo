package ngdemo.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ngdemo.domain.Receta;
import ngdemo.service.RecetaService;


@Path("/recetas")
public class RecetaRestService {

    private List<Receta> recetas;

    private RecetaService service;

    @PersistenceContext(unitName = "angularDemo-PU")
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Receta getDefaultRecetaInJSON() {
        return service.getDefaultReceta();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Receta create(Receta receta) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("angularDemo-PU");
        EntityManager em = emf.createEntityManager();
        System.out.println(receta);
            service.create(receta);
        return service.getDefaultReceta();
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }
}
