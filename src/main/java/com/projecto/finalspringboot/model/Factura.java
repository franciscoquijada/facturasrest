package com.projecto.finalspringboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información de la factura")
@Entity
@Table(name="facturas")
public class Factura {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idFactura;
	
	@ApiModelProperty(notes = "Descripcion debe tener minimo 5 caracteres")
	@Size(min = 3, message = "Descripcion debe tener minimo 5 caracteres")
	@Column(name = "descripcion", nullable = false, length = 70)
	private String descripcion;
	
	@ApiModelProperty(notes = "Observacion debe tener minimo 5 caracteres")
	@Size(min = 5, message = "Observacion debe tener minimo 5 caracteres")
	@Column(name = "observacion", nullable = false, length = 70)
	private String observacion;
	
	@ManyToOne(fetch= FetchType.LAZY)
	//@JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "fk_factura_cliente"))
	private Cliente cliente;
	
	@OneToMany(fetch=FetchType.LAZY, cascade={ CascadeType.ALL }/*, orphanRemoval=true*/)
	@JoinColumn(name="factura_id")
	private List<DetalleFactura> detalles;
	
	public Factura() {
		this.detalles = new ArrayList<DetalleFactura>();
	}
	
	public Double getTotal() {
		Double total = 0.0;
		int size = detalles.size();
		for(int i = 0; i<size;i++) {
			total += detalles.get(i).calcularSubtotal();
		}
		return total;
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	
	public void addDetalleFactura(DetalleFactura detalle) {
		this.detalles.add(detalle);
	}
	
	
}
