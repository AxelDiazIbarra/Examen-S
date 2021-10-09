package com.ventas.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ventas.demo.entity.DetalleVentaEntity;
import com.ventas.demo.request.DetalleVentaRequest;
import com.ventas.demo.service.DetalleVentaService;

@RestController
@RequestMapping("/detalles")
public class DetalleVentaController {

	@Autowired
	DetalleVentaService service;
	
	@PostMapping
	public DetalleVentaEntity insertarDetalleVenta(@RequestBody DetalleVentaRequest detalle) {
		return service.insertarDetalleVenta(detalle);
	}
	
	@GetMapping
	public List<DetalleVentaEntity> getAll() {
		return service.listarDetalleVenta();
	}
	
	@GetMapping("buscar-por-id/{detalleId}")
	public DetalleVentaEntity getById(@PathVariable int detalleId) {
		return service.buscarDetalleVentaId(detalleId);
	}
	
	@PutMapping
	public DetalleVentaEntity updateDetalleVenta(@RequestBody DetalleVentaRequest detalle) {
		return service.actualizar(detalle);
	}
	
	@DeleteMapping("/{detalleId}")
	public String deleteDetalle(@PathVariable int detalleId) {
		return service.eliminar(detalleId);
	}
}
