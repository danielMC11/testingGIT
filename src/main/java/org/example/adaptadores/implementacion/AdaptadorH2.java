package org.example.adaptadores.implementacion;

import java.sql.*;

import org.example.adaptadores.AdaptadorBaseDeDatos;
import org.example.util.PropertiesUtil;
import java.util.Properties;

public class AdaptadorH2 implements AdaptadorBaseDeDatos {
	private static AdaptadorH2 instanciaAdaptadorH2;
	private static final String PROPERTIES_URL = "./propiedades/h2.properties";


	private String url;
	private String user;
	private String password;

	public AdaptadorH2(){
		crearTablas();
	}

	public static AdaptadorH2 obtenerInstancia() {
		if (instanciaAdaptadorH2 == null) {
			instanciaAdaptadorH2 = new AdaptadorH2();
		}
		return instanciaAdaptadorH2;
	}

	@Override
	public Connection obtenerConexion() throws SQLException {
		determinarParametrosConexion();
		return DriverManager.getConnection(url, user, password);
	}

	@Override
	public void determinarParametrosConexion(){
		Properties prop = PropertiesUtil.cargarArchivoProperties(PROPERTIES_URL);
		url = prop.getProperty("URL");
		user = prop.getProperty("USER");
		password = prop.getProperty("PASSWORD");
	}

	@Override
	public void crearTablas(){
		try(Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement()
		){
			stmt.execute("CREATE TABLE IF NOT EXISTS PRODUCTO (" +
				"productoId INT PRIMARY KEY AUTO_INCREMENT," +
				"nombre VARCHAR(100)," +
				"precio DOUBLE," +
				"cantidad INT)");

		} catch (SQLException e){
			System.err.println("ERROR AL CREAR TABLAS: " + e.getMessage());
		}
	}


}
