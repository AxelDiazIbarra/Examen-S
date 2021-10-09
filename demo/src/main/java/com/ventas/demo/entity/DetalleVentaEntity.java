package com.ventas.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity 
@Table(name="DETALLE_VENTA")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
property="@detalleVentaId", scope = DetalleVentaEntity.class)

public class DetalleVentaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="DETALLE_ID", columnDefinition= "NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_auto")
	@SequenceGenerator(name = "id_auto", sequenceName = "DETALLEVENTA_SEQ", allocationSize=1)
	private int detalleId;
	
	@Column(name="CANTIDAD", columnDefinition = "NUMBER")
	private int cantidad;

	@ManyToOne
	@JoinColumn(name="PRODUCTO_ID", columnDefinition="NUMBER")
	private ProductoEntity producto;
	
	@ManyToOne
	@JoinColumn(name="VENTA_ID", columnDefinition="NUMBER")
	private VentaEntity venta;
	
	public VentaEntity getVenta() {
		return venta;
	}

	public void setVenta(VentaEntity venta) {
		this.venta = venta;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	
	public int getDetalleId() {
		return detalleId;
	}

	public void setDetalleId(int detalleId) {
		this.detalleId = detalleId;
	}


	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public DetalleVentaEntity(int detalleId, VentaEntity venta, ProductoEntity producto, int cantidad) {
		this.detalleId = detalleId;
		this.venta = venta;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public DetalleVentaEntity() {

	}

}
