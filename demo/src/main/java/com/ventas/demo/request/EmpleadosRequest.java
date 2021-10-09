package com.ventas.demo.request;

public class EmpleadosRequest {

	int empleadoId;
	String nombre;
	String telefono;
	String correo;
	
	public int getEmpleadoId() {
		return empleadoId;
	}
	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public EmpleadosRequest(int empleadoId, String nombre, String telefono, String correo) {
		this.empleadoId = empleadoId;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}
	
}
