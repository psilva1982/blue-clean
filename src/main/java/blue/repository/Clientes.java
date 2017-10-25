package blue.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import blue.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long> {
	
	public Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj); 
}
