package blue.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import blue.model.TipoPessoa;

@Named
@ViewScoped
public class TipoPessoaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public TipoPessoa[] getTipos() {
		
		return TipoPessoa.values();		
	}
}
