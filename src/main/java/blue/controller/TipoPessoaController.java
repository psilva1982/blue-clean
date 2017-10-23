package blue.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import blue.model.TipoPessoa;

@Component
@Scope("view")
public class TipoPessoaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public TipoPessoa[] getTipos() {
		
		return TipoPessoa.values();		
	}
}
