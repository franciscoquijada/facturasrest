package com.projecto.finalspringboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projecto.finalspringboot.model.Producto;

public interface IProductoService extends ICRUD<Producto> {
	Page<Producto> listarPageable(Pageable pageable);
}
