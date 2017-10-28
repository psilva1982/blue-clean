package blue.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import blue.model.Cliente;
import blue.repository.helper.ClientesQueries;

public interface Clientes extends JpaRepository<Cliente, Long>, ClientesQueries {
	
	public Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj); 
}
