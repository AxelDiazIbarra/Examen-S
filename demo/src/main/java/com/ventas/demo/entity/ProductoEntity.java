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
@Table(name = "PRODUCTO")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@productoId", scope = ProductoEntity.class)

public class ProductoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRODUCTO_ID", columnDefinition = "NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_auto")
	@SequenceGenerator(name = "id_auto", sequenceName = "PRODUCTO_SEQ", allocationSize = 1)
	private int productoId;

	@Column(name = "PRECIO", columnDefinition = "NUMBER")
	private int precio;

	@Column(name = "NOMBRE", columnDefinition = "VARCHAR(20)")
	private String productoNom;

	@Column(name = "MARCA", columnDefinition = "VARCHAR(20)")
	private String marca;

	@OneToMany(mappedBy = "producto")
	private List<DetalleVentaEntity> listDetalleVenta;

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getProductoNom() {
		return productoNom;
	}

	public void setProductoNom(String productoNom) {
		this.productoNom = productoNom;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public ProductoEntity(int productoId, int precio, String productoNom, String marca) {
		this.productoId = productoId;
		this.precio = precio;
		this.productoNom = productoNom;
		this.marca = marca;
	}

	public ProductoEntity() {

	}

}
