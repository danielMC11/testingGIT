package org.example.modelo;

public class Producto {
	private Integer id;
	private String nombre;
	private Double precio;
	private Integer cantidad;

	public Producto(){

	}

	public Producto(String nombre, Double precio, Integer cantidad) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto{" +
			"id=" + id +
			", nombre='" + nombre + '\'' +
			", precio=" + precio +
			", cantidad=" + cantidad +
			'}';
	}
}
