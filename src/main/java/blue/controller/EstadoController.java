package blue.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import blue.model.Estado;
import blue.repository.Estados;

@Component
@Scope("request")
public class EstadoController {
	
	private List<Estado> estados = new ArrayList<Estado>();
	
	@Autowired
	private Estados estadosRepository;
	
	@PostConstruct
	public void postConstruct() {
		estados = estadosRepository.findAll();
	}
	
	public List<Estado> getEstados() {
		System.out.println(" >>>> Executando getEstado ");
		return estados;
	}
}

