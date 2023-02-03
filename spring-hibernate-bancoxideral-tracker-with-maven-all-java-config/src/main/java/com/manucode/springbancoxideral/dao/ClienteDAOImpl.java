package com.manucode.springbancoxideral.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manucode.springbancoxideral.entity.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Cliente> dameClientes() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Cliente> theQuery = 
				currentSession.createQuery("from Cliente order by apellido",
											Cliente.class);
		
		// execute query and get result list
		List<Cliente> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

	@Override
	public void guardaCliente(Cliente elCliente) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(elCliente);
		
	}

	@Override
	public Cliente dameCliente(int elId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Cliente elCliente = currentSession.get(Cliente.class, elId);
		
		return elCliente;
	}

	@Override
	public void eliminarCliente(int elId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Cliente where id=:clienteId");
		theQuery.setParameter("clienteId", elId);
		
		theQuery.executeUpdate();		
	}

}











