package org.example;

import org.example.adaptadores.BaseDeDatos;
import org.example.dao.ProductoDAO;
import org.example.modelo.Producto;

public class Main {
	public static void main(String[] args) {

		Producto camiseta = new Producto("Camiseta", 45000.0, 20);
		Producto pantalon = new Producto("Pantalon", 130000.0, 10);
		Producto zapato = new Producto("Zapato", 250000.0, 5);
		Producto adasdas = new Producto("Adidas", 2321132.1, 12);
		Producto adios = new Producto("Adidas", 213412.0,412);

		ProductoDAO productoDAO = new ProductoDAO(BaseDeDatos.H2);

		for(Producto producto : productoDAO.	buscarTodos())
			System.out.println(producto);

	}
}
