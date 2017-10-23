package blue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import blue.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long> {

}
