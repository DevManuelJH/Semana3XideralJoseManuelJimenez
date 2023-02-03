package com.manucode.springbancoxideral.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manucode.springbancoxideral.dao.ClienteDAO;
import com.manucode.springbancoxideral.entity.Cliente;

@Service
public class ClienteServicioImpl implements ClienteServicio {

	// need to inject customer dao
	@Autowired
	@Qualifier("clienteDAOImpljdbc")
	private ClienteDAO clienteDAO;
	
	@Override
	@Transactional
	public List<Cliente> dameClientes() {
		return clienteDAO.dameClientes();
	}

	@Override
	@Transactional
	public void guardarCliente(Cliente elCliente) {

		clienteDAO.guardaCliente(elCliente);
	}

	@Override
	@Transactional
	public Cliente dameCliente(int elId) {
		
		return clienteDAO.dameCliente(elId);
	}

	@Override
	@Transactional
	public void eliminaCliente(int elId) {
		
		clienteDAO.eliminarCliente(elId);
	}
}





