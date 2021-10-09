package com.ventas.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.demo.entity.EmpleadosEntity;
import com.ventas.demo.exceptions.ApiRequestException;
import com.ventas.demo.exceptions.BusinessException;
import com.ventas.demo.repository.EmpleadosRepository;
import com.ventas.demo.request.EmpleadosRequest;
import com.ventas.demo.service.EmpleadosService;

@Service
public class EmpleadosServiceImpl implements EmpleadosService {

	@Autowired
	EmpleadosRepository repo;

	@Override
	public List<EmpleadosEntity> listarEmpleados() {
		List<EmpleadosEntity> list = repo.findAll();
		return list;

	}

	@Override
	public EmpleadosEntity buscarEmpleado(int empleadoId) {
		if (repo.existsById(empleadoId)) {
			EmpleadosEntity empleadodb = repo.findById(empleadoId).get();
			return empleadodb;
		} else {
			throw new ApiRequestException("No se encontró un registro con ese id.");
		}
	}

	@Override
	public EmpleadosEntity insertarEmpleado(EmpleadosRequest ob) {

		if (repo.findByNombre(ob.getNombre()) != null) {
			throw new BusinessException("Ya hay un empleado con ese nombre");
		} else {
			EmpleadosEntity empleadodb = new EmpleadosEntity();

			empleadodb.setEmpleadoId(ob.getEmpleadoId());
			empleadodb.setNombre(ob.getNombre());
			empleadodb.setTelefono(ob.getTelefono());
			empleadodb.setCorreo(ob.getCorreo());

			repo.save(empleadodb);
			return empleadodb;
		}
	}

	@Override
	public EmpleadosEntity actualizar(EmpleadosRequest ob) {

		if (repo.existsById(ob.getEmpleadoId())) {

			EmpleadosEntity empleadodb = repo.findById(ob.getEmpleadoId()).get();

			empleadodb.setEmpleadoId(ob.getEmpleadoId());
			empleadodb.setNombre(ob.getNombre());
			empleadodb.setTelefono(ob.getTelefono());
			empleadodb.setCorreo(ob.getCorreo());

			repo.save(empleadodb);
			return empleadodb;

		} else {
			throw new ApiRequestException("No se encontró un registro con ese id.");
		}
	}

	@Override
	public String eliminaEmpleado(int empleadoId) {
		if (repo.existsById(empleadoId)) {
			repo.deleteById(empleadoId);
			return "Eliminado exitosamente";
		} else {
			throw new ApiRequestException("No se encontró un registro con ese id.");
		}
	}


}
