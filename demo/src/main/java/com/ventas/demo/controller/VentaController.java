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

import com.ventas.demo.entity.VentaEntity;
import com.ventas.demo.request.VentaRequest;
import com.ventas.demo.service.VentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {

	@Autowired
	VentaService service;

	@PostMapping
	public VentaEntity saveVenta(@RequestBody VentaRequest venta) {
		return service.insertar(venta);
	}

	@GetMapping
	public List<VentaEntity> getAll() {
		return service.listar();
	}

	@GetMapping("buscar-por-id/{ventaId}")
	public VentaEntity getById(@PathVariable int ventaId) {
		return service.buscar(ventaId);
	}

	@PutMapping
	public VentaEntity updateVenta(@RequestBody VentaRequest venta) {
		return service.actualizar(venta);
	}

	@DeleteMapping("/{ventaId}")
	public String deleteVenta(@PathVariable int ventaId) {
		return service.eliminar(ventaId);
	}

}
