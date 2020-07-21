package com.projecto.finalspringboot.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projecto.finalspringboot.model.Cliente;
import com.projecto.finalspringboot.model.Factura;
import com.projecto.finalspringboot.model.Producto;
import com.projecto.finalspringboot.repo.IClienteRepo;
import com.projecto.finalspringboot.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	IClienteRepo repoCliente;
	
	@Override
	public Cliente registrar(Cliente cli) {
		return repoCliente.save(cli);
	}
	
	@Override
	public Cliente modificar(Cliente cli) {
		return repoCliente.save(cli);
	}
	
	@Override
	public List<Cliente> listar() {
		return repoCliente.findAll();
	}
	
	
	@Override
	public Page<Cliente> listarPageable(Pageable pageable) {
		return repoCliente.findAll(pageable);
	}
	
	@Override
	public Cliente leerPorId(Integer id) {
		Optional<Cliente> op = repoCliente.findById(id);
		return op.isPresent() ? op.get() : new Cliente();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repoCliente.deleteById(id);
		return true;
	}
	
	public List<Cliente> listarTodos(){
		return repoCliente.listarTodos();
	}

}
