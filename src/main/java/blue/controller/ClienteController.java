package blue.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import blue.repository.Clientes;
import blue.model.Cliente;

@Component
@Scope("view")
public class ClienteController implements Serializable {
	
	private Cliente cliente; 
	
	@Autowired
	private Clientes clientes; 
	
	@PostConstruct
	public void init() {
		this.cliente = new Cliente();
	}
	
	public List<Cliente> listaTodos() {
		return clientes.findAll();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void salvar() {
		try {
			Thread.sleep(100000);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
