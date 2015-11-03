package ngdemo.domain;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement()
public class ProductoReceta extends Producto {
	private Integer cantidad;

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(final Integer cantidad) {
		this.cantidad = cantidad;
	}
}