package com.projecto.finalspringboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.projecto.finalspringboot.model.Cliente;
import com.projecto.finalspringboot.model.Producto;
import com.projecto.finalspringboot.model.Factura;

public interface IClienteService extends ICRUD<Cliente>{
	
	Page<Cliente> listarPageable(Pageable pageable);
	
	@Query(nativeQuery = true, value = "SELECT id_cliente, nombres, apellidos, rut, email, telefono FROM clientes")
	public List<Cliente> listarTodos();
	
	/*@Query("select idCliente, nombres, apellidos, rut, email, telefono from Cliente")
    public List<Cliente> listarTodos();*/
	
}
