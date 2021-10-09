package com.ventas.demo.request;

public class ProductoRequest {
	private int productoId;
	private String nombre;
	private int precio;
	private String marca;
	public int getProductoId() {
		return productoId;
	}
	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public ProductoRequest(int productoId, String nombre, int precio, String marca) {
		super();
		this.productoId = productoId;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
	}
	
	public ProductoRequest() {
		
	}
}
