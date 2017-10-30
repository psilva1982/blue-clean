package blue.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import blue.helper.generator.ClienteGenerator;
import blue.model.Cidade;
import blue.model.Cliente;
import blue.model.Endereco;
import blue.repository.Cidades;
import blue.repository.Clientes;
import blue.service.CadastroClienteService;
import blue.service.exception.CpfCnpjClienteJaCadastradoException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Endereco endereco;
	private Cliente cliente;
	private Cidade cidade; 
	private List<Cliente> listaClientes = new ArrayList<Cliente>();
		
	private String labelDocumento;
	private String maskDocumento;
	private boolean desabilitaDocumento;
	
	@Inject
	private Clientes clientes;
	
	@Inject
	private Cidades cidades;
	
	@Inject
	private CadastroClienteService cadastroClienteService;
	
	@PostConstruct
	public void init() {
		cliente = new Cliente();
	}
	
	public void preparaCadastro() {
		cliente.setEndereco(new Endereco());
		labelDocumento = "CPF / CNPJ";
		desabilitaDocumento = true; 
	}
	
	public void selecionaTipoDocumento() {
		if(cliente.isFisica()) {
			labelDocumento = "CPF";
			maskDocumento = "999.999.999-99";
			desabilitaDocumento = false;
			
		}else {
			labelDocumento = "CNPJ";
			maskDocumento = "99.999.999/9999-99";
			desabilitaDocumento = false;
		}
	}
	
	public void salvar() {
		
		try {
			
			cliente.setCredito(new BigDecimal("0.0"));
			cadastroClienteService.salvar(cliente);
						
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Cliente cadastrado com sucesso"));		
			
	        preparaCadastro();
	        
		}catch (CpfCnpjClienteJaCadastradoException e) {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro", e.getMessage()));
		}
	}
	
	public void listarClientes() {
		this.listaClientes = clientes.findAll();
	}

	public void loading() {
		try {
			Thread.sleep(10000);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
