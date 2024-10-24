package org.example.dao;

import org.example.adaptadores.AdaptadorBaseDeDatos;
import org.example.adaptadores.BaseDeDatos;
import org.example.fabricas.FabricaBaseDeDatos;
import org.example.modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
	AdaptadorBaseDeDatos adaptadorBaseDeDatos;
	public ProductoDAO(BaseDeDatos baseDeDatos){
		adaptadorBaseDeDatos = FabricaBaseDeDatos.obtenerInstancia().obtenerAdaptador(baseDeDatos);
	}

	public void guardar(Producto producto){
		try(Connection conn = adaptadorBaseDeDatos.obtenerConexion();
				PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO PRODUCTO (nombre, precio, cantidad) VALUES (?, ?, ?)"
				);
		){
			pstmt.setString(1, producto.getNombre());
			pstmt.setDouble(2, producto.getPrecio());
			pstmt.setInt(3, producto.getCantidad());

			pstmt.executeUpdate();

		} catch(Exception e) {
			System.err.println("ERROR: " + e.getMessage());
		}

	}

	public void actualizar( Integer id, String campo, Object valor){

		try(Connection conn = adaptadorBaseDeDatos.obtenerConexion();
				PreparedStatement pstmt = conn.prepareStatement("UPDATE PRODUCTO SET " +campo + " = ? WHERE productoId = ?");
		){
			pstmt.setObject(1, valor);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();

		} catch(Exception e){
			System.err.println("ERROR: " + e.getMessage());
		}
	}
	public Producto buscarPorId( Integer id){
		Producto producto = new Producto();
		try(Connection conn = adaptadorBaseDeDatos.obtenerConexion();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM PRODUCTO WHERE productoId = ?");
		) {
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				producto.setId(rs.getInt("productoId"));
				producto.setNombre(rs.getString("nombre"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setCantidad(rs.getInt("cantidad"));
			}

		} catch(Exception e){
			System.err.println("ERROR: " + e.getMessage());
		}
		return producto;
	}

	public List<Producto> buscarTodos(){
		List<Producto> productos = new ArrayList<>();
		try(Connection conn = adaptadorBaseDeDatos.obtenerConexion();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM PRODUCTO");
		) {
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("productoId"));
				producto.setNombre(rs.getString("nombre"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setCantidad(rs.getInt("cantidad"));
				productos.add(producto);
			}

		} catch(Exception e){
			System.err.println("ERROR: " + e.getMessage());
		}
		return productos;
	}

	public void eliminarPorId(Integer id){
		try(Connection conn = adaptadorBaseDeDatos.obtenerConexion();
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM PRODUCTO WHERE productoId = ?");
		){
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch(Exception e){
			System.err.println("ERROR: " + e.getMessage());
		}
	}




}
