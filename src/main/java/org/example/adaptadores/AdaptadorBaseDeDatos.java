package org.example.adaptadores;

import java.sql.Connection;
import java.sql.SQLException;

public interface AdaptadorBaseDeDatos {
	Connection obtenerConexion() throws SQLException;
	void determinarParametrosConexion();
	void crearTablas();

}
