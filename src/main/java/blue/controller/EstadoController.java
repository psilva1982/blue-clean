package blue.controller;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import blue.model.Estado;
import blue.repository.Estados;

@Component
@Scope("view")
public class EstadoController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Estados estadosRepository;
	
	public List<Estado> getEstados() {
		return estadosRepository.findAll();
	}
}

