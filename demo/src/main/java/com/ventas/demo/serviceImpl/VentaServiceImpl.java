package com.ventas.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.demo.entity.EmpleadosEntity;
import com.ventas.demo.entity.VentaEntity;
import com.ventas.demo.repository.EmpleadosRepository;
import com.ventas.demo.repository.VentaRepository;
import com.ventas.demo.request.VentaRequest;
import com.ventas.demo.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService{
	
	
	@Autowired
	VentaRepository repo;
	
	@Autowired
	EmpleadosRepository eRepo;

	@Override
	public List<VentaEntity> listar() {
		
		return repo.findAll();
	}

	@Override
	public VentaEntity buscar(int ventaId) {
		
		return repo.findById(ventaId).get();
	}

	@Override
	public VentaEntity insertar(VentaRequest object) {
		VentaEntity venta = new VentaEntity();
		
		EmpleadosEntity empleado = eRepo.findById(object.getEmpleado().getEmpleadoId()).get();
		
		venta.setEmpleado(empleado);
		
		venta.setFecha(object.getFecha());
		venta.setTotal(object.getTotal());
		repo.save(venta);
		
		return venta;
	}

	@Override
	public VentaEntity actualizar(VentaRequest object) {
		VentaEntity venta = repo.findById(object.getVentaId()).get();
		EmpleadosEntity empleado = eRepo.findById(object.getEmpleado().getEmpleadoId()).get();
		
		venta.setEmpleado(empleado);		
		venta.setFecha(object.getFecha());
		venta.setTotal(object.getTotal());
		repo.save(venta);
		return venta;
	}

	@Override
	public String eliminar(int ventaId) {
		repo.deleteById(ventaId);
		return "Eliminado";
	}

}
