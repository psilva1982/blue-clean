package blue.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blue.model.Estado;

@Repository
public interface Estados extends JpaRepository<Estado, Long> {

	
}
