package com.ventas.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ventas.demo.entity.ProductoEntity;
import com.ventas.demo.request.ProductoRequest;
import com.ventas.demo.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	ProductoService service;

	@PostMapping
	public ProductoEntity saveProducto(@RequestBody ProductoRequest producto) {
		return service.insertar(producto);
	}

	@GetMapping("buscar-por-id/{productoId}")
	public ProductoEntity getById(@PathVariable int productoId) {
		return service.buscar(productoId);
	}

	@PutMapping
	public ProductoEntity updateProducto(@RequestBody ProductoRequest producto) {
		return service.actualizar(producto);
	}

	@DeleteMapping("/{productoId}")
	public String deleteProducto(@PathVariable int productoId) {
		return service.eliminar(productoId);
	}
}
