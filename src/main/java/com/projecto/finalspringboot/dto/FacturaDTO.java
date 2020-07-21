package com.projecto.finalspringboot.dto;

import org.springframework.hateoas.ResourceSupport;

//import com.escalab.model.Medico;
//import com.escalab.model.Paciente;

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
