package blue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blue.model.Estado;
import blue.repository.Estados;

@Service
public class CadastroEstadoService {
	
	@Autowired
	private Estados estados;
	
	public List<Estado> getEstados() {
		return estados.findAll();
	}
}
