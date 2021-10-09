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

import com.ventas.demo.entity.EmpleadosEntity;
import com.ventas.demo.request.EmpleadosRequest;
import com.ventas.demo.service.EmpleadosService;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {


	@Autowired
	EmpleadosService service;
	
	@PostMapping
	public EmpleadosEntity saveEmpleado(@RequestBody EmpleadosRequest empleado) {
		return service.insertarEmpleado(empleado);
	}
	
	@GetMapping
	public List<EmpleadosEntity> getAll() {
		return service.listarEmpleados();
	}
	
	@GetMapping("buscar-por-id/{empleadoId}")
	public EmpleadosEntity getById(@PathVariable int empleadoId) {
		return service.buscarEmpleado(empleadoId);
	}
	
	
	@PutMapping
	public EmpleadosEntity updateEmpleado(@RequestBody EmpleadosRequest empleado) {
		return service.actualizar(empleado);
	}
	
	@DeleteMapping("/{empleadoId}")
	public String deleteEmpleado(@PathVariable int empleadoId) {
		return service.eliminaEmpleado(empleadoId);
	}
	
	
}
