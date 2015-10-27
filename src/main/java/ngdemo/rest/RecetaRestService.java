package ngdemo.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ngdemo.domain.Receta;
import ngdemo.service.RecetaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/recetas")
@Component
public class RecetaRestService {

	private List<Receta> recetas;

	private RecetaService service;

	@Autowired
	private RecetaService autowireado;

	private Receta receta;

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
	public Receta create(final Receta receta) {
		// final EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("angularDemo-PU");
		// final EntityManager em = emf.createEntityManager();
		System.out.println(this.receta);
		service.create(receta);
		return service.getDefaultReceta();
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(final List<Receta> recetas) {
		this.recetas = recetas;
	}

	public Receta getReceta() {
		return receta;
	}

	@Autowired
	public void setReceta(final Receta receta) {
		this.receta = receta;
	}
}
