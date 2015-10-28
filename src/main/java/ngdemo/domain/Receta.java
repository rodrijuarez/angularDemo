package ngdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Receta {
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "receta")
	@TableGenerator(name = "receta", table = "sequences", pkColumnName = "key", pkColumnValue = "receta", valueColumnName = "seed")
	@Id
	private Integer id;

	private String nombre;

	private String descripcion;

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
}
