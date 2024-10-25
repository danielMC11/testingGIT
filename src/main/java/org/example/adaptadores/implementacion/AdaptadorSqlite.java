package org.example.adaptadores.implementacion;

import org.example.adaptadores.AdaptadorBaseDeDatos;

import org.example.modelo.Producto;
import org.example.util.PropertiesUtil;

import java.sql.*;
import java.util.Properties;

public class AdaptadorSqlite implements AdaptadorBaseDeDatos {
	private static final String PROPERTIES_PATH = "./propiedades/sqlite.properties";
	private static AdaptadorSqlite instancia;

	private String url;

	private AdaptadorSqlite(){
		crearTablas();
	}

	public static AdaptadorSqlite obtenerInstancia(){
		if(instancia==null){
			instancia = new AdaptadorSqlite();
		}
		return instancia;
	}


	@Override
	public Connection obtenerConexion() throws SQLException {
		if(url==null){
			determinarParametrosConexion();
		}
		return DriverManager.getConnection(url);
	}

	@Override
	public void determinarParametrosConexion() {
		Properties prop = PropertiesUtil.cargarArchivoProperties(PROPERTIES_PATH);
		url = prop.getProperty("URL") + "/" + prop.getProperty("DBNAME");
	}

	@Override
	public void crearTablas() {
		try (Connection conn = obtenerConexion();
				 Statement stmt = conn.createStatement()) {

			stmt.execute("CREATE TABLE IF NOT EXISTS PRODUCTO (" +
				"productoId INTEGER PRIMARY KEY," +
				"nombre VARCHAR(100)," +
				"precio DOUBLE," +
				"cantidad INT)");

		} catch (SQLException e) {
			System.err.println("ERROR AL CREAR TABLAS: " + e.getMessage());
		}

	}
}
