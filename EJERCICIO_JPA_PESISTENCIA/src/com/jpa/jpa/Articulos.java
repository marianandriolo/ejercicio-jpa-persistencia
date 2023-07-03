package com.jpa.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ARTICULOS database table.
 * 
 */
@Entity
@NamedQuery(name="Articulos.findAll", query="SELECT a FROM Articulos a")
public class Articulos implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codigoArticulo;
	private Integer cantidad;
	private String descripcionArticulo;
	private Double precioUnidadArticulo;

	public Articulos() {
	}


	@Id
	@Column(name="CODIGO_ARTICULO")
	public Long getCodigoArticulo() {
		return this.codigoArticulo;
	}

	public void setCodigoArticulo(long i) {
		this.codigoArticulo = i;
	}


	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	@Column(name="DESCRIPCION_ARTICULO")
	public String getDescripcionArticulo() {
		return this.descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}


	@Column(name="PRECIO_UNIDAD_ARTICULO")
	public Double getPrecioUnidadArticulo() {
		return this.precioUnidadArticulo;
	}

	public void setPrecioUnidadArticulo(Double precioUnidadArticulo) {
		this.precioUnidadArticulo = precioUnidadArticulo;
	}


	@Override
	public String toString() {
		return "Codigo articulo: " + codigoArticulo + ", cantidad: " + cantidad + ", descripcion articulo: "
				+ descripcionArticulo + ", precio unidad articulo: " + precioUnidadArticulo +"\n";
	}

}