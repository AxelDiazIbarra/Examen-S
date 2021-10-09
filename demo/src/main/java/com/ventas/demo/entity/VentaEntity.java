package com.ventas.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "VENTA")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@ventaId", scope = VentaEntity.class)

public class VentaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "VENTA_ID", columnDefinition = "NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_auto")
	@SequenceGenerator(name = "id_auto", sequenceName = "VENTA_SEQ", allocationSize = 1)
	private int ventaId;

	@ManyToOne
	@JoinColumn(name = "EMPLEADO_ID", columnDefinition = "NUMBER")
	private EmpleadosEntity empleado;
	@Column(name = "FECHA_VENTA", columnDefinition = "DATE")
	private Date fecha;
	@Column(name = "TOTAL", columnDefinition = "NUMBER")
	private int total;

	@OneToMany(mappedBy = "venta")
	private List<DetalleVentaEntity> listDetalleVenta;

	public int getVentaId() {
		return ventaId;
	}

	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}

	public EmpleadosEntity getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadosEntity empleado) {
		this.empleado = empleado;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public VentaEntity(int ventaId, EmpleadosEntity empleado, int total, Date fecha) {
		this.ventaId = ventaId;
		this.empleado = empleado;
		this.total = total;
		this.fecha = fecha;
	}

	public VentaEntity() {

	}
}
