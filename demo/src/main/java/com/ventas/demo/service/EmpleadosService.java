package com.ventas.demo.service;

import java.util.List;

import com.ventas.demo.entity.EmpleadosEntity;
import com.ventas.demo.request.EmpleadosRequest;

public interface EmpleadosService {

	List<EmpleadosEntity> listarEmpleados();
	public EmpleadosEntity buscarEmpleado(int empleadoId);
	public EmpleadosEntity insertarEmpleado(EmpleadosRequest object);
	public EmpleadosEntity actualizar(EmpleadosRequest object);
	String eliminaEmpleado(int empleadoId);
}
