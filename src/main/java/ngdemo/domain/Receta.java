package ngdemo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement()
public class Receta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;

	private String descripcion;

	@OneToMany
	private List<ProductoReceta> productoRecetas;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {

		return descripcion;
	}

	public void setDescripcion(final String descripcion) {

		this.descripcion = descripcion;

	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public List<ProductoReceta> getProductoRecetas() {
		return productoRecetas;
	}

	public void setProductoRecetas(final List<ProductoReceta> productoRecetas) {
		this.productoRecetas = productoRecetas;
	}
}
