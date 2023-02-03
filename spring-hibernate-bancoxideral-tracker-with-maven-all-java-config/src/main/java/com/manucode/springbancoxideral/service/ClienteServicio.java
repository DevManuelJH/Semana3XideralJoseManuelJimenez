package com.manucode.springbancoxideral.service;

import java.util.List;

import com.manucode.springbancoxideral.entity.Cliente;

public interface ClienteServicio {

	public List<Cliente> dameClientes();

	public void guardarCliente(Cliente elCliente);

	public Cliente dameCliente(int elId);

	public void eliminaCliente(int elId);
	
}
