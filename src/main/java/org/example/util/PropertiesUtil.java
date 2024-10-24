package org.example.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	public static Properties cargarArchivoProperties(String propertiesURL){
		Properties prop = new Properties();

		try (FileInputStream input = new FileInputStream(propertiesURL)) {
			prop.load(input);
		} catch (Exception e) {
			System.err.println("ERROR AL CARGAR ARCHIVO: " + e.getMessage());
		}
		return prop;
	}
}
