package com.ventas.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ventas.demo.entity.EmpleadosEntity;

public interface EmpleadosRepository extends JpaRepository<EmpleadosEntity, Integer> {
	
	@Query("SELECT e FROM EmpleadosEntity e WHERE e.nombre = :nombre")
	EmpleadosEntity findByNombre(@Param("nombre") String nombre);

}
