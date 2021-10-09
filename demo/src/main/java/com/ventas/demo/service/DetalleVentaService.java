package com.ventas.demo.service;

import java.util.List;

import com.ventas.demo.entity.DetalleVentaEntity;
import com.ventas.demo.request.DetalleVentaRequest;

public interface DetalleVentaService {

	List<DetalleVentaEntity> listarDetalleVenta();
	public DetalleVentaEntity buscarDetalleVentaId(int detalleVentaId);
	public DetalleVentaEntity insertarDetalleVenta(DetalleVentaRequest object);
	public DetalleVentaEntity actualizar(DetalleVentaRequest object);
	String eliminar(int detalleID);
}
