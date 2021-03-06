package com.projecto.finalspringboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projecto.finalspringboot.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer>{
	
	@Query("SELECT c.idCliente, c.nombres, c.apellidos, c.rut, c.email, c.telefono FROM Cliente c")
    public List<Cliente> listarTodos();
}
