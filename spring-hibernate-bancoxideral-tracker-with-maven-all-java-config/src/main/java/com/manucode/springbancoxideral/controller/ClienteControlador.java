package com.manucode.springbancoxideral.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manucode.springbancoxideral.entity.Cliente;
import com.manucode.springbancoxideral.service.ClienteServicio;

@Controller
@RequestMapping("/cliente")
public class ClienteControlador {

	// need to inject our customer service
	@Autowired
	private ClienteServicio servicioCliente;
	
	@GetMapping("/lista")
	public String listaClientes(Model theModel) {
		
		// get customers from the service
		List<Cliente> losClientes = servicioCliente.dameClientes();
				
		// add the customers to the model
		theModel.addAttribute("clientes", losClientes);
		
		return "lista-clientes";
	}
	
	@GetMapping("/mostrarFormAgregar")
	public String mostrarFormAgregar(Model theModel) {
		
		// create model attribute to bind form data
		Cliente elCliente = new Cliente();
		
		theModel.addAttribute("cliente", elCliente);
		
		return "formulario-clientes";
	}
	
	@PostMapping("/guardarCliente")
	public String guardarCliente(@ModelAttribute("cliente") Cliente elCliente) {
		
		// save the customer using our service
		servicioCliente.guardarCliente(elCliente);	
		
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/mostrarFormActualizar")
	public String mostrarFormActualizar(@RequestParam("clienteId") int elId,
									Model theModel) {
		
		// get the customer from our service
		Cliente elCliente = servicioCliente.dameCliente(elId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("cliente", elCliente);
		
		// send over to our form		
		return "formulario-clientes";
	}
	
	@GetMapping("/eliminar")
	public String eliminarCliente(@RequestParam("clienteId") int elId) {
		
		// delete the customer
		servicioCliente.eliminaCliente(elId);
		
		return "redirect:/cliente/lista";
	}
}










