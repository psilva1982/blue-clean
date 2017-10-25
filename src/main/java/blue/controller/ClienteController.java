package blue.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import blue.model.Cidade;
import blue.model.Cliente;
import blue.model.Endereco;
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
	
	private String labelDocumento;
	private String maskDocumento;
	private boolean desabilitaDocumento;
	
	@Inject
	private Clientes clientes;
	
	@Inject
	private CadastroClienteService cadastroClienteService;
			
	public void preparaCadastro() {
		cliente = new Cliente();
		
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
			cadastroClienteService.salvar(cliente);
			
			/*
			System.out.println("Nome: " +cliente.getNome());
			System.out.println("Tipo: " +cliente.getTipoPessoa().getDescricao());
			System.out.println("Documento: " +cliente.getCpfOuCnpj());
			System.out.println("Telefone: " +cliente.getTelefone());
			System.out.println("Email: " +cliente.getEmail());
			System.out.println("Logradouro: " +cliente.getEndereco().getLogradouro());
			System.out.println("Número: " +cliente.getEndereco().getNumero());
			System.out.println("Complemento: " +cliente.getEndereco().getComplemento());
			System.out.println("Cep: " +cliente.getEndereco().getCep());
			System.out.println("Cidade: " +cliente.getEndereco().getCidade().getNome());
			*/
			
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Cliente cadastrado com sucesso"));		
			
	        preparaCadastro();
	        
		}catch (CpfCnpjClienteJaCadastradoException e) {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro", e.getMessage()));
		}

	}
}
