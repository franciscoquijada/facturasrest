package com.projecto.finalspringboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projecto.finalspringboot.model.Factura;

public interface IFacturaService extends ICRUD<Factura>{
	Page<Factura> listarPageable(Pageable pageable);
}
