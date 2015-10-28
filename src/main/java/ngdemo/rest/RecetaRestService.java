package ngdemo.rest;

import java.util.List;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
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

	@Autowired
	private RecetaService recetaService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Receta getDefaultRecetaInJSON() {
		return recetaService.getDefaultReceta();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Receta create(final Receta receta) throws NotSupportedException, SystemException, Exception {
		return recetaService.create(receta);
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(final List<Receta> recetas) {
		this.recetas = recetas;
	}
	
	public void setRecetaService(final RecetaService recetaService) {
		this.recetaService = recetaService;
	}
}
