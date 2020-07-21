package com.projecto.finalspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projecto.finalspringboot.model.Factura;

public interface IFacturaRepo extends JpaRepository<Factura,Integer>{
	//Agregado nuevo
	/*@Query("select f from Factura f join fetch f.cliente c join fetch f.items l join fetch l.producto where f.id=?1")
	public Factura fetchByIdWithClienteWhitItemFacturaWithProducto(Integer id);*/

}
