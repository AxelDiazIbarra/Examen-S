package com.ventas.demo.request;

import com.ventas.demo.entity.ProductoEntity;
import com.ventas.demo.entity.VentaEntity;

public class DetalleVentaRequest {
	
	int DetalleId;
	VentaEntity Venta;
	ProductoEntity Producto;
	int cantidad;
	public int getDetalleId() {
		return DetalleId;
	}
	public void setDetalleId(int detalleId) {
		DetalleId = detalleId;
	}

	public VentaEntity getVenta() {
		return Venta;
	}
	public void setVenta(VentaEntity ventaId) {
		Venta = ventaId;
	}
	public ProductoEntity getProducto() {
		return Producto;
	}
	public void setProductoId(ProductoEntity productoId) {
		Producto = productoId;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public DetalleVentaRequest(int detalleId, VentaEntity ventaId, ProductoEntity productoId, int cantidad) {
		DetalleId = detalleId;
		Venta = ventaId;
		Producto = productoId;
		this.cantidad = cantidad;
	}

	
}
