package com.projecto.finalspringboot.dto;

import org.springframework.hateoas.ResourceSupport;

public class FacturaDTO extends ResourceSupport{
	
	private Integer idFactura;
	//private Factura factura;
	//private Producto producto;

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	

}
