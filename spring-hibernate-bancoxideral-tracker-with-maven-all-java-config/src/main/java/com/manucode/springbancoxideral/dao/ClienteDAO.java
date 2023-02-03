package com.manucode.springbancoxideral.dao;

import java.util.List;

import com.manucode.springbancoxideral.entity.Cliente;

public interface ClienteDAO {

	public List<Cliente> dameClientes();

	public void guardaCliente(Cliente elCliente);

	public Cliente dameCliente(int elId);

	public void eliminarCliente(int elId);
	
}
