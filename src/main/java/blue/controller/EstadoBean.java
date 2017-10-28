package blue.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import blue.model.Cidade;
import blue.model.Estado;
import blue.repository.Cidades;
import blue.repository.Estados;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class EstadoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Cidade> listaCidades = new ArrayList<Cidade>();
	private Cidade cidade = new Cidade();
	private Estado estado;
	private boolean bloqueiaCidade;
	
	@Inject
	private Estados estados;
	
	@Inject
	private Cidades cidades;
	
	@PostConstruct
	public void init() {
		estado = new Estado();
		bloqueiaCidade = true;
	}
	
	public List<Estado> getEstados() {		
		return estados.findAll();
	}
			
	public void carregarCidades() {
		listaCidades.clear();
				
		listaCidades = cidades.findByEstadoCodigo(estado.getCodigo());
		
		if(listaCidades.size() > 0) {
			bloqueiaCidade = false;
		
		}else {
			bloqueiaCidade = true;
		}
	}
}

