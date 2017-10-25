package blue.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import blue.model.Cidade;
import blue.model.Estado;


public interface Cidades extends JpaRepository<Cidade, Long> {

	public List<Cidade> findByEstadoCodigo(Long codigoEstado);
	public Optional<Cidade> findByNomeAndEstado(String nome, Estado estado);
}
