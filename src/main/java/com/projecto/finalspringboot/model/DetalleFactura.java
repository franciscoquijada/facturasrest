package com.projecto.finalspringboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información de la factura")
@Entity
@Table(name="detalle_factura")
public class DetalleFactura {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDetalle;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="producto_id")
	private Producto producto;

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Double calcularSubtotal() {
		return cantidad.doubleValue() * producto.getPrecio();
	}

}
