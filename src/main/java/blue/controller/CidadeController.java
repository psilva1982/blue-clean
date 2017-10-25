package blue.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import blue.model.Cidade;
import blue.repository.Cidades;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Named
@ViewScoped
public class CidadeController implements Serializable {
	
	@Autowired
	private Cidades cidades;
	
	private List<Cidade> listaCidades = new ArrayList<Cidade>();
	
	public void carregarCidades() {
		listaCidades.clear();
	}
}

