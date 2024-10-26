package org.example;

import org.example.adaptadores.BaseDeDatos;
import org.example.dao.ProductoDAO;
import org.example.modelo.Producto;

public class Main {
	public static void main(String[] args) {

		Producto z1 = new Producto("Adasdas", 20.0, 12);
		Producto z2 = new Producto("aDIOS", 15.0,412);
		Producto z2point2 = new Producto("Adormir", 23.0, 125);
		Producto z4 = new Producto("KIKE", 12.0, 12);
		Producto z5 = new Producto("KEVIN", 15.0,52);


		System.out.println("CHANGES from local");

		ProductoDAO productoDAO = new ProductoDAO(BaseDeDatos.SQLITE);

		for(Producto producto : productoDAO.	buscarTodos())
			System.out.println(producto);

	}
}
