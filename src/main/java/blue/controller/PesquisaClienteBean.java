package blue.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import blue.model.Cliente;
import blue.model.lazy.LazyClienteDataModel;
import blue.repository.Clientes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class PesquisaClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private LazyClienteDataModel lazyClientes;
	private Cliente clienteSelecionado; 
	
	@Inject
	private Clientes clientes;
	
	@PostConstruct
	public void init() {
		lazyClientes = new LazyClienteDataModel(clientes);
	}
}
