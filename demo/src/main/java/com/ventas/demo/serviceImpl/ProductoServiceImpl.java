package com.ventas.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.demo.entity.ProductoEntity;
import com.ventas.demo.repository.ProductoRepository;
import com.ventas.demo.request.ProductoRequest;
import com.ventas.demo.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository prepo;
	
	@Override
	public List<ProductoEntity> listar() {
		
		return prepo.findAll();
	}
	
	@Override
	public ProductoEntity insertar(ProductoRequest object) {
		ProductoEntity producto = new ProductoEntity();
		
		producto.setPrecio(object.getPrecio());
		producto.setMarca(object.getMarca());
		producto.setProductoNom(object.getNombre());
		prepo.save(producto);
		
		return producto;
	}
	
	@Override
	public ProductoEntity actualizar(ProductoRequest object) {
		ProductoEntity producto = prepo.findById(object.getProductoId()).get();
		
		producto.setPrecio(object.getPrecio());
		producto.setMarca(object.getMarca());
		producto.setProductoNom(object.getNombre());
		prepo.save(producto);
		return producto;		
	}
	
	@Override
	public String eliminar(int productoId) {
		prepo.deleteById(productoId);
		return "Eliminado";
	}

	@Override
	public ProductoEntity buscar(int productoId) {
		
		
		return prepo.findById(productoId).get();
	}

}
