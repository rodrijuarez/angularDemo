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

import ngdemo.domain.Producto;
import ngdemo.service.ProductoService;

@Path("/productos")
@Component
public class ProductoRestService {

	@Autowired
	private ProductoService productoService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> getProductos() {
		return productoService.getAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Producto getProducto(@PathParam("id") final int id) {
		return productoService.get(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Producto create(final Producto producto) throws NotSupportedException,
			SystemException, Exception {
		return productoService.create(producto);
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id") final int id) {
		productoService.delete(id);
	}

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void update(final Producto producto) {
		productoService.update(producto);
	}

	public void setProductoService(final ProductoService productoService) {
		this.productoService = productoService;
	}
}
