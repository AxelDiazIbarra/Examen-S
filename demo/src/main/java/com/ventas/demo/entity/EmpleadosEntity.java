package com.ventas.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity 
@Table(name="EMPLEADO")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
property="@empleadoId", scope = EmpleadosEntity.class)
public class EmpleadosEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	@Id
	@Column(name="EMPLEADO_ID", columnDefinition= "NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_auto")
	@SequenceGenerator(name = "id_auto", sequenceName = "EMPLEADO_SEQUENCE", allocationSize=1)
	private int empleadoId;
	
	@Column(name="NOMBRE", columnDefinition= "NVARCHAR(20)")
	private String nombre;
	@Column(name="TELEFONO", columnDefinition= "NVARCHAR(10)")
	private String telefono;
	@Column(name="CORREO", columnDefinition= "NVARCHAR(20)")
	private String correo;
	
	@OneToMany(mappedBy="empleado")
	private List<VentaEntity> listVenta;

	public EmpleadosEntity() {

	}

	public EmpleadosEntity(int empleadoId, String nombre, String telefono, String correo) {
		this.empleadoId = empleadoId;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}

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

	public List<VentaEntity> getListVenta() {
		return listVenta;
	}

	public void setListVenta(List<VentaEntity> listVenta) {
		this.listVenta = listVenta;
	}
	

}
