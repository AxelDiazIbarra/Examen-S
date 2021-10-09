package com.ventas.demo.service;

import java.util.List;

import com.ventas.demo.entity.VentaEntity;
import com.ventas.demo.request.VentaRequest;

public interface VentaService {
	List<VentaEntity> listar();
	VentaEntity buscar(int ventaId);
	VentaEntity insertar(VentaRequest object);
	VentaEntity actualizar(VentaRequest object);
	String eliminar(int ventaId);

}
