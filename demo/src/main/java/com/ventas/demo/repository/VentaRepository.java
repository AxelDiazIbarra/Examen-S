package com.ventas.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ventas.demo.entity.VentaEntity;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Integer>{

	
}
