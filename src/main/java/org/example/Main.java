package org.example;

import org.example.adaptadores.BaseDeDatos;
import org.example.dao.ProductoDAO;
import org.example.modelo.Producto;

public class Main {
	public static void main(String[] args) {

		System.out.println("Mensaje Remoto");

		Producto z1 = new Producto("Adasdas", 20.0, 12);
		Producto z2 = new Producto("aDIOS", 15.0,412);
		Producto z2point2 = new Producto("Adormir", 23.0, 125);
		Producto z4 = new Producto("KIKE", 12.0, 12);
		Producto z5 = new Producto("KEVIN", 15.0,52);


		System.out.println("CHANGES from local");

		ProductoDAO productoDAO = new ProductoDAO(BaseDeDatos.SQLITE);

		Integer x = 123;

		for(Producto producto : productoDAO.	buscarTodos())
			System.out.println(producto);

	}
}
