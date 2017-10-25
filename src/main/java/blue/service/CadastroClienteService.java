package blue.service;

import java.io.Serializable;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import blue.model.Cliente;
import blue.repository.Clientes;
import blue.service.exception.CpfCnpjClienteJaCadastradoException;
import blue.service.exception.ImpossivelExcluirEntidadeException;
import blue.util.cdi.Transactional;

public class CadastroClienteService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Clientes clientes;
	
	@Transactional
	public void salvar(Cliente cliente) {
		
		Optional<Cliente> existente = clientes.findByCpfOuCnpj(cliente.getCpfOuCnpjSemFormatacao());
		
		if(cliente.isNovo() && existente.isPresent()) {
			throw new CpfCnpjClienteJaCadastradoException("CPF/CNPJ já cadastrado");
		}
		
		if(existente.isPresent() && existente.get().getCodigo() != cliente.getCodigo()) {
			throw new CpfCnpjClienteJaCadastradoException("CPF/CNPJ já cadastrado");
		}
		
		clientes.save(cliente);
	}

	@Transactional
	public void excluir(Cliente cliente) {
		
		try {
			
			clientes.delete(cliente);
			clientes.flush();
			
		}catch (PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Impossível excluir, cliente efetuou compras");
		}		
	}
}
