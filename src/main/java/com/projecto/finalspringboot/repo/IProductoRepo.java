package com.projecto.finalspringboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projecto.finalspringboot.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer>{
	//Agregado nuevo
	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findByNombre(String term);

	public List<Producto> findByNombreLikeIgnoreCase(String term);

}
