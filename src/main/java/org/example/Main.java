package org.example;

import org.example.adaptadores.BaseDeDatos;
import org.example.dao.ProductoDAO;
import org.example.modelo.Producto;

public class Main {
	public static void main(String[] args) {

		Producto adasdas = new Producto("Adidas", 2321132.1, 12);
		Producto adios = new Producto("Adidas", 213412.0,412);
		Producto neki = new Producto("Nike", 21312.0, 123);

		ProductoDAO productoDAO = new ProductoDAO(BaseDeDatos.H2);

		for(Producto producto : productoDAO.buscarTodos())
			System.out.println(producto);

	}
}
