package com.projecto.finalspringboot.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projecto.finalspringboot.exception.ModeloNotFoundException;
import com.projecto.finalspringboot.model.Factura;
import com.projecto.finalspringboot.service.IFacturaService;


@RestController
@RequestMapping("/facturas")
//@CrossOrigin()
public class FacturaController {
	
	@Autowired
	private IFacturaService service;
	
	@GetMapping
	public ResponseEntity<List<Factura>> listar(){
		 List<Factura> lista = service.listar();
		return new ResponseEntity<List<Factura>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Factura> listarPorId(@PathVariable("id") Integer id){
		Factura fac = service.leerPorId(id);
		if(fac.getIdFactura() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Factura>(fac, HttpStatus.OK); 
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Factura>> listarPageable(Pageable pageable) {
		Page<Factura> clientes = service.listarPageable(pageable);
		return new ResponseEntity<Page<Factura>>(clientes, HttpStatus.OK);
	}

	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Factura factura) {
		Factura fac = service.registrar(factura);
		//factura/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(factura.getIdFactura()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Factura> modificar(@Valid @RequestBody Factura factura) {
		Factura fac = service.modificar(factura);
		return new ResponseEntity<Factura>(fac, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Factura fac = service.leerPorId(id);
		if(fac.getIdFactura() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}