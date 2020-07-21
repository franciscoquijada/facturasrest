package com.projecto.finalspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecto.finalspringboot.model.DetalleFactura;

public interface IDetalleFacturaRepo extends JpaRepository<DetalleFactura, Integer>{

}
