package com.projecto.finalspringboot.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projecto.finalspringboot.model.Factura;
import com.projecto.finalspringboot.repo.IFacturaRepo;
import com.projecto.finalspringboot.service.IFacturaService;

@Service
public class FacturaServiceImpl implements IFacturaService{
	
	@Autowired
	IFacturaRepo repo;
	
	@Override
	public Factura registrar(Factura fac) {
		return repo.save(fac);
	}
	
	@Override
	public Factura modificar(Factura fac) {
		return repo.save(fac);
	}
	
	@Override
	public List<Factura> listar() {
		return repo.findAll();
	}
	
	@Override
	public Page<Factura> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	@Override
	public Factura leerPorId(Integer id) {
		Optional<Factura> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Factura();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
