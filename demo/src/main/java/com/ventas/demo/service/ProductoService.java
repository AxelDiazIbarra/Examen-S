package com.ventas.demo.service;

import java.util.List;

import com.ventas.demo.entity.ProductoEntity;
import com.ventas.demo.request.ProductoRequest;

public interface ProductoService {
	
	List<ProductoEntity> listar();

	ProductoEntity buscar(int productoId);

	ProductoEntity insertar(ProductoRequest object);

	ProductoEntity actualizar(ProductoRequest object);

	String eliminar(int productoId);
}
