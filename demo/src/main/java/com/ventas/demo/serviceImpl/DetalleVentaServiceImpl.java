package com.ventas.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.demo.entity.DetalleVentaEntity;
import com.ventas.demo.entity.ProductoEntity;
import com.ventas.demo.entity.VentaEntity;
import com.ventas.demo.exceptions.ApiRequestException;
import com.ventas.demo.repository.DetalleVentaRepository;
import com.ventas.demo.repository.ProductoRepository;
import com.ventas.demo.repository.VentaRepository;
import com.ventas.demo.request.DetalleVentaRequest;
import com.ventas.demo.service.DetalleVentaService;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService{

	@Autowired
	DetalleVentaRepository repo;
	@Autowired
	ProductoRepository prepo;
	@Autowired
	VentaRepository vrepo;
	

	@Override
	public List<DetalleVentaEntity> listarDetalleVenta() {
		List<DetalleVentaEntity> list = repo.findAll();
		return list;

	}

	@Override
	public DetalleVentaEntity buscarDetalleVentaId(int detalleVentaId) {

		if (repo.existsById(detalleVentaId)) {
			DetalleVentaEntity detalleVta = repo.findById(detalleVentaId).get();
			return detalleVta;
		} else {
			throw new ApiRequestException("No se encontró un registro con ese id.");
		}
	}

	@Override
	public DetalleVentaEntity insertarDetalleVenta(DetalleVentaRequest ob) {

			DetalleVentaEntity detalleVta = new DetalleVentaEntity();
			ProductoEntity producto = prepo.findById(ob.getProducto().getProductoId()).get();
			VentaEntity venta = vrepo.findById(ob.getVenta().getVentaId()).get();
			
			detalleVta.setDetalleId(ob.getDetalleId());
			detalleVta.setProducto(producto);
			detalleVta.setVenta(venta);
			detalleVta.setCantidad(ob.getCantidad());
			

			repo.save(detalleVta);
			return detalleVta;	
	}

	@Override
	public DetalleVentaEntity actualizar(DetalleVentaRequest object) {
		DetalleVentaEntity detalleVta = repo.findById(object.getDetalleId()).get();
		VentaEntity venta = vrepo.findById(object.getVenta().getVentaId()).get();
		ProductoEntity producto = prepo.findById(object.getProducto().getProductoId()).get();
		
		detalleVta.setVenta(venta);
		detalleVta.setProducto(producto);
		detalleVta.setCantidad(object.getCantidad());
		repo.save(detalleVta);
		return detalleVta;
	}

	@Override
	public String eliminar(int detalleId) {
		repo.deleteById(detalleId);
		return "Eliminado";
	}
	
}
