package com.projecto.finalspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projecto.finalspringboot.model.Factura;

public interface IFacturaRepo extends JpaRepository<Factura,Integer>{

}
