package org.example.fabricas;

import org.example.adaptadores.AdaptadorBaseDeDatos;
import org.example.adaptadores.implementacion.AdaptadorH2;
import org.example.adaptadores.BaseDeDatos;

public class FabricaBaseDeDatos {
	private static FabricaBaseDeDatos instanciaFabricaBaseDeDatos;

	public static FabricaBaseDeDatos obtenerInstancia(){
		if (instanciaFabricaBaseDeDatos == null) {
			instanciaFabricaBaseDeDatos = new FabricaBaseDeDatos();
		}
		return instanciaFabricaBaseDeDatos;
	}

	public AdaptadorBaseDeDatos obtenerAdaptador(BaseDeDatos baseDeDatos){
		return switch (baseDeDatos){
			case H2 -> AdaptadorH2.obtenerInstancia();
			default -> throw new IllegalArgumentException("Tipo de base de datos no soportado");
		};
	}
}
