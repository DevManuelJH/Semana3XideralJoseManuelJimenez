package com.manucode.springbancoxideral.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manucode.springbancoxideral.entity.Cliente;

@Repository
public class ClienteDAOImpljdbc implements ClienteDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Cliente> dameClientes() {

		List<Cliente> losClientes = new ArrayList<>();

		String sql = "select * from estudiantexideral order by apellido";
		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			while (myRs.next()) {

				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String email = myRs.getString("email");
				String estatus = myRs.getString("estatus");
				// create new student object
				Cliente tempCliente = new Cliente(id, nombre, apellido, email, estatus);

				losClientes.add(tempCliente);
			}

			return losClientes;
		} catch (Exception e) {
			e.printStackTrace();
			return losClientes;
		}
	}

	@Override
	public void guardaCliente(Cliente elCliente){
		
		int idCliente = elCliente.getId();
		if(idCliente == 0) {
			try {
				agregarCliente(elCliente);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				editarCliente(elCliente);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public Cliente dameCliente(int elId) {

		Cliente elCliente = null;

		// create sql to get selected student
		String sql = "select * from estudiantexideral where id=?";
		ResultSet myRs = null;

		try (Connection myConn = dataSource.getConnection(); PreparedStatement myStmt = myConn.prepareStatement(sql)) {
			// convert student id to int

			// set params
			myStmt.setInt(1, elId);

			// execute statement
			myRs = myStmt.executeQuery();

			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String correo = myRs.getString("email");
				String estatus = myRs.getString("estatus");

				// use the studentId during construction
				elCliente = new Cliente(elId, nombre, apellido, correo, estatus);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return elCliente;
	}

	@Override
	public void eliminarCliente(int elId) {
		// create sql to delete student
		String sql = "delete from estudiantexideral where id=?";

		try (Connection myConn = dataSource.getConnection(); PreparedStatement myStmt = myConn.prepareStatement(sql)) {

			// convert student id to int
			// int estudianteId = Integer.parseInt(elId);

			// set params
			myStmt.setInt(1, elId);

			// execute sql statement
			myStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void agregarCliente(Cliente elCliente) throws Exception {
		// create sql for insert
		String sql = "insert into estudiantexideral (nombre, apellido, email, estatus) values (?, ?, ?, ?)";

		// aplica try with resources
		try (Connection myConn = dataSource.getConnection(); PreparedStatement myStmt = myConn.prepareStatement(sql)) {
			// get db connection

			// set the param values for the student
			myStmt.setString(1, elCliente.getNombre());
			myStmt.setString(2, elCliente.getApellido());
			myStmt.setString(3, elCliente.getEmail());
			myStmt.setString(4, elCliente.getEstatus());

			// execute sql insert
			myStmt.execute();
		}
	}

	public void editarCliente(Cliente elCliente) throws Exception {

		String sql = "update estudiantexideral set nombre=?, apellido=?, email=?, estatus=? where id=?";

		try (Connection myConn = dataSource.getConnection(); PreparedStatement myStmt = myConn.prepareStatement(sql)) {

			// set params
			myStmt.setString(1, elCliente.getNombre());
			myStmt.setString(2, elCliente.getApellido());
			myStmt.setString(3, elCliente.getEmail());
			myStmt.setString(4, elCliente.getEstatus());
			myStmt.setInt(5, elCliente.getId());

			// execute SQL statement
			myStmt.execute();
		}
	}

}
