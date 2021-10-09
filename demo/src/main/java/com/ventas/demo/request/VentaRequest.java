package com.ventas.demo.request;

import java.sql.Date;

import com.ventas.demo.entity.EmpleadosEntity;

public class VentaRequest {

	private int ventaId;
	private Date fecha;
	private int total;
	private EmpleadosEntity empleado;

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

	public VentaRequest(int ventaId, Date fecha, int total, EmpleadosEntity empleado) {
		this.ventaId = ventaId;
		this.fecha = fecha;
		this.total = total;
		this.empleado = empleado;
	}

	public VentaRequest() {

	}
}
